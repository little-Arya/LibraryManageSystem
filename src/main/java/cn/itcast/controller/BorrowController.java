package cn.itcast.controller;

import cn.itcast.domain.Book;
import cn.itcast.domain.Borrow;
import cn.itcast.domain.Read;
import cn.itcast.service.BookService;
import cn.itcast.service.BorrowService;
import cn.itcast.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @Autowired
    private ReadService readService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/findAllBorrow")
    public String findAllBorrow(Model model){
        System.out.println("表现层：查询所有账户。。。。");
        //调用service方法
        List<Borrow> list=borrowService.findAllBorrow();

        //System.out.println(list);

        model.addAttribute("borrowlist",list);
        //    accountService.findAll();
        return "borrowlist";
    }



    @RequestMapping("/addBorrow")
    public void addBorrow(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        //ids是书籍的编号
        //System.out.println(ids);
        Borrow borrow = new Borrow();
        Integer rdID = Integer.valueOf(request.getParameter("rdID"));
        Integer bkID = Integer.valueOf(request.getParameter("bkID"));
        Read read = readService.getReadById(rdID);
        Book book = bookService.getItemById(bkID);
        //图书在馆和读者证件状态有效才可以借书
        if(read.getRdStatus().equals("有效")&&book.getBkStatus().equals("在馆"))
        {
            String OperatorLend = (String) session.getAttribute("rdName");
            System.out.println("这是借书管理员" + OperatorLend);
            borrow.setOperatorLend(OperatorLend);
            borrow.setRdID(rdID);
            borrow.setBkID(bkID);
            //获取当前时间为借书时间，在根据读者类型给出应还时间
           //时间转换
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //上传时间
           // bro.setCreateTime(Timestamp.valueOf(nowTime));
            borrow.setLdDateOut(Timestamp.valueOf(nowTime));
            System.out.println("当前时间"+Timestamp.valueOf(nowTime));//获取时间成功
            //根据读者类型给出不同的归还日期
            if(read.getRdType().equals("教师")){
                //Date tomorrow = new java.util.Date( (new java.util.Date()).getTime()+86400000*60);
          /**      Date yes=new Date();
                SimpleDateFormat sdf_y = new SimpleDateFormat("yyyy-MM");
                Timestamp tomorrow = Timestamp.valueOf(sdf_y.format(yes)+"-30 23:59:59");
                borrow.setLdDateRetPlan(tomorrow);
                System.out.println("这是归还时间"+tomorrow);**/
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);//设置起时间
                cal.add(Calendar.MONTH, 2);
                System.out.println("输出归还日期::"+cal.getTime());
                borrow.setLdDateRetPlan(cal.getTime());
            }else{
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);//设置起时间
                cal.add(Calendar.MONTH, 1);
                System.out.println("输出归还日期::"+cal.getTime());
                borrow.setLdDateRetPlan(cal.getTime());
            }


            borrow.setLsHasReturn(0);
            borrowService.saveBorrow(borrow);


            // 要让读者借书数量加一，借书提交的时候把id传过来,只让数据库的借书数量加一
            System.out.println(borrow.getRdID());
            Integer iss = read.getRdBorrowQty();
            Integer ibq = iss + 1;
            System.out.println("11111" + iss);
            read.setRdBorrowQty(ibq);
            System.out.println("2222222" + read.getRdBorrowQty());
            readService.addBroQty(read);

            //还要改变图书的状态，在馆改为借出
            book.setBkStatus("借出");
            bookService.upBookStu(book);
            response.sendRedirect(request.getContextPath() + "/findAllBorrow");

        }else {
            System.out.println("不可借书！");
            request.getRequestDispatcher("/WEB-INF/pages/borrowbook.jsp").forward(request,response);

        }

        return;
    }

    @RequestMapping("/ReturnBook")
    public void ReturnBook(HttpServletResponse response,HttpSession session,int rdID,int bkID,int BorrowID,HttpServletRequest request)throws Exception{
  //还书就是让读者的已借数量减1，图书的状态由借出变为在馆，然后借书表增加还书管理员
        System.out.println(rdID);
        System.out.println(bkID);
        Read read = readService.getReadById(rdID);
        Book book = bookService.getItemById(bkID);
     //   Integer is = read.getRdBorrowQty();
      //  Integer ib = is-1;
      //  System.out.println(ib);
        read.setRdBorrowQty(0);
        readService.updateReadById(read);
        book.setBkStatus("在馆");
        bookService.upBookStu(book);
        //改变了图书表和读者表的信息就要删除这条借书记录了,不是删除，是要添加它的字段信息，实际还书日期,并添加还书操作员
        Borrow borrow=borrowService.getBorrowById(BorrowID);
        //borrow.setLdDateRetAct("已还");
        borrow.setLsHasReturn(1);
        String backuser = (String) session.getAttribute("rdName");
        borrow.setOperatorRet(backuser);
      //获取当前时间为归还时间
        String nowTimes = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        borrow.setLdDateRetAct(Timestamp.valueOf(nowTimes));

        //用归还日期减去借书日期得到超期天数，然后计算罚款金额，超期金额

        SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd HH:mm:ss");
        Date curDate= new Date(System.currentTimeMillis());//获取当前时间       
        //Date parse = formatter.parse(String.valueOf(borrow.getLdDateRetPlan()));
        //Date c=new Date(String.valueOf(borrow.getLdDateRetPlan()));
        long yy = curDate.getTime() - borrow.getLdDateRetPlan().getTime();//当前日期减去应还日期就是超期天数
        System.out.println("这是超期天数"+yy/(24 * 60 * 60 * 1000));//相差多少天

        borrow.setLdOverDay(Math.toIntExact(yy / (24 * 60 * 60 * 1000)));
        if(Math.toIntExact(yy/(24 * 60 * 60 * 1000))>0)
        {
            borrow.setLdOverMoney(book.getBkPrice()*0.05);
            borrow.setLdPunishMoney(book.getBkPrice()*1.05);
        }else {
            borrow.setLdOverDay(0);
            borrow.setLdOverMoney(0.00);
            borrow.setLdPunishMoney(0.00);
        }

        //设置续借次数为0
       // borrow.setLdContinueTimes(0);
        //borrow.setOperatorRet("Arya");
        borrowService.updateBorrow(borrow);
        response.sendRedirect(request.getContextPath() + "/findAllBorrow");
        return;
    }


    @RequestMapping("/ContinueBook")
    public void ContinueBook(HttpServletResponse response,HttpSession session,int rdID,int bkID,int BorrowID,HttpServletRequest request)throws Exception{
       //续借是还没还书就再借！！！！！！
        //不要理解错误！！！！！
        //续借只需要更新借书表，更新两个时间和续借数量，不需要更新读者表和图书表，续借的前置条件不能搞错
        Read read = readService.getReadById(rdID);
        Book book = bookService.getItemById(bkID);
        if(read!=null&&!read.getRdStatus().equals("挂失")){
            Borrow borrow=borrowService.getBorrowById(BorrowID);
            //设置续借次数为一
          //  Integer is=borrow.getLdContinueTimes()+1;
           // borrow.setLdContinueTimes(borrow.getLdContinueTimes()+1);
            //获取当前时间为借书时间再算出应还日期
          //获取当前时间为借书时间，在根据读者类型给出应还时间
            //时间转换
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            //上传时间
            // bro.setCreateTime(Timestamp.valueOf(nowTime));
            borrow.setLdDateOut(Timestamp.valueOf(nowTime));
            System.out.println("当前时间"+Timestamp.valueOf(nowTime));//获取时间成功
            //根据读者类型给出不同的归还日期
            if(read.getRdType().equals("教师")){
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);//设置起时间
                cal.add(Calendar.MONTH, 2);
                System.out.println("输出归还日期::"+cal.getTime());
                borrow.setLdDateRetPlan(cal.getTime());
            }else{
                Date date = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);//设置起时间
                cal.add(Calendar.MONTH, 1);
                System.out.println("输出归还日期::"+cal.getTime());
                borrow.setLdDateRetPlan(cal.getTime());
            }
           // borrow.getLdDateRetAct();
            borrow.setLdContinueTimes(1);
            borrowService.updateBorrow(borrow);
        response.sendRedirect(request.getContextPath() + "/findAllBorrow");}
        else {
            request.getRequestDispatcher("/WEB-INF/pages/borrowbook.jsp").forward(request,response);
        }
        return;
    }
}

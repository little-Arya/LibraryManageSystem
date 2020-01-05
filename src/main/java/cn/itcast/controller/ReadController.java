package cn.itcast.controller;

import cn.itcast.domain.Read;
import cn.itcast.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ReadController {

    @Autowired
    private ReadService readService;

    @RequestMapping("/loginServletRead")
    public ModelAndView login(String rdName, Integer rdPwd, ModelAndView mv, HttpSession session, HttpServletRequest request){

        Read read=readService.login(rdName, rdPwd);
        String username1=request.getParameter("rdName");
        String password1=request.getParameter("rdPwd");
        System.out.println(username1);
        System.out.println(password1);
        System.out.println(read);

        //Integer is=read.getRdID();
        //说明匹配到了

        Read read2=readService.getReadByName(rdName);
        if(read!=null){
            //这是管理员
            if(read2.getRdAdminRoles().equals("管理员")) {
                session.setAttribute("read", read);
                //放在session方便后面取名字
                request.getSession().setAttribute("rdName",rdName);
                mv.setViewName("system");
            }
            else {
                //这是普通用户
                //这是普通用户
                //登录成功，将user对象设置到HttpSession作用范围域中
                Read read1 = readService.getReadById(read.getRdID());
                String rdStatus=read1.getRdStatus();
                System.out.println(rdStatus);
                if(rdStatus.equals("挂失"))
                {
                    //登录失败，设置失败信息，并调转到登录页面
                    mv.addObject("message","状态为挂失，不能登录");
                    System.out.println("挂失状态不可登录");
                    mv.setViewName("redirect:/index.jsp");

                }else {
                    session.setAttribute("read", read);
                    //转发到main请求
                    //  mv.setView(new RedirectView("/index.jsp"));
                    System.out.println("登录成功");
                    System.out.println(rdName);
                    //放在session方便后面取名字
                    request.getSession().setAttribute("rdName",rdName);
                    mv.setViewName("user");
                }}
        }
        else {
            //登录失败，设置失败信息，并调转到登录页面
            mv.addObject("message","登录名和密码错误，请重新输入");
            System.out.println("登录名和密码错误，请重新输入");
            mv.setViewName("redirect:/index.jsp");
        }
        return mv;
    }



    //查询所有账户
    @RequestMapping("/findAllRead")
    public String findAllRead(Model model){
        System.out.println("表现层：查询所有账户。。。。");
        //调用service方法
        List<Read> list=readService.findAllRead();
        model.addAttribute("listRead",list);
        //    accountService.findAll();
        return "listRead";
    }

    //添加图书信息
    @RequestMapping("/addRead")
    public String addRead(MultipartFile rdPhoto, HttpServletRequest request) throws IOException {
        System.out.println("保存账户");
        //因为封装不上信息所以用这种新方法
        Read read=new Read();

        String rdName=request.getParameter("rdName");
        System.out.println(rdName);
        read.setRdName(rdName);
        String rdSex=request.getParameter("rdSex");
        System.out.println(rdSex);
        read.setRdSex(rdSex);
        String rdType=request.getParameter("rdType");
        System.out.println(rdType);
        read.setRdType(rdType);
        String rdDept=request.getParameter("rdDept");
        System.out.println(rdDept);
        read.setRdDept(rdDept);
        String rdPhone=request.getParameter("rdPhone");
        System.out.println(rdPhone);
        read.setRdPhone(rdPhone);
        String rdEmail=request.getParameter("rdEmail");
        System.out.println(rdEmail);
        read.setRdEmail(rdEmail);
        String rdDateReg=request.getParameter("rdDateReg");
        System.out.println(rdDateReg);
        read.setRdDateReg(rdDateReg);
        String rdStatus=request.getParameter("rdStatus");
        System.out.println(rdStatus);
        read.setRdStatus(rdStatus);
        Integer rdBorrowQty= Integer.valueOf(request.getParameter("rdBorrowQty"));
        read.setRdBorrowQty(rdBorrowQty);
        String rdPwd=request.getParameter("rdPwd");
        read.setRdPwd(rdPwd);
        String rdAdminRoles=request.getParameter("rdAdminRoles");
        System.out.println(rdAdminRoles);
        read.setRdAdminRoles(rdAdminRoles);

        String imgs=rdPhoto.getOriginalFilename();

        System.out.println("111111111111111111");

        //图片上传成功后，将图片的地址写到数据库
        String filePath = "E:\\images";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = rdPhoto.getOriginalFilename();
        System.out.println(originalFilename);
        //新的文件名字
        String newFileName = UUID.randomUUID()+originalFilename;

        read.setRdPhoto(newFileName);
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        rdPhoto.transferTo(targetFile);
        //文件名保存到实体类对应属性上

        //  accountService.saveAccount(account);
        readService.saveRead(read);
        System.out.println(newFileName);

        return "redirect:/findAllRead";

    }

    //模糊查询
    @RequestMapping("/getReadByTDN")
    public String getReadByTDN(Read read ,Model model) {
        List<Read> items = readService.getItemByTDN(read);
        System.out.println(read.getRdDept());
        System.out.println(read.getRdAdminRoles());
        System.out.println(items);
        model.addAttribute("items", items); // 将数据放在model中
        return "items"; // 返回视图
    }

    //注销借书证
    @RequestMapping("/deleteReadById")
    public String deleteReadById(int rdID) { //接收页面的请求id
        readService.deleteReadById(rdID);
        System.out.println("删除成功");
        return "redirect:/findAllRead";  //重定向到展示数据页面
    }


    /** 接收用户id,展示id对应的用户信息*/
    @RequestMapping("/updateRead")
    public String updateRead(Model model,int rdID,HttpServletRequest request) {
        Read read = readService.getReadById(rdID);

        System.out.println(read.getRdID());

        int ids=read.getRdID();
        request.setAttribute("ids",ids);

        String rdName=read.getRdName();
        request.setAttribute("rdName", rdName);
        String rdSex=read.getRdSex();
        request.setAttribute("rdSex", rdSex);
        String rdType=read.getRdType();
        request.setAttribute("rdType", rdType);
        String rdDept=read.getRdDept();
        request.setAttribute("rdDept", rdDept);
        String rdPhone=read.getRdPhone();
        request.setAttribute("rdPhone", rdPhone);
        String rdEmail=read.getRdEmail();
        request.setAttribute("rdEmail",rdEmail);
        String rdDateReg=read.getRdDateReg();
        request.setAttribute("rdDateReg", rdDateReg);
        String rdPhoto=read.getRdPhoto();
        request.setAttribute("rdPhoto", rdPhoto);

        String rdStatus=read.getRdStatus();
        request.setAttribute("rdStatus", rdStatus);
        Integer rdBorrowQty=read.getRdBorrowQty();
        request.setAttribute("rdBorrowQty", rdBorrowQty);
        String rdPwd=read.getRdPwd();
        request.setAttribute("rdPwd",rdPwd);
        String rdAdminRoles=read.getRdAdminRoles();
        request.setAttribute("rdAdminRoles", rdAdminRoles);

        model.addAttribute("readupdate",read);
        return "readupdate";

    }

    /** 接收客户端修改的数据,在数据库中更新,重定向到showAll*/
    @RequestMapping("/doreadupdata")
    public String doreadupdata(Read read) {
        readService.updateReadById(read);
        return "redirect:/findAllRead";
    }


    @RequestMapping("/findOneread")
    public ModelAndView findOneread(int rdID, ModelAndView mv,Model model, HttpServletRequest request){
        Read read=readService.getReadById(rdID);
        System.out.println(rdID);

        if (read!=null){
        int ids=read.getRdID();
        request.setAttribute("ids",ids);
        String rdName=read.getRdName();
        request.setAttribute("rdName", rdName);
        String rdSex=read.getRdSex();
        request.setAttribute("rdSex", rdSex);
        String rdType=read.getRdType();
        request.setAttribute("rdType", rdType);
        String rdDept=read.getRdDept();
        request.setAttribute("rdDept", rdDept);
        String rdPhone=read.getRdPhone();
        request.setAttribute("rdPhone", rdPhone);
        String rdEmail=read.getRdEmail();
        request.setAttribute("rdEmail",rdEmail);
        String rdDateReg=read.getRdDateReg();
        request.setAttribute("rdDateReg", rdDateReg);
        String rdPhoto=read.getRdPhoto();
        request.setAttribute("rdPhoto", rdPhoto);

        String rdStatus=read.getRdStatus();
        request.setAttribute("rdStatus", rdStatus);
        Integer rdBorrowQty=read.getRdBorrowQty();
        request.setAttribute("rdBorrowQty", rdBorrowQty);
        String rdPwd=read.getRdPwd();
        request.setAttribute("rdPwd",rdPwd);
        String rdAdminRoles=read.getRdAdminRoles();
        request.setAttribute("rdAdminRoles", rdAdminRoles);

        model.addAttribute("borrowmanage",read);
        mv.setViewName("borrowmanage");
       // return "borrowmanage";
        }
        else {
            //登录失败，设置失败信息，并调转到登录页面
            mv.addObject("message","不存在此用户");
            System.out.println("不存在此用户");
            mv.setViewName("borrowmanage");
        }
        return  mv;
    }

}

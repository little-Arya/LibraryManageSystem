package cn.itcast.controller;

import cn.itcast.domain.Book;
import cn.itcast.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //查询所有账户
    @RequestMapping("/findAllBook")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户。。。。");
        //调用service方法
        List<Book> list=bookService.findAllBook();
        model.addAttribute("list",list);
        //    accountService.findAll();
        return "list";
    }

    //添加图书信息
    @RequestMapping("/addbook")
    public String addbook(MultipartFile bkCover, HttpServletRequest request) throws IOException {
        System.out.println("保存账户");
        //因为封装不上信息所以用这种新方法
        Book book=new Book();

        String bkCode=request.getParameter("bkCode");
        System.out.println(bkCode);
        book.setBkCode(bkCode);
        String bkName=request.getParameter("bkName");
        System.out.println(bkName);
        book.setBkName(bkName);
        String bkAuthor=request.getParameter("bkAuthor");
        System.out.println(bkAuthor);
        book.setBkAuthor(bkAuthor);
        String bkPress=request.getParameter("bkPress");
        System.out.println(bkPress);
        book.setBkPress(bkPress);
        String bkDatePress=request.getParameter("bkDatePress");
        System.out.println(bkDatePress);
        book.setBkDatePress(bkDatePress);
        String bkISBN=request.getParameter("bkISBN");
        System.out.println(bkISBN);
        book.setBkISBN(bkISBN);
        String bkCatalog=request.getParameter("bkCatalog");
        System.out.println(bkCatalog);
        book.setBkCatalog(bkCatalog);
        String bkLanguage=request.getParameter("bkLanguage");
        System.out.println(bkLanguage);
        book.setBkLanguage(bkLanguage);
        Integer bkPages=Integer.parseInt(request.getParameter("bkPages"));
        System.out.println(bkPages);
        book.setBkPages(bkPages);
        Double bkPrice=Double.parseDouble(request.getParameter("bkPrice"));
        System.out.println(bkPrice);
        book.setBkPrice(bkPrice);
        String bkBrief=request.getParameter("bkBrief");
        System.out.println(bkBrief);
        book.setBkBrief(bkBrief);
        String bkDateIn=request.getParameter("bkDateIn");
        System.out.println(bkDateIn);
        book.setBkDateIn(bkDateIn);
        String bkStatus=request.getParameter("bkStatus");
        System.out.println(bkStatus);
        book.setBkStatus(bkStatus);

        String imgs=bkCover.getOriginalFilename();

        System.out.println("111111111111111111");

        //图片上传成功后，将图片的地址写到数据库
        String filePath = "E:\\images";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = bkCover.getOriginalFilename();
        System.out.println(originalFilename);
        //新的文件名字
        String newFileName = UUID.randomUUID()+originalFilename;

        book.setBkCover(newFileName);
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        bkCover.transferTo(targetFile);
        //文件名保存到实体类对应属性上

      //  accountService.saveAccount(account);
        bookService.saveBook(book);
        System.out.println(newFileName);


        return "redirect:/findAllBook";

    }


    @RequestMapping("/deleteItemById")
    public String deleteItemById(int bkID) { //接收页面的请求id
        bookService.deleteItemById(bkID);
        System.out.println("删除成功");
        return "redirect:/findAllBook";  //重定向到展示数据页面
    }


    /** 接收用户id,展示id对应的用户信息*/
    @RequestMapping("/updatebook")
    public String update(Model model,int bkID,HttpServletRequest request) {
       Book book = bookService.getItemById(bkID);

        System.out.println(book.getBkID());
        System.out.println(book.getBkName());

        int ids=book.getBkID();
        request.setAttribute("ids",ids);

        String bkCode=book.getBkCode();
        request.setAttribute("bkCode", bkCode);
        String bkName=book.getBkName();
        request.setAttribute("bkName", bkName);
        String bkAuthor=book.getBkAuthor();
        request.setAttribute("bkAuthor", bkAuthor);
        String bkPress=book.getBkPress();
        request.setAttribute("bkPress", bkPress);
        String bkDatePress=book.getBkDatePress();
        request.setAttribute("bkDatePress", bkDatePress);
        String bkISBN=book.getBkISBN();
        request.setAttribute("bkISBN", bkISBN);
        String bkCatalog=book.getBkCatalog();
        request.setAttribute("bkCatalog", bkCatalog);
        String bkLanguage=book.getBkLanguage();
        request.setAttribute("bkLanguage", bkLanguage);
        Integer bkPages=book.getBkPages();
        request.setAttribute("bkPages",bkPages);

        Double bkPrice=book.getBkPrice();
        request.setAttribute("bkPrice",bkPrice);

        String bkDateIn=book.getBkDateIn();
        request.setAttribute("bkDateIn", bkDateIn);
        String bkBrief=book.getBkBrief();
        request.setAttribute("bkBrief", bkBrief);
        String bkCover=book.getBkCover();
        request.setAttribute("bkCover",bkCover);
        String bkStatus=book.getBkStatus();
        request.setAttribute("bkStatus", bkStatus);


        model.addAttribute("bookupdate",book);
        return "bookupdate";

    }


    /** 接收客户端修改的数据,在数据库中更新,重定向到showAll*/
    @RequestMapping("/doupdata")
    public String doupdata(Book book) {
        bookService.updateBookById(book);
        return "redirect:/findAllBook";
    }


    //模糊查询
    @RequestMapping("/getBOOKByTDN")
    public String getBOOKByTDN(Book book,Model model) {
        List<Book> items = bookService.getBookByCNA(book);
        model.addAttribute("bookpage", items); // 将数据放在model中
        return "bookpage"; // 返回视图
    }

    //模糊查询
    @RequestMapping("/getBOOKByTDNSB")
    public String getBOOKByTDNSB(Book book,Model model) {
        List<Book> items = bookService.getBookByCNA(book);
        System.out.println(book);
        model.addAttribute("borrowmanage1", items); // 将数据放在model中
        return "borrowmanage"; // 返回视图
    }
}

package cn.itcast.controller;

import cn.itcast.domain.Read;
import cn.itcast.domain.User;
import cn.itcast.service.ReadService;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReadService readService;
    //登录操作

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model){
        System.out.println("表现层：查询所有账户。。。。");
        //调用service方法
        List<User> lists=userService.findAllUser();

        System.out.println(lists);

        model.addAttribute("usermanage",lists);
        //    accountService.findAll();
        return "usermanage";
    }


    @RequestMapping("/loginServlet")
    public ModelAndView login(String username, String password, ModelAndView mv, HttpSession session, HttpServletRequest request){

        User user=userService.login(username, password);
        String username1=request.getParameter("username");
        String password1=request.getParameter("password");

        System.out.println(username1);
        if(user!=null){
            //这是管理员
            if(username1.equals("admin")&&password1.equals("admin")) {
                session.setAttribute("user", user);
                mv.setViewName("system");
            }
            else {
                    //这是普通用户
                    //这是普通用户
                    //登录成功，将user对象设置到HttpSession作用范围域中
                Read read = readService.getReadById(Integer.parseInt(username1));
                String rdStatus=read.getRdStatus();
                System.out.println(rdStatus);
                if(rdStatus.equals("挂失"))
                {
                    //登录失败，设置失败信息，并调转到登录页面
                    mv.addObject("message","状态为挂失，不能登录");
                    System.out.println("挂失状态不可登录");
                    mv.setViewName("redirect:/index.jsp");

                }else {
                    session.setAttribute("user", user);
                    //转发到main请求
                    //  mv.setView(new RedirectView("/index.jsp"));
                    System.out.println("登录成功");
                    System.out.println(username);
                    //放在session方便后面取名字
                    request.getSession().setAttribute("username",username);
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

    @RequestMapping("/system")
    public void system(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //   accountService.saveAccount(account);
        request.getRequestDispatcher("/WEB-INF/pages/system.jsp").forward(request,response);
    }

    //页面跳转
    @RequestMapping("/readmanage")
    public void readmanage(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //   accountService.saveAccount(account);
        request.getRequestDispatcher("/WEB-INF/pages/readmanage.jsp").forward(request,response);

    }
    @RequestMapping("/borrowmanage")
    public void borrowmanage(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //   accountService.saveAccount(account);
        request.getRequestDispatcher("/WEB-INF/pages/borrowmanage.jsp").forward(request,response);

    }
    @RequestMapping("/usermanage")
    public void usermanage(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //   accountService.saveAccount(account);
        request.getRequestDispatcher("/WEB-INF/pages/usermanage.jsp").forward(request,response);

    }

    //注销登录
    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request){
        request.getSession().setAttribute("user", null);
        return "redirect:/index.jsp";
    }

    @RequestMapping("/toUser")
    public void toUser(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //   accountService.saveAccount(account);
        request.getRequestDispatcher("/WEB-INF/pages/user.jsp").forward(request,response);
    }

    //修改用户密码
    @RequestMapping("/toChangePwd")
    public String toChangePwd( Model model, HttpServletRequest request){
        //获取用户名
        HttpSession session = request.getSession();
        String username= (String) session.getAttribute("rdName");
        System.out.println(username);

      //  System.out.println(username);
        //通过id获=获取所有信息
        Read read = readService.getReadByName(username);
        //System.out.println(read.getRdAdminRoles());

       // Integer ids=read.getRdID();
        request.setAttribute("rdID",read.getRdID());

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


        model.addAttribute("cpd",read);

        return "cpd";
    }


    /** 接收客户端修改的数据,在数据库中更新,重定向到showAll*/
    @RequestMapping("/CPBreadupdata")
    public String CPBreadupdata(Read read,Integer rdID, HttpServletRequest request) {
        System.out.println(rdID);
        System.out.println(read.getRdAdminRoles());
     //   System.out.println(request .getParameter("rdName"));
        Integer username=read.getRdID();
        System.out.println(username);
        readService.updateReadById(read);

        return "redirect:/toChangePwd";
    }

    @RequestMapping("/toborrow")
    public void toborrow(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        //   accountService.saveAccount(account);
        request.getRequestDispatcher("/WEB-INF/pages/borrowbook.jsp").forward(request,response);
    }



    //用户管理
    //删除用户类型
    @RequestMapping("/deleteTYReadById")
    public String deleteTYReadById(int rdType) { //接收页面的请求id
        userService.deleteTYReadById(rdType);
        System.out.println("删除成功");
        return "redirect:/findAllUser";  //重定向到展示数据页面
    }

    //修改用户类型
    @RequestMapping("/updateTYRead")
    public String updateTYRead(Model model,int rdType,HttpServletRequest request){

        User user=userService.getRTByType(rdType);

        int ids=user.getRdType();
        request.setAttribute("ids",ids);

        String rdTypeName=user.getRdTypeName();
        request.setAttribute("rdTypeName", rdTypeName);
        Integer canendQty=user.getCanendQty();
        request.setAttribute("canendQty",canendQty);
        Integer canendDay=user.getCanendDay();
        request.setAttribute("canendDay",canendDay);

        Integer canContinueTimes=user.getCanendDay();
        request.setAttribute("canContinueTimes",canContinueTimes);
        Double punishRate=user.getPunishRate();
        request.setAttribute("punishRate",punishRate);

        Integer pateValid=user.getPateValid();
        request.setAttribute("pateValid",pateValid);


        model.addAttribute("userupdate",user);
        return "userupdate";

    }

    /** 接收客户端修改的数据,在数据库中更新,重定向到showAll*/
    @RequestMapping("/TYupdata")
    public String TYupdata(User user) {
        userService.updateTYById(user);
        return "redirect:/findAllUser";
    }
}

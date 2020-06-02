package org.controller;

import org.po.User;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session){
        //通过账号和密码查询用户
        User user=userService.findUser(usercode,password);
        if(user!=null){
            //将用户对象添加到Session
            session.setAttribute("USER_SESSION",user);
            //跳转到主页面
            //return "customer";
            return "redirect:customer/list.action";
        }
        model.addAttribute("msg","账号或密码错误，请重新输入！");
        //返回到登录页面
        return "login";
    }
    @RequestMapping(value = "/toCustomer.action")
    public String toCustomer(){
        return "customer";
    }
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        //清楚Session
        session.invalidate();
        //重定向到登录页面的跳转页面
        return "redirect:login.action";
    }
    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
}

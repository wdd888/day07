package net.wanho.controller;

import net.wanho.entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/4.
 */
@Controller
public class LojinController {
    @RequestMapping("login")
    public String login(String username, String password,String index, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        if("admin".equals(username)&&"123456".equals(password)){
            User user=new User(username,password);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user",user);
            if ("on".equals(index)){
                Cookie cookie=new Cookie("user",username+"-"+password);
                cookie.setMaxAge(3600*24*5);
                httpServletResponse.addCookie(cookie);
            }
            return  "redirect:/toSuccess";
        }

        return "error";

    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("toSuccess")
    public String toSuccess(){
        return "success";
    }
    @RequestMapping("toError")
    public String toError(){
        return "error";
    }


}

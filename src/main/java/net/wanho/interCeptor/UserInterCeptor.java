package net.wanho.interCeptor;

import net.wanho.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/6/4.
 */
public class UserInterCeptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
           response.sendRedirect("toSuccess");
            return false;

        }

        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if ("user".equals(cookies[i].getName())) {
                cookie = cookies[i];
            }
        }
        if (cookie != null) {
            String[] temp = cookie.getValue().split("-");
            if ("admin".equals(temp[0]) && "123456".equals(temp[1])) {
                User user = new User(temp[0], temp[1]);
                session.setAttribute("user", user);
                response.sendRedirect("toSuccess");
                return false;
            }
        }
        return true;
    }
}

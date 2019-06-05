package net.wanho.exceptionResolver;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/6/4.
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        logger.error(e.getMessage()+"*******************************************************");
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "服务器异常");
        modelAndView.setViewName("error");
        return modelAndView;

    }
}

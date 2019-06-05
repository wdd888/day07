package net.wanho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/6/4.
 */
@Controller
public class TestController {
    @RequestMapping("testInterCeptor")
    public  String testInterCeptor(){
        System.out.println(1);
        return "success";
    }
}

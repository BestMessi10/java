package com.imooc.springbootimoocstarter.controller;

import com.imooc.springbootimoocstarter.config.WebMvcConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @RequestMapping("/")
    public String index(){
        return "thymeleaf/index1";
    }
    @RequestMapping("/login")
    public String login(){
        return "thymeleaf/login";
    }
    @RequestMapping("/loginPost")
    public String loginPost(String name, String password, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return "thymeleaf/login";
        }
        session.setAttribute(WebMvcConfigurer.SESSION_KEY,name);
        map.put("success", true);
        map.put("message", "登录成功");
        return "thymeleaf/index1";
    }
    @RequestMapping("/logout")
    public String loginOut(HttpSession session){
        session.removeAttribute(WebMvcConfigurer.SESSION_KEY);
        return "thymeleaf/login";
    }
}

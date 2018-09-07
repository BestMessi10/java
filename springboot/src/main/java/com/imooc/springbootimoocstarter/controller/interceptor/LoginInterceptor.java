package com.imooc.springbootimoocstarter.controller.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import static com.imooc.springbootimoocstarter.config.WebMvcConfigurer.SESSION_KEY;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if(session.getAttribute(SESSION_KEY) !=null){
            return true;
        }
        //System.out.println(SESSION_KEY);
        String url = "/login";
        response.sendRedirect(url);
        return false;
    }
}

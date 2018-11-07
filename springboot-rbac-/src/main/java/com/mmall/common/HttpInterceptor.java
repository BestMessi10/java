package com.mmall.common;

import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request start. url:{}, params:{}", url, JsonMapper.obj2String(parameterMap));
//        long start = System.currentTimeMillis();
//        request.setAttribute(START_TIME, start);
        return true;
    }

    //正常情况结束之后都会调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
//        long start = (Long) request.getAttribute(START_TIME);
//        long end = System.currentTimeMillis();
        log.info("request finished. url:{}, cost:{}", url, JsonMapper.obj2String(parameterMap));
        removeThreadLocalInfo();
    }

    //任何情况下都会调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
//        long start = (Long) request.getAttribute(START_TIME);
//        long end = System.currentTimeMillis();
        log.info("request exception. url:{}, cost:{}", url, JsonMapper.obj2String(parameterMap));

        removeThreadLocalInfo();
    }

    public void removeThreadLocalInfo() {
        RequestHolder.remove();;
    }
}

package com.springapp.domain;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XssIntercepter extends HandlerInterceptorAdapter {

    private String path;
    private Policy policy;

    public XssIntercepter(String path) {
        this.path = path;
        try {
            this.policy = Policy.getInstance(this.path);
        } catch (PolicyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("time",System.currentTimeMillis());
        AntiSamy antiSamy = new AntiSamy();
        String input = request.getQueryString();
        if(input != null){
        final CleanResults cr = antiSamy.scan(input, policy, AntiSamy.SAX);
        response.getOutputStream().write(cr.getCleanHTML().getBytes());
        System.out.println("~~~~~~~~~~~"+cr.getCleanHTML());
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long currentTime = System.currentTimeMillis();
        Long preTime = (Long) request.getAttribute("time");
        request.setAttribute("time",currentTime- preTime);
        AntiSamy antiSamy = new AntiSamy();
        String queryString = request.getQueryString();
        if(queryString != null){
        final CleanResults cr = antiSamy.scan(queryString, policy, AntiSamy.SAX);
        response.getOutputStream().write(cr.getCleanHTML().getBytes());
        System.out.println("~~~~~~~~~~~"+cr.getCleanHTML());
        }
    }
}

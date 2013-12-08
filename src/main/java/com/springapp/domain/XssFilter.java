package com.springapp.domain;


import org.owasp.validator.html.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class XssFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
        if ("text/html;charset=UTF-8".equals(response.getContentType())) {
            try {
                String path = "src/main/resources/antisamy-myspace-1.4.4.xml";
                Policy policy = Policy.getInstance(path);
                AntiSamy antiSamy = new AntiSamy();

                CleanResults cleanResults = antiSamy.scan(request.getParameter("input"), policy, AntiSamy.SAX);
                response.getOutputStream().write(cleanResults.getCleanHTML().getBytes());
            } catch (ScanException e) {
                e.printStackTrace();
            } catch (PolicyException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}

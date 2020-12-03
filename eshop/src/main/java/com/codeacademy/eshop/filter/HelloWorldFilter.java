package com.codeacademy.eshop.filter;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import java.io.IOException;

@Component
public class HelloWorldFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------------- Hello, World!!! Execution started! ------------------------");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        filterChain.doFilter(servletRequest, servletResponse);

        stopWatch.stop();
        System.out.println("----------------- Execution ended!!! Time passed: " + stopWatch.getLastTaskTimeMillis() + "ms ------------------------");
    }

}

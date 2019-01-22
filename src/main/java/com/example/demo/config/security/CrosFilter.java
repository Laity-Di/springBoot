package com.example.demo.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ryan
 * @since: 2018/11/9 14:11
 * @description: 权限过滤器，过滤器是基于servlet
 * @modifyTime:
 * @modifier:
 */
public class CrosFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrosFilter.class);

    @Value("${filter.allowedOrigin}")
    private String allowedOrigin;

    @Value("${filter.allowedHeaders}")
    private String allowedHeaders;

    private static final Set<String> DISALLOWED_METHOD = new HashSet<>();

    static {
        DISALLOWED_METHOD.add("OPTIONS");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", allowedHeaders);
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if (DISALLOWED_METHOD.contains(request.getMethod())) {
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}

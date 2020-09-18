package com.carrot.train.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            System.out.println("name=" + name + ";value=" + servletConfig.getInitParameter(name));
        }
        this.config = servletConfig;

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {


        Enumeration<String> parameterNames = servletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println("name=" + name + ";value=" + servletRequest.getParameter(name));
        }
        servletResponse.setContentType("text/html;charset=UTF-8");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println("========请求头");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println("key=" + name + ";value=" + request.getHeader(name));
        }
        System.out.println("========请求头");



        servletResponse.getWriter().println(config.getInitParameter("bank"));
    }

    @Override
    public String getServletInfo() {
        return "2020-09-18";
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

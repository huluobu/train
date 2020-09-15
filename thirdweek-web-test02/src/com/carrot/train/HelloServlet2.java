package com.carrot.train;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet2")
public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("httpservlet request");
        ServletConfig servletConfig=getServletConfig();
        System.out.println(servletConfig);
/*        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("保存之前: Context1 获取 key1 的值是:"+ context.getAttribute("key1"));
        context.setAttribute("key1", "value1");
        System.out.println("Context1 中获取域数据 key1 的值是:"+ context.getAttribute("key1"));*/


    }



}

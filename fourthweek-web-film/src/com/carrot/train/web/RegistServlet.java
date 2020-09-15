package com.carrot.train.web;


import com.carrot.train.enetity.User;
import com.carrot.train.impl.UserServiceImpl;
import com.carrot.train.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if (userService.existsUsername(username)) {
            System.out.println("用户名[" + username + "]已存在!");

            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "用户名已存在！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

//        跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        } else {
            //      可用
//                调用Sservice保存到数据库
            userService.registUser(new User(null, username, password, email));
//
//        跳到注册成功页面 regist_success.jsp
            req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
        }

    }
}

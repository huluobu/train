package com.carrot.train.spring.controller;

import com.carrot.train.spring.MD5Util;
import com.carrot.train.spring.enetity.Users;
import com.carrot.train.spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;

    /**
     * 登录页面
     * @return
     */
    @GetMapping(value = {"/login", "/"})
    public Object login() {
        return "login";
    }

    /**
     * 登录提交
     * @return
     */
    @PostMapping("/submitLogin")
    public Object submitLogin(String staffCode, String password, Model model,
                              HttpServletRequest request) {
        String msg = null;
        if (null == staffCode || null == password) {
            msg = "参数错误";
        } else {
            Users users = (Users) this.usersService.findByPrimaryKey(staffCode);
            if (null == users) {
                msg = "用户不存在";
            } else if (!password.equals(users.getPassword())) {
                msg = "用户密码错误";
            }

            users.setLoginTime(new Date());
            this.usersService.update(users);
        }
        if (null != msg) {
            model.addAttribute("msg", msg);
            return "error";
        }
        String token = MD5Util.MD5(staffCode);
        request.getSession().setAttribute("token", token);
        request.getSession().setAttribute("staffCode", staffCode);

        return "redirect:/home";
    }

    /**
     * home主页
     * @return
     */
    @GetMapping("/home")
    public Object home(Model model, HttpServletRequest request) {
        model.addAttribute("staffCode", request.getSession().getAttribute("staffCode"));

        return "home";
    }
}

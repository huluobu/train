package com.carrot.train.spring.controller;

import com.carrot.train.spring.enetity.Staff;
import com.carrot.train.spring.enetity.Users;
import com.carrot.train.spring.enums.StaffTypeEnum;
import com.carrot.train.spring.enums.StatusEnum;
import com.carrot.train.spring.services.StaffService;
import com.carrot.train.spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private StaffService staffService;
    @Autowired
    private UsersService usersService;

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public Object register() {
        return "register";
    }

    /**
     * 注册提交
     * @return
     */
    @PostMapping("/submitRegister")
    public Object submitRegister(String staffCode, String staffName, String password,
                                 Model model, HttpServletRequest request) throws Exception {
        if (null == staffCode || null == staffName || null == password) {
            model.addAttribute("msg", "参数错误");
            return "error";
        }

        if (null != staffService.findByPrimaryKey(staffCode)) {
            model.addAttribute("msg", "登录名已被注册");
            return "error";
        }

        Staff staff = new Staff();
        staff.setStaffCode(staffCode);
        staff.setStaffName(staffName);
        staff.setStatus(StatusEnum.ENABLED.getCode());
        staff.setStaffType(StaffTypeEnum.COMMON.getCode());
        this.staffService.insert(staff);

        Users users = new Users();
        users.setUserId(staffCode);
        users.setPassword(password);
        users.setUserName(staffName);
        users.setEnabled(StatusEnum.ENABLED.getCode());
        this.usersService.insert(users);

        return "login";
    }
}

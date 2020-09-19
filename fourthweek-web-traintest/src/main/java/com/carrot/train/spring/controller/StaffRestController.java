package com.carrot.train.spring.controller;

import com.carrot.train.spring.enetity.Staff;
import com.carrot.train.spring.enums.GenerEnum;
import com.carrot.train.spring.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StaffRestController {

    @Autowired
    private StaffMapper staffMapper;

    @GetMapping("/saveStaff")
    public Object saveStaff() {

        Staff staff = new Staff();
        staff.setStaffCode("pactera");
        staff.setStaffName("光大信用卡");
        staff.setGender(GenerEnum.M.getCode());
        staff.setStaffType("ADMIN");
        staff.setStatus("ENABLE");

        this.staffMapper.insert(staff);

        return staff;
    }

//    @GetMapping("/getStaff")
////    public Object getStaff(String staffCode) {
////        return this.staffMapper.getStaffWithStaffCode(staffCode, "ADMIN");
////    }

    @GetMapping("/listStaff")
    public Object listStaff() {
        return this.staffMapper.selectStaff();
    }
}

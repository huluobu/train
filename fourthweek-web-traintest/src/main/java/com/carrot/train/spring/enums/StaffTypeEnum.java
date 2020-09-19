package com.carrot.train.spring.enums;

/**
 * @description:
 * @author: Lance
 * @create: 2020-09-19
 **/
public enum  StaffTypeEnum {
    ADMINS("管理员","AMDINS"),
    COMMON("普通员工", "COMMON");

    private String name;
    private String code;

    StaffTypeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

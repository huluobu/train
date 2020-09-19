package com.carrot.train.spring.enums;

/**
 * @description: 状态
 * @author: Lance
 * @create: 2020-09-19
 **/
public enum StatusEnum {
    ENABLED("启动", "ENABLED"),
    FORBIDDEN("禁用", "FORBIDDEN");

    private String name;
    private String code;

    StatusEnum(String name, String code) {
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

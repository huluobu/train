package com.carrot.train.spring.enums;

public enum GenerEnum {
    M("男性", "M"),
    F("女性", "F"),
    O("其它", "O");


    private String name;
    private String code;

    GenerEnum(String name, String code) {
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

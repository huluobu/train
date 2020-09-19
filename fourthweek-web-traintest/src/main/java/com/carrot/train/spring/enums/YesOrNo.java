package com.carrot.train.spring.enums;

public enum YesOrNo {
    YES("是", "Y"),
    NO("否", "N");

    private String name;
    private String value;

    YesOrNo(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

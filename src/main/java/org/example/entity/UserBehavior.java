package org.example.entity;

public class UserBehavior {
    // 修正属性定义
    private String name;  // 改用String类型
    private String value;

    // 补充name的setter
    public void setName(String name) {
        this.name = name;
    }

    // 补充value的setter
    public void setValue(String value) {
        this.value = value;
    }

    // 补全getter方法

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}


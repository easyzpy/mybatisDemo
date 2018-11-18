package com.imefuture.enumeration;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/18  18:50
 */
public enum EmpType {
    VIP(1, "会员"),
    Tourist(0, "游客");

    private Integer code;
    private String desc;

    EmpType(Integer code, String desc) {
        this.code = code;
//        this.code = new Integer(code);
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}


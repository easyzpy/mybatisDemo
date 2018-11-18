package com.imefuture.enumeration;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/18  21:18
 */
public enum Age {
    Young("20"),
    Old("30");

    private String desc;

    Age(String desc) {
        this.desc = desc;
    }
}

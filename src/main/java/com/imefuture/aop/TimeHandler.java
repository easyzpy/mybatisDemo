package com.imefuture.aop;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/4  23:00
 */
public class TimeHandler {
    private Long startTm;

    private Long endTm;

    public void beforeHandler(){
        this.startTm = System.currentTimeMillis();
        System.out.println("startTm: " + startTm);
    }

    public void afterHandler(){
        this.endTm = System.currentTimeMillis();
        System.out.println("endTm: " + endTm);
        System.out.println("totleTm: " + (endTm - startTm) + "ms");
    }
}

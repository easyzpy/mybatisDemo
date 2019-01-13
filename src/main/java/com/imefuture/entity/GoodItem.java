package com.imefuture.entity;

import com.imefuture.entity.base.BaseEntity;

public class GoodItem extends BaseEntity {
    private Integer goodItemId;
    private String name;

    public Integer getGoodItemId() {
        return goodItemId;
    }

    public void setGoodItemId(Integer goodItemId) {
        this.goodItemId = goodItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

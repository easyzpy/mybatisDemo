package com.imefuture.mapper;

import com.imefuture.entity.GoodItem;

import java.util.List;

public interface GoodItemDao {
    int insertGoodItem(GoodItem goodItem);

    List<GoodItem> goodItemList();

    Integer delGoodItem(Integer id);

}

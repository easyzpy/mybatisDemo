package com.imefuture.service;

import com.imefuture.entity.GoodItem;
import com.imefuture.mapper.GoodItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodItemServiceImpl {

    @Autowired
    private GoodItemDao goodItemDao;

    public GoodItem addGoodItem(GoodItem goodItem){
        if (goodItem.getName() == null || goodItem.getName().length() == 0){
            return null;
        }
        int i = goodItemDao.insertGoodItem(goodItem);
            return i > 0 ? goodItem: null;
    }

    public List<GoodItem> goodItemList(){
        return goodItemDao.goodItemList();
    }
    public boolean delGoodItem(Integer id){
        if (id == null || id < 0){
            return false;
        }
        Integer integer = goodItemDao.delGoodItem(id);
        return integer != null && integer > 0;
    }

}

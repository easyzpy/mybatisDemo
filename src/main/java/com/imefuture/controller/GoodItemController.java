package com.imefuture.controller;

import com.imefuture.entity.GoodItem;
import com.imefuture.service.GoodItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "goodItem")
public class GoodItemController {

    @Autowired
    private GoodItemServiceImpl goodItemService;
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<GoodItem> list(){


        return goodItemService.goodItemList();
    }

    @RequestMapping(value = "goodItem", method = RequestMethod.POST)
    public GoodItem add(@RequestBody GoodItem goodItem){
        return goodItemService.addGoodItem(goodItem);
    }
    @RequestMapping(value = "goodItem/{id}", method = RequestMethod.DELETE)
    public boolean del(@PathVariable("id") Integer id){
        return goodItemService.delGoodItem(id);
//        return false;
    }
}

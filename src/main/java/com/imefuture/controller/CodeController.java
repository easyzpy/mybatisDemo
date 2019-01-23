package com.imefuture.controller;

import com.imefuture.utils.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("redis")
public class CodeController {
    @Autowired
    private RedisCacheManager redisCacheManager;
    private static final String INSIDE_ORDER_CODE = "insideOrderCode";
    @RequestMapping("code")
    public Long getCode(){
        //直
        long insideOrderCode = redisCacheManager.incr(INSIDE_ORDER_CODE, 1L);
        if (insideOrderCode == 1){
            redisCacheManager.del(INSIDE_ORDER_CODE);
            long incr = redisCacheManager.incr(INSIDE_ORDER_CODE, 201901240001L);
            //设置过期时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY,0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            calendar.set(Calendar.MILLISECOND,0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(sdf.format(calendar.getTime()));
             redisCacheManager.expire(INSIDE_ORDER_CODE, System.currentTimeMillis() - calendar.getTimeInMillis(), TimeUnit.MILLISECONDS);
            long expire = redisCacheManager.getExpire(INSIDE_ORDER_CODE);
            System.out.println(expire);
            return incr;
        }

        return insideOrderCode;
    }
}

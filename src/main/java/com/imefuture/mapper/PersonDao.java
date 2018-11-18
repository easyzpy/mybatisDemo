package com.imefuture.mapper;

import com.imefuture.entity.Person;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhangpingyang
 * @Date: 2018/10/31  23:17
 */
public interface PersonDao {
    Person selectPerson(Long personId);
}

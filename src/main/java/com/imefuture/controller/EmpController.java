package com.imefuture.controller;

import com.imefuture.entity.Employee;
import com.imefuture.mapper.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/18  22:22
 */
@Controller
@RequestMapping(value = "emp")
public class EmpController {

    @Autowired
    private EmployeeDao empDao;

    @RequestMapping("list")
    @ResponseBody
    public List<Employee> list(){
        List<Employee> empList = empDao.getEmpList();
//        List<Employee> list = new ArrayList<>();
//        list.add(empAndDept);
        return empList;
    }
    @RequestMapping("table")
    public String table(){

        return "table";
    }
}

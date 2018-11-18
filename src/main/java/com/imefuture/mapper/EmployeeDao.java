package com.imefuture.mapper;

import com.imefuture.entity.Employee;

import java.util.List;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/7  23:54
 */
public interface EmployeeDao {
    Employee getEmpById(Integer empId);
    Employee getEmpAndDept(Integer empId);

    Integer insertEmployee(Employee employee);

    Integer insertEmployees(List<Employee> employees);

    List<Employee> getEmpList();

    Integer delEmp(String text);
}

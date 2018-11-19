package com.imefuture.mapper;

import com.imefuture.entity.Employee;
import org.apache.ibatis.annotations.Param;

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

    List<Employee> getEmpList(@Param("start") Integer start, @Param("end") Integer end);

    Integer delEmp(String text);
}

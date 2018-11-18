package com.imefuture.entity;

import com.imefuture.entity.base.BaseEntity;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/7  23:51
 */
@Alias("dept")
public class Department extends BaseEntity {
    private Integer deptId;
    private String departmentName;
    private Employee employee;
    private List<Employee> employees;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", departmentName='" + departmentName + '\'' +
                ", employee=" + employee +
                ", employees=" + employees +
                "} " + super.toString();
    }
}

package com.imefuture.entity;

import com.imefuture.entity.base.BaseEntity;
import com.imefuture.enumeration.Age;
import com.imefuture.enumeration.EmpType;
import org.apache.ibatis.type.Alias;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/7  23:50
 */
@Alias("emp")
public class Employee extends BaseEntity {
    private Integer empId;
    private String lastName;
    private String email;
    private String gender;
    private EmpType employeeType;
    private EmpType empType;
    private Age age;
    private Department dept;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public EmpType getEmpType() {
        return empType;
    }

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }

    public EmpType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmpType employeeType) {
        this.employeeType = employeeType;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", employeeType=" + employeeType +
                ", empType=" + empType +
                ", age=" + age +
                ", dept=" + dept +
                "} " + super.toString();
    }
}

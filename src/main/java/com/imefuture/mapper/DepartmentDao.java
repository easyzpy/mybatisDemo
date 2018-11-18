package com.imefuture.mapper;

import com.imefuture.entity.Department;

/**
 * @Author: zhangpingyang
 * @Date: 2018/11/15  23:13
 */
public interface DepartmentDao {
    Department findById(Integer deptId);
    Department findDeptAndEmpByDeptId(Integer deptId);
}

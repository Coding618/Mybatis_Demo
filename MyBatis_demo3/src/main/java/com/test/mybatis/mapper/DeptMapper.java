package com.test.mybatis.mapper;

import com.test.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 通过分步查询，查询员工所对应的部门信息
     * 分布查询第二步：通过did查询查询员工所对应的部门信息
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 获取部门，以及部门中的所有员工信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分布查询部门以及部门中员工的信息
     * 分步查询的第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}

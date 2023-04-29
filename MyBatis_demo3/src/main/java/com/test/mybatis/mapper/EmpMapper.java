package com.test.mybatis.mapper;

import com.test.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有员工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及对应的部门
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询，查询员工所对应的部门信息
     * 分布查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分布查询部门以及部门中员工的信息
     * 分步查询的第一步：根据did查询对应员工的信息
     */
    List<Emp> getDeptAndEmptByStepTwo(@Param("did") Integer did);
}

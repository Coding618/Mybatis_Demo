package com.test.mybatis.mapper;

import com.test.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /**
     * 通过id，查询员工信息
     */
    Emp getEmpByEid(@Param("eid") Integer eid);

    /**
     * 插入一个员工数据
     */
    void insertEmp(Emp emp);
}

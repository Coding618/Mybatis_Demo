package com.test.mybatis.test;

import com.test.mybatis.mapper.DynamicSQLMapper;
import com.test.mybatis.pojo.Emp;
import com.test.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapTest {

    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "三哥", 23, null, null));
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "三哥", 23, "男", "123@163.com");
//        Emp emp2 = new Emp(null, "四爷", 33, "女", "123@163.com");
//        Emp emp3 = new Emp(null, "五哥", 18, "男", "123@163.com");
//        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        List<Emp> list1 = mapper.getEmpByChoose(emp1);
        list1.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(result);
    }

    @Test
    public void testInsertMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "三哥", 23, "男", "123@163.com", null);
        Emp emp2 = new Emp(null, "四爷", 33, "女", "123@163.com", null);
        Emp emp3 = new Emp(null, "五哥", 18, "男", "123@163.com", null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result = mapper.insertMoreByList(emps);
        System.out.println(result);
    }
}
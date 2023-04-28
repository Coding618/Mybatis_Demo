package com.test.mybatis.test;

import com.test.mybatis.mapper.ParameterMapper;
import com.test.mybatis.pojo.User;
import com.test.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {
    /**
     * MyBatis 获取参数的2种方式 ${} 和 #{}
     * ${} 本质是字符拼接
     * #{} 本质是占位符赋值
     * MyBatis 获取参数值的各种情况：
     * 1、mapper接口方法的参数为单个的字面量类型
     * 2、                   多个字面量类型
     * 3、map结合类型的参数
     * 4. 实体类参数的类型
     * 5. 使用Param标识参数
     */

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("Lee", "123456");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = new User(null,"Lee", "123456", 17, "男", "123456@163.com");
        int result = mapper.insertUser(user);
        System.out.println(result);
//        return result;
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "三哥");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("三哥", "123456");
        System.out.println(user);
    }

    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("三哥");
        System.out.println(user);
    }


    /**
     * 查询所有用户信息
     */
    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }
}

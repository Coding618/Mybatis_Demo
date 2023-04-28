package com.test.mybatis.test;

import com.test.mybatis.mapper.SelectMapper;
import com.test.mybatis.pojo.User;
import com.test.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    /**
     * 添加用户
     */
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User(null, "五哥", "123", 22, "女", "1234556@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

    /**
     * 动态获取表名
     */
    @Test
    public void testGetTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        list.forEach(user -> System.out.println(user));
    }

    /**
     * 根据用户id，批量删除用户数据
     */
    @Test
    public void testDeleteUserByIds() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int result = mapper.deleteUserByIds("1, 6");
        System.out.println(result);
    }

    /**
     * 根据用户名进行模糊查询
     */
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getUserByLike("admin");
        list.forEach(user -> System.out.println(user));
    }

    /**
     * 查询所有用户信息为Map集合
     */
    @Test
    public void testGetUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        List<Map<String, Object>> map = mapper.getAllUserToMap();
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
    }

    /**
     * 根据用户id查询用户信息并转换为Map
     */
    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(3);
        System.out.println(map);

    }

    /**
     * 查询用户的总记录数
     */
    @Test
    public void testGetUserCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int userCount = mapper.getUserCount();
        System.out.println("userCount: " + userCount);
    }

    /**
     * 根据所有用户信息
     */
    @Test
    public void testgetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUserList();
        list.forEach(user -> System.out.println(user));
    }

    /**
     * 根据用户id查询用户信息
     */
    @Test
    public void testUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user);
    }
}

package com.test.mybatis.mapper;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    /**
     * 检查用户登录
     */
    User checkLoginByParam(@Param("username") String  username, @Param("password") String password);

    /**
     * 查询所有员工信息
     */
    List<User> getAllUser();

    /**
     * 单个参数, 根据用户名查询用户信息
     */
    User getUserByUsername(String username);

    /**
     * 多个参数，根据用户名和密码检查用户登录
     */
    User checkLogin(String username, String password);

    /**
     * 验证登陆，参数为map集合
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

}

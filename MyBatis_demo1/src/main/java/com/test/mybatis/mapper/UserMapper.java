package com.test.mybatis.mapper;

import com.test.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * MyBatis 面向接口编程的2个一致：
     * 1、映射文件的namespace要和mapper接口的类名保持一致；
     * 2、映射文件的SQL语句id要和mapper接口的方法名保持一致
     */

    /**
     * 添加用户信息
     */
    int insertUser();

    void updateUser();

    void deleteUser();

    User getUserById();

    List<User> getAllUser();
}

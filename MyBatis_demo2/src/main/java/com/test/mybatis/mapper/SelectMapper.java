package com.test.mybatis.mapper;

import com.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") int id);

    /**
     * 查询所有用户信息
     */
    List<User> getAllUserList();

    /**
     * 查询用户的总记录数
     */
    int getUserCount();

    /**
     * 根据用户id查询用户信息为 map 集合
     */
    Map<String, Object> getUserByIdToMap(@Param("id") int id);

    /**
     * 查询所有用户信息为Map集合
     */
//    List<Map<String, Object>> getAllUserToMap();
    @MapKey("id")
    Map<String, Object> getAllUserToMap();

    /**
     * 根据用户名进行模糊查询
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 根据用户id，批量删除用户数据
     */
    int deleteUserByIds(@Param("ids") String ids);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户
     */
    void insertUser(User user);


}

package com.example.demo.foundation.mapper;

import com.example.demo.foundation.BaseDao;
import com.example.demo.foundation.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * @author: Ryan
 * @since: 2018/11/8 14:36
 * @description:
 * @modifyTime:
 * @modifier:
 */
public interface UserDao extends BaseDao<User> {

    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    @Select("SELECT id, user_name, phone FROM `sys_user` where id = #{userId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "phone", property = "phone")
    })
    Map<String, Object> getUserInfo(@Param("userId") String userId);

    /**
     * 用户登录使用接口
     * @param userName
     * @param password
     * @return
     */
    @Select("SELECT id, user_name, phone FROM `sys_user` where user_name = #{userName} and password = #{password}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "phone", property = "phone")
    })
    User userLogin(@Param("userName") String userName, @Param("password") String password);
}

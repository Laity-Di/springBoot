package com.example.demo.service.user;

import java.util.Map;

/**
 * @author: Ryan
 * @since: 2018/11/8 15:03
 * @description:
 * @modifyTime:
 * @modifier:
 */
public interface UserService {

    /**
     * 获取用户信息接口
     * @param id
     * @return
     */
    Map<String, Object> getUserInfo(String id);
}

package com.example.demo.service.user.impl;

import com.example.demo.foundation.entity.User;
import com.example.demo.foundation.mapper.UserDao;
import com.example.demo.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @author: Ryan
 * @since: 2018/11/8 15:04
 * @description:
 * @modifyTime:
 * @modifier:
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public Map<String, Object> getUserInfo(String userId){

        return userDao.getUserInfo(userId);

    }
}

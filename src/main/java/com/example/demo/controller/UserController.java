package com.example.demo.controller;

import com.example.demo.foundation.entity.User;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Ryan
 * @since: 2018/11/5 14:47
 * @description:
 * @modifyTime:
 * @modifier:
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("v1.0.0/getUserName/")
    public Map<String, Object> getUserName(@RequestBody Map<String, String> paramsMap) throws Exception{
            throw new Exception("123");


        //return userService.getUserInfo(paramsMap.get("userId"));
    }

}

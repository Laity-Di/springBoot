package com.example.demo.controller;

import com.example.demo.foundation.entity.User;
import com.example.demo.foundation.model.json.JsonResult;
import com.example.demo.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("v1.0.0/login")
//    public JsonResult userLogin(@RequestBody User user){
////        Subject subject = SecurityUtils.getSubject();
////        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
////        try {
////            subject.login(token);
////            return JsonResult.buildSuccessResult("登录成功", subject.getSession().getId());
////        } catch (IncorrectCredentialsException e) {
////            return JsonResult.buildErrorStateResult("密码错误！", null);
////        } catch (LockedAccountException e) {
////            return JsonResult.buildErrorStateResult("登录失败，该用户已被冻结！", null);
////        } catch (AuthenticationException e) {
////            return JsonResult.buildErrorStateResult("登录失败，用户不存在！", null);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return JsonResult.buildErrorStateResult("登录异常！", null);
////        }
//
//    }

        @PostMapping("v1.0.0/getUserName/")
    public Map<String, Object> getUserName(@RequestBody Map<String, String> paramsMap){

        return userService.getUserInfo(paramsMap.get("userId"));
    }

    @RequestMapping(value = "unauth")
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }

}

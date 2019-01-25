package com.example.demo.config.security.shiro;

import com.example.demo.foundation.entity.User;
import com.example.demo.foundation.mapper.UserDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Ryan
 * @since: 2018/11/13 16:36
 * @description:
 * @modifyTime:
 * @modifier:
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    /**
     * 登录认证处理方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        User user=new User();
        if(!token.getUsername().equals("")){
            user =(User) userDao.getUserInfo(token.getUsername());
        }
        if(!user.getName().equals(token.getUsername())){
            return null;
        }else {
            //这个参数是给login回传的信息。不是类对象什么的。
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                    user.getName(),
                    user.getPassword(),
                    getName());
            return simpleAuthenticationInfo;
        }
    }

    /**
     * 权限验证处理方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 这个值是认证方法中的SimpleAuthenticationInfo对象的第一个参数的值即user.getUsername()
        String username=(String) principalCollection.getPrimaryPrincipal();

        System.out.print(username+">>>执行了授权方法\n");

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        //可以根据username查询数据库改用户所有角色,可以根据username查询数据库改用户所有资源权限
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addStringPermission("news");

        return simpleAuthorizationInfo;
    }
}


package com.example.demo.config.shiro;

/**
 * @author: Ryan
 * @since: 2018/11/13 16:36
 * @description:
 * @modifyTime:
 * @modifier:
 */
public class MyShiroRealm {


//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        User userInfo = (User) principals.getPrimaryPrincipal();
//        for (SysRole role : userInfo.getRoleList()) {
//            authorizationInfo.addRole(role.getRole());
//            for (SysPermission p : role.getPermissions()) {
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
//        return authorizationInfo;
//    }
//
//    /**
//     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
//     * @param token
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
//            throws AuthenticationException {
//        //获取用户的输入的账号.
//        String username = (String) token.getPrincipal();
//        //通过username从数据库中查找 User对象，如果找到，没找到.
//        //实际项目中，这里可以根据实际情况做缓存，如果不做
//        // Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        User userInfo = userInfoService.findByUsername(username);
//        if (userInfo == null) {
//            return null;
//        }
//        if (userInfo.getState() == 1) {
//            throw new LockedAccountException();
//        }
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                userInfo,
//                userInfo.getPassword(),
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),
//                getName()
//        );
//        return authenticationInfo;
//    }
}

package com.example.demo.config.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Ryan
 * @since: 2018/11/13 16:35
 * @description:
 * @modifyTime:
 * @modifier:
 */
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/news", "perms[news]");
        filterMap.put("/admin", "roles[admin]");
        filterMap.put("/index", "anon");
        filterMap.put("/**", "authc");

        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/news");
        bean.setUnauthorizedUrl("/unauth");
        return bean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(new MyShiroRealm());
        return securityManager;
    }

}

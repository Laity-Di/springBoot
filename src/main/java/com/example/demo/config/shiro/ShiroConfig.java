package com.example.demo.config.shiro;

/**
 * @author: Ryan
 * @since: 2018/11/13 16:35
 * @description:
 * @modifyTime:
 * @modifier:
 */
public class ShiroConfig {

   /* *//**
     * 安全管理器
     * @return
     *//*
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    *//**
     * Realm配置
     * @return
     *//*
    @Bean
    public MyShiroRealm userRealm(){
        return new MyShiroRealm();
    }

    *//**
     * SessionDAO配置
     * @return
     *//*
    @Bean
    public SessionDAO sessionDAO(){
        return new MemorySessionDAO();
    }

    *//**
     * sessionManager配置
     * @return
     *//*
    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(sessionDAO());
        return sessionManager;
    }

    *//**
     * shiroFilter配置
     * @param securityManager
     * @return
     *//*
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
        filters.put("token", new LoginAuthorizationFilter());
        filters.put("corsFilter", new CrosFilter());
        shiroFilter.setFilters(filters);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/user/login", "corsFilter,anon");
        filterChainDefinitionMap.put("/user/logout", "corsFilter,anon");
        filterChainDefinitionMap.put("/user*//**", "corsFilter,token");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilter;
    }

    *//**
     * 保证实现了Shiro内部lifecycle函数的bean执行
     *//*
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    *//**
     * 启用shrio授权注解拦截方式，AOP式方法级权限检查
     * 依赖其他bean的初始化
     * @return
     *//*
    @Bean
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    *//**
     * 加入注解的使用，不加入这个注解不生效 使用shiro框架提供的切面类，用于创建代理对象
     * @param securityManager
     * @return
     *//*
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor
    (DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
*/

}

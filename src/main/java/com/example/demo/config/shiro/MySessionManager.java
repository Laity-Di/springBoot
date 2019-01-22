package com.example.demo.config.shiro;

/**
 * @author: Ryan
 * @since: 2018/11/13 16:32
 * @description:
 * @modifyTime:
 * @modifier:
 */
public class MySessionManager {
/*

    private static final String AUTHORIZATION = "Authorization";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public MySessionManager() {
        super();
    }

    */
/**
     * 传统结构项目中，shiro从cookie中读取sessionId以此来维持会话;
     * 但是在前后端分离的项目中（也可在移动APP项目使用）
     * 我们选择在ajax的请求头中传递sessionId，因此需要重写shiro获取sessionId的方式
     * @param request
     * @param response
     * @return
     *//*

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute
                    (ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);

            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);

            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            return super.getSessionId(request, response);
        }
    }
*/

}

package com.example.demo.config.shiro;

/**
 * @author: Ryan
 * @since: 2018/11/14 10:57
 * @description:
 * @modifyTime:
 * @modifier:
 */
public class LoginAuthorizationFilter {

    /**
     * 这个方法是未登录需要执行的方法
     *//*
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            //设置响应头
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json");
            //设置返回的数据
            JsonResult result = JsonResult.buildErrorStateResult("您尚未登录，请重新登录！",
                    null, 8401L);
            //写回给客户端
            PrintWriter out = httpResponse.getWriter();
            out.write(JSONObject.toJSONString(result));
            //刷新和关闭输出流
            out.flush();
            out.close();
        } else {
            //设置响应头
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json");
            //设置返回的数据
            JsonResult result = JsonResult.buildErrorStateResult("您的登录信息有误，请重新登录！",
                    null, 8402L);
            //写回给客户端
            PrintWriter out = httpResponse.getWriter();
            out.write(JSONObject.toJSONString(result));
            //刷新和关闭输出流
            out.flush();
            out.close();
        }
        return false;
    }*/
}

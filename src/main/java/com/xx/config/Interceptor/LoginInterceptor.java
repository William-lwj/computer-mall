package com.xx.config.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @ClassName: LoginInterceptor
 * @Package: com.xx.config.Interceptor
 * @Author: liu
 * @Date: 2023/5/9 21:23
 * @Version: 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局session对象中是否有uid数据,如果有则放行,如果没有重定向到登录页面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器(把url和Controller映射到一块)
     * @return 返回值为true放行当前请求,反之拦截当前请求
     * @Author: liu
     * @Date: 2023/5/9 21:28
    */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        Object obj = request.getSession().getAttribute("uid");
        if(obj == null) {
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }

}

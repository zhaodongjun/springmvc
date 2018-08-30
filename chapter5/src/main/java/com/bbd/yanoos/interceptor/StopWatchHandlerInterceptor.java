package com.bbd.yanoos.interceptor;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaodongjun on 2018/8/30 0030.
 */
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {
    //Spring提供的一个命名的ThreadLocal实现
    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        long beginTime = System.currentTimeMillis();//1、开始时间
        startTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
        System.out.println("=======preHandle========");
        return true;//继续流程
    }

    /**
     * 登录检测
     * 在访问某些资源时（如订单页面），需要用户登录后才能查看，因此需要进行登录检测。
     * 流程：
     * 1、访问需要登录的资源时，由拦截器重定向到登录页面；
     * 2、如果访问的是登录页面，拦截器不应该拦截；
     * 3、用户登录成功后，往cookie/session添加登录成功的标识（如用户编号）；
     * 4、下次请求时，拦截器通过判断cookie/session中是否有该标识来决定继续流程还是到登录页面；
     * 5、在此拦截器还应该允许游客访问的资源。
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//                             Object handler) throws Exception {
//        //1、请求到登录页面 放行
//        if(request.getServletPath().startsWith(loginUrl)) {
//            return true;
//        }
//
//        //2、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求
//
//        //3、如果用户已经登录 放行
//        if(request.getSession().getAttribute("username") != null) {
//            //更好的实现方式的使用cookie
//            return true;
//        }
//
//        //4、非法请求 即这些请求需要登录后才能访问
//        //重定向到登录页面
//        response.sendRedirect(request.getContextPath() + loginUrl);
//        return false;
//    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();//2、结束时间
        long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - beginTime;//3、消耗的时间
        if (consumeTime > 500) {//此处认为处理时间超过500毫秒的请求为慢请求
            //TODO 记录到日志文件
            System.out.println(
                    String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
        }
    }
}
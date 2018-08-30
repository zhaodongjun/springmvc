package com.bbd.yanoos.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * Created by zhaodongjun on 2018/8/30 0030.
 */
public class HandlerInterceptorController implements Controller{
    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("===========HandlerInterceptorController");
        return new ModelAndView("interceptor");
    }
}


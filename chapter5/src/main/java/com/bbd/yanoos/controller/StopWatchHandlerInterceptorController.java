package com.bbd.yanoos.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaodongjun on 2018/8/30 0030.
 */
public class StopWatchHandlerInterceptorController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("===========StopWatchHandlerInterceptorController");
        for (int i=0;i<50000;i++){
//            System.out.println("i="+i);
        }
        return new ModelAndView("interceptor");
    }
}

package com.bbd.yanoos.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaodongjun on 2018/8/29 0029.
 */
public class HelloWorldWithoutReturnModelAndViewController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        resp.getWriter().write("Hello World!!");
        //如果想直接在该处理器/控制器写响应 可以通过返回null告诉DispatcherServlet自己已经写出响应了，不需要它进行视图解析
        return null;
    }
}

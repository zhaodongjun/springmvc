package com.bbd.yanoos.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet转发控制器
 * Created by zhaodongjun on 2018/8/29 0029.
 */
public class ForwardingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.getWriter().write("Controller forward to Servlet");

    }
}

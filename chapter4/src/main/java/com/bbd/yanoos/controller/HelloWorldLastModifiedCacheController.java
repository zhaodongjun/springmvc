package com.bbd.yanoos.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Last-Modified缓存机制
 * Created by zhaodongjun on 2018/8/29 0029.
 */
public class HelloWorldLastModifiedCacheController extends AbstractController implements LastModified {
    private long lastModified;
    private boolean boo = true;
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //点击后再次请求当前页面
        resp.getWriter().write("<a href=''>this</a>");
        return null;
    }
    public long getLastModified(HttpServletRequest request) {
        if(lastModified == 0L && boo) {
            //TODO 此处更新的条件：如果内容有更新，应该重新返回内容最新修改的时间戳
            lastModified = System.currentTimeMillis();
//            boo = false;
        }
//        else{
//            lastModified = System.currentTimeMillis();
//        }
        return lastModified;
    }
}

package com.zjg.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.zjg.test.service.TestRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Properties;

/**
 * @author zjg
 * @description:
 * @date 2020/9/13 0:26
 */
@RestController
@RequestMapping("remote")
public class RemoteTestController {

    @Autowired
    TestRemoteService testRemoteService;

    @RequestMapping("test")
    public String testRemote() {
       return testRemoteService.remote("test");
    }


}

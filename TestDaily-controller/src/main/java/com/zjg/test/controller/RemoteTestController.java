package com.zjg.test.controller;

import com.zjg.test.service.remote.TestRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

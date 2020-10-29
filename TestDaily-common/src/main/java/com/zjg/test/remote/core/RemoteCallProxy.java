//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zjg.test.remote.core;


import com.zjg.test.remote.core.annotation.RemotePath;
import com.zjg.test.util.AssertUtil;
import com.zjg.test.util.HttpService;
import com.zjg.test.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
  * @description: 代理类的拦截
  * @author zjg
  * @date 2020/5/1 15:49
  */
@Slf4j
public class RemoteCallProxy implements InvocationHandler {

    private String serverName;

    public RemoteCallProxy(String serverName){
        this.serverName = serverName;
    }


    /**
     * proxy:代理类代理的真实代理对象com.sun.proxy.$Proxy0
     * method:我们所要调用某个对象真实的方法的Method对象
     * args:指代代理对象方法传递的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RemotePath remotePath = (RemotePath)method.getAnnotation(RemotePath.class);
        AssertUtil.isNotNull(remotePath,"远程访问，remotePath不能为空");
        String methodPath = remotePath.value();
        AssertUtil.isNotBlank(methodPath,"远程访问，methodPath不能为空");
        Class<?> returnType = method.getReturnType();
        AssertUtil.isNotNull(returnType,"远程访问，returnType不能为空");
        AssertUtil.isNotNull(args,"远程访问，args不能为空");

        String url = serverName + "/" + remotePath.value();


        HttpService httpService = SpringContextUtil.getBean(HttpService.class);
        Object result = httpService.post(url, args[0], returnType);
        AssertUtil.isNotNull(result,"远程访问，返回参数不能为空");
        log.info("远程方法url:" + url + "  请求参数:" + args[0] + "  远程服务地址serverName：" + serverName);
        return result;
    }

}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zjg.test.remote.core;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class RemoteFactoryBean<T> implements FactoryBean<T> {
    private Class<T> remoteCallServiceInterface;

    /**
     * 远程服务名称
     */
    private String remoteServerName;

    public RemoteFactoryBean(Class<T> remoteCallServiceInterface) {
        this.remoteCallServiceInterface = remoteCallServiceInterface;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(this.remoteCallServiceInterface.getClassLoader(), new Class[]{this.remoteCallServiceInterface}, new RemoteCallProxy(remoteServerName));
    }

    @Override
    public Class<?> getObjectType() {
        return this.remoteCallServiceInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


    public String getRemoteServerName() {
        return this.remoteServerName;
    }

    public void setRemoteServerName(String remoteServerName) {
        this.remoteServerName = remoteServerName;
    }
}

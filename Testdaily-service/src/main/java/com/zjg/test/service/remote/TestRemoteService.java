package com.zjg.test.service.remote;

import com.zjg.test.remote.core.annotation.RemotePath;
import com.zjg.test.remote.core.annotation.RemoteServer;

/**
 * @author zjg
 * @description:
 * @date 2020/5/2 20:40
 */
@RemoteServer("${zjg.test.server}")
public interface TestRemoteService {

    @RemotePath("zjg.zjg.zjg.method")
    String remote(String str);
}

package com.zjg.controller;

import com.alibaba.fastjson.JSONArray;
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
@RequestMapping("fuRongLiang")
public class TestController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("test")
    public String downOrderDetail() {
        Cookie[] cookies = request.getCookies();

//        for(Cookie cookie : cookies){
//            System.out.println(cookie.getName());
//        }
        HttpSession session = request.getSession(false);
        System.out.println(session.getId());

        //获取订单List的json
        List<String> orderList = getOrderList();
        if(CollectionUtils.isEmpty(orderList)){
            return "";
        }
        for(String order : orderList){
//            String response = getHttpResponse(order);
        }
        return "success";
    }

//    private String getHttpResponse(String order) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("cookie", getValue("cookie"));
//        String requestBody = JSON.toJSONString(requestParam);
//        HttpEntity<String> request = new HttpEntity(requestBody, headers);
//        String url = cloudConfig.getGwUrl() + api;
//        String newUri = this.authProcessor.reconstructURI(url, (Map)null, requestBody, appId, token, secret);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.postForEntity(newUri, request, String.class, new Object[0]);
//        log.info("[HttpChoiceGwService] api:{} request:{}, response:{}", new Object[]{newUri, request, response});
//        return this.adaptResponse(response, returnType);

//    }

    private List<String> getOrderList() {
        String orderList = getValue("orderList");
        Assert.hasText(orderList,"获取配置为空");
        return JSONArray.parseArray(orderList, String.class);
    }

    private String getValue(String key) {
        Assert.hasText(key,"获取配置，key不能为空");
        String path = null;
        String resultValue = null;
        InputStream inputStream = null;
        try {
            path = TestController.class.getProtectionDomain().getCodeSource()
                    .getLocation().getFile();
            //转换处理中文及空格
            path = URLDecoder.decode(path, "UTF-8").substring(6,path.indexOf("rush-order.jar"));
            inputStream = new FileInputStream(path+"/test.txt");
            Properties props = new Properties();
            props.load(inputStream);
            resultValue = props.getProperty(key);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultValue;
    }

}

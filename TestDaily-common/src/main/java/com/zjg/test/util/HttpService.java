package com.zjg.test.util;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zjg
 * @description:
 * @date 2020/10/29 16:38
 */
@Service
public class HttpService {


    public String post(String url, Object arg, Class<?> returnType) {
        return "success";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-Service-Group", "pos-choice-x");
//        headers.set("X-Forwarded-Scheme", "https");
//        headers.set("x-forwarded-port", "443");
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        headers.setContentType(type);
//        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
//        String requestBody = JSON.toJSONString(arg);
//        HttpEntity<String> request = new HttpEntity(requestBody, headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class, new Object[0]);
//        return response.getBody();
    }
}

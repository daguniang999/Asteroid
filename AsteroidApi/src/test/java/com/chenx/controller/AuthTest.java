package com.chenx.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:springmvc.xml", "classpath:application.xml", "classpath:spring-mybatis.xml"})
public class AuthTest {


    @Test
    public void authError() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/AsteroidApi/test", String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void authExpired() {
        RestTemplate template = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE1OTUxMTQzMTB9.zdc6th2DMuQSoC_rRnLtWB4Tpe8fLSzszCekT0GE6JY");
        HttpEntity requestEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> responseEntity = template.exchange("http://localhost:8080/AsteroidApi/test", HttpMethod.GET, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void authExist() {
        RestTemplate template = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE1OTUxMTQzMTB9.zdc6th2DMuQSoC_rRnLtWB4Tpe8fLSzszCekT0GE6JY");
        HttpEntity requestEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> responseEntity = template.exchange("http://localhost:8080/AsteroidApi/test", HttpMethod.GET, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }


    @Test
    public void auth() {
        RestTemplate template = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE2OTUxMTQzMTB9.ivUd_mBsvikzcQrOsKnsud1RQJ5lo0nSuAdtfQ7h5lQ");
        HttpEntity requestEntity = new HttpEntity(httpHeaders);

        ResponseEntity<String> responseEntity = template.exchange("http://localhost:8080/AsteroidApi/test", HttpMethod.GET, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }
}

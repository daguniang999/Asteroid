package com.chenx.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:springmvc.xml", "classpath:application.xml", "classpath:spring-mybatis.xml"})
public class LoginTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    Login login;

    @Test
    public void etss() {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("username", "123");
        HttpHeaders header = new HttpHeaders();
        header.add("secutity", "1111");
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(params, header);
        ResponseEntity<String> resultResponseEntity = restTemplate.exchange("http://localhost:8080/AsteroidApi/login", HttpMethod.POST, requestEntity, String.class);
    }

    @Test
    public void getLogin() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", "11");
        params.put("password", "fdfd");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/AsteroidApi/login?username={username}&&password={password}", String.class, params);

    }

    @Test
    public void postLogin() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("name", "111");
        params.add("password", "222");
        HttpEntity<Map> entity = new HttpEntity<Map>(params,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/AsteroidApi/login", HttpMethod.POST, entity, String.class);
        System.out.println(responseEntity.getBody());
    }


}

package com.chenx.controller;

import com.chenx.common.bean.User;
import com.chenx.mapper.LoginMapper;
import com.chenx.service.LoginService;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc.xml", "classpath:application.xml", "classpath:spring-mybatis.xml"})
@WebAppConfiguration
public class mybatisTest {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    LoginService loginService;

    @Autowired
    Login login;

    @Autowired
    DataSource dataSource;

    @Test
    public void test() throws Exception{
        System.out.println(login.login(new User()));
    }

}



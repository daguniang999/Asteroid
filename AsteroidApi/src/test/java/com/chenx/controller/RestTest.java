package com.chenx.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc-test.xml", "classpath:application-test.xml"})
public class RestTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void etss() {
        try {
            Connection con = dataSource.getConnection();
            if(!con.isClosed()) {
                System.out.println("!!!!!!!!!!");
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("fdfs");
    }

    @Test
    public void fdsf() {
        System.out.println("dsf");
    }

    @Before
    public void before() {
        System.out.println("!!!!: 1");
    }
    @After
    public void after() {
        System.out.println("!!!!1: 3");
    }


}

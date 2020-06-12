package com.chenx.controller;

import com.chenx.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login() {
        User user = new User();
        user.setId("fds");
        return user;
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public User test() {
        User user = new User();
        user.setId("fds");
        return user;
    }
}

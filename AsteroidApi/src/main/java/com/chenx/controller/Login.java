package com.chenx.controller;

import com.chenx.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = { "http://localhost:4200", "null"})
@RestController
public class Login {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login() {
        User user = new User();
        user.setId("please login");
        return user;
    }

    @RequestMapping(value = "/login", params = "error", method = RequestMethod.GET)
    public User loginError() {
        User user = new User();
        user.setId("error");
        return user;
    }

    @RequestMapping(value = "/login", params = "success", method = RequestMethod.GET)
    public User loginSuccess() {
        User user = new User();
        user.setId("success");
        return user;
    }

    @RequestMapping(value = "/login", params = "logout", method = RequestMethod.GET)
    public User loginOut() {
        User user = new User();
        user.setId("out");
        return user;
    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public User test() {
//        User user = new User();
//        user.setId("fds11");
//        return user;
//    }
}

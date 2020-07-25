package com.chenx.controller;


import com.chenx.common.bean.Token;
import com.chenx.common.bean.User;
import com.chenx.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;


@RestController
@Api(tags = "Login", description = "登录控制")
public class Login {

    @Autowired
    LoginService loginService;


    @ApiOperation(value = "登录接口", notes = "登录")
    @PostMapping(value = "/login")
    public Token login(@Valid User user) throws Exception {
        Token token = loginService.login(user);
        return token;
    }
}

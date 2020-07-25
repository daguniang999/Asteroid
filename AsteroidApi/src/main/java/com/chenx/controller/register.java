package com.chenx.controller;

import com.chenx.common.bean.User;
import com.chenx.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Register", description = "注册控制")
@RestController
public class register {

    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/register")
    @ApiOperation(value = "注册接口", notes = "注册")
    public Boolean register(User user) throws Exception {

        return registerService.register(user);

    }

}

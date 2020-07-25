package com.chenx.controller;

import com.chenx.common.bean.Result;
import com.chenx.common.commonConst.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Authorization", description = "权限控制")
@RestController
@RequestMapping(value = "/auth")
public class Auth {

    @ApiOperation(value = "权限错误", notes = "Token存在问题")
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public Result tokenError() {
        Result result = Result.failure(ResultCode.PERMISSION_IS_ERROR);
        return result;
    }

    @ApiOperation(value = "权限过期", notes = "Token过期")
    @RequestMapping(value = "/expired", method = RequestMethod.GET)
    public Result tokenExpired() {
        Result result = Result.failure(ResultCode.PERMISSION_IS_EXPIRED);
        return result;
    }

    @ApiOperation(value = "Token不存在", notes = "Token没有携带")
    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    public Result tokenNotExist() {
        Result result = Result.failure(ResultCode.PERMISSION_NOT_EXIST);
        return result;
    }

}

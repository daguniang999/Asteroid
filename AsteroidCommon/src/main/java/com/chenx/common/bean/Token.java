package com.chenx.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Token", description = "凭证")
public class Token {
    @ApiModelProperty(value = "凭证")
    private String token;

    @ApiModelProperty(value = "过期时间")
    private Long ttl;

    @ApiModelProperty(value = "登录时间")
    private String loginTime;

    @ApiModelProperty(value = "用户信息")
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

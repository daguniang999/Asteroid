package com.chenx.service;

import com.chenx.common.bean.Token;
import com.chenx.common.bean.User;

public interface LoginService {
    Token login(User user) throws Exception;
}

package com.chenx.service.impl;

import com.chenx.common.bean.Token;
import com.chenx.common.bean.User;
import com.chenx.common.commonConst.ResultCode;
import com.chenx.common.exception.UserException;
import com.chenx.common.util.BCryptUtil;
import com.chenx.mapper.LoginMapper;
import com.chenx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    public Token login(User user) throws Exception {
        User dbUser = loginMapper.getLogin(user.getName());
        Token token;
        if (dbUser != null) {
            if (BCryptUtil.checkpw(user.getPassword(), dbUser.getPassword())) {
                token = new Token();
                token.setToken(dbUser.getName());
            } else {
                throw new UserException(ResultCode.USER_LOGIN_ERROR, null);
            }
        } else {
            throw new UserException(ResultCode.USER_NOT_EXIST, null);
        }

        return token;
    }
}

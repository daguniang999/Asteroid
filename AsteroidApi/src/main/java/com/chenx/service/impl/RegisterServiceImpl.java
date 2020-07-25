package com.chenx.service.impl;

import com.chenx.common.bean.User;
import com.chenx.common.commonConst.ResultCode;
import com.chenx.common.exception.SystemException;
import com.chenx.common.exception.UserException;
import com.chenx.common.util.BCryptUtil;
import com.chenx.mapper.RegisterMapper;
import com.chenx.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterMapper registerMapper;


    public boolean register(User user) throws Exception {

        User dbUser = registerMapper.isExist(user);
        if (dbUser != null) {
            throw new UserException(ResultCode.USER_HAS_EXISTED, null);
        } else {
            String password = BCryptUtil.hashpw(user.getPassword(), BCryptUtil.gensalt());
            user.setPassword(password);
            Integer row = registerMapper.addUser(user);
            if (row == 0) {
                throw new SystemException(ResultCode.SYSTEM_INNER_ERROR, null);
            }
        }
        return true;
    }
}

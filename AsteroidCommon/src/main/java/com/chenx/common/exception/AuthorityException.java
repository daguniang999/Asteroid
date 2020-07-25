package com.chenx.common.exception;

import com.chenx.common.commonConst.ResultCode;

public class AuthorityException extends BaseException {
    public AuthorityException(ResultCode code, String message) {
        super(code, message);
    }
}

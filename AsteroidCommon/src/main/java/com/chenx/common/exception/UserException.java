package com.chenx.common.exception;

import com.chenx.common.commonConst.ResultCode;

public class UserException extends BaseException {

    public UserException(ResultCode code, Object data) {
        super(code, data);
    }

    public UserException() {
        super();
    }

}

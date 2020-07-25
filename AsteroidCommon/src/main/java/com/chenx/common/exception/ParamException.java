package com.chenx.common.exception;

import com.chenx.common.commonConst.ResultCode;

public class ParamException extends BaseException {
    public ParamException(ResultCode code, String message) {
        super(code, message);
    }

    public ParamException() {
        super();
    }
}

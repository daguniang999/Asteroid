package com.chenx.common.exception;

import com.chenx.common.commonConst.ResultCode;

public class SystemException extends BaseException {
    public SystemException(ResultCode code, String message) {
        super(code, message);
    }

    public SystemException() {
        super();
    }
}

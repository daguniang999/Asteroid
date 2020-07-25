package com.chenx.common.exception;

import com.chenx.common.commonConst.ResultCode;

public class DataException extends BaseException {
    public DataException(ResultCode code, String message) {
        super(code, message);
    }
}

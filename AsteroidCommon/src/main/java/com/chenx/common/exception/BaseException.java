package com.chenx.common.exception;

import com.chenx.common.commonConst.ResultCode;

public class BaseException extends Exception {
    private Object data;

    private ResultCode code;

    public BaseException() {
        super();
    }

    public BaseException(ResultCode code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }
}

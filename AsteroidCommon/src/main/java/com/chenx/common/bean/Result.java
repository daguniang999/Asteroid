package com.chenx.common.bean;

import com.chenx.common.commonConst.ResultCode;

public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public Result() {}

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode code) {
        Result result = new Result();
        result.setResultCode(code);
        return result;
    }

    public static Result failure(ResultCode code, Object data) {
        Result result = new Result();
        result.setResultCode(code);
        result.setData(data);
        return result;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.Code();
        this.message = code.Message();
    }
}

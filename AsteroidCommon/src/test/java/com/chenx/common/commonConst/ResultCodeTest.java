package com.chenx.common.commonConst;

import org.junit.Test;

public class ResultCodeTest {

    @Test
    public void getCodeByName() {
        String name = "USER_NOT_LOGGED_IN";
        Integer code = ResultCode.getCode(name);
        System.out.println(code);
    }

    @Test
    public void getMessageByName() {
        String name = "USER_NOT_LOGGED_IN";
        String message = ResultCode.getMessage(name);
        System.out.println(message);
    }

    @Test
    public void getCode() {
        Integer code = ResultCode.DATA_IS_WRONG.Code();
        System.out.println(code);
    }

    @Test
    public void getMessage() {
        String message = ResultCode.DATA_ALREADY_EXISTED.Message();
        System.out.println(message);
    }

}

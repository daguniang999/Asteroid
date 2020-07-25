package com.chenx.common.commonConst;

import java.util.ArrayList;
import java.util.List;

public enum ResultCode {
    /* 成功状态码 */
    SUCCESS(1, "成功"),

    /* 参数错误: 10001 - 19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    /* 用户错误: 20001 - 29999 */
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),

    /*  系统错误: 30001 - 39999 */
    SYSTEM_INNER_ERROR(30001, "系统繁忙，请稍后重试"),

    /* 数据错误: 40001 - 49999 */
    RESULT_DATA_NONE(40001, "数据不存在"),
    DATA_IS_WRONG(40002, "数据有误"),
    DATA_ALREADY_EXISTED(40003, "数据已存在"),

    /* 权限错误: 50001 - 59999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限"),
    PERMISSION_IS_ERROR(70002, "权限错误"),
    PERMISSION_IS_EXPIRED(70003, "权限过期"),
    PERMISSION_NOT_EXIST(70004, "token未携带");



    /* 状态码 */
    private Integer code;
    /*  消息 */
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer Code() {
        return this.code;
    }

    public String Message() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.name();
    }

    /* 根据name获取Code */
    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    /* 根据name获取Message */
    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return null;
    }

    //校验重复的code值
    public static void main(String[] args) {
        ResultCode[] ApiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode ApiResultCode : ApiResultCodes) {
            if (codeList.contains(ApiResultCode.code)) {
                System.out.println(ApiResultCode.code);
            } else {
                codeList.add(ApiResultCode.Code());
            }
        }

        System.out.println("Success!");
    }

}

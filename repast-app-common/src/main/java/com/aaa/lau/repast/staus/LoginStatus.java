package com.aaa.lau.repast.staus;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-09 23:10
 **/
public enum LoginStatus {

    LOGIN_SUCCESS("201","登陆成功"),
    LOGIN_FAILED("501","登陆失败"),
    USER_EXIST("202","用户存在"),
    USER_NOT_EXIST("401","用户不存在"),
    PASSWORD_WRONG("502","密码错误"),
    LOGOUT_WRONG("503","用户退出错误");

    LoginStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

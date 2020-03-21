package com.aaa.lau.repast.base;

import java.io.Serializable;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:状态
 * @Author: Thor Lau
 * @Create: 2020-03-09 23:21
 **/
public class ResultData<T> implements Serializable {
    private String code;
    private String msg;
    private String detail;
    private T data;
    private String token;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.aaa.lau.repast.staus;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-09 23:11
 **/
public enum StatusEnums {

    SUCCESS("1","操作成功"),
    FAILED("2","操作失败"),
    ENOUGH("3","库存充足"),
    NOT_ENOUGH("4","库存不足"),
    CLEAR_CART_SUCCESS("5","清空购物车"),
    DELETE_OPERATION("6","删除操作"),
    UPDATE_OPERATION("7","修改操作"),
    INSERT_OPERATION("8","删除操作");

    private String code;
    private String msg;

    StatusEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

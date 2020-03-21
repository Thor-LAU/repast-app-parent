package com.aaa.lau.repast.base;

import org.springframework.stereotype.Controller;

import static com.aaa.lau.repast.staus.LoginStatus.*;
import static com.aaa.lau.repast.staus.StatusEnums.*;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-09 23:05
 **/
@Controller
public class BaseController {

    /**
     * @author Seven Lee
     * @description
     *      登录成功，使用系统消息
     * @param []
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，自定义返回消息
     * @param [msg]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，使用系统消息，自定义返回值
     * @param [data]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录成功，自定义消息，自定义返回值
     * @param [msg, data]
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录失败，返回系统消息
     * @param []
     * @date 2019/11/20
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录失败，使用自定义消息
     * @param [msg]
     * @date 2020/3/12
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    protected ResultData loginFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作成功，返回系统消息
     * @param []
     * @date 2020/3/12
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作成功，返回自定义消息
     * @param [msg]
     * @date 2020/3/12
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作成功，使用系统消息，自定义返回值
     * @param [data]
     * @date 2020/3/12
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作成功，自定义消息，自定义返回值
     * @param [msg, data]
     * @date 2020/3/12
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作失败，使用系统消息
     * @param []
     * @date 2020/3/12
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作失败，使用自定义消息
     * @param [msg]
     * @date 2020/3/12
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Author Thor Lau
     * @Description
     *      自定义优惠券查询成功消息
     * @Date 2020/3/17/16:36
     * @Param []
     * @Return com.aaa.lau.repast.base.ResultData
     */
    protected ResultData couponsuccess(Object coupon,String token){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(coupon);
        resultData.setToken(token);
        return resultData;
    }

    protected ResultData couponfailed(String token){
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        resultData.setToken(token);
        return resultData;
    }

    protected ResultData couponfailedw(){
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }
    //暂未完成，待补充

}

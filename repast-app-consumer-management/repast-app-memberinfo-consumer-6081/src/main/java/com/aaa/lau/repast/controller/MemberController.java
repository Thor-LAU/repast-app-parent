package com.aaa.lau.repast.controller;

import com.aaa.lau.repast.annotation.LoginLogAnnotation;
import com.aaa.lau.repast.base.BaseController;
import com.aaa.lau.repast.base.ResultData;
import com.aaa.lau.repast.service.IRepastService;
import com.aaa.lau.repast.utils.GetZuulFilterParamsUtil;
import com.aaa.lau.repast.vo.TokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaa.lau.repast.model.Member;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-10 17:40
 **/
@RestController
@Api(value = "用户信息", tags = "用户信息接口(提供所有与用户相关的操作)")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService repastService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     *      member这个参数是由微信过来的--->并不知道自己数据库中的member_id是多少
     *      只会传递open_id
     * @param [member]
     * @date 2020/3/10
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
     **/
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录", notes = "用户执行登录操作(接收微信端传递数据)")
    @LoginLogAnnotation(operationType = "登录操作", operationName = "普通用户登录")
    public ResultData doLogin(HttpServletRequest request) {
        // 既然要接收参数必须使用getInputSteam();--->通过流来进行转换
        Map params = GetZuulFilterParamsUtil.getParams(request);
        // 需要调用api工程(feign)
        TokenVo tokenVo = repastService.doLogin(params);
        if(tokenVo.getIfSuccess()) {
            return super.loginSuccess((Object) tokenVo.getToken());
        }
        return super.loginFailed();
    }

    @GetMapping("/test")
    public Object test()
    {
        String url = "http://localhost:4081/aaa/thor/doLogin";
        Member member = new Member();
        member.setNickname("dasjqwe11");
        member.setOpenId("dashj1ykfjdsvbcdas");
        member.setUsername("czkju81316hgf");
        return restTemplate.postForObject(url, member, ResultData.class);
    }
}

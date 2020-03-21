package com.aaa.lau.repast.service;

import com.aaa.lau.repast.base.ResultData;
import com.aaa.lau.repast.config.FeignMultiPartConfig;
import com.aaa.lau.repast.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aaa.lau.repast.model.Member;

import java.util.List;
import java.util.Map;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-10 17:48
 **/
@FeignClient(value = "memberinfo-interface",configuration = FeignMultiPartConfig.class)
//@FeignClient(value = "memberinfo-interface",fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {
    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param map
     * @date 2020/3/10
     * @return java.lang.Boolean
     * @throws
     **/
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody Map map);

    /**
     * @author Seven Lee
     * @description
     *      登录日志保存
     * @param map
     * @date 2020/3/11
     * @return java.lang.Boolean
     * @throws
     **/
    @PostMapping("/add")
    ResultData saveLog(@RequestBody Map map);

}

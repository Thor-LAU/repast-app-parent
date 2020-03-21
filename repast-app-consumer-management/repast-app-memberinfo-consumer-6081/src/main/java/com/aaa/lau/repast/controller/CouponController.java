package com.aaa.lau.repast.controller;

import com.aaa.lau.repast.base.*;
import com.aaa.lau.repast.service.CouponService;
import com.aaa.lau.repast.model.*;
import com.aaa.lau.repast.utils.GetZuulFilterParamsUtil;
import com.aaa.lau.repast.vo.TokenVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static com.aaa.lau.repast.staticstatus.RequestProperties.*;
import static com.aaa.lau.repast.staticstatus.StaticCode.*;


/**
 * @Program: 20200309-repast-app-parent
 * @Description: 优惠券的Controller
 * @Author: Thor Lau
 * @Create: 2020-03-12 23:34
 **/
@RestController
@Api(value = "购物券操作", tags = "这是用户对购物券的所有操作")
public class CouponController extends BaseController {
    @Autowired
    CouponService couponService;

    @Autowired
    private RestTemplate restTemplate;


    /**
     * @Author Thor Lau
     * @Description
     *      查询所有的优惠券
     * @Date 2020/3/13/0:00
     * @Param []
     * @Return com.aaa.lau.repast.base.ResultData
     */
    @PostMapping("/selectAllByDate")
    @ApiOperation(value = "查询", notes = "查询所有没有过期的优惠券")
    public ResultData selectAllByDate(HttpServletRequest request){
        Map params = GetZuulFilterParamsUtil.getParams(request);
        TokenVo tokenVo = couponService.selectAllByDate(params);
        if (tokenVo != null) {
            return couponsuccess(tokenVo.getData(),tokenVo.getToken());
        }
        return couponfailed(tokenVo.getToken());
    }

    /**
     * @Author Thor Lau
     * @Description
     *      根据商品查询对应的购物券
     * @Date 2020/3/13/17:36
     * @Param [coupon, token]
     * @Return java.util.List<Coupon>
     */
    @PostMapping("/selectByProduct")
    @ApiOperation(value = "查询", notes = "根据商品查询对应的购物券")
    public ResultData selectByProduct(HttpServletRequest request){
        Map params = GetZuulFilterParamsUtil.getParams(request);
        Long a = (Long) params.get(MEMBERID);
        Long b = (Long) params.get(SHOPID);
        if (params.get(TOKEN) != null && a > 0 && b > 0){
            TokenVo tokenVo = couponService.selectByProduct(params);
            if (tokenVo != null) {
                return couponsuccess(tokenVo.getData(),tokenVo.getToken());
            }
            return couponfailed(tokenVo.getToken());
        }
        return couponfailed((String) params.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      根据用户查询这个用户所拥有的购物券
     * @Date 2020/3/13/18:03
     * @Param [member, token]
     * @Return java.util.List<Coupon>
     */
    @PostMapping("/selectByMember")
    @ApiOperation(value = "查询", notes = "根据用户查询这个用户所拥有的购物券")
    public ResultData selectByMember(HttpServletRequest request){
        Map params = GetZuulFilterParamsUtil.getParams(request);
        if (params != null){
            TokenVo tokenVo = couponService.selectByMember(params);
            if (tokenVo != null) {
                return couponsuccess(tokenVo.getData(),tokenVo.getToken());
            }
            return couponfailed(tokenVo.getToken());
        }
        return couponfailed((String) params.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      用户删除优惠券的操作
     * @Date 2020/3/14/23:31
     * @Param [coupon, token]
     * @Return int
     */
    @PostMapping("/deleteCoupon")
    @ApiOperation(value = "删除", notes = "会员可以删除优惠券")
    public ResultData deleteCoupon(HttpServletRequest request){
        Map params = GetZuulFilterParamsUtil.getParams(request);
        if (params != null){
            TokenVo c = couponService.deleteCoupon(params);
            if (c != null) {
                return couponsuccess(c.getData(),c.getToken());
            }
            return couponfailed(c.getToken());
        }
        return couponfailed((String) params.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      每到十二点，自动更新优惠券状态，
     *      检验优惠券是否过期
     * @Date 2020/3/14/23:45
     * @Param []
     * @Return int
     */
    @Scheduled(cron = CRON)
    public int updateByTime(){
        int c = couponService.updateByTime();
        if (c != 0) {
            return c;
        }
        return 0;
    }

    /**
     * @Author Thor Lau
     * @Description
     *      用户领取优惠券的操作
     * @Date 2020/3/14/23:30
     * @Param [member, token]
     * @Return int
     */
    @PostMapping("/insertCouponByMember")
    @ApiOperation(value = "领取", notes = "用户领取优惠券的操作")
    public ResultData insertCouponByMember(HttpServletRequest request){
        Map params = GetZuulFilterParamsUtil.getParams(request);
        if (params != null){
            TokenVo c =couponService.insertCouponByMember(params);
            if (c != null) {
                return couponsuccess(c.getData(),c.getToken());
            }
            return couponfailed(c.getToken());
        }
        return couponfailed((String) params.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      限时秒杀
     * @Date 2020/3/17/15:48
     * @Param [couponHistory, token]
     * @Return int
     */
    @PostMapping("/getCoupon")
    @ApiOperation(value = "秒杀", notes = "秒杀优惠券")
    public ResultData getCoupon(HttpServletRequest request){
        Map params = GetZuulFilterParamsUtil.getParams(request);
        if (params != null){
            TokenVo c =couponService.getCoupon(params);
            if (c != null) {
                return couponsuccess(c.getData(),c.getToken());
            }
            return couponfailed(c.getToken());
        }
        return couponfailed((String) params.get(TOKEN));
    }

    @PostMapping("/usedCouponByMember")
    @ApiOperation(value = "使用", notes = "用户使用过的优惠券")
    public ResultData usedCouponByMember(HttpServletRequest request){
        Map params = GetZuulFilterParamsUtil.getParams(request);
        if (params != null){
            TokenVo c = couponService.usedCouponByMember(params);
            if (c != null){
                return couponsuccess(c.getData(),c.getToken());
            }
        }
        return couponfailed((String) params.get(TOKEN));
    }

    @GetMapping("/ceshi")
    public Object ceshi()
    {
        String url = "http://localhost:4081/aaa/thor/insertCouponByMember";
        Map map = new HashMap();
        map.put("CouponId",1);
        map.put("MemberId",1);
        map.put("ShopId",1);
        map.put("token","123456");
        return restTemplate.postForObject(url, map, ResultData.class);
    }
}

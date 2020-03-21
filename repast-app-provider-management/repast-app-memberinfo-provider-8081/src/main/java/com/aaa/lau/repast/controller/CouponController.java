package com.aaa.lau.repast.controller;

import com.aaa.lau.repast.base.BaseService;
import com.aaa.lau.repast.base.CommonController;
import com.aaa.lau.repast.model.*;
import com.aaa.lau.repast.service.CouponService;
import com.aaa.lau.repast.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.aaa.lau.repast.staticstatus.RequestProperties.*;

/**
 * @Program: 20200309-repast-app-parent
 * @Description: 优惠券
 * @Author: Thor Lau
 * @Create: 2020-03-14 11:12
 **/
@RestController
public class CouponController extends CommonController<Coupon> {
    @Autowired
    CouponService couponService;


    @PostMapping("/selectAllByDate")
    public TokenVo selectAllByDate(@RequestBody Map map){
        TokenVo tokenVo = couponService.selectAllByDate(map);
        return tokenVo;
    }

    /**
     * @Author Thor Lau
     * @Description
     *      根据商品查询出来对应的优惠券
     * @Date 2020/3/15/17:45
     * @Param [shopId]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    @PostMapping("/selectByProduct")
    public TokenVo selectByProduct(@RequestBody Map map){
        TokenVo tokenVo = couponService.selectByProduct(map);
        return tokenVo;
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
    public TokenVo selectByMember(@RequestBody Map map){
        return couponService.selectByMember(map);
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
    public TokenVo deleteCoupon(@RequestBody Map map){
        return couponService.deleteCoupon(map);
    }

    /**
     * @Author Thor Lau
     * @Description
     *      将已过期的优惠券的状态改为已过期
     * @Date 2020/3/15/20:15
     * @Param [nowTime]
     * @Return int
     */
    @PutMapping("/updateByTime")
    public int updateByTime(){
        return couponService.updateByTime();
    }

    /**
     * @Author Thor Lau
     * @Description
     *      用户领取优惠券的操作
     * @Date 2020/3/15/22:34
     * @Param [couponHistory]
     * @Return int
     */
    @PostMapping("/insertCouponByMember")
    public TokenVo insertCouponByMember(@RequestBody Map map){
        return couponService.insertCouponByMember(map);
    }

    /**
     * @Author Thor Lau
     * @Description
     *      秒杀
     * @Date 2020/3/20/18:29
     * @Param [couponHistory, token]
     * @Return com.aaa.lau.repast.vo.TokenVo
     */
    @PostMapping("/getCoupon")
    public TokenVo getCoupon(@RequestBody Map map){
        return couponService.getCoupon(map);
    }

    @PutMapping("/usedCouponByMember")
    public TokenVo usedCouponByMember(@RequestBody Map map){
        return couponService.usedCouponByMember(map);
    }

    @Override
    public BaseService<Coupon> getBaseService() {
        return couponService;
    }
}

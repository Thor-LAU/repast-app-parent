package com.aaa.lau.repast.service;

import com.aaa.lau.repast.config.FeignMultiPartConfig;
import com.aaa.lau.repast.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Program: 20200309-repast-app-parent
 * @Description: 优惠券的Service
 * @Author: Thor Lau
 * @Create: 2020-03-12 23:38
 **/
@FeignClient(value = "couponinfo-interface",configuration = FeignMultiPartConfig.class)
public interface CouponService {

    /**
     * @Author Thor Lau
     * @Description
     *      selectAllByDate：查询所有没有过期的优惠券
     * @Date 2020/3/13/0:00
     * @Param []
     * @Return com.aaa.lau.repast.base.ResultData
     */
    @PostMapping("/selectAllByDate")
    TokenVo selectAllByDate(@RequestBody Map map);

    /**
     * @Author Thor Lau
     * @Description
     *      根据商品查询对应的购物券
     * @Date 2020/3/14/23:20
     * @Param [product]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    @PostMapping("/selectByProduct")
    TokenVo selectByProduct(@RequestBody Map map);

    /**
     * @Author Thor Lau
     * @Description
     *      根据用户查询所拥有的优惠券
     * @Date 2020/3/14/23:21
     * @Param [id]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    @PostMapping("/selectByMember")
    TokenVo selectByMember(@RequestBody Map map);

    /**
     * @Author Thor Lau
     * @Description
     *      用户删除优惠券的操作
     * @Date 2020/3/14/23:43
     * @Param [Id]
     * @Return int
     */
    @PostMapping("/deleteCoupon")
    TokenVo deleteCoupon(@RequestBody Map map);

    /**
     * @Author Thor Lau
     * @Description
     *      领取优惠券的操作
     * @Date 2020/3/14/23:44
     * @Param [id]
     * @Return int
     */
    @PostMapping("/insertCouponByMember")
    TokenVo insertCouponByMember(@RequestBody Map map);

    /**
     * @Author Thor Lau
     * @Description
     *      每到十二点，自动更新优惠券状态，
     *      检验优惠券是否过期
     * @Date 2020/3/14/23:44
     * @Param []
     * @Return int
     */
    @PutMapping("/updateByTime")
    int updateByTime();

    /**
     * @Author Thor Lau
     * @Description
     *      限时秒杀
     * @Date 2020/3/17/16:00
     * @Param [couponHistory]
     * @Return int
     */
    @PostMapping("/getCoupon")
    TokenVo getCoupon(@RequestBody Map map);

    /**
     * @Author Thor Lau
     * @Description
     *      使用过的优惠券
     * @Date 2020/3/20/18:07
     * @Param [member, token]
     * @Return com.aaa.lau.repast.vo.TokenVo
     */
    @PutMapping("/usedCouponByMember")
    TokenVo usedCouponByMember(@RequestBody Map map);
}

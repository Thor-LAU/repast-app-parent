package com.aaa.lau.repast.mapper;

import com.aaa.lau.repast.model.CouponHistory;
import com.aaa.lau.repast.model.Member;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CouponHistoryMapper extends Mapper<CouponHistory> {
    /**
     * @Author Thor Lau
     * @Description
     *      用户领取优惠券的操作
     * @Date 2020/3/15/22:32
     * @Param [couponHistory]
     * @Return java.util.List<com.aaa.lau.repast.model.CouponHistory>
     */
    int insertCouponByMember(CouponHistory couponHistory);

    int usedCouponByMember(Long id);

    int deleteCoupon(Long id);
}
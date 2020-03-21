package com.aaa.lau.repast.mapper;

import com.aaa.lau.repast.model.Coupon;
import com.aaa.lau.repast.model.CouponHistory;
import com.aaa.lau.repast.model.Product;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface CouponMapper extends Mapper<Coupon> {

    /**
     * @Author Thor Lau
     * @Description
     *      查询所有没有过期的优惠券
     * @Date 2020/3/14/17:25
     * @Param [date]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    List<Coupon> selectAllByDate(Date nowTime);

    List<Coupon> selectAllByDateP(Date nowTime);

    /**
     * @Author Thor Lau
     * @Description
     *      根据商品查询出来对应的优惠券
     * @Date 2020/3/15/17:45
     * @Param [shopId]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    List<Coupon> selectByProduct(Long shopId);

    List<Coupon> selectByProductP(Long shopId);

    /**
     * @Author Thor Lau
     * @Description
     *      根据用户查询出这个用户所拥有的优惠券
     * @Date 2020/3/15/20:13
     * @Param [id]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    List<Coupon> selectByMember(Long id);

    /**
     * @Author Thor Lau
     * @Description
     *      在执行修改为状态已过期状态的优惠券操作之前
     *      需要用此方法查出过期的优惠券都有哪些
     * @Date 2020/3/15/20:13
     * @Param [nowTime]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    List<Coupon> selectBeforeUpdate(Date nowTime);

    /**
     * @Author Thor Lau
     * @Description
     *      将已过期的优惠券的状态改为已过期
     * @Date 2020/3/15/20:15
     * @Param [nowTime]
     * @Return int
     */
    int updateByTime(Long Id);

    List<Coupon> selectById(Long Id, Date date);

    int updateCount(Coupon coupon);
}
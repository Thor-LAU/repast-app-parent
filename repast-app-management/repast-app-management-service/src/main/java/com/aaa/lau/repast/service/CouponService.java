package com.aaa.lau.repast.service;

import com.aaa.lau.repast.base.BaseService;
import com.aaa.lau.repast.mapper.*;
import com.aaa.lau.repast.model.*;
import com.aaa.lau.repast.utils.StringUtil;
import com.aaa.lau.repast.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;
import java.util.*;

import static com.aaa.lau.repast.staticstatus.RequestProperties.*;

/**
 * @Program: 20200309-repast-app-parent
 * @Description:
 * @Author: Thor Lau
 * @Create: 2020-03-13 18:13
 **/
@Service
public class CouponService extends BaseService<Coupon> {
    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouponHistoryMapper couponHistoryMapper;

    @Autowired
    MemberMapper memberMapper;

    //TODO 验证token：&& token != null && token.equals("")

    /**
     * @Author Thor Lau
     * @Description
     *      查询所有优惠券
     *          1.登陆的用户，可以看到符合自己等级的所有优惠券
     *          2.未登录，只能看到普通的优惠券
     * @Date 2020/3/14/17:18
     * @Param []
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    public TokenVo selectAllByDate(Map map){
        TokenVo tokenVo = new TokenVo();
        if (map.get(TOKEN) != null && StringUtil.isNotEmpty((String)map.get(TOKEN))) {
            Map member1 = memberMapper.selectMemberById((Long) map.get(MEMBERID));
            if (member1.get("token").equals(map.get(TOKEN)) &&
                    (Integer) member1.get("growth_point") > 10){
                Date nowTime = new Date();
                List<Coupon> list = couponMapper.selectAllByDate(nowTime);
                TokenVo tokenVo1 = new TokenVo();
                if (list != null){
                    tokenVo1.setData(list).setToken((String) map.get(TOKEN));
                    return tokenVo;
                }
                return tokenVo.setToken((String) (map.get(TOKEN)));
            }
        }
        //token不存在的情况下
        Date nowTime = new Date();
        List<Coupon> list = couponMapper.selectAllByDateP(nowTime);
        TokenVo tokenVo1 = new TokenVo();
        if (list != null){
            tokenVo1.setToken((String) map.get(TOKEN));
            tokenVo1.setData(list);
            return tokenVo1;
        }
        return tokenVo1.setData((String) map.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      根据商品查询出来对应的优惠券，与查询所有类似，也有两种
     * @Date 2020/3/15/17:45
     * @Param [shopId]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    public TokenVo selectByProduct(Map map){
        TokenVo tokenVo = new TokenVo();
        if (map == null){
            return tokenVo.setToken((String) map.get(TOKEN));
        }
        if ((Long)map.get(MEMBERID) > 0 && (Long)map.get(SHOPID) > 0 && map.get(TOKEN) != null && StringUtil.isNotEmpty((String)map.get(TOKEN))){
            Map member1 = memberMapper.selectMemberById((Long) map.get(MEMBERID));
            if (member1 != null && member1.get("token").equals((String) map.get(TOKEN)) && (Integer)member1.get("growth_point") > 10){
                List<Coupon> list = couponMapper.selectByProduct((Long)map.get(SHOPID));
                TokenVo tokenVo1 = new TokenVo();
                if (list != null) {
                    tokenVo1.setData(list).setToken((String) map.get(TOKEN));
                    return tokenVo1;
                }
                return tokenVo1.setToken((String) map.get(TOKEN));
            }
        }
        if ((Long)map.get(SHOPID) != null) {
            List<Coupon> list = couponMapper.selectByProductP((Long)map.get(SHOPID));
            TokenVo tokenVo2 = new TokenVo();
            if (list != null) {
                tokenVo2.setData(list).setToken((String) map.get(TOKEN));
                return tokenVo2;
            }
            return tokenVo2.setToken((String) map.get(TOKEN));
        }
        return tokenVo.setToken((String) map.get(TOKEN));
    }


    /**
     * @Author Thor Lau
     * @Description
     *      根据用户ID查询用户本人所拥有的优惠券
     * @Date 2020/3/15/17:45
     * @Param [id]
     * @Return java.util.List<com.aaa.lau.repast.model.Coupon>
     */
    public TokenVo selectByMember(Map map){
        TokenVo tokenVo = new TokenVo();
        if (map==null){
            return tokenVo.setToken((String) map.get(TOKEN));
        }
        if (map != null && map.get(TOKEN) != null && StringUtil.isNotEmpty((String)map.get(TOKEN))){
            Map member1 = memberMapper.selectMemberById((Long)map.get(MEMBERID));
            if (member1.get("token").equals(map.get(TOKEN))){
                Long id = (Long)map.get(MEMBERID);
                if (id != null){
                    List<Coupon> list = couponMapper.selectByMember(id);
                    TokenVo tokenVo1 = new TokenVo();
                    if (list != null) {
                        return tokenVo1.setToken((String) map.get(TOKEN)).setData(list);
                    }
                    return tokenVo1.setToken((String) map.get(TOKEN));
                }
            }
        }
        return tokenVo.setToken((String) map.get(TOKEN));
    }


    /**
     * @Author Thor Lau
     * @Description
     *      将过期的优惠券更改为已过期
     *  --->在此之前需要查出都有哪些优惠券过期了
     * @Date 2020/3/15/17:46
     * @Param []
     * @Return int
     */
    public int updateByTime(){
        Date nowTime = new Date();
        List<Coupon> list=couponMapper.selectBeforeUpdate(nowTime);
        if (list != null){
            for(int i = 0 ; i < list.size() ; i++) {
                Long Id = list.get(i).getId();
                if (Id != 0){
                    couponMapper.updateByTime(Id);
                }
                return 0;
            }
        }
        return 0;
    }

    /**
     * @Author Thor Lau
     * @Description
     *      用户领取优惠券的操作
     * @Date 2020/3/15/22:35
     * @Param [couponHistory]
     * @Return int
     */
//    public static void main(String[] args) {
//        Map map = new HashMap();
//        map.put("TOKEN","abcd");
//        List list = new ArrayList();
//        list.add(map.get("TOKEN"));
//        map.remove("TOKEN");
//        System.out.println(map+"------"+list);
//    }
    public TokenVo insertCouponByMember(Map map){
        TokenVo tokenVo = new TokenVo();
        if (map == null){
            return tokenVo.setToken((String) map.get(TOKEN));
          }
//        if(null != map.get(TOKEN) && StringUtil.isNotEmpty((String)map.get(TOKEN))) {
//            // map中包含的有token值，不能直接转换对象类型--->转换异常--->所以需要把token移除
//            List list = new ArrayList();
//            list.add(map.get(TOKEN));
//            map.remove(TOKEN);
//        }
        if ((Long)map.get(COUPONID) != 0 && map.get(TOKEN) != null && StringUtil.isNotEmpty((String) map.get(TOKEN))){
            Date nowTime = new Date();
            List<Coupon> list = couponMapper.selectById((Long)map.get(COUPONID),nowTime);
            if (list != null) {
                if (map.get(COUPONID) != null &&
                        map.get(SHOPID) != null &&
                        map.get(MEMBERID) != null) {
                    Coupon coupon = list.get(0);
//                    couponHistory.setCouponCode(coupon.getCode());
                    map.put(CODE,coupon.getCode());
                    Map member = memberMapper.selectMemberById((Long)map.get(MEMBERID));
                    List a = new ArrayList();
                    a.add(map.get(TOKEN));
                    map.remove(TOKEN);
                    CouponService couponService = new CouponService();
                    CouponHistory couponHistory = new CouponHistory();
                    CouponHistory couponHistory1 = couponService.mapToBean(map,couponHistory);
                    if (member != null){
                        couponHistory1.setMemberNickname((String) member.get("Nickname"));
                        couponHistory1.setCreateTime(nowTime);
                        int b = couponHistoryMapper.insertCouponByMember(couponHistory1);
                        TokenVo tokenVo2 = new TokenVo();
                        if (b > 0){
                            return tokenVo2.setData(b).setToken((String) a.get(0));
                        }
                        return tokenVo2.setToken((String) a.get(0));
                    }
                }
            }
        }
        return tokenVo.setToken((String) map.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      限时秒杀
     *      时间过了就不能再抢了
     *      有开始时间，要将状态改为不可领取，
     *      到了开始时间之后将状态改为可领取，
     *      当当前的时间=结束时间时，将状态改回去即可
     * @Date 2020/3/16/0:06
     * @Param []
     * @Return int
     */
    public TokenVo getCoupon(Map map){
        TokenVo tokenVo = new TokenVo();
        if (map == null){
            return tokenVo.setToken((String) map.get(TOKEN));
        }
        if (map.get(TOKEN) != null &&
                StringUtil.isNotEmpty((String) map.get(TOKEN)) &&
                (Long)map.get(MEMBERID) != 0){
            Map member = memberMapper.selectMemberById((Long)map.get(MEMBERID));
            if (member != null && member.equals("") && member.get("token").equals((String) map.get(TOKEN))){
                Date nowTime = new Date();
                List<Coupon> list = couponMapper.selectById((Long)map.get(COUPONID),nowTime);
                Coupon coupon = list.get(0);
                Integer c = coupon.getCount();
                if (list == null && c > 1) {
                    if (map.get(COUPONID) != null &&
                            map.get(SHOPID) != null &&
                            map.get(MEMBERID) != null) {
                        TokenVo tokenVo1 = new TokenVo();
                        map.put(CODE,coupon.getCode());
                        Map list1 = memberMapper.selectMemberById((Long) map.get(MEMBERID));
                        map.put(MEMBERNICKNAME,(String) list1.get("Nickname"));
                        map.put(CREATETIME,nowTime);
                        List a = new ArrayList();
                        a.add(map.get(TOKEN));
                        map.remove(TOKEN);
                        CouponService couponService = new CouponService();
                        CouponHistory couponHistory = new CouponHistory();
                        CouponHistory couponHistory1 = couponService.mapToBean(map,couponHistory);
                        int b = couponHistoryMapper.insertCouponByMember(couponHistory1);
                        if (b > 0){
                            coupon.setCount(c-1);
                            int d = couponMapper.updateCount(coupon);
                            return tokenVo1.setData(b).setToken((String) a.get(0));
                        }
                        return tokenVo1.setToken((String) a.get(0));
                    }
                }
            }
        }
        return tokenVo.setToken((String) map.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      转换为实体
     * @Date 2020/3/21/4:34
     * @Param [map, bean]
     * @Return T
     */
    public static <T> T mapToBean(Map<String, Object> map,T bean){
        BeanMap beanMap=BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * @Author Thor Lau
     * @Description
     *      用户使用了优惠券
     * @Date 2020/3/17/18:18
     * @Param [member, token]
     * @Return int
     */
    public TokenVo usedCouponByMember(Map map){
        TokenVo tokenVo = new TokenVo();
        if (map == null){
            return tokenVo.setToken((String) map.get(TOKEN));
        }
        if ((Long)map.get(MEMBERID) != 0 &&
                map.get(TOKEN) != null &&
                StringUtil.isNotEmpty((String) map.get(TOKEN))){
            int a = couponHistoryMapper.usedCouponByMember((Long)map.get(MEMBERID));
            TokenVo tokenVo1 = new TokenVo();
            if (a != 0){
                return tokenVo1.setData(a).setToken((String)map.get(TOKEN));
            }
            return tokenVo1.setToken((String)map.get(TOKEN));
        }
        return tokenVo.setToken((String)map.get(TOKEN));
    }

    /**
     * @Author Thor Lau
     * @Description
     *      用户删除优惠券
     * @Date 2020/3/20/18:31
     * @Param [id, token]
     * @Return com.aaa.lau.repast.vo.TokenVo
     */
    public TokenVo deleteCoupon(Map map) {
        TokenVo tokenVo = new TokenVo();
        if (map == null){
            return tokenVo.setToken((String) map.get(TOKEN));
        }
        if ((Long)map.get(COUPONHISTORYID) != 0 && map.get(TOKEN) != null &&
                StringUtil.isNotEmpty((String) map.get(TOKEN))){
            int a = couponHistoryMapper.deleteCoupon((Long)map.get(COUPONHISTORYID));
            TokenVo tokenVo1 = new TokenVo();
            if (a != 0){
                return tokenVo1.setData(a).setToken((String)map.get(TOKEN));
            }
            return tokenVo1.setToken((String)map.get(TOKEN));
        }
        return tokenVo.setToken((String)map.get(TOKEN));
    }
}

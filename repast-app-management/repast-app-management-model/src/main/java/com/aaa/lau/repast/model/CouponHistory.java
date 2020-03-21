package com.aaa.lau.repast.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sms_coupon_history")
public class CouponHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "coupon_code")
    private String couponCode;

    /**
     * ?????
     */
    @Column(name = "member_nickname")
    private String memberNickname;

    /**
     * ?????0->?????1->????
     */
    @Column(name = "get_type")
    private Integer getType;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * ?????0->????1->????2->???
     */
    @Column(name = "use_status")
    private Integer useStatus;

    /**
     * ????
     */
    @Column(name = "use_time")
    private Date useTime;

    /**
     * ????
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * ????
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return shop_id
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * @param shopId
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * @return coupon_id
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * @param couponId
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * @return member_id
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * @return coupon_code
     */
    public String getCouponCode() {
        return couponCode;
    }

    /**
     * @param couponCode
     */
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }

    /**
     * 获取?????
     *
     * @return member_nickname - ?????
     */
    public String getMemberNickname() {
        return memberNickname;
    }

    /**
     * 设置?????
     *
     * @param memberNickname ?????
     */
    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname == null ? null : memberNickname.trim();
    }

    /**
     * 获取?????0->?????1->????
     *
     * @return get_type - ?????0->?????1->????
     */
    public Integer getGetType() {
        return getType;
    }

    /**
     * 设置?????0->?????1->????
     *
     * @param getType ?????0->?????1->????
     */
    public void setGetType(Integer getType) {
        this.getType = getType;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取?????0->????1->????2->???
     *
     * @return use_status - ?????0->????1->????2->???
     */
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
     * 设置?????0->????1->????2->???
     *
     * @param useStatus ?????0->????1->????2->???
     */
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    /**
     * 获取????
     *
     * @return use_time - ????
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     * 设置????
     *
     * @param useTime ????
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    /**
     * 获取????
     *
     * @return order_id - ????
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置????
     *
     * @param orderId ????
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取????
     *
     * @return order_sn - ????
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 设置????
     *
     * @param orderSn ????
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }
}
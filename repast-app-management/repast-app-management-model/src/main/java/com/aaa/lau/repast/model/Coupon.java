package com.aaa.lau.repast.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sms_coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    /**
     * ??????0->?????1->?????2->?????3->????
     */
    private Integer type;

    private String name;

    /**
     * ?????0->???1->???2->PC
     */
    private Integer platform;

    /**
     * ??
     */
    private Integer count;

    /**
     * ??
     */
    private BigDecimal amount;

    /**
     * ??????
     */
    @Column(name = "per_limit")
    private Integer perLimit;

    /**
     * ?????0?????
     */
    @Column(name = "min_point")
    private BigDecimal minPoint;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * ?????0->?????1->?????2->????
     */
    @Column(name = "use_type")
    private Integer useType;

    /**
     * ??
     */
    private String note;

    /**
     * ????
     */
    @Column(name = "publish_count")
    private Integer publishCount;

    /**
     * ?????
     */
    @Column(name = "use_count")
    private Integer useCount;

    /**
     * ????
     */
    @Column(name = "receive_count")
    private Integer receiveCount;

    /**
     * ???????
     */
    @Column(name = "enable_time")
    private Date enableTime;

    /**
     * ???
     */
    private String code;

    /**
     * ?????????0->???
     */
    @Column(name = "member_level")
    private Integer memberLevel;

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
     * 获取??????0->?????1->?????2->?????3->????
     *
     * @return type - ??????0->?????1->?????2->?????3->????
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置??????0->?????1->?????2->?????3->????
     *
     * @param type ??????0->?????1->?????2->?????3->????
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取?????0->???1->???2->PC
     *
     * @return platform - ?????0->???1->???2->PC
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 设置?????0->???1->???2->PC
     *
     * @param platform ?????0->???1->???2->PC
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 获取??
     *
     * @return count - ??
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置??
     *
     * @param count ??
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取??
     *
     * @return amount - ??
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置??
     *
     * @param amount ??
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取??????
     *
     * @return per_limit - ??????
     */
    public Integer getPerLimit() {
        return perLimit;
    }

    /**
     * 设置??????
     *
     * @param perLimit ??????
     */
    public void setPerLimit(Integer perLimit) {
        this.perLimit = perLimit;
    }

    /**
     * 获取?????0?????
     *
     * @return min_point - ?????0?????
     */
    public BigDecimal getMinPoint() {
        return minPoint;
    }

    /**
     * 设置?????0?????
     *
     * @param minPoint ?????0?????
     */
    public void setMinPoint(BigDecimal minPoint) {
        this.minPoint = minPoint;
    }

    /**
     * @return start_time
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取?????0->?????1->?????2->????
     *
     * @return use_type - ?????0->?????1->?????2->????
     */
    public Integer getUseType() {
        return useType;
    }

    /**
     * 设置?????0->?????1->?????2->????
     *
     * @param useType ?????0->?????1->?????2->????
     */
    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    /**
     * 获取??
     *
     * @return note - ??
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置??
     *
     * @param note ??
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取????
     *
     * @return publish_count - ????
     */
    public Integer getPublishCount() {
        return publishCount;
    }

    /**
     * 设置????
     *
     * @param publishCount ????
     */
    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    /**
     * 获取?????
     *
     * @return use_count - ?????
     */
    public Integer getUseCount() {
        return useCount;
    }

    /**
     * 设置?????
     *
     * @param useCount ?????
     */
    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    /**
     * 获取????
     *
     * @return receive_count - ????
     */
    public Integer getReceiveCount() {
        return receiveCount;
    }

    /**
     * 设置????
     *
     * @param receiveCount ????
     */
    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    /**
     * 获取???????
     *
     * @return enable_time - ???????
     */
    public Date getEnableTime() {
        return enableTime;
    }

    /**
     * 设置???????
     *
     * @param enableTime ???????
     */
    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    /**
     * 获取???
     *
     * @return code - ???
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置???
     *
     * @param code ???
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取?????????0->???
     *
     * @return member_level - ?????????0->???
     */
    public Integer getMemberLevel() {
        return memberLevel;
    }

    /**
     * 设置?????????0->???
     *
     * @param memberLevel ?????????0->???
     */
    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }
}
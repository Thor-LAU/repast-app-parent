package com.aaa.lau.repast.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pms_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ??ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * ??ID
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * ????ID
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * ??????ID
     */
    @Column(name = "product_attribute_category_id")
    private Long productAttributeCategoryId;

    private String name;

    private String pic;

    /**
     * ??
     */
    @Column(name = "product_sn")
    private String productSn;

    /**
     * ?????0->????1->???
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * ?????0->???1->??
     */
    @Column(name = "publish_status")
    private Integer publishStatus;

    /**
     * ????:0->?????1->??
     */
    @Column(name = "new_status")
    private Integer newStatus;

    /**
     * ?????0->????1->??
     */
    @Column(name = "recommand_status")
    private Integer recommandStatus;

    /**
     * ??
     */
    private Integer sort;

    /**
     * ??
     */
    private Integer sale;

    private BigDecimal price;

    /**
     * ????
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * ?????
     */
    @Column(name = "gift_point")
    private Integer giftPoint;

    /**
     * ???
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * ???
     */
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    /**
     * ??
     */
    private Integer stock;

    /**
     * ?????
     */
    @Column(name = "low_stock")
    private Integer lowStock;

    /**
     * ??
     */
    private String unit;

    /**
     * ?????????
     */
    private BigDecimal weight;

    /**
     * ???????????1->?????2->?????3->????
     */
    @Column(name = "service_ids")
    private String serviceIds;

    private String keywords;

    private String note;

    /**
     * ??id
     */
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "detail_title")
    private String detailTitle;

    /**
     * ??????
     */
    @Column(name = "promotion_start_time")
    private Date promotionStartTime;

    /**
     * ??????
     */
    @Column(name = "promotion_end_time")
    private Date promotionEndTime;

    /**
     * ??????
     */
    @Column(name = "promotion_per_limit")
    private Integer promotionPerLimit;

    /**
     * ?????0->????????;1->??????2->??????3->???????4->???????5->???
     */
    @Column(name = "promotion_type")
    private Integer promotionType;

    /**
     * ????
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * ??????
     */
    @Column(name = "product_category_name")
    private String productCategoryName;

    /**
     * ???0-> ???;  1-> ??
     */
    private Byte currency;

    /**
     * ????
     */
    private String description;

    @Column(name = "detail_desc")
    private String detailDesc;

    /**
     * ????????
     */
    @Column(name = "detail_html")
    private String detailHtml;

    /**
     * ???????
     */
    @Column(name = "detail_mobile_html")
    private String detailMobileHtml;

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
     * 获取??ID
     *
     * @return shop_id - ??ID
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置??ID
     *
     * @param shopId ??ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取??ID
     *
     * @return brand_id - ??ID
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 设置??ID
     *
     * @param brandId ??ID
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取????ID
     *
     * @return product_category_id - ????ID
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * 设置????ID
     *
     * @param productCategoryId ????ID
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * 获取??????ID
     *
     * @return product_attribute_category_id - ??????ID
     */
    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    /**
     * 设置??????ID
     *
     * @param productAttributeCategoryId ??????ID
     */
    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
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
     * @return pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取??
     *
     * @return product_sn - ??
     */
    public String getProductSn() {
        return productSn;
    }

    /**
     * 设置??
     *
     * @param productSn ??
     */
    public void setProductSn(String productSn) {
        this.productSn = productSn == null ? null : productSn.trim();
    }

    /**
     * 获取?????0->????1->???
     *
     * @return delete_status - ?????0->????1->???
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置?????0->????1->???
     *
     * @param deleteStatus ?????0->????1->???
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取?????0->???1->??
     *
     * @return publish_status - ?????0->???1->??
     */
    public Integer getPublishStatus() {
        return publishStatus;
    }

    /**
     * 设置?????0->???1->??
     *
     * @param publishStatus ?????0->???1->??
     */
    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 获取????:0->?????1->??
     *
     * @return new_status - ????:0->?????1->??
     */
    public Integer getNewStatus() {
        return newStatus;
    }

    /**
     * 设置????:0->?????1->??
     *
     * @param newStatus ????:0->?????1->??
     */
    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    /**
     * 获取?????0->????1->??
     *
     * @return recommand_status - ?????0->????1->??
     */
    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    /**
     * 设置?????0->????1->??
     *
     * @param recommandStatus ?????0->????1->??
     */
    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    /**
     * 获取??
     *
     * @return sort - ??
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置??
     *
     * @param sort ??
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取??
     *
     * @return sale - ??
     */
    public Integer getSale() {
        return sale;
    }

    /**
     * 设置??
     *
     * @param sale ??
     */
    public void setSale(Integer sale) {
        this.sale = sale;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取????
     *
     * @return promotion_price - ????
     */
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * 设置????
     *
     * @param promotionPrice ????
     */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /**
     * 获取?????
     *
     * @return gift_point - ?????
     */
    public Integer getGiftPoint() {
        return giftPoint;
    }

    /**
     * 设置?????
     *
     * @param giftPoint ?????
     */
    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    /**
     * 获取???
     *
     * @return sub_title - ???
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 设置???
     *
     * @param subTitle ???
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    /**
     * 获取???
     *
     * @return original_price - ???
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置???
     *
     * @param originalPrice ???
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取??
     *
     * @return stock - ??
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置??
     *
     * @param stock ??
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取?????
     *
     * @return low_stock - ?????
     */
    public Integer getLowStock() {
        return lowStock;
    }

    /**
     * 设置?????
     *
     * @param lowStock ?????
     */
    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    /**
     * 获取??
     *
     * @return unit - ??
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置??
     *
     * @param unit ??
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 获取?????????
     *
     * @return weight - ?????????
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 设置?????????
     *
     * @param weight ?????????
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 获取???????????1->?????2->?????3->????
     *
     * @return service_ids - ???????????1->?????2->?????3->????
     */
    public String getServiceIds() {
        return serviceIds;
    }

    /**
     * 设置???????????1->?????2->?????3->????
     *
     * @param serviceIds ???????????1->?????2->?????3->????
     */
    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds == null ? null : serviceIds.trim();
    }

    /**
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取??id
     *
     * @return album_id - ??id
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * 设置??id
     *
     * @param albumId ??id
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    /**
     * @return detail_title
     */
    public String getDetailTitle() {
        return detailTitle;
    }

    /**
     * @param detailTitle
     */
    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle == null ? null : detailTitle.trim();
    }

    /**
     * 获取??????
     *
     * @return promotion_start_time - ??????
     */
    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    /**
     * 设置??????
     *
     * @param promotionStartTime ??????
     */
    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    /**
     * 获取??????
     *
     * @return promotion_end_time - ??????
     */
    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    /**
     * 设置??????
     *
     * @param promotionEndTime ??????
     */
    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    /**
     * 获取??????
     *
     * @return promotion_per_limit - ??????
     */
    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    /**
     * 设置??????
     *
     * @param promotionPerLimit ??????
     */
    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    /**
     * 获取?????0->????????;1->??????2->??????3->???????4->???????5->???
     *
     * @return promotion_type - ?????0->????????;1->??????2->??????3->???????4->???????5->???
     */
    public Integer getPromotionType() {
        return promotionType;
    }

    /**
     * 设置?????0->????????;1->??????2->??????3->???????4->???????5->???
     *
     * @param promotionType ?????0->????????;1->??????2->??????3->???????4->???????5->???
     */
    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    /**
     * 获取????
     *
     * @return brand_name - ????
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置????
     *
     * @param brandName ????
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 获取??????
     *
     * @return product_category_name - ??????
     */
    public String getProductCategoryName() {
        return productCategoryName;
    }

    /**
     * 设置??????
     *
     * @param productCategoryName ??????
     */
    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName == null ? null : productCategoryName.trim();
    }

    /**
     * 获取???0-> ???;  1-> ??
     *
     * @return currency - ???0-> ???;  1-> ??
     */
    public Byte getCurrency() {
        return currency;
    }

    /**
     * 设置???0-> ???;  1-> ??
     *
     * @param currency ???0-> ???;  1-> ??
     */
    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    /**
     * 获取????
     *
     * @return description - ????
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置????
     *
     * @param description ????
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return detail_desc
     */
    public String getDetailDesc() {
        return detailDesc;
    }

    /**
     * @param detailDesc
     */
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }

    /**
     * 获取????????
     *
     * @return detail_html - ????????
     */
    public String getDetailHtml() {
        return detailHtml;
    }

    /**
     * 设置????????
     *
     * @param detailHtml ????????
     */
    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml == null ? null : detailHtml.trim();
    }

    /**
     * 获取???????
     *
     * @return detail_mobile_html - ???????
     */
    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    /**
     * 设置???????
     *
     * @param detailMobileHtml ???????
     */
    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml == null ? null : detailMobileHtml.trim();
    }
}
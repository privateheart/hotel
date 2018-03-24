package io.renren.modules.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 物品--单位表  一个物品可以有多个单位
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-19 07:02:14
 */
public class HGoodsUnit implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer goodsUnitId;
    //物品Id
    private Integer goodsId;
    //单位
    private String unit;
    //换算率 {箱 x 换算率 = 瓶（标准单位）}
    private Integer conversionRate;
    //该单位下的 价格
    private BigDecimal unitPrice;
    //是否原子单位
    private Integer isAtomic;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer creator;
    //
    private Integer modifier;
    //是否有效
    private Integer isValid;

    /**
     * 设置：
     */
    public void setGoodsUnitId(Integer goodsUnitId) {
        this.goodsUnitId = goodsUnitId;
    }

    /**
     * 获取：
     */
    public Integer getGoodsUnitId() {
        return goodsUnitId;
    }

    /**
     * 设置：物品Id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：物品Id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置：单位
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取：单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置：换算率 {箱 x 换算率 = 瓶（标准单位）}
     */
    public void setConversionRate(Integer conversionRate) {
        this.conversionRate = conversionRate;
    }

    /**
     * 获取：换算率 {箱 x 换算率 = 瓶（标准单位）}
     */
    public Integer getConversionRate() {
        return conversionRate;
    }

    /**
     * 设置：该单位下的 价格
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * 获取：该单位下的 价格
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * 设置：是否原子单位
     */
    public void setIsAtomic(Integer isAtomic) {
        this.isAtomic = isAtomic;
    }

    /**
     * 获取：是否原子单位
     */
    public Integer getIsAtomic() {
        return isAtomic;
    }

    /**
     * 设置：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取：
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置：
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 获取：
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * 设置：
     */
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取：
     */
    public Integer getModifier() {
        return modifier;
    }

    /**
     * 设置：是否有效
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取：是否有效
     */
    public Integer getIsValid() {
        return isValid;
    }
}

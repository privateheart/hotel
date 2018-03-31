package io.renren.modules.stock.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 库存流动记录表Vo
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 15:32:42
 */
public class HStockFlowVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer stockFlowId;
    //物品id
    private Integer goodsId;
    //厅号id
    private Integer roomId;
    //进出数量
    private BigDecimal qty;
    //录入库存时的单位
    private Integer goodsUnitId;
    //原子数量
    private BigDecimal atomicQty;
    //操作时间
    private Date createTime;
    //操作人
    private Integer creator;
    //
    private Date modifyTime;
    //
    private Integer modifier;

    private String flowUnit;//库存流动时的单位

    private String atomicUnit;//当前流动物品的原子单位

    /**
     * 设置：主键
     */
    public void setStockFlowId(Integer stockFlowId) {
        this.stockFlowId = stockFlowId;
    }

    /**
     * 获取：主键
     */
    public Integer getStockFlowId() {
        return stockFlowId;
    }

    /**
     * 设置：物品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取：物品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置：厅号id
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取：厅号id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * 设置：进出数量
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * 获取：进出数量
     */
    public BigDecimal getQty() {
        return qty;
    }

    /**
     * 设置：录入库存时的单位
     */
    public void setGoodsUnitId(Integer goodsUnitId) {
        this.goodsUnitId = goodsUnitId;
    }

    /**
     * 获取：录入库存时的单位
     */
    public Integer getGoodsUnitId() {
        return goodsUnitId;
    }

    /**
     * 设置：原子数量
     */
    public void setAtomicQty(BigDecimal atomicQty) {
        this.atomicQty = atomicQty;
    }

    /**
     * 获取：原子数量
     */
    public BigDecimal getAtomicQty() {
        return atomicQty;
    }

    /**
     * 设置：操作时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：操作时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：操作人
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * 获取：操作人
     */
    public Integer getCreator() {
        return creator;
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
    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取：
     */
    public Integer getModifier() {
        return modifier;
    }

    public String getFlowUnit() {
        return flowUnit;
    }

    public void setFlowUnit(String flowUnit) {
        this.flowUnit = flowUnit;
    }

    public String getAtomicUnit() {
        return atomicUnit;
    }

    public void setAtomicUnit(String atomicUnit) {
        this.atomicUnit = atomicUnit;
    }
}

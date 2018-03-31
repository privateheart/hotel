package io.renren.modules.stock.vo;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 库存表
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 09:28:49
 */
public class HGoodsStockVo implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer goodsStockId;
    //物品id
    private Integer goodsId;
    //数量(原子)
    private BigDecimal qty;

    private String atomicUnit;//原子单位

    /**
     * 设置：
     */
    public void setGoodsStockId(Integer goodsStockId) {
        this.goodsStockId = goodsStockId;
    }

    /**
     * 获取：
     */
    public Integer getGoodsStockId() {
        return goodsStockId;
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
     * 设置：数量(原子)
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * 获取：数量(原子)
     */
    public BigDecimal getQty() {
        return qty;
    }

    public String getAtomicUnit() {
        return atomicUnit;
    }

    public void setAtomicUnit(String atomicUnit) {
        this.atomicUnit = atomicUnit;
    }
}

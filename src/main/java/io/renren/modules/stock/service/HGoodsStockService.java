package io.renren.modules.stock.service;

import io.renren.modules.stock.entity.HGoodsStock;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 库存表
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 09:28:49
 */
public interface HGoodsStockService {

    HGoodsStock queryObject(Integer goodsStockId);

    List<HGoodsStock> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(HGoodsStock hGoodsStock);

    void update(HGoodsStock hGoodsStock);

    void delete(Integer goodsStockId);

    void deleteBatch(Integer[] goodsStockIds);

    void updateQtyByStockFlow(BigDecimal qty, Integer goodsId);

    /**
     * 查询 有没有该 物品的库存记录
     * @param goodsId
     * @return
     */
    Integer queryGoodsStockExists(Integer goodsId);
}

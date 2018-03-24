package io.renren.modules.stock.service;

import io.renren.modules.stock.entity.HGoodsStock;

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
}

package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HGoodsStock;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 库存表
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 09:28:49
 */
@Mapper
public interface HGoodsStockDao extends BaseDao<HGoodsStock> {
    /**
     * 修改库存的数量
     * @param qty
     * @param goodsId
     */
    void updateQtyByStockFlow(@Param("qty")BigDecimal qty,@Param("goodsId")Integer goodsId);

    /**
     * 查询 有没有该 物品的库存记录
     * @param goodsId
     * @return
     */
    Integer queryGoodsStockExists(@Param("goodsId")Integer goodsId);
}

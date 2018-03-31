package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HGoodsStock;
import io.renren.modules.stock.vo.HGoodsStockVo;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
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
@Mapper
public interface HGoodsStockDao extends BaseDao<HGoodsStock> {
    /**
     * 修改库存的数量
     * @param flowQty
     * @param goodsId
     */
    void updateQtyByStockFlow(@Param("flowQty") BigDecimal flowQty, @Param("goodsId") Integer goodsId);

    /**
     * 查询 有没有该 物品的库存记录
     * @param goodsId
     * @return
     */
    Integer queryGoodsStockExists(@Param("goodsId")Integer goodsId);

    /**
     * 查询 库存列表
     *
     * @param map
     * @return
     */
    List<HGoodsStockVo> queryHGoodsStockVoList(Map<String, Object> map);

    /**
     * 查询 库存列表总条数
     *
     * @param map
     * @return
     */
    int queryHGoodsStockVoListTotal(Map<String, Object> map);
}

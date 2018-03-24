package io.renren.modules.stock.service;

import io.renren.modules.stock.entity.HGoodsUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 物品--单位表  一个物品可以有多个单位
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-19 07:02:14
 */
public interface HGoodsUnitService {

    HGoodsUnit queryObject(Integer goodsUnitId);

    List<HGoodsUnit> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(HGoodsUnit hGoodsUnit);

    void update(HGoodsUnit hGoodsUnit);

    void delete(Integer goodsUnitId);

    void deleteBatch(Integer[] goodsUnitIds);

    /**
     * 根据  goodsId 查询它下面的单位
     *
     * @param goodsId
     * @return
     */
    List<HGoodsUnit> queryUnitsByGoodsId(Integer goodsId);
}

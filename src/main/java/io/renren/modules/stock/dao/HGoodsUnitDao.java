package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HGoodsUnit;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 物品--单位表  一个物品可以有多个单位
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-19 07:02:14
 */
@Mapper
public interface HGoodsUnitDao extends BaseDao<HGoodsUnit> {
    /**
     * 根据  goodsId 查询它下面的单位
     *
     * @param goodsId
     * @return
     */
    List<HGoodsUnit> queryUnitsByGoodsId(@Param("goodsId") Integer goodsId);

    /**
     * 根据 物品 id 查询原子单位个数  大于0则不可以新增
     *
     * @param goodsId
     * @return
     */
    Integer checkAtomUnitCount(@Param("goodsId") Integer goodsId);
}

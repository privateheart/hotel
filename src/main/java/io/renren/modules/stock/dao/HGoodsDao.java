package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HGoods;
import io.renren.modules.stock.vo.HGoodsVo;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 物品表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-04 09:01:11
 */
@Mapper
public interface HGoodsDao extends BaseDao<HGoods> {

    List<HGoodsVo> queryHGoodsVoList(Map<String,Object> map);

    int queryHGoodsVoTotal(Map<String,Object> map);

    List<HGoodsVo> queryAllHGoodsVoList();
}

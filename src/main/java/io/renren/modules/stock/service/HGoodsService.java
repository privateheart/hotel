package io.renren.modules.stock.service;

import io.renren.modules.stock.entity.HGoods;
import io.renren.modules.stock.vo.HGoodsVo;

import java.util.List;
import java.util.Map;

/**
 * 物品表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-04 09:01:11
 */
public interface HGoodsService {
	
	HGoods queryObject(Integer goodsId);
	
	List<HGoods> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HGoods hGoods);
	
	void update(HGoods hGoods);
	
	void delete(Integer goodsId);
	
	void deleteBatch(Integer[] goodsIds);

	List<HGoodsVo> queryHGoodsVoList(Map<String,Object> map);

	int queryHGoodsVoTotal(Map<String,Object> map);

    List<HGoodsVo> queryAllHGoodsVoList();
}

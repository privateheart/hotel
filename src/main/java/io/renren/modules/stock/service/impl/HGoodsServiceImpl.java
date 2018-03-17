package io.renren.modules.stock.service.impl;

import io.renren.modules.stock.vo.HGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.stock.dao.HGoodsDao;
import io.renren.modules.stock.entity.HGoods;
import io.renren.modules.stock.service.HGoodsService;



@Service("hGoodsService")
public class HGoodsServiceImpl implements HGoodsService {
	@Autowired
	private HGoodsDao hGoodsDao;
	
	@Override
	public HGoods queryObject(Integer goodsId){
		return hGoodsDao.queryObject(goodsId);
	}
	
	@Override
	public List<HGoods> queryList(Map<String, Object> map){
		return hGoodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hGoodsDao.queryTotal(map);
	}
	
	@Override
	public void save(HGoods hGoods){
		hGoodsDao.save(hGoods);
	}
	
	@Override
	public void update(HGoods hGoods){
		hGoodsDao.update(hGoods);
	}
	
	@Override
	public void delete(Integer goodsId){
		hGoodsDao.delete(goodsId);
	}
	
	@Override
	public void deleteBatch(Integer[] goodsIds){
		hGoodsDao.deleteBatch(goodsIds);
	}

	@Override
	public List<HGoodsVo> queryHGoodsVoList(Map<String, Object> map) {
		return hGoodsDao.queryHGoodsVoList(map);
	}

	@Override
	public int queryHGoodsVoTotal(Map<String, Object> map) {
		return hGoodsDao.queryHGoodsVoTotal(map);
	}
}

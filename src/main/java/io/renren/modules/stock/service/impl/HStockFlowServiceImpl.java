package io.renren.modules.stock.service.impl;

import io.renren.modules.stock.dao.HGoodsStockDao;
import io.renren.modules.stock.entity.HGoodsStock;
import io.renren.modules.stock.service.HGoodsStockService;
import io.renren.modules.stock.vo.HStockFlowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import io.renren.modules.stock.dao.HStockFlowDao;
import io.renren.modules.stock.entity.HStockFlow;
import io.renren.modules.stock.service.HStockFlowService;
import org.springframework.transaction.annotation.Transactional;


@Service("hStockFlowService")
public class HStockFlowServiceImpl implements HStockFlowService {
	@Autowired
	private HStockFlowDao hStockFlowDao;

	@Autowired
	private HGoodsStockDao hGoodsStockDao;
	@Override
	public HStockFlow queryObject(Integer stockFlowId){
		return hStockFlowDao.queryObject(stockFlowId);
	}
	
	@Override
	public List<HStockFlow> queryList(Map<String, Object> map){
		return hStockFlowDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hStockFlowDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(HStockFlow hStockFlow){
		//检查是否有该物品的库存记录
		Integer count = hGoodsStockDao.queryGoodsStockExists(hStockFlow.getGoodsId());
		if (count<1){//没有库存记录则，重新插入一条 数量为零的记录
			HGoodsStock hGoodsStock = new HGoodsStock();
			hGoodsStock.setGoodsId(hStockFlow.getGoodsId());
			hGoodsStock.setQty(BigDecimal.ZERO);
            hGoodsStockDao.save(hGoodsStock);
        }
		//修改库存数量
		BigDecimal atomicQty = hStockFlow.getAtomicQty();
		hGoodsStockDao.updateQtyByStockFlow(atomicQty,hStockFlow.getGoodsId());
		hStockFlowDao.save(hStockFlow);
	}
	
	@Override
	@Transactional
	public void update(HStockFlow hStockFlow){
		//复原当前库存流动之前的 库存
		HStockFlow flow = hStockFlowDao.queryObject(hStockFlow.getStockFlowId());
		hGoodsStockDao.updateQtyByStockFlow(flow.getAtomicQty().negate(),flow.getGoodsId());
		//跟新修改后的库存
		hGoodsStockDao.updateQtyByStockFlow(hStockFlow.getAtomicQty(),hStockFlow.getGoodsId());
		hStockFlowDao.update(hStockFlow);
	}
	
	@Override
	public void delete(Integer stockFlowId){
		hStockFlowDao.delete(stockFlowId);
	}
	
	@Override
	public void deleteBatch(Integer[] stockFlowIds){
		hStockFlowDao.deleteBatch(stockFlowIds);
	}

    @Override
    public List<HStockFlowVo> queryStockFlowVoList(Map<String, Object> map) {
        return hStockFlowDao.queryStockFlowVoList(map);
    }

    @Override
    public int queryStockFlowVoTotal(Map<String, Object> map) {
        return hStockFlowDao.queryStockFlowVoTotal(map);
    }
}

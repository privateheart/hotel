package io.renren.modules.stock.service;

import io.renren.modules.stock.entity.HStockFlow;
import io.renren.modules.stock.vo.HStockFlowVo;

import java.util.List;
import java.util.Map;

/**
 * 库存流动记录表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 15:32:42
 */
public interface HStockFlowService {
	
	HStockFlow queryObject(Integer stockFlowId);
	
	List<HStockFlow> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HStockFlow hStockFlow);
	
	void update(HStockFlow hStockFlow);
	
	void delete(Integer stockFlowId);
	
	void deleteBatch(Integer[] stockFlowIds);

    /**
     * 查询 库存流动Vo
     *
     * @param map
     * @return
     */
    List<HStockFlowVo> queryStockFlowVoList(Map<String, Object> map);

    /**
     * 查询 库存流动总条数
     *
     * @param map
     * @return
     */
    int queryStockFlowVoTotal(Map<String, Object> map);
}

package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HStockFlow;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存流动记录表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 15:32:42
 */
@Mapper
public interface HStockFlowDao extends BaseDao<HStockFlow> {
	
}

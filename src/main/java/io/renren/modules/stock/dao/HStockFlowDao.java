package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HStockFlow;
import io.renren.modules.stock.vo.HStockFlowVo;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 库存流动记录表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 15:32:42
 */
@Mapper
public interface HStockFlowDao extends BaseDao<HStockFlow> {
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

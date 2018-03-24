package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HGoodsStock;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 库存表
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 09:28:49
 */
@Mapper
public interface HGoodsStockDao extends BaseDao<HGoodsStock> {

}

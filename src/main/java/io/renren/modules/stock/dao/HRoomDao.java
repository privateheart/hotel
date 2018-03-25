package io.renren.modules.stock.dao;

import io.renren.modules.stock.entity.HRoom;
import io.renren.modules.stock.vo.HRoomVo;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 厅房表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-07 19:49:15
 */
@Mapper
public interface HRoomDao extends BaseDao<HRoom> {

    List<HRoomVo> queryHRoomVoList(Map<String,Object> map);

    int queryHRoomVoTotal(Map<String,Object> map);

    /**
     * 查询所有的 厅房
     * @return
     */
    List<HRoomVo> queryAllRoomVoList();
}

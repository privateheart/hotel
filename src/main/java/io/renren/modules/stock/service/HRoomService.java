package io.renren.modules.stock.service;

import io.renren.modules.stock.entity.HRoom;
import io.renren.modules.stock.vo.HRoomVo;

import java.util.List;
import java.util.Map;

/**
 * 厅房表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-07 19:49:15
 */
public interface HRoomService {
	
	HRoom queryObject(Integer roomId);
	
	List<HRoom> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HRoom hRoom);
	
	void update(HRoom hRoom);
	
	void delete(Integer roomId);
	
	void deleteBatch(Integer[] roomIds);

	List<HRoomVo> queryHRoomVoList(Map<String,Object> map);

	int queryHRoomVoTotal(Map<String,Object> map);
}

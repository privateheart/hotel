package io.renren.modules.stock.service.impl;

import io.renren.modules.stock.vo.HRoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.stock.dao.HRoomDao;
import io.renren.modules.stock.entity.HRoom;
import io.renren.modules.stock.service.HRoomService;



@Service("hRoomService")
public class HRoomServiceImpl implements HRoomService {
	@Autowired
	private HRoomDao hRoomDao;
	
	@Override
	public HRoom queryObject(Integer roomId){
		return hRoomDao.queryObject(roomId);
	}
	
	@Override
	public List<HRoom> queryList(Map<String, Object> map){
		return hRoomDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hRoomDao.queryTotal(map);
	}
	
	@Override
	public void save(HRoom hRoom){
		hRoomDao.save(hRoom);
	}
	
	@Override
	public void update(HRoom hRoom){
		hRoomDao.update(hRoom);
	}
	
	@Override
	public void delete(Integer roomId){
		hRoomDao.delete(roomId);
	}
	
	@Override
	public void deleteBatch(Integer[] roomIds){
		hRoomDao.deleteBatch(roomIds);
	}

	@Override
	public List<HRoomVo> queryHRoomVoList(Map<String, Object> map) {
		return hRoomDao.queryHRoomVoList(map);
	}

	@Override
	public int queryHRoomVoTotal(Map<String, Object> map) {
		return hRoomDao.queryHRoomVoTotal(map);
	}

	@Override
	public List<HRoomVo> queryAllRoomVoList() {
		return hRoomDao.queryAllRoomVoList();
	}
}

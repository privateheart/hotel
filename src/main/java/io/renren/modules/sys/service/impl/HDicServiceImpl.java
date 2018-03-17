package io.renren.modules.sys.service.impl;

import io.renren.modules.sys.vo.HDicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.sys.dao.HDicDao;
import io.renren.modules.sys.entity.HDic;
import io.renren.modules.sys.service.HDicService;



@Service("hDicService")
public class HDicServiceImpl implements HDicService {
	@Autowired
	private HDicDao hDicDao;
	
	@Override
	public HDic queryObject(Integer dicId){
		return hDicDao.queryObject(dicId);
	}
	
	@Override
	public List<HDic> queryList(Map<String, Object> map){
		return hDicDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hDicDao.queryTotal(map);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void save(HDic hDic){
		hDicDao.save(hDic);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void update(HDic hDic){
		hDicDao.update(hDic);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void delete(Integer dicId){
		hDicDao.delete(dicId);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void deleteBatch(Integer[] dicIds){
		hDicDao.deleteBatch(dicIds);
	}

	@Override
	public List<HDicVo> queryHDicVoList(Map<String, Object> map) {
		return hDicDao.queryHDicVoList(map);
	}

	@Override
	@Cacheable(value = "hDicVos")
	public List<HDicVo> queryAllDicVos() {
		return hDicDao.queryAllDicVos();
	}
}

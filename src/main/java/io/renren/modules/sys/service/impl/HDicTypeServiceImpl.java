package io.renren.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.sys.dao.HDicTypeDao;
import io.renren.modules.sys.entity.HDicType;
import io.renren.modules.sys.service.HDicTypeService;



@Service("hDicTypeService")
public class HDicTypeServiceImpl implements HDicTypeService {
	@Autowired
	private HDicTypeDao hDicTypeDao;
	
	@Override
	public HDicType queryObject(Integer dicTypeId){
		return hDicTypeDao.queryObject(dicTypeId);
	}
	
	@Override
	public List<HDicType> queryList(Map<String, Object> map){
		return hDicTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hDicTypeDao.queryTotal(map);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void save(HDicType hDicType){
		hDicTypeDao.save(hDicType);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void update(HDicType hDicType){
		hDicTypeDao.update(hDicType);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void delete(Integer dicTypeId){
		hDicTypeDao.delete(dicTypeId);
	}
	
	@Override
	@CacheEvict(value="HDickTypes", allEntries=true)
	public void deleteBatch(Integer[] dicTypeIds){
		hDicTypeDao.deleteBatch(dicTypeIds);
	}

	@Cacheable(value = "HDickTypes")
	public List<HDicType> queryAll(){
		return hDicTypeDao.queryAll();
	}
}

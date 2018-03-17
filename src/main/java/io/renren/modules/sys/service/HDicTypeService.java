package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.HDicType;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-02-25 15:32:17
 */
public interface HDicTypeService {
	
	HDicType queryObject(Integer dicTypeId);
	
	List<HDicType> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HDicType hDicType);
	
	void update(HDicType hDicType);
	
	void delete(Integer dicTypeId);
	
	void deleteBatch(Integer[] dicTypeIds);

	public List<HDicType> queryAll();
}

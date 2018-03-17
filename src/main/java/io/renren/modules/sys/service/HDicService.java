package io.renren.modules.sys.service;

import io.renren.modules.sys.entity.HDic;
import io.renren.modules.sys.vo.HDicVo;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-02-25 15:32:17
 */
public interface HDicService {
	
	HDic queryObject(Integer dicId);
	
	List<HDic> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HDic hDic);
	
	void update(HDic hDic);
	
	void delete(Integer dicId);
	
	void deleteBatch(Integer[] dicIds);

	List<HDicVo> queryHDicVoList(Map<String, Object> map);

	List<HDicVo> queryAllDicVos();
}

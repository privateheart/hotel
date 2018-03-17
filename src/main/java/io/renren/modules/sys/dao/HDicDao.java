package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.HDic;
import io.renren.modules.sys.dao.BaseDao;
import io.renren.modules.sys.vo.HDicVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-02-25 15:32:17
 */
@Mapper
public interface HDicDao extends BaseDao<HDic> {

    List<HDicVo> queryHDicVoList(Map<String, Object> map);

    List<HDicVo> queryAllDicVos();
}

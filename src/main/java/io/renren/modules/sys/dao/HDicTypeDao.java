package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.HDicType;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-02-25 15:32:17
 */
@Mapper
public interface HDicTypeDao extends BaseDao<HDicType> {
    public List<HDicType> queryAll();
}

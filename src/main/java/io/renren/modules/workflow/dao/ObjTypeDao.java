package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.FlowTypeObj;
import io.renren.modules.workflow.entity.ObjType;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface ObjTypeDao {
    @Insert("INSERT INTO util_wf_objtype(OBJTYPE,SYSCODE,DESCRIPTION,UPDATEDBY,UPDATEDWHEN) values(#{objType},#{syscode},#{description},#{isActive},#{updatedBy},#{updatedWhen}) ")
    void saveObjType(ObjType objType);

    @Delete("DELETE FROM util_wf_objtype where OBJTYPE=#{objType} ")
    int removeObjType(String  objType);

    @Update("UPDATE util_wf_objtype set SYSCODE=#{syscode},DESCRIPTION=#{description},UPDATEDBY=#{updatedBy},UPDATEDWHEN=#{updatedWhen} WHERE OBJTYPE=#{objType}")
    int updateObjType(ObjType objType);

    @Select("SELECT OBJTYPE,SYSCODE,DESCRIPTION,UPDATEDBY,UPDATEDWHEN from util_wf_objtype WHERE FLOWTYPEOBJID=#{objType}")
    ObjType getObjType(String objType);

    @Select("SELECT OBJTYPE,SYSCODE,DESCRIPTION,UPDATEDBY,UPDATEDWHEN from util_wf_objtype")
    List<FlowTypeObj> listFlowTypeObj();
}

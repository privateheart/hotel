package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.FlowTypeObj;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface FlowTypeObjDao {
    @Insert("INSERT INTO util_wf_flowtypeobj(TYPEID,OBJTYPE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN) values(#{typeId},#{objType},#{description},#{isActive},#{updatedBy},#{updatedWhen}) ")
    void saveFlowTypeObj(FlowTypeObj flowTypeObj);

    @Delete("DELETE FROM util_wf_flowtypeobj WHERE FLOWTYPEOBJID=#{flowTypeObjID} ")
    int removeFlowTypeObj(long flowTypeObjID);

    @Update("UPDATE util_wf_flowtypeobj set TYPEID=#{typeId},OBJTYPE=#{objType},ISACTIVE=#{isActive},DESCRIPTION=#{description},UPDATEDBY=#{updatedBy},UPDATEDWHEN=#{updatedWhen} WHERE flowtypeobjid=#{flowTypeObjID}")
    int updateFlowTypeObj(FlowTypeObj flowTypeObj);

    @Select("SELECT FLOWTYPEOBJID,TYPEID,OBJTYPE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN from util_wf_flowtypeobj WHERE FLOWTYPEOBJID=#{flowTypeObjID}")
    FlowTypeObj getFlowTypeObj(long flowTypeObjID);

    @Select("SELECT FLOWTYPEOBJID,TYPEID,OBJTYPE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN from util_wf_flowtypeobj")
    List<FlowTypeObj> listFlowTypeObj();

    @Select("SELECT FLOWTYPEOBJID,TYPEID,OBJTYPE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN from util_wf_flowtypeobj WHERE OBJTYPE = #{objType} and t.isActive = 1 ")
    List<FlowTypeObj> listFlowTypeObjByObjType(String objType);
}

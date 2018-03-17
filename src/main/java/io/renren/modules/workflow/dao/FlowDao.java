package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.Flow;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/29.
 */
@Mapper
public interface FlowDao{

    @Insert("insert into util_wf_flow(FLOWNAME,TYPEID,TYPECODE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN,REPLACEDBY,ISREAPPLY) " +
            "values(#{flowName},#{typeId},#{typeCode},#{description},#{isActive},#{updatedBy},#{updatedWhen},#{replacedBy},#{isReApply})")
    void saveFlow(Flow flow);

    @Delete("delete from util_wf_flow where FLOWID=#{flowId}")
    int removeFlow(Long flowId);

    @Update("update util_wf_flow set FLOWNAME=#{flowName},TYPEID=#{typeId},TYPECODE=#{typeCode},DESCRIPTION=#{description},UPDATEDBY=#{updatedBy}," +
            "UPDATEDWHEN=#{updatedWhen},ISACTIVE=#{isActive},REPLACEDBY=#{replacedBy},ISREAPPLY=#{isReApply} where FLOWID=#{flowId}")
    int updateFlow(Flow flow);

    @Select("SELECT FLOWNAME,TYPEID,TYPECODE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN,REPLACEDBY,ISREAPPLY FROM util_wf_flow where FLOWID=#{flowId}")
    Flow getFlowById(Long flowId);

    @Select("SELECT FLOWNAME,TYPEID,TYPECODE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN,REPLACEDBY,ISREAPPLY FROM util_wf_flow")
    List<Flow> listFlow();

    @Select("SELECT FLOWNAME,TYPEID,TYPECODE,DESCRIPTION,ISACTIVE,UPDATEDBY,UPDATEDWHEN,REPLACEDBY,ISREAPPLY FROM util_wf_flow WHERE  TYPEID = #{typeId} and ISACTIVE = 1")
    List<Flow> listFlowByTypeId(long typeId);

}

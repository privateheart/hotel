package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.FlowRoleAction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface FlowRoleActionDao {

    @Insert("INSERT INTO util_wf_flowroleaction(FLOWID,NODEID,ROLE,ACTIONID,DESCRIPTION,UPDATEDBY,UPDATEDWHEN) VALUES(#{flowId},#{nodeId},#{role},#{actionId},#{description},#{updatedBy},#{updatedWhen}) ")
    void saveFlowRoleAction(FlowRoleAction flowRoleAction);

    @Delete("DELETE FROM util_wf_flowroleaction WHERE ROLEACTIONID=#{roleActionId} ")
    int removeFlowRoleAction(long roleActionId);

    @Update("UPDATE util_wf_flowroleaction SET FLOWID=#{flowId},NODEID=#{nodeId},ROLE=#{role},ACTIONID=#{actionId},DESCRIPTION=#{description},UPDATEDBY=#{updatedBy},UPDATEDWHEN=#{updatedWhen} WHERE ROLEACTIONID=#{roleActionId}")
    int updateFlowRoleAction(FlowRoleAction flowRoleAction);

    @Select("SELECT ROLEACTIONID,FLOWID,NODEID,ROLE,ACTIONID,DESCRIPTION,UPDATEDBY,UPDATEDWHEN FROM util_wf_flowroleaction WHERE ROLEACTIONID=#{roleActionId}")
    FlowRoleAction getRoleAction(long roleActionId);

    @Select("SELECT ROLEACTIONID,FLOWID,NODEID,ROLE,ACTIONID,DESCRIPTION,UPDATEDBY,UPDATEDWHEN FROM util_wf_flowroleaction")
    List<FlowRoleAction> listFlowRoleAction();

    @Select("SELECT ROLEACTIONID,FLOWID,NODEID,ROLE,ACTIONID,DESCRIPTION,UPDATEDBY,UPDATEDWHEN FROM util_wf_flowroleaction WHERE nodeId = #{nodeId} ")
    List<FlowRoleAction> listFlowRoleActionByNodeId(long nodeId);

    @Select("SELECT ra.ROLEACTIONID,ra.FLOWID,ra.NODEID,ra.ROLE,ra.ACTIONID,ra.DESCRIPTION,ra.UPDATEDBY,ra.UPDATEDWHEN FROM util_wf_flowroleaction ra,util_wf_flowaction fa  where ra.nodeId = #{nodeId} and fa.ACTIONID =ra.ACTIONID and fa.toNodeId <> #{nodeId}")
    List<FlowRoleAction> listFlowRoleActionByNodeIdAndNodeId(long nodeId);
}

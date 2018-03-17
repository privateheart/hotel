package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.FlowNode;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface FlowNodeDao {

    @Insert("INSERT INTO util_wf_flownode(FLOWDID,NODENAME,NODETYPE,ISFIRSTNODE,ISLASTNODE,UPDATEDBY,UPDATEDWHEN) VALUES(#{flowId},#{nodeName},#{nodeType},#{isFirstNode},#{isLastNode},#{updatedBy},#{updatedWhen})")
    void saveFlowNode(FlowNode flowNode);

    @Update("UPDATE util_wf_flownode SET FLOWDID=#{flowId},NODENAME=#{nodeName},NODETYPE=#{nodeType},ISFIRSTNODE=#{isFirstNode},ISLASTNODE=#{isLastNode},UPDATEDBY=#{updatedBy},UPDATEDWHEN=#{updatedWhen} WHERE NODEID=#{nodeId}")
    int updateFlowNode(FlowNode flowNode);

    @Delete("DELETE FROM util_wf_flownode WHERE NODEID=#{nodeId}")
    int removeFlowNode(long nodeId);

    @Select("SELECT NODEID,FLOWDID,NODENAME,NODETYPE,ISFIRSTNODE,ISLASTNODE,UPDATEDBY,UPDATEDWHEN FROM util_wf_flownode WHERE NODEID=#{nodeId}")
    FlowNode getFlowNode(long nodeId);

    @Select("SELECT NODEID,FLOWDID,NODENAME,NODETYPE,ISFIRSTNODE,ISLASTNODE,UPDATEDBY,UPDATEDWHEN FROM util_wf_flownode")
    List<FlowNode> listFlowNode();


}

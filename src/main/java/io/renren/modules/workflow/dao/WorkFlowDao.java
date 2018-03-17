package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.FlowAction;
import io.renren.modules.workflow.entity.WfLog;
import io.renren.modules.workflow.entity.WorkFlow;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface WorkFlowDao {
    @Insert("INSERT INTO util_wf_workflow(FLOWID,OBJTYPE,OBJID,WFLOGID,ISREPLACED,REPLACEDBYWFID,FROMOPERATORID,FROMOPERATORNAME,FROMOPERATORORG,FROMOPERATORPOS,PREACITONID,PREACTIONNAME,PREACTIONTYPE,PREACTIONNOTES,PRECOMMITTIME,NODEID,NODENAME,NODETYPE,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,HAVEMULTIOPERATOR,LIMITDATE) " +
            " values(#{flowID},#{objType},#{objID},#{wfLogID},#{isReplaced},#{replacedByWFID},#{fromOperatorID},#{fromOperatorName},#{fromOperatorOrg},#{fromOperatorPos},#{preAcitonID},#{preActionName},#{preActionType},#{preActionNotes},#{preCommitTime},#{nodeID},#{nodeName},#{nodeType},#{operatorID},#{operatorName},#{operatorOrg},#{operatorPos},#{haveMultiOperator},#{limitDate})")
    void saveWorkFlow(WorkFlow workFlow);

    @Update("UPDATE util_wf_workflow SET FLOWID=#{flowID},OBJTYPE=#{objType},OBJID=#{objID},WFLOGID=#{wfLogID},ISREPLACED=#{isReplaced},REPLACEDBYWFID=#{replacedByWFID},FROMOPERATORID=#{fromOperatorID},FROMOPERATORNAME=#{fromOperatorName},FROMOPERATORORG=#{fromOperatorOrg},FROMOPERATORPOS=#{fromOperatorPos},PREACITONID=#{preAcitonID},PREACTIONNAME=#{preActionName},PREACTIONTYPE=#{preActionType}," +
            " PREACTIONNOTES=#{preActionNotes},PRECOMMITTIME=#{preCommitTime},NODEID=#{nodeID},NODENAME=#{nodeName},NODETYPE=#{nodeType},OPERATORID=#{operatorID},OPERATORNAME=#{operatorName},OPERATORORG=#{operatorOrg},OPERATORPOS=#{operatorPos},HAVEMULTIOPERATOR=#{haveMultiOperator},LIMITDATE=#{limitDate} WHERE WFID=#{wfId}")
    int updateWorkFlow(WorkFlow workFlow);

    @Delete("DELETE FROM util_wf_workflow WHERE WFID=#{wfId}")
    int removeWorkFlow(long wfId);

    @Select("SELECT WFID,FLOWID,OBJTYPE,OBJID,WFLOGID,ISREPLACED,REPLACEDBYWFID,FROMOPERATORID,FROMOPERATORNAME,FROMOPERATORORG,FROMOPERATORPOS,PREACITONID,PREACTIONNAME,PREACTIONTYPE,PREACTIONNOTES,PRECOMMITTIME,NODEID,NODENAME,NODETYPE,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,HAVEMULTIOPERATOR,LIMITDATE FROM util_wf_workflow WHERE WFID=#{wfId}")
    WorkFlow getWorkFlow(long wfId);

    @Select("SELECT WFID,FLOWID,OBJTYPE,OBJID,WFLOGID,ISREPLACED,REPLACEDBYWFID,FROMOPERATORID,FROMOPERATORNAME,FROMOPERATORORG,FROMOPERATORPOS,PREACITONID,PREACTIONNAME,PREACTIONTYPE,PREACTIONNOTES,PRECOMMITTIME,NODEID,NODENAME,NODETYPE,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,HAVEMULTIOPERATOR,LIMITDATE FROM util_wf_workflow")
    List<WorkFlow> listWorkFlow();

    @Select("SELECT WFID,FLOWID,OBJTYPE,OBJID,WFLOGID,ISREPLACED,REPLACEDBYWFID,FROMOPERATORID,FROMOPERATORNAME,FROMOPERATORORG,FROMOPERATORPOS,PREACITONID,PREACTIONNAME,PREACTIONTYPE,PREACTIONNOTES,PRECOMMITTIME,NODEID,NODENAME,NODETYPE,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,HAVEMULTIOPERATOR,LIMITDATE FROM util_wf_workflow wf where wf.OBJID = #{objId} and wf.OBJTYPE = #{objType}")
    List<WorkFlow> listWorkFlowByObjIdAndObjType(long objId,String objType);

    @Select("select wf.wfid from util_wf_workflow wf left join util_wf_flownode n on n.nodeid = wf.nodeid where wf.objtype = #{objType} and wf.objid = #{objId} and n.islastnode = 0")
    List listwfidByObjIdAndObjType(long objId,String objType);

    @Select("select t.wftaskid from util_wf_wftask t where t.wflogcorpid is not null and t.iscommit = 0 and  t.wflogid = #{wfLogID} ")
    List listwftaskidBywflogid(long wfLogID);

    @Select("select log from WfLog log,FlowAction action where log.preAcitonID = action.actionId and action.actionType='MAINACTION' and action.toNodeId=#{nodeId} and log.wfId=#{wfId} order by log.wfLogID desc")
    List<WfLog> listLog(long nodeId, long wfId);

    @Select("select action from WfLog log,FlowAction action where log.preAcitonID = action.actionId and action.actionType='MAINACTION' and action.toNodeId=#{nodeId} and log.wfId=#{wfId} order by log.wfLogID desc")
    List<FlowAction> listAction(long nodeId, long wfId);

    @Select("select um.usergroup from util_wf_usergroupmember um join util_wf_usergroup zu1 on zu1.usergroup = um.usergroup where um.username = #{username} and zu1.catalog = #{catalog}")
    List getUserRoleBySytem(String username,String catalog);

    @Select("select um.usergroup from util_wf_usergroupmember um join util_wf_usergroup zu1 on zu1.usergroup = um.usergroup where um.username = #{username} and zu1.catalog = #{catalog} and zu1.usergroup = #{rolename}")
    List getUserHasRole(String username,String catalog,String rolename);

    @Select("SELECT * FROM (SELECT DISTINCT hu.username, hu.namech, zgm.usergroup, ug.description,hu.id EMPID FROM util_wf_usergroupmember zgm LEFT JOIN aled_user hu ON zgm.username = hu.username LEFT JOIN util_wf_usergroup ug ON ug.usergroup = zgm.usergroup WHERE trim(zgm.usergroup) = #{role} ) t WHERE t.username IS NOT NULL ORDER BY t.username DESC")
    List getRoleUserMember(String role);

}

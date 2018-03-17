package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.FlowAction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface FlowActionDao {

    @Insert("INSERT INTO util_wf_flowaction(FLOWID,NODEID,ACTIONNAME,ACTIONTYPE,DESCRIPTION,TONODEID,CANDRAWBACK,CANMULTIOPERATOR,MULTIOPERATORTYPE,TIMELIMIT,HAVEBOXMSG,HAVEMOBILEMSG,UPDATEDBY,UPDATEDWHEN,DECIDESTR,DECIDEVALUE) " +
            " values(#{flowId},#{nodeId},#{actionName},#{actionType},#{description},#{toNodeId},#{canDrawBack},#{canMultiOperator},#{multiOperatorType},#{timeLimit},#{haveBoxMsg},#{haveMobileMsg},#{updatedBy},#{updatedWhen},#{decideStr},#{decideValue})")
    void saveFlowAction(FlowAction flowAction);

    @Select("SELECT ACTIONID,FLOWID,NODEID,ACTIONNAME,ACTIONTYPE,DESCRIPTION,TONODEID,CANDRAWBACK,CANMULTIOPERATOR,MULTIOPERATORTYPE,TIMELIMIT,HAVEBOXMSG,HAVEMOBILEMSG,UPDATEDBY,UPDATEDWHEN,DECIDESTR,DECIDEVALUE from util_wf_flowaction WHERE ACTIONID=#{actionId}")
    FlowAction getFlowActionById(long actionId);

    @Select("SELECT ACTIONID,FLOWID,NODEID,ACTIONNAME,ACTIONTYPE,DESCRIPTION,TONODEID,CANDRAWBACK,CANMULTIOPERATOR,MULTIOPERATORTYPE,TIMELIMIT,HAVEBOXMSG,HAVEMOBILEMSG,UPDATEDBY,UPDATEDWHEN,DECIDESTR,DECIDEVALUE from util_wf_flowaction ")
    List<FlowAction> listFlowAction();

    @Update("UPDATE util_wf_flowaction SET FLOWID=#{flowId},NODEID=#{nodeId},ACTIONNAME=#{actionName},ACTIONTYPE=#{actionType},DESCRIPTION=#{description},TONODEID=#{toNodeId}," +
            "CANDRAWBACK=#{canDrawBack},CANMULTIOPERATOR=#{canMultiOperator},MULTIOPERATORTYPE=#{multiOperatorType},TIMELIMIT=#{timeLimit},HAVEBOXMSG=#{haveBoxMsg},HAVEMOBILEMSG=#{haveMobileMsg}," +
            "UPDATEDBY=#{updatedBy},UPDATEDWHEN=#{updatedWhen},DECIDESTR=#{decideStr},DECIDEVALUE=#{decideValue} WHERE ACTIONID=#{actionId}")
    int updateFlowAction(FlowAction flowAction);

    @Delete("DELETE FROM util_wf_flowaction WHERE ACTIONID=#{actionId}")
    int removeFlowAction(long actionId);

    @Select("SELECT ACTIONID,FLOWID,NODEID,ACTIONNAME,ACTIONTYPE,DESCRIPTION,TONODEID,CANDRAWBACK,CANMULTIOPERATOR,MULTIOPERATORTYPE,TIMELIMIT,HAVEBOXMSG,HAVEMOBILEMSG,UPDATEDBY,UPDATEDWHEN,DECIDESTR,DECIDEVALUE from util_wf_flowaction WHERE NODEID=#{nodeId}")
    List<FlowAction>  listFlowActionByNodeId(long nodeId);

    @Select("select distinct ac.decideStr from util_wf_flowaction ac where ac.decideStr is not null and ac.nodeId =#{nodeId}")
    List<String> listDecideStrBynodeId(long nodeId);

    @Select("select t.actionid from util_wf_flowaction t where t.nodeid is null and t.flowid =#{flowId}")
    List listActionIdByFlowId(long flowId);

    @Select("select ACTIONID,FLOWID,NODEID,ACTIONNAME,ACTIONTYPE,DESCRIPTION,TONODEID,CANDRAWBACK,CANMULTIOPERATOR,MULTIOPERATORTYPE,TIMELIMIT,HAVEBOXMSG,HAVEMOBILEMSG,UPDATEDBY,UPDATEDWHEN,DECIDESTR,DECIDEVALUE from util_wf_flowaction t where t.nodeid is null and t.flowid =#{flowId}")
    List listFlowActionIdByFlowId(long flowId);

}


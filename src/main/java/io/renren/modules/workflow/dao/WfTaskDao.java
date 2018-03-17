package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.WfTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface WfTaskDao {
    @Insert("INSERT INTO util_wf_wftask(WFID,WFLOGID,WFLOGCORPID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISCORPOPERATOR,ISCOMMIT,ISHANDLED,COMMITTIME,MSGSTATUS) " +
            " values(#{wfID},#{wfLogID},#{wfLogCorpID},#{operatorID},#{operatorName},#{operatorOrg},#{operatorPos},#{isCorpOperator},#{isCommit},#{isHandled},#{commitTime},#{msgstatus})")
    void saveWfTask(WfTask wfTask);

    @Update("UPDATE util_wf_wftask SET WFID=#{wfID},WFLOGID=#{wfLogID},WFLOGCORPID=#{wfLogCorpID},OPERATORID=#{operatorID},OPERATORNAME=#{operatorName},OPERATORORG=#{operatorOrg},OPERATORPOS=#{operatorPos}," +
            "ISCORPOPERATOR=#{isCorpOperator},ISCOMMIT=#{isCommit},ISHANDLED=#{isHandled},COMMITTIME=#{commitTime},MSGSTATUS=#{msgstatus} WHERE WFTASKID= #{wfTaskID}")
    int updateWfTask(WfTask wfTask);

    @Delete("DELETE FROM util_wf_wftask WHERE WFTASKID= #{wfTaskID}")
    int removeWfTask(long wfTaskID);

    @Select("select WFTASKID,WFID,WFLOGID,WFLOGCORPID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISCORPOPERATOR,ISCOMMIT,ISHANDLED,COMMITTIME,MSGSTATUS from util_wf_wftask WHERE WFTASKID= #{wfTaskID}")
    WfTask getWfTask(long wfTaskID);

    @Select("select WFTASKID,WFID,WFLOGID,WFLOGCORPID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISCORPOPERATOR,ISCOMMIT,ISHANDLED,COMMITTIME,MSGSTATUS from util_wf_wftask WHERE WFID= #{wfID}")
    WfTask getWfTaskByWfID(long wfID);

    @Select("select WFTASKID,WFID,WFLOGID,WFLOGCORPID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISCORPOPERATOR,ISCOMMIT,ISHANDLED,COMMITTIME,MSGSTATUS from util_wf_wftask ")
    List<WfTask> listWfTask();

    @Select("SELECT  WFTASKID,WFID,WFLOGID,WFLOGCORPID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISCORPOPERATOR,ISCOMMIT,ISHANDLED,COMMITTIME,MSGSTATUS from util_wf_wftask wt where wt.wfLogID = #{wfLogID} and wt.isCorpOperator = 0 and wt.wfLogCorpID is null")
    List<WfTask> listWfTaskBywfLogID(long wflogId);

    @Update("update util_wf_wftask t set t.iscommit = 1,t.committime = sysdate where t.iscommit = 0 and t.wflogcorpid is not null and t.iscorpoperator <> 0 and t.wflogid = #{wflogid}")
    void updateWfTaskByWflogid(long wflogid);

    @Select(" select WFTASKID,WFID,WFLOGID,WFLOGCORPID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISCORPOPERATOR,ISCOMMIT,ISHANDLED,COMMITTIME,MSGSTATUS from util_wf_wftask task where task.isCommit = 0 and task.wfLogCorpID is not null and task.wfLogID =#{wflogId}")
    List<WfTask> listWfTaskByWfLogId(long wflogId);
}

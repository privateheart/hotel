package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.WfLogCorp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface WfLogCorpDao {

    @Insert("INSERT INTO util_wf_wflogcorp(WFLOGID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISACTIVE,COMMITTYPE,COMMITNOTES,COMMITTIME,PREWFLOGCORPID) " +
            " values(#{wfLogID},#{operatorID},#{operatorName},#{operatorOrg},#{operatorPos},#{isActive},#{commitType},#{commitNotes},#{commitTime},#{preWfLogCorpID})")
    void saveWfLogCorp(WfLogCorp wfLogCorp);

    @Delete("DELETE FROM util_wf_wflogcorp WHERE WFLOGCORPID=#{wfLogCorpID}")
    int removeWfLogCorp(long wfLogCorpID);

    @Update("UPDATE util_wf_wflogcorp SET WFLOGID=#{wfLogID},OPERATORID=#{operatorID},OPERATORNAME=#{operatorName},OPERATORORG=#{operatorOrg},OPERATORPOS=#{operatorPos},ISACTIVE=#{isActive},COMMITTYPE=#{commitType}," +
            "COMMITNOTES=#{commitNotes},COMMITTIME=#{commitTime},PREWFLOGCORPID=#{preWfLogCorpID} WHERE WFLOGCORPID=#{wfLogCorpID}")
    int updateWfLogCorp(WfLogCorp wfLogCorp);

    @Select("SELECT WFLOGCORPID,WFLOGID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISACTIVE,COMMITTYPE,COMMITNOTES,COMMITTIME,PREWFLOGCORPID FROM util_wf_wflogcorp WHERE WFLOGCORPID=#{wfLogCorpID}")
    WfLogCorp getWfLogCorp(long wfLogCorpID);

    @Select("SELECT WFLOGCORPID,WFLOGID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISACTIVE,COMMITTYPE,COMMITNOTES,COMMITTIME,PREWFLOGCORPID FROM util_wf_wflogcorp ")
    List<WfLogCorp> listWfLogCorp();

    @Select("SELECT WFLOGCORPID,WFLOGID,OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS,ISACTIVE,COMMITTYPE,COMMITNOTES,COMMITTIME,PREWFLOGCORPID FROM util_wf_wflogcorp WHERE WFLOGID=#{wfLogID}")
    List<WfLogCorp> listWfLogCorpBywfLogID(long wfLogID);

    @Update("update util_wf_wflogcorp t set t.committype = 'SUBMIT',t.commitnotes = #{comimsg},t.committime = sysdate() where t.isactive = 1 and t.wflogid = #{wflogid}")
    void updateWfLogCorpByWflogid(long wflogid);
}

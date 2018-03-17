package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.OperatorInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface OperatorInfoDao {

    @Insert("INSERT INTO util_wf_operatorinfo(OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS) VALUES(#{operatorId},#{operatorName},#{operatorOrg},#{operatorPos})")
    void saveOperatorInfo(OperatorInfo operatorInfo);

    @Update("UPDATE util_wf_operatorinfo SET OPERATORNAME=#{operatorName},OPERATORORG=#{operatorOrg},OPERATORPOS=#{operatorPos} WHERE OPERATORID=#{operatorId}")
    int updateOperatorInfo(OperatorInfo operatorInfo);

    @Delete("DELETE FROM util_wf_operatorinfo WHERE OPERATORID=#{operatorId}")
    int removeOperatorInfo(String operatorId);

    @Select("SELECT OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS FROM util_wf_operatorinfo WHERE OPERATORID=#{operatorId}")
    OperatorInfo getOperatorInfoByoperatorID(String operatorId);

    @Select("SELECT OPERATORID,OPERATORNAME,OPERATORORG,OPERATORPOS FROM util_wf_operatorinfo")
    List<OperatorInfo> listOperatorInfoList();
}

package io.renren.modules.workflow.dao;

import io.renren.modules.workflow.entity.WfLogRefFile;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by szj_pc on 2017/8/31.
 */
@Mapper
public interface WfLogRefFileDao {

    @Insert("INSERT INTO util_wf_wflogreffile(WFLOGID,FILENAME,UPLOADFILENAME,DESCRIPTION,URL,UPLOADBY,UPLOADWHEN,RENAMEBY,RENAMEWHEN,ISDELETED,DELETEDBY,DELETEDWHEN) " +
            " values(#{wfLogID},#{fileName},#{upLoadFileName},#{description},#{url},#{upLoadBy},#{upLoadWhen},#{reNameBy},#{reNameWhen},#{isDeleted},#{deletedBy},#{deletedWhen})")
    void saveWfLogRefFile(WfLogRefFile wfLogRefFile);

    @Update("UPDATE util_wf_wflogreffile set WFLOGID=#{wfLogID},FILENAME=#{fileName},UPLOADFILENAME=#{upLoadFileName},DESCRIPTION=#{description},URL=#{url},UPLOADBY=#{upLoadBy},UPLOADWHEN=#{upLoadWhen},RENAMEBY=#{reNameBy},RENAMEWHEN=#{reNameWhen},ISDELETED=#{isDeleted},DELETEDBY=#{deletedBy},DELETEDWHEN=#{deletedWhen} WHERE WFLOGREFFILEID=#{wfLogRefFileID}")
    int updateWfLogRefFile(WfLogRefFile wfLogRefFile);

    @Delete("DELETE FROM util_wf_wflogreffile WHERE WFLOGREFFILEID=#{wfLogRefFileID}")
    int removeWfLogRefFile(long wfLogRefFileID);

    @Select("SELECT WFLOGREFFILEID,WFLOGID,FILENAME,UPLOADFILENAME,DESCRIPTION,URL,UPLOADBY,UPLOADWHEN,RENAMEBY,RENAMEWHEN,ISDELETED,DELETEDBY,DELETEDWHEN FROM util_wf_wflogreffile WHERE WFLOGREFFILEID=#{wfLogRefFileID}")
    WfLogRefFile getWfLogRefFile(long wfLogRefFileID);

    @Select("SELECT WFLOGREFFILEID,WFLOGID,FILENAME,UPLOADFILENAME,DESCRIPTION,URL,UPLOADBY,UPLOADWHEN,RENAMEBY,RENAMEWHEN,ISDELETED,DELETEDBY,DELETEDWHEN FROM util_wf_wflogreffile ")
    List<WfLogRefFile> listWfLogRefFile();
}

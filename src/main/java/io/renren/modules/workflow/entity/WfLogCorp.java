package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class WfLogCorp {
    private long wfLogCorpID;
    private long wfLogID;
    private String operatorOrg;
    private String operatorPos;
    private String operatorID;
    private String operatorName;
    private long isActive;
    private String commitType;
    private String commitNotes;
    private Date commitTime;
    private Long preWfLogCorpID;

    public long getWfLogCorpID() {
        return wfLogCorpID;
    }

    public void setWfLogCorpID(long wfLogCorpID) {
        this.wfLogCorpID = wfLogCorpID;
    }

    public long getWfLogID() {
        return wfLogID;
    }

    public void setWfLogID(long wfLogID) {
        this.wfLogID = wfLogID;
    }

    public String getOperatorOrg() {
        return operatorOrg;
    }

    public void setOperatorOrg(String operatorOrg) {
        this.operatorOrg = operatorOrg;
    }

    public String getOperatorPos() {
        return operatorPos;
    }

    public void setOperatorPos(String operatorPos) {
        this.operatorPos = operatorPos;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public long getIsActive() {
        return isActive;
    }

    public void setIsActive(long isActive) {
        this.isActive = isActive;
    }

    public String getCommitType() {
        return commitType;
    }

    public void setCommitType(String commitType) {
        this.commitType = commitType;
    }

    public String getCommitNotes() {
        return commitNotes;
    }

    public void setCommitNotes(String commitNotes) {
        this.commitNotes = commitNotes;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Long getPreWfLogCorpID() {
        return preWfLogCorpID;
    }

    public void setPreWfLogCorpID(Long preWfLogCorpID) {
        this.preWfLogCorpID = preWfLogCorpID;
    }
}

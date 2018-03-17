package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class WfTask {
    private long wfTaskID;
    private long wfID;
    private long wfLogID;
    private Long wfLogCorpID;
    private String operatorOrg;
    private String operatorPos;
    private String operatorID;
    private String operatorName;
    private int isCorpOperator;
    private int isCommit;
    private int isHandled;
    private Date commitTime;
    private int msgstatus;

    public long getWfTaskID() {
        return wfTaskID;
    }

    public void setWfTaskID(long wfTaskID) {
        this.wfTaskID = wfTaskID;
    }

    public long getWfID() {
        return wfID;
    }

    public void setWfID(long wfID) {
        this.wfID = wfID;
    }

    public long getWfLogID() {
        return wfLogID;
    }

    public void setWfLogID(long wfLogID) {
        this.wfLogID = wfLogID;
    }

    public Long getWfLogCorpID() {
        return wfLogCorpID;
    }

    public void setWfLogCorpID(Long wfLogCorpID) {
        this.wfLogCorpID = wfLogCorpID;
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

    public int getIsCorpOperator() {
        return isCorpOperator;
    }

    public void setIsCorpOperator(int isCorpOperator) {
        this.isCorpOperator = isCorpOperator;
    }

    public int getIsCommit() {
        return isCommit;
    }

    public void setIsCommit(int isCommit) {
        this.isCommit = isCommit;
    }

    public int getIsHandled() {
        return isHandled;
    }

    public void setIsHandled(int isHandled) {
        this.isHandled = isHandled;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public int getMsgstatus() {
        return msgstatus;
    }

    public void setMsgstatus(int msgstatus) {
        this.msgstatus = msgstatus;
    }
}

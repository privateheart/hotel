package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class WfLog {
    private long wfLogID;
    private long wfId;
    private String fromOperatorOrg;
    private String fromOperatorPos;
    private String fromOperatorID;
    private String fromOperatorName;
    private long preAcitonID;
    private String preActionName;
    private String preActionType;
    private String preActionNotes;
    private Date preCommitTime;
    private long nodeID;
    private String nodeName;
    private String nodeType;
    private String operatorOrg;
    private String operatorPos;
    private String operatorID;
    private String operatorName;
    private long haveMultiOperator;
    private Date limitDate;
    private Long preWfLogID;
    private Long nextWfLogID;
    private long isFirstWfLogID;
    private long isLastWfLogID;

    public long getWfLogID() {
        return wfLogID;
    }

    public void setWfLogID(long wfLogID) {
        this.wfLogID = wfLogID;
    }

    public long getWfId() {
        return wfId;
    }

    public void setWfId(long wfId) {
        this.wfId = wfId;
    }

    public String getFromOperatorOrg() {
        return fromOperatorOrg;
    }

    public void setFromOperatorOrg(String fromOperatorOrg) {
        this.fromOperatorOrg = fromOperatorOrg;
    }

    public String getFromOperatorPos() {
        return fromOperatorPos;
    }

    public void setFromOperatorPos(String fromOperatorPos) {
        this.fromOperatorPos = fromOperatorPos;
    }

    public String getFromOperatorID() {
        return fromOperatorID;
    }

    public void setFromOperatorID(String fromOperatorID) {
        this.fromOperatorID = fromOperatorID;
    }

    public String getFromOperatorName() {
        return fromOperatorName;
    }

    public void setFromOperatorName(String fromOperatorName) {
        this.fromOperatorName = fromOperatorName;
    }

    public long getPreAcitonID() {
        return preAcitonID;
    }

    public void setPreAcitonID(long preAcitonID) {
        this.preAcitonID = preAcitonID;
    }

    public String getPreActionName() {
        return preActionName;
    }

    public void setPreActionName(String preActionName) {
        this.preActionName = preActionName;
    }

    public String getPreActionType() {
        return preActionType;
    }

    public void setPreActionType(String preActionType) {
        this.preActionType = preActionType;
    }

    public String getPreActionNotes() {
        return preActionNotes;
    }

    public void setPreActionNotes(String preActionNotes) {
        this.preActionNotes = preActionNotes;
    }

    public Date getPreCommitTime() {
        return preCommitTime;
    }

    public void setPreCommitTime(Date preCommitTime) {
        this.preCommitTime = preCommitTime;
    }

    public long getNodeID() {
        return nodeID;
    }

    public void setNodeID(long nodeID) {
        this.nodeID = nodeID;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
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

    public long getHaveMultiOperator() {
        return haveMultiOperator;
    }

    public void setHaveMultiOperator(long haveMultiOperator) {
        this.haveMultiOperator = haveMultiOperator;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public Long getPreWfLogID() {
        return preWfLogID;
    }

    public void setPreWfLogID(Long preWfLogID) {
        this.preWfLogID = preWfLogID;
    }

    public Long getNextWfLogID() {
        return nextWfLogID;
    }

    public void setNextWfLogID(Long nextWfLogID) {
        this.nextWfLogID = nextWfLogID;
    }

    public long getIsFirstWfLogID() {
        return isFirstWfLogID;
    }

    public void setIsFirstWfLogID(long isFirstWfLogID) {
        this.isFirstWfLogID = isFirstWfLogID;
    }

    public long getIsLastWfLogID() {
        return isLastWfLogID;
    }

    public void setIsLastWfLogID(long isLastWfLogID) {
        this.isLastWfLogID = isLastWfLogID;
    }
}

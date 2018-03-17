package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class FlowAction {
    private long actionId;
    private long flowId;
    private Long nodeId;
    private String actionName;
    private String actionType;
    private String decideStr;
    private String decideValue;
    private String description;
    private long toNodeId;// end 是不是可以没有id
    private int canDrawBack;
    private int canMultiOperator;
    private String multiOperatorType;
    private Integer timeLimit;
    private Integer haveBoxMsg;
    private Integer haveMobileMsg;
    private String updatedBy;
    private Date updatedWhen;

    public FlowAction() {
        super();
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public long getFlowId() {
        return flowId;
    }

    public void setFlowId(long flowId) {
        this.flowId = flowId;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getToNodeId() {
        return toNodeId;
    }

    public void setToNodeId(long toNodeId) {
        this.toNodeId = toNodeId;
    }

    public int getCanDrawBack() {
        return canDrawBack;
    }

    public void setCanDrawBack(int canDrawBack) {
        this.canDrawBack = canDrawBack;
    }

    public int getCanMultiOperator() {
        return canMultiOperator;
    }

    public void setCanMultiOperator(int canMultiOperator) {
        this.canMultiOperator = canMultiOperator;
    }

    public String getMultiOperatorType() {
        return multiOperatorType;
    }

    public void setMultiOperatorType(String multiOperatorType) {
        this.multiOperatorType = multiOperatorType;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Date getUpdatedWhen() {
        return updatedWhen;
    }

    public void setUpdatedWhen(Date updatedWhen) {
        this.updatedWhen = updatedWhen;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getHaveBoxMsg() {
        return haveBoxMsg;
    }

    public void setHaveBoxMsg(Integer haveBoxMsg) {
        this.haveBoxMsg = haveBoxMsg;
    }

    public Integer getHaveMobileMsg() {
        return haveMobileMsg;
    }

    public void setHaveMobileMsg(Integer haveMobileMsg) {
        this.haveMobileMsg = haveMobileMsg;
    }

    public String getDecideValue() {
        return decideValue;
    }

    public void setDecideValue(String decideValue) {
        this.decideValue = decideValue;
    }

    public String getDecideStr() {
        return decideStr;
    }

    public void setDecideStr(String decideStr) {
        this.decideStr = decideStr;
    }

    @Override
    public String toString() {
        return "FlowAction{" +
                "actionId=" + actionId +
                ", flowId=" + flowId +
                ", nodeId=" + nodeId +
                ", actionName='" + actionName + '\'' +
                ", actionType='" + actionType + '\'' +
                ", decideStr='" + decideStr + '\'' +
                ", decideValue='" + decideValue + '\'' +
                ", description='" + description + '\'' +
                ", toNodeId=" + toNodeId +
                ", canDrawBack=" + canDrawBack +
                ", canMultiOperator=" + canMultiOperator +
                ", multiOperatorType='" + multiOperatorType + '\'' +
                ", timeLimit=" + timeLimit +
                ", haveBoxMsg=" + haveBoxMsg +
                ", haveMobileMsg=" + haveMobileMsg +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedWhen=" + updatedWhen +
                '}';
    }
}

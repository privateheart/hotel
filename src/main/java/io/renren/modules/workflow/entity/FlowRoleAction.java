package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class FlowRoleAction {
    private long roleActionId;
    private long flowId;
    private long nodeId;
    private String role;
    private FlowAction flowAction;
    private String description;
    private String updatedBy;
    private Date updatedWhen;

    public long getRoleActionId() {
        return roleActionId;
    }

    public void setRoleActionId(long roleActionId) {
        this.roleActionId = roleActionId;
    }

    public long getFlowId() {
        return flowId;
    }

    public void setFlowId(long flowId) {
        this.flowId = flowId;
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

   /* public FlowAction getActionId() {
        return actionId;
    }

    public void setActionId(FlowAction actionId) {
        this.actionId = actionId;
    }*/

    public FlowAction getFlowAction() {
        return flowAction;
    }

    public void setFlowAction(FlowAction flowAction) {
        this.flowAction = flowAction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedWhen() {
        return updatedWhen;
    }

    public void setUpdatedWhen(Date updatedWhen) {
        this.updatedWhen = updatedWhen;
    }

    public FlowRoleAction() {
        super();
    }
}

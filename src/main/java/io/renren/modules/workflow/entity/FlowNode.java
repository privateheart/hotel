package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class FlowNode {
    private long nodeId;
    private long flowdId;
    private String nodeName;
    private String nodeType;
    private long isFirstNode;
    private long isLastNode;
    private String updatedBy;
    private Date updatedWhen;

    public FlowNode() {
        super();
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public long getFlowdId() {
        return flowdId;
    }

    public void setFlowdId(long flowdId) {
        this.flowdId = flowdId;
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

    public long getIsFirstNode() {
        return isFirstNode;
    }

    public void setIsFirstNode(long isFirstNode) {
        this.isFirstNode = isFirstNode;
    }

    public long getIsLastNode() {
        return isLastNode;
    }

    public void setIsLastNode(long isLastNode) {
        this.isLastNode = isLastNode;
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
}

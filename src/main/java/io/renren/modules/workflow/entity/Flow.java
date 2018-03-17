package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class Flow {
    private long flowId;
    private String flowName;
    private Long typeId;
    private String typeCode;
    private String description;
    private int isActive;
    private String updatedBy;
    private Date updatedWhen;
    private Long replacedBy;
    private int isReApply;// 是否能在流程结束后提交审批

    public long getFlowId() {
        return flowId;
    }

    public void setFlowId(long flowId) {
        this.flowId = flowId;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
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

    public Long getReplacedBy() {
        return replacedBy;
    }

    public void setReplacedBy(Long replacedBy) {
        this.replacedBy = replacedBy;
    }

    public int getIsReApply() {
        return isReApply;
    }

    public void setIsReApply(int isReApply) {
        this.isReApply = isReApply;
    }

    public Flow() {
        super();
    }

    @Override
    public String toString() {
        return "Flow{" +
                "flowId=" + flowId +
                ", flowName='" + flowName + '\'' +
                ", typeId=" + typeId +
                ", typeCode='" + typeCode + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedWhen=" + updatedWhen +
                ", replacedBy=" + replacedBy +
                ", isReApply=" + isReApply +
                '}';
    }
}

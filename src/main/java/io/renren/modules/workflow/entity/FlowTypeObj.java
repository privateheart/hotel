package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class FlowTypeObj {
    private long flowTypeObjID;
    private long typeID;
    private String objType;
    private String description;
    private int isActive;
    private String updatedBy;
    private Date updatedWhen;

    public long getFlowTypeObjID() {
        return flowTypeObjID;
    }

    public void setFlowTypeObjID(long flowTypeObjID) {
        this.flowTypeObjID = flowTypeObjID;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
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

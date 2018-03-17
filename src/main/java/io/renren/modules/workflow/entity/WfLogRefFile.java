package io.renren.modules.workflow.entity;

import java.util.Date;

/**
 * Created by szj_pc on 2017/8/29.
 */
public class WfLogRefFile {
    private long wfLogRefFileID;
    private long wfLogID;
    private String fileName;
    private String upLoadFileName;
    private String description;
    private String url;
    private String upLoadBy;
    private Date upLoadWhen;
    private String reNameBy;
    private Date reNameWhen;
    private int isDeleted;
    private String deletedBy;
    private Date deletedWhen;

    public long getWfLogRefFileID() {
        return wfLogRefFileID;
    }

    public void setWfLogRefFileID(long wfLogRefFileID) {
        this.wfLogRefFileID = wfLogRefFileID;
    }

    public long getWfLogID() {
        return wfLogID;
    }

    public void setWfLogID(long wfLogID) {
        this.wfLogID = wfLogID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUpLoadFileName() {
        return upLoadFileName;
    }

    public void setUpLoadFileName(String upLoadFileName) {
        this.upLoadFileName = upLoadFileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpLoadBy() {
        return upLoadBy;
    }

    public void setUpLoadBy(String upLoadBy) {
        this.upLoadBy = upLoadBy;
    }

    public Date getUpLoadWhen() {
        return upLoadWhen;
    }

    public void setUpLoadWhen(Date upLoadWhen) {
        this.upLoadWhen = upLoadWhen;
    }

    public String getReNameBy() {
        return reNameBy;
    }

    public void setReNameBy(String reNameBy) {
        this.reNameBy = reNameBy;
    }

    public Date getReNameWhen() {
        return reNameWhen;
    }

    public void setReNameWhen(Date reNameWhen) {
        this.reNameWhen = reNameWhen;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeletedWhen() {
        return deletedWhen;
    }

    public void setDeletedWhen(Date deletedWhen) {
        this.deletedWhen = deletedWhen;
    }
}

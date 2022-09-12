package com.techleads.app.model;

import lombok.*;

import java.time.LocalDateTime;

@ToString
public class ApproverNames {

    private String fullName;
    private String areaName;
    private String statusName;
    private String userId;
    private LocalDateTime updtedTs;

    public ApproverNames() {
    }

    public ApproverNames(String fullName, String areaName, String statusName, String userId, LocalDateTime updtedTs) {
        this.fullName = fullName;
        this.areaName = areaName;
        this.statusName = statusName;
        this.userId = userId;
        this.updtedTs = updtedTs;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getUpdtedTs() {
        return updtedTs;
    }

    public void setUpdtedTs(LocalDateTime updtedTs) {
        this.updtedTs = updtedTs;
    }
}

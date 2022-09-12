package com.techleads.app.model;

import java.time.LocalDateTime;

public class DelinkingReqDTO {
    private String partNumber;
    private String partDescription;
    private String approver;
    private String approveOrReject;
    private LocalDateTime updtedTs;

    public DelinkingReqDTO(String partNumber, String partDescription, String approver, String approveOrReject, LocalDateTime updtedTs) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.approver = approver;
        this.approveOrReject = approveOrReject;
        this.updtedTs = updtedTs;
    }

    public DelinkingReqDTO() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getApproveOrReject() {
        return approveOrReject;
    }

    public void setApproveOrReject(String approveOrReject) {
        this.approveOrReject = approveOrReject;
    }

    public LocalDateTime getUpdtedTs() {
        return updtedTs;
    }

    public void setUpdtedTs(LocalDateTime updtedTs) {
        this.updtedTs = updtedTs;
    }
}

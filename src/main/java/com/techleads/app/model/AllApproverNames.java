package com.techleads.app.model;

import java.util.List;

public class AllApproverNames {

    private List<Recent> recent;
    private List<AllUsers> all;
    private List<ApprovedUsers> approvedUsers;

    public AllApproverNames() {
    }

    public List<Recent> getRecent() {
        return recent;
    }

    public void setRecent(List<Recent> recent) {
        this.recent = recent;
    }

    public List<AllUsers> getAll() {
        return all;
    }

    public void setAll(List<AllUsers> all) {
        this.all = all;
    }

    public List<ApprovedUsers> getApprovedUsers() {
        return approvedUsers;
    }

    public void setApprovedUsers(List<ApprovedUsers> approvedUsers) {
        this.approvedUsers = approvedUsers;
    }
}

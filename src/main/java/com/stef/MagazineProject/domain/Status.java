package com.stef.MagazineProject.domain;

import com.stef.MagazineProject.DAO.Identificators;

public class Status implements Identificators<Integer> {
    private String status;
    private int statusId;

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }

    protected void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int getId() {
        return statusId;
    }

    @Override
    public String toString() {
        return "Status: " +
                "\n |\tStatus: \t\t\t|\t" + status +
                "\n |\tStatusId: \t\t\t|\t" + statusId;
    }
}
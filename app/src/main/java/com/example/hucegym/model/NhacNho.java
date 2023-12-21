package com.example.hucegym.model;

import java.util.Date;

public class NhacNho {
    private String id_nhac_nho;
    private String notice;
    private Date addAt;

    public NhacNho(String id_nhac_nho, String notice, Date addAt) {
        this.id_nhac_nho = id_nhac_nho;
        this.notice = notice;
        this.addAt = addAt;
    }

    public String getId_nhac_nho() {
        return id_nhac_nho;
    }

    public void setId_nhac_nho(String id_nhac_nho) {
        this.id_nhac_nho = id_nhac_nho;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getAddAt() {
        return addAt;
    }

    public void setAddAt(Date addAt) {
        this.addAt = addAt;
    }

}

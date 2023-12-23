package com.example.hucegym.model;

import java.util.Date;

public class FeedBack {
    private String noi_dung;
    private Date email;
    private int status;
    private String ten_co_so;
    private String ten_hoi_vien;
    private String so_dien_thoai;

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public Date getEmail() {
        return email;
    }

    public void setEmail(Date email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTen_co_so() {
        return ten_co_so;
    }

    public void setTen_co_so(String ten_co_so) {
        this.ten_co_so = ten_co_so;
    }

    public String getTen_hoi_vien() {
        return ten_hoi_vien;
    }

    public void setTen_hoi_vien(String ten_hoi_vien) {
        this.ten_hoi_vien = ten_hoi_vien;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }
}

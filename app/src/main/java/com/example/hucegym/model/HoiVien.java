package com.example.hucegym.model;

import java.util.Date;

public class HoiVien {
    private int idHv;
    private String tenHv;
    private Date ngaySinh;
    private String gioiTinh;
    private int tuoi;
    private String soDienThoai;
    private String email;
    private String cmnd;
    private String bienSoXe;


    public int getIdHv() {
        return idHv;
    }

    public void setIdHv(int idHv) {
        this.idHv = idHv;
    }

    public String getTenHv() {
        return tenHv;
    }

    public void setTenHv(String tenHv) {
        this.tenHv = tenHv;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

}


package com.example.hucegym.model;

import java.util.Date;

public class HoiVien {
    private int id_hv;
    private int id_lop;
    private String name_hv;
    private Date ngay_sinh;
    private String gioi_tinh;
    private int tuoi;
    private String sdt;
    private String email;
    private String cmnd;
    private String bien_xe;

    private float chieu_cao;
    private float can_nang;
    private float phan_tram_mo;

    public int getId_hv() {
        return id_hv;
    }

    public void setId_hv(int id_hv) {
        this.id_hv = id_hv;
    }

    public int getId_lop() {
        return id_lop;
    }

    public void setId_lop(int id_lop) {
        this.id_lop = id_lop;
    }

    public String getName_hv() {
        return name_hv;
    }

    public void setName_hv(String name_hv) {
        this.name_hv = name_hv;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public String getBien_xe() {
        return bien_xe;
    }

    public void setBien_xe(String bien_xe) {
        this.bien_xe = bien_xe;
    }

    public float getChieu_cao() {
        return chieu_cao;
    }

    public void setChieu_cao(float chieu_cao) {
        this.chieu_cao = chieu_cao;
    }

    public float getCan_nang() {
        return can_nang;
    }

    public void setCan_nang(float can_nang) {
        this.can_nang = can_nang;
    }

    public float getPhan_tram_mo() {
        return phan_tram_mo;
    }

    public void setPhan_tram_mo(float phan_tram_mo) {
        this.phan_tram_mo = phan_tram_mo;
    }
}


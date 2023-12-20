package com.example.hucegym.model;

import com.google.gson.annotations.SerializedName;

public class HoiVien {
    @SerializedName("id_hv")
    private String id_hv;

    @SerializedName("id_lop")
    private String id_lop;

    @SerializedName("name_hv")
    private String name_hv;

    @SerializedName("ngay_sinh")
    private String ngay_sinh;

    @SerializedName("gioi_tinh")
    private String gioi_tinh;

    @SerializedName("tuoi")
    private String tuoi;

    @SerializedName("sdt")
    private String sdt;

    @SerializedName("email")
    private String email;

    @SerializedName("cmnd")
    private String cmnd;

    @SerializedName("bien_xe")
    private String bien_xe;

    @SerializedName("chieu_cao")
    private String chieu_cao;

    @SerializedName("can_nang")
    private String can_nang;

    @SerializedName("phan_tram_mo")
    private String phan_tram_mo;

    public String getId_hv() {
        return id_hv;
    }

    public void setId_hv(String id_hv) {
        this.id_hv = id_hv;
    }

    public String getId_lop() {
        return id_lop;
    }

    public void setId_lop(String id_lop) {
        this.id_lop = id_lop;
    }

    public String getName_hv() {
        return name_hv;
    }

    public void setName_hv(String name_hv) {
        this.name_hv = name_hv;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
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

    public String getChieu_cao() {
        return chieu_cao;
    }

    public void setChieu_cao(String chieu_cao) {
        this.chieu_cao = chieu_cao;
    }

    public String getCan_nang() {
        return can_nang;
    }

    public void setCan_nang(String can_nang) {
        this.can_nang = can_nang;
    }

    public String getPhan_tram_mo() {
        return phan_tram_mo;
    }

    public void setPhan_tram_mo(String phan_tram_mo) {
        this.phan_tram_mo = phan_tram_mo;
    }
}

package com.example.hucegym.model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private int id_nv;
    private String name;
    private String gioi_tinh;
    private int tuoi;
    private String sdt;
    private String cmnd;
    private String bien_so_xe;
    private String gmail;

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getBien_so_xe() {
        return bien_so_xe;
    }

    public void setBien_so_xe(String bien_so_xe) {
        this.bien_so_xe = bien_so_xe;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "id_nv=" + id_nv +
                ", name='" + name + '\'' +
                ", gioi_tinh='" + gioi_tinh + '\'' +
                ", tuoi=" + tuoi +
                ", sdt='" + sdt + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", bien_so_xe='" + bien_so_xe + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}

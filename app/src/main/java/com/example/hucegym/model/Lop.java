package com.example.hucegym.model;

import java.io.Serializable;
import java.util.Date;

public class Lop implements Serializable {
    private int id_lop;
    private int id_nv;
    private String name_nv;
    private String types_room;
    private String ten_lop;
    private String packages;
    private String ngay_hoat_dong;
    private String so_luong_hv;
    private Date time_start;
    private Date time_end;

    public int getId_lop() {
        return id_lop;
    }

    public void setId_lop(int id_lop) {
        this.id_lop = id_lop;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public String getName_nv() {
        return name_nv;
    }

    public void setName_nv(String name_nv) {
        this.name_nv = name_nv;
    }

    public String getTypes_room() {
        return types_room;
    }

    public void setTypes_room(String types_room) {
        this.types_room = types_room;
    }

    public String getTen_lop() {
        return ten_lop;
    }

    public void setTen_lop(String ten_lop) {
        this.ten_lop = ten_lop;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getNgay_hoat_dong() {
        return ngay_hoat_dong;
    }

    public void setNgay_hoat_dong(String ngay_hoat_dong) {
        this.ngay_hoat_dong = ngay_hoat_dong;
    }

    public String getSo_luong_hv() {
        return so_luong_hv;
    }

    public void setSo_luong_hv(String so_luong_hv) {
        this.so_luong_hv = so_luong_hv;
    }

    public Date getTime_start() {
        return time_start;
    }

    public void setTime_start(Date time_start) {
        this.time_start = time_start;
    }

    public Date getTime_end() {
        return time_end;
    }

    public void setTime_end(Date time_end) {
        this.time_end = time_end;
    }

    @Override
    public String toString() {
        return "Lop{" +
                "id_lop=" + id_lop +
                ", id_nv=" + id_nv +
                ", name_nv='" + name_nv + '\'' +
                ", types_room='" + types_room + '\'' +
                ", ten_lop='" + ten_lop + '\'' +
                ", packages='" + packages + '\'' +
                ", ngay_hoat_dong='" + ngay_hoat_dong + '\'' +
                ", so_luong_hv='" + so_luong_hv + '\'' +
                ", time_start=" + time_start +
                ", time_end=" + time_end +
                '}';
    }
}

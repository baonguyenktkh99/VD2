package com.example.qlts;

import java.util.Date;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private Date ngaySinh;
    private String diaChi;
    private Integer soDT;
    private String matKhau;
    private String phongBan;

    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public Integer getSoDT() {
        return soDT;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDT(Integer soDT) {
        this.soDT = soDT;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public NhanVien(String maNV, String tenNV, Date ngaySinh, String diaChi, Integer soDT, String matKhau, String phongBan) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.matKhau = matKhau;
        this.phongBan = phongBan;
    }

    public NhanVien() {
    }
}

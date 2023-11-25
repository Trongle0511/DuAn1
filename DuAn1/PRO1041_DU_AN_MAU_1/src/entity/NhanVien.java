/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private String maNV, matKhau, tenNV,diaChi,soDT,khuVuc;
    private boolean gioiTinh,chucvu;
    private Date ngayVaoLam;

    public NhanVien(String maNV, String tenNV, boolean chucvu, String diaChi, String soDT, boolean gioiTinh, Date ngayVaoLam, String matKhau,String khuVuc) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.chucvu = chucvu;
        this.ngayVaoLam = ngayVaoLam;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.matKhau = matKhau;
        this.khuVuc = khuVuc;
        

    }

    public NhanVien() {
    }
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isChucvu() {
        return chucvu;
    }

    public void setChucvu(boolean chucvu) {
        this.chucvu = chucvu;
    }



    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    
}

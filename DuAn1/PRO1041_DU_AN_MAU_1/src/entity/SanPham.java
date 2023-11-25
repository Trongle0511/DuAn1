/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author USER
 */
public class SanPham {
    private String maSP;
    private String maNCC;
    private String maLH;
    private String tenSP;
    private String hinh;
    private Double giaSP;

    public SanPham(String maSP, String maNCC, String maLH, String tenSP, String hinh, Double giaSP) {
        this.maSP = maSP;
        this.maNCC = maNCC;
        this.maLH = maLH;
        this.tenSP = tenSP;
        this.hinh = hinh;
        this.giaSP = giaSP;
    }
    
    
    public SanPham(){
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(Double giaSP) {
        this.giaSP = giaSP;
    }
    
}

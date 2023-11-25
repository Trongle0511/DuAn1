/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author USER
 */
public class calamviec {
    private String maCLV;
    private String tenCLV;
    private String khuVuc;
    private String maNV;

    public calamviec(String maCLV, String tenCLV, String khuVuc, String maNV) {
        this.maCLV = maCLV;
        this.tenCLV = tenCLV;
        this.khuVuc = khuVuc;
        this.maNV = maNV;
    }

    public calamviec(){
        
    }

    public String getMaCLV() {
        return maCLV;
    }

    public void setMaCLV(String maCLV) {
        this.maCLV = maCLV;
    }

    public String getTenCLV() {
        return tenCLV;
    }

    public void setTenCLV(String tenCLV) {
        this.tenCLV = tenCLV;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}

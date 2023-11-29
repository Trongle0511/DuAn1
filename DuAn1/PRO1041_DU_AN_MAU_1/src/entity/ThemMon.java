/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author My MSI
 */
public class ThemMon {
    private String tenMon;
    private Double giaMon ;
    private int soLuongMua ;
    private double tongTien ;

    public ThemMon() {
    }

    public ThemMon(String tenMon, Double giaMon, int soLuongMua, double tongTien) {
        this.tenMon = tenMon;
        this.giaMon = giaMon;
        this.soLuongMua = soLuongMua;
        this.tongTien = tongTien;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public Double getGiaMon() {
        return giaMon;
    }

    public void setGiaMon(Double giaMon) {
        this.giaMon = giaMon;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
}

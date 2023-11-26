/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.HoaDon;
import utils.JdbcHelper;

/**
 *
 * @author My MSI
 */
public class hoaDonDao {

    public void insert(HoaDon hd) {
        String inserHoaSon = "insert into hoaDon \n"
                + "(maHD,maNV,maKH,ngayHD,tongTien,diemTL,giamGia)  values(?,?,?,?,?,?,?)";
        new JdbcHelper().update(inserHoaSon, hd.getMaHD(), hd.getMaNV(),
                 hd.getMaKH(), hd.getNgayInHD(), hd.getTongTien(),
                 hd.getDiem(), hd.getGiamgia());

    }
    
}

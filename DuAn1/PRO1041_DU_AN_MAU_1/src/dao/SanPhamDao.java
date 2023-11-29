/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SanPham;
import entity.SanPhamHD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.ConnectJDBC;

/**
 *
 * @author My MSI
 */
public class SanPhamDao {

    public static SanPhamDao khoitao() {
        return new SanPhamDao();
    }

//    đụ má gọi à
    public ArrayList<SanPhamHD> selectAll() {
        ArrayList<SanPhamHD> sp = new ArrayList<>();

        try {
            Connection con = ConnectJDBC.getConnection();
            String sql = "Select tenSP, giaSP from sanPham ";
            PreparedStatement st = con.prepareStatement(sql);
            System.out.println("Bạn đang sử dụng câu lệnh " + sql);
            ResultSet sex = st.executeQuery();
            while (sex.next()) {
                String tenSP = sex.getString("tenSP");
                Double giaSP = sex.getDouble("giaSP");

                SanPhamHD sp1 = new SanPhamHD(tenSP, giaSP);
                sp.add(sp1);

            }
            con.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return sp;
    }

    public SanPhamHD selectByName(String tenSp) {
        SanPhamHD sphd = null;
 
        try {
            Connection con = ConnectJDBC.getConnection();
            String sql = "Select tenSP, giaSP from sanPham where tenSP = ? ";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenSp);

            System.out.println("Bạn đang sử dụng câu lệnh " + sql);
            ResultSet sex = st.executeQuery();
            while (sex.next()) {
                String tenSP = sex.getString("tenSP");
                Double giaSP = sex.getDouble("giaSP");

                sphd = new SanPhamHD(tenSP, giaSP);

            }
            con.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return sphd;
    }

}

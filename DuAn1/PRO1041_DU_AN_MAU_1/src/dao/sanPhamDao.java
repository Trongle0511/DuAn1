/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanVien;
import entity.SanPham;
import entity.SanPham1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectJDBC;
import utils.JdbcHelper;

/**
 *
 * @author My MSI
 */
public class sanPhamDao {

    public static sanPhamDao khoiTao() {
        return new sanPhamDao();
    }

    public ArrayList<SanPham1> selectAll() {
        ArrayList<SanPham1> sp = new ArrayList<>();
        try {
            Connection connection = ConnectJDBC.getConnection();
            String sql = "Select tenSp,giaSP from sanPham";
            PreparedStatement st = connection.prepareStatement(sql);
            System.out.println("Bạn đang sử dụng câu lệnh " + sql);
            ResultSet sex = st.executeQuery();
            while (sex.next()) {

                String tenSp = sex.getString("tenSP");

                double giaSP = sex.getDouble("giaSP");
                SanPham1 sp1 = new SanPham1(tenSp, giaSP);
                sp.add(sp1);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public SanPham1 selectByID(String id) {
        SanPham1 sp = null;
        try {
            Connection connection = ConnectJDBC.getConnection();
            String sql = "Select tenSp,giaSP from sanPham where tenSP = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            System.out.println("Bạn đang sử dụng câu lệnh " + sql);
            ResultSet sex = st.executeQuery();
            if (sex.next()) {

                String tenSp = sex.getString("tenSP");

                double giaSP = sex.getDouble("giaSP");
                sp = new SanPham1(tenSp,giaSP);
                
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
}



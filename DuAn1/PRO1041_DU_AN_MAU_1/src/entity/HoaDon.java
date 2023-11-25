
package entity;
import java.sql.Date;
/**
 *
 * @author USER
 */
public class HoaDon {
    private String maHD;
    private String maNV;
    private String maKH;
    private Date ngayInHD;
    private int tongTien;
    private int diem;
    private int giamgia;

    public HoaDon(String maHD, String maNV, String maKH, Date ngayInHD, int tongTien, int diem, int giamgia) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngayInHD = ngayInHD;
        this.tongTien = tongTien;
        this.diem = diem;
        this.giamgia = giamgia;
    }
    
    public HoaDon(){
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayInHD() {
        return ngayInHD;
    }

    public void setNgayInHD(Date ngayInHD) {
        this.ngayInHD = ngayInHD;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }
    
    
}

package NhanVien;


import CauHinh.CauHinh;
import PhongBan.PhongBan;
import java.text.ParseException;
import java.util.Date;

public class NhanVienBinhThuong extends NhanVien {

    public NhanVienBinhThuong(String tenNhanVien, Date ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan) {
        super(tenNhanVien, ngaySinh, email, gioiTinh, heSo, phongBan);
    }

    public NhanVienBinhThuong(String tenNhanVien, String ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan) throws ParseException {
        super(tenNhanVien, CauHinh.f.parse(ngaySinh), email, gioiTinh, heSo, phongBan);
    }
    
//    public NhanVienBinhThuong(PhongBan phongBan) throws ParseException {
//        super(phongBan);
//    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong();
    }

    @Override
    public String loaiNhanVien() {
        return "Nhan vien binh thuong";
    }

    @Override
    public void hienThiNhanVien() {
        System.out.println("Loai nhan vien: " + this.loaiNhanVien());
        super.hienThiNhanVien();
    }

}

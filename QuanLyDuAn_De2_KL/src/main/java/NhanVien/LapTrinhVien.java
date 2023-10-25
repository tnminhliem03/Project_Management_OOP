package NhanVien;

import CauHinh.CauHinh;
import PhongBan.PhongBan;
import java.text.ParseException;
import java.util.Date;

public class LapTrinhVien extends NhanVien {

    private double gioLamThem;

    public LapTrinhVien(String tenNhanVien, Date ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan, double gioLamThem) {
        super(tenNhanVien, ngaySinh, email, gioiTinh, heSo, phongBan);
        this.gioLamThem = gioLamThem;
    }

    public LapTrinhVien(String tenNhanVien, String ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan, double gioLamThem) throws ParseException {
        super(tenNhanVien, CauHinh.f.parse(ngaySinh), email, gioiTinh, heSo, phongBan);
        this.gioLamThem = gioLamThem;
    }

    @Override
    public double tinhLuong() {
        System.out.println("\nBan co muon update so gio? 1.Co 2.Khong\n");
        int abc = Integer.parseInt(CauHinh.sc.nextLine());
        if (abc != 1) {
            this.setLuongNhanVien(this.getLuongNhanVien() + (this.getLuongCoBan() / 30 * getGioLamThem()));
            return this.getLuongNhanVien();
        } else {
            System.out.print("Nhap so gio chuan bi update: ");
            double soGioUpdate = Double.parseDouble(CauHinh.sc.nextLine());
            this.setLuongNhanVien(this.getLuongNhanVien() + (this.getLuongCoBan() / 30 * getGioLamThem()));
            return this.getLuongNhanVien();
        }
    }

    @Override
    public String loaiNhanVien() {
        return "Lap trinh vien";
    }

    @Override
    public void hienThiNhanVien() {
        System.out.println("Loai nhan vien: " + this.loaiNhanVien());
        super.hienThiNhanVien();
        System.out.println("So gio da lam them: " + this.getGioLamThem());
    }

    /**
     * @return the gioLamThem
     */
    public double getGioLamThem() {
        return gioLamThem;
    }

    /**
     * @param gioLamThem the gioLamThem to set
     */
    public void setGioLamThem(double gioLamThem) {
        this.gioLamThem = gioLamThem;
    }

}

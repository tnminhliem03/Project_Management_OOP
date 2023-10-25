package NhanVien;

import CauHinh.CauHinh;
import NhanVien.NhanVien;
import PhongBan.PhongBan;
import java.text.ParseException;
import java.util.Date;

public class KiemThuVien extends NhanVien {

    private int soLoi;

    public KiemThuVien(String tenNhanVien, Date ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan, int soLoi) {
        super(tenNhanVien, ngaySinh, email, gioiTinh, heSo, phongBan);
        this.soLoi = soLoi;
    }

    public KiemThuVien(String tenNhanVien, String ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan, int soLoi) throws ParseException {
        super(tenNhanVien, CauHinh.f.parse(ngaySinh), email, gioiTinh, heSo, phongBan);
        this.soLoi = soLoi;
    }

//    public KiemThuVien(PhongBan phongBan) throws ParseException {
//        super(phongBan);
//        System.out.println("Nhan vien dac biet - Nhap ngay nham chuc phong ban(dd/MM/yyyy): ");
//        this.soLoi = Integer.parseInt(CauHinh.sc.nextLine());
//    }
    @Override
    public double tinhLuong() {
        System.out.println("\nBan co muon update so loi? 1.Co 2.Khong\n");
        int abc = Integer.parseInt(CauHinh.sc.nextLine());
        if (abc != 1) {
            this.setLuongNhanVien(this.getLuongNhanVien() + (200.000 * getSoLoi()));
            return this.getLuongNhanVien();
        }
        else {
            System.out.print("Nhap so loi chuan bi update: ");
            int soLoiTimDuoc = Integer.parseInt(CauHinh.sc.nextLine());
            this.setSoLoi(soLoiTimDuoc);
            this.setLuongNhanVien(this.getLuongNhanVien() + (200.000 * getSoLoi()));
            return this.getLuongNhanVien();
        }
    }

    public String loaiNhanVien() {
        return "Kiem thu vien";
    }

    @Override
    public void hienThiNhanVien() {
        System.out.println("Loai nhan vien: " + this.loaiNhanVien());
        super.hienThiNhanVien();
        System.out.println("So loi hien tai da tim duoc: " + this.getSoLoi());
    }

    /**
     * @return the soLoi
     */
    public int getSoLoi() {
        return soLoi;
    }

    /**
     * @param soLoi the soLoi to set
     */
    public void setSoLoi(int soLoi) {
        this.soLoi = soLoi;
    }
}

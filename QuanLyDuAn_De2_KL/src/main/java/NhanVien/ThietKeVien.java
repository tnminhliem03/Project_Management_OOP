package NhanVien;


import CauHinh.CauHinh;
import PhongBan.PhongBan;
import java.text.ParseException;
import java.util.Date;

public class ThietKeVien extends NhanVien {

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    private double bonus;

    public ThietKeVien(String tenNhanVien, Date ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan, double bonus) {
        super(tenNhanVien, ngaySinh, email, gioiTinh, heSo, phongBan);
        this.bonus = bonus;
    }

    public ThietKeVien(String tenNhanVien, String ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan, double bonus) throws ParseException {
        super(tenNhanVien, CauHinh.f.parse(ngaySinh), email, gioiTinh, heSo, phongBan);
        this.bonus = bonus;
    }

    @Override
    public double tinhLuong() {
        System.out.println("\nBan co muon update luong bonus? 1.Co 2.Khong\n");
        int abc = Integer.parseInt(CauHinh.sc.nextLine());
        if (abc != 1) {
            this.setLuongNhanVien(this.getLuongNhanVien() * this.getBonus());
            return this.getLuongNhanVien();
        } else {
            System.out.print("Nhap so luong bonus chuan bi update: ");
            double luongUpdate = Double.parseDouble(CauHinh.sc.nextLine());
            this.setLuongNhanVien(this.getLuongNhanVien() + luongUpdate);
            return this.getLuongNhanVien();
        }
    }

    @Override
    public String loaiNhanVien() {
        return "Thiet ke vien";
    }

    @Override
    public void hienThiNhanVien() {
        System.out.println("Loai nhan vien: " + this.loaiNhanVien());
        super.hienThiNhanVien();
        System.out.println("Luong bonus: " + this.getBonus());
    }

}

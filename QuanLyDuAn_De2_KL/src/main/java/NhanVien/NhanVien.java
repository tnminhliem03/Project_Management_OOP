package NhanVien;

import CauHinh.CauHinh;
import DuAn.DuAn;
import PhongBan.PhongBan;
import ThanNhan.ThanNhan;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class NhanVien {

    public static int dem = 0;

    private int maNhanVien = ++dem;

    private String tenNhanVien;

    private Date ngaySinh;

    private String email;

    private String gioiTinh;

    private double heSo;

    private PhongBan phongBanCuaNhanVien;

    private double luongCoBan = 5000;

    private double luongNhanVien;

    private List<ThanNhan> danhSachThanNhan = new ArrayList<>();

    private List<DuAn> danhSachDuAn = new ArrayList<>();

    public NhanVien(String tenNhanVien, Date ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan) {
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.heSo = heSo;
        this.phongBanCuaNhanVien = phongBan;
    }

    public NhanVien(String tenNhanVien, String ngaySinh, String email, String gioiTinh, double heSo, PhongBan phongBan) throws ParseException {
        this(tenNhanVien, CauHinh.f.parse(ngaySinh), email, gioiTinh, heSo, phongBan);
    }

    public double tinhLuong() {
        System.out.println("\nBan co muon sua he so? 1.Co 2.Khong");
        int luaChonHeSo = Integer.parseInt(CauHinh.sc.nextLine());
        if (luaChonHeSo != 1) {
            this.setLuongNhanVien(getLuongCoBan() * getHeSo());
            return this.getLuongNhanVien();
        }
        else {
            System.out.print("Nhap he so ban muon update: ");
            double heSoUpdate = Double.parseDouble(CauHinh.sc.nextLine());
            this.heSo = heSoUpdate;
            this.setLuongNhanVien(getLuongCoBan() * getHeSo());
            return this.getLuongNhanVien();
        }
    }

    public int tinhTuoi() {
        return CauHinh.time.get(Calendar.YEAR) - Integer.parseInt(CauHinh.f.format(getNgaySinh()).substring(6));
    }

    public abstract String loaiNhanVien();

    public void hienThiNhanVien() {
        System.out.printf("\n= = = = =\nMa nhan vien: %d\nTen: %s\nNgay sinh: %s\nEmail: %s\nGioi tinh: %s\nHe so: %.1f\nLuong: %.3f\n", getMaNhanVien(), getTenNhanVien(), CauHinh.f.format(getNgaySinh()), getEmail(), getGioiTinh(), getHeSo(), getLuongNhanVien());
    }

    public void hienThiDanhSachThanNhan() {
        this.getDanhSachThanNhan().forEach(h -> h.hienThi());
    }

    public void hienThiDuAnThamGia() {
        if (this.getDanhSachDuAn().size() == 0) {
            System.out.println("Nhan vien chua tham gia du an nao!\n");
        } else {
            this.getDanhSachDuAn().forEach(h -> h.hienThiDuAn());
        }
    }

    public void themThanNhan(ThanNhan thanNhan) {
        this.getDanhSachThanNhan().add(thanNhan);
    }

    public void themDuAn(DuAn duAn) {
        if (this.getDanhSachDuAn().size() >= 3) {
            System.out.println("Nhan vien nay chi co the tham gia toi da 3 du an!");
        } else {
            this.getDanhSachDuAn().add(duAn);
        }
    }

    public void xoaThanNhan(ThanNhan thanNhan) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachThanNhan().size(); i++) {
            if (this.getDanhSachThanNhan().get(i).getHoTen().equalsIgnoreCase(thanNhan.getHoTen()) == true) {
                this.getDanhSachThanNhan().remove(i);
                check = true;
            }
        }
        if (check == true) {
            System.out.println("Da xoa than nhan thanh cong!\n");
        } else {
            System.out.println("Khong tim thay than nhan cua nhan vien nay!\n");
        }
    }

    public void xoaDuAn(DuAn duAn) {
        if (this.getDanhSachDuAn().size() <= 0) {
            System.out.println("nhan vien chua tham gia du an nao!\n");
        } else {
            boolean check = false;
            for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
                if (this.getDanhSachDuAn().get(i).getTenDuAn().equalsIgnoreCase(duAn.getTenDuAn())) {
                    this.getDanhSachDuAn().remove(i);
                    check = true;
                }
            }
            if (check == true) {
                System.out.println("Da xoa du an thanh cong!\n");
            } else {
                System.out.println("Khong tim thay du an nay!\n");
            }
        }
    }

    /**
     * @return the maNhanVien
     */
    public int getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    /**
     * @return the tenNhanVien
     */
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    /**
     * @param tenNhanVien the tenNhanVien to set
     */
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    /**
     * @return the ngaySinh
     */
    public Date getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the heSo
     */
    public double getHeSo() {
        return heSo;
    }

    /**
     * @param heSo the heSo to set
     */
    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    /**
     * @return the phongBanCuaNhanVien
     */
    public PhongBan getPhongBanCuaNhanVien() {
        return phongBanCuaNhanVien;
    }

    /**
     * @param phongBanCuaNhanVien the phongBanCuaNhanVien to set
     */
    public void setPhongBanCuaNhanVien(PhongBan phongBanCuaNhanVien) {
        this.phongBanCuaNhanVien = phongBanCuaNhanVien;
    }

    /**
     * @return the luongCoBan
     */
    public double getLuongCoBan() {
        return luongCoBan;
    }

    /**
     * @return the luongNhanVien
     */
    public double getLuongNhanVien() {
        return luongNhanVien;
    }

    /**
     * @param luongNhanVien the luongNhanVien to set
     */
    public void setLuongNhanVien(double luongNhanVien) {
        this.luongNhanVien = luongNhanVien;
    }

    /**
     * @return the danhSachThanNhan
     */
    public List<ThanNhan> getDanhSachThanNhan() {
        return danhSachThanNhan;
    }

    /**
     * @param danhSachThanNhan the danhSachThanNhan to set
     */
    public void setDanhSachThanNhan(List<ThanNhan> danhSachThanNhan) {
        this.danhSachThanNhan = danhSachThanNhan;
    }

    /**
     * @return the danhSachDuAn
     */
    public List<DuAn> getDanhSachDuAn() {
        return danhSachDuAn;
    }

    /**
     * @param danhSachDuAn the danhSachDuAn to set
     */
    public void setDanhSachDuAn(List<DuAn> danhSachDuAn) {
        this.danhSachDuAn = danhSachDuAn;
    }

    /**
     * @param luongCoBan the luongCoBan to set
     */
    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

}

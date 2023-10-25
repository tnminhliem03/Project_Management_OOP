package DuAn;


import CauHinh.CauHinh;
import NhanVien.NhanVien;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DuAn {

    public static int dem = 0;

    private int maDuAn = ++dem;

    private String tenDuAn;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private double tongKinhPhi;

    private NhanVien nguoiChuNhiem;

    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    public DuAn() {

    }

    public DuAn(String tenDuAn, String ngayBatDau, String ngayKetThuc, double tongKinhPhi) throws ParseException {
        this.tenDuAn = tenDuAn;
        this.ngayBatDau = CauHinh.f.parse(ngayBatDau);
        this.ngayKetThuc = CauHinh.f.parse(ngayKetThuc);
        this.tongKinhPhi = tongKinhPhi;
    }

    public void chiDinhNguoiChuNhiem(NhanVien nguoiChuNhiem) {
        if (this.getNguoiChuNhiem() == null) { //kiem tra da co nguoi chu nhiem chua
            if (this.getDanhSachNhanVien().stream().filter(h -> h.getMaNhanVien() == nguoiChuNhiem.getMaNhanVien()).collect(Collectors.toList()).size() == 0) { // nhan vien nay dang tham gia du an nay
                this.setNguoiChuNhiem(nguoiChuNhiem);
                System.out.println("Da gan nhan vien co trong du an nay lam nguoi chu nhiem!\n");
            } else { // nhan vien nhay chua tham gia vao du an nay
                this.themNhanVien(nguoiChuNhiem);
                this.setNguoiChuNhiem(nguoiChuNhiem);
                System.out.println("Nguoi chu nhiem da duoc them vao du an!\n");
            }
        } else {
            System.out.println("Da co nguoi chu nhiem trong du an nay!\nBan co muon sua NGUOI CHU NHIEM THAM GIA DU AN NAY KHONG? (Nhap 1 de tiep tuc - 2 de thoat)");
            int tam = Integer.parseInt(CauHinh.sc.nextLine());
            if (tam == 1) {
                this.setNguoiChuNhiem(nguoiChuNhiem);
            }
        }
        System.out.println("\nDa chi dinh thanh cong!\n");
    }

    public void xoaNguoiChuNhiem() {
        if (this.getNguoiChuNhiem() == null) {
            System.out.println("Chua co nguoi chu nhiem trong du an nay!\n");
        } else {
            this.setNguoiChuNhiem(null);
        }
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        if (this.getDanhSachNhanVien().size() == 0) {
            System.out.println("Khong co nhan vien trong du an nay!\n");
        } else {
            for (int i = 0; i < this.getDanhSachNhanVien().size(); i++) {
                if (this.getDanhSachNhanVien().get(i).getMaNhanVien() == nhanVien.getMaNhanVien()) {
                    this.getDanhSachNhanVien().remove(i);
                }
            }
        }
    }

    public void hienThiDuAn() {
        System.out.printf("\n= = = = =\nMa du an: %s\nTen du an: %s\nNgay bat dau: %s\nNgay ket thuc: %s\nTong kinh phi: %.3f\n", getMaDuAn(), getTenDuAn(), CauHinh.f.format(getNgayBatDau()), CauHinh.f.format(getNgayKetThuc()), getTongKinhPhi());
    }

    public void hienThiDanhSachNhanVien() {
        if (this.getDanhSachNhanVien().size() == 0) {
            System.out.println("Chua co nhan vien tham gia du an nay!\n");
        } else if (this.getDanhSachNhanVien().size() < 5) {
            this.getDanhSachNhanVien().forEach(h -> h.hienThiNhanVien());
            System.out.println("Chua du so luong toi thieu nhan vien tham gia, can them " + (5 - this.getDanhSachNhanVien().size()) + " nhan vien!\n");
        } else {
            this.getDanhSachNhanVien().forEach(h -> h.hienThiNhanVien());
        }
    }

    public void hienThiNguoiChuNhiem() {
        if (this.getNguoiChuNhiem() == null) {
            System.out.println("Chua co nguoi chu nhiem! Ban nen them nguoi chu nhiem vao du an nay.\n");
        } else {
            this.getNguoiChuNhiem().hienThiNhanVien();
        }
    }

    /**
     * Toi thieu co 5 nhan vien va toi da 10 nhan vien de tham gia du an
     *
     * @param nhanVien
     */
    public void themNhanVien(NhanVien nhanVien) {
        if (this.getDanhSachNhanVien().stream().filter(h -> h.getMaNhanVien() == nhanVien.getMaNhanVien()).collect(Collectors.toList()).size() == 0) { // chua co nhan vien nay trong du an
            if (this.getDanhSachNhanVien().size() == 10) {
                System.out.println("Du an nay da du so luong nhan vien tham gia!");
            } else {
                this.getDanhSachNhanVien().add(nhanVien);

                if (this.getDanhSachNhanVien().size() < 5) {
                    System.out.println("Chua du so luong nhan vien toi thieu tham gia, can " + (5 - this.getDanhSachNhanVien().size()) + " nhan vien tham gia vao du an!");
                }
            }
        } else {
            System.out.println("nhan vien dang tham gia du an nay!");
        }
    }

    /**
     * @return the maDuAn
     */
    public int getMaDuAn() {
        return maDuAn;
    }

    /**
     * @param maDuAn the maDuAn to set
     */
    public void setMaDuAn(int maDuAn) {
        this.maDuAn = maDuAn;
    }

    /**
     * @return the tenDuAn
     */
    public String getTenDuAn() {
        return tenDuAn;
    }

    /**
     * @param tenDuAn the tenDuAn to set
     */
    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    /**
     * @return the ngayBatDau
     */
    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    /**
     * @param ngayBatDau the ngayBatDau to set
     */
    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    /**
     * @return the ngayKetThuc
     */
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    /**
     * @param ngayKetThuc the ngayKetThuc to set
     */
    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    /**
     * @return the tongKinhPhi
     */
    public double getTongKinhPhi() {
        return tongKinhPhi;
    }

    /**
     * @param tongKinhPhi the tongKinhPhi to set
     */
    public void setTongKinhPhi(double tongKinhPhi) {
        this.tongKinhPhi = tongKinhPhi;
    }

    /**
     * @return the nguoiChuNhiem
     */
    public NhanVien getNguoiChuNhiem() {
        return nguoiChuNhiem;
    }

    /**
     * @param nguoiChuNhiem the nguoiChuNhiem to set
     */
    public void setNguoiChuNhiem(NhanVien nguoiChuNhiem) {
        this.nguoiChuNhiem = nguoiChuNhiem;
    }

    /**
     * @return the danhSachNhanVien
     */
    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    /**
     * @param danhSachNhanVien the danhSachNhanVien to set
     */
    public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

}

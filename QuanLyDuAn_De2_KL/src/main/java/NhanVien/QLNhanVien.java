package NhanVien;


import CauHinh.CauHinh;
import PhongBan.PhongBan;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QLNhanVien {

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

    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    public QLNhanVien() {

    }

    public void hienThiDanhSachNhanVien() {
        if (this.getDanhSachNhanVien().size() == 0) {
            System.out.println("Chua co nhan vien nao trong danh sach!\n");
        } else {
            this.getDanhSachNhanVien().forEach(h -> h.hienThiNhanVien());
        }
    }

    public void hienThiDanhSachDuAnNhanVienThamGia(int maNhanVien) {
        boolean check = false;
        for (NhanVien h : this.getDanhSachNhanVien()) {
            if (h.getMaNhanVien() == maNhanVien) {
                h.hienThiDuAnThamGia();
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay nhan vien nay!\n");
        }
    }

    public void xoaNhanVien(int maNhanVien) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachNhanVien().size(); i++) {
            if (this.getDanhSachNhanVien().get(i).getMaNhanVien() == maNhanVien) {
                this.getDanhSachNhanVien().remove(i);
                System.out.println("Da xoa nhan vien thanh cong!\n");
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay nhan vien nay!\n");
        }
    }

    public void xoaNhanVien(String tuKhoa) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachNhanVien().size(); i++) {
            if (this.getDanhSachNhanVien().get(i).getTenNhanVien().equalsIgnoreCase(tuKhoa)
                    || CauHinh.f.format(this.getDanhSachNhanVien().get(i).getNgaySinh()).equalsIgnoreCase(tuKhoa)
                    || this.getDanhSachNhanVien().get(i).getEmail().equalsIgnoreCase(tuKhoa)) {
                this.getDanhSachNhanVien().remove(i);
                System.out.println("Da xoa nhan vien thanh cong!\n");
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay nhan vien nay!\n");
        }
    }
    
    public NhanVien nhapVaTaoNhanVien(PhongBan phongBan) throws ParseException {
        System.out.print("Ten nhan vien: ");
        String tenNhanVien = CauHinh.sc.nextLine();
        System.out.print("Ngay sinh(dd/MM/yyyy): ");
        Date ngaySinh = CauHinh.f.parse(CauHinh.sc.nextLine());
        System.out.print("Gioi tinh: ");
        String gioiTinh = CauHinh.sc.nextLine();
        System.out.print("He so: ");
        double heSo = Double.parseDouble(CauHinh.sc.nextLine());
        CauHinh.sc.nextLine();
        System.out.println("Da tao thanh cong!\n");
        System.out.println("Ban muon tao nhan vien gi?\n");
        System.out.println("1. Nhan vien binh thuong\n2.Nhan vien dac biet\n3. Lap trinh vien\n4. Thiet ke vien\n5. Kiem thu vien\n");
        System.out.print("Nhap lua chon cua ban(1-5): ");
        int luaChonTao = Integer.parseInt(CauHinh.sc.nextLine());
        switch (luaChonTao) {
            case 1 -> {
                return new NhanVienBinhThuong(tenNhanVien, ngaySinh, gioiTinh, gioiTinh, heSo, phongBan);
            }
            case 2 -> {
                System.out.print("Nhap ngay nham chuc phong ban cua nhan vien dac biet: ");
                Date ngayNhamChuc = CauHinh.f.parse(CauHinh.sc.nextLine());
                return new NhanVienDacBiet(ngaySinh, tenNhanVien, gioiTinh, gioiTinh, heSo, phongBan, ngayNhamChuc);
            }
            case 3 -> {
                System.out.print("Nhap gio lam them cua lap trinh vien: ");
                double gioLamThem = Double.parseDouble(CauHinh.sc.nextLine());
                return new LapTrinhVien(tenNhanVien, ngaySinh, gioiTinh, gioiTinh, heSo, phongBan, gioLamThem);
            }
            case 4 -> {
                System.out.println("Nhap luong bonus cua thiet ke vienL: ");
                double bonus = Double.parseDouble(CauHinh.sc.nextLine());
                return new ThietKeVien(tenNhanVien, ngaySinh, gioiTinh, gioiTinh, heSo, phongBan, bonus);
            }
            case 5 -> {
                System.out.print("Nhap so loi tim duoc cua kiem thu vien: ");
                int soLoi = Integer.parseInt(CauHinh.sc.nextLine());
                return new KiemThuVien(tenNhanVien, ngaySinh, gioiTinh, gioiTinh, heSo, phongBan, soLoi);
            }
        }
        return null;
    }

    public void themNhanVien(NhanVien nv) {
        if (this.getDanhSachNhanVien().stream().filter(h -> h.getMaNhanVien() == nv.getMaNhanVien()).collect(Collectors.toList()).size() == 0) {
            this.getDanhSachNhanVien().add(nv);
        } else {
            System.out.println("Da co nhan vien trong danh sach nay!\n");
        }
    }

    public NhanVien timKiemNhanVien(int maNhanVien) {
        return this.getDanhSachNhanVien().stream().filter(h -> h.getMaNhanVien() == maNhanVien).findFirst().get();
    }

    public List<NhanVien> timKiemNhanVien(String tuKhoa) {
        return this.getDanhSachNhanVien().stream().filter(h -> h.getTenNhanVien().contains(tuKhoa)
        || CauHinh.f.format(h.getNgaySinh()).equalsIgnoreCase(tuKhoa)
        || h.getPhongBanCuaNhanVien().getTenPhongBan().equalsIgnoreCase(tuKhoa)).collect(Collectors.toList());
    }

    public List<NhanVien> timKiemNhanVienTheoTuoi(int doTuoi) {
        return this.getDanhSachNhanVien().stream().filter(h -> h.tinhTuoi() == doTuoi).collect(Collectors.toList());
    }

    public List<NhanVien> timKiemNhanVienTheoTuoi(int tuoiTu, int denTuoi) {
        return this.getDanhSachNhanVien().stream().filter(h -> 
                h.tinhTuoi() >= tuoiTu && h.tinhTuoi() <= denTuoi
        ).collect(Collectors.toList());
    }

}

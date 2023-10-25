package DuAn;

import CauHinh.CauHinh;
import DuAn.DuAn;
import NhanVien.NhanVien;
import NhanVien.QLNhanVien;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QLDuAn {

    private List<DuAn> danhSachDuAn = new ArrayList<>();

    public QLDuAn() {

    }

    public void hienThiDanhSachDuAn() {
        if (this.getDanhSachDuAn().size() == 0) {
            System.out.println("Khong co du an nao trong danh sach!\n");
        } else {
            for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
                this.getDanhSachDuAn().get(i).hienThiDuAn();
            }
        }
    }

    public void hienThiNhanVienCuaDuAn(int maDuAn) {
        boolean check = false;
        for (DuAn h : this.getDanhSachDuAn()) {
            if (h.getMaDuAn() == maDuAn) {
                if (h.getDanhSachNhanVien().size() == 0) {
                    System.out.println("Khong co nhan vien trong danh sach nay!\n");
                } else {
                    h.hienThiDanhSachNhanVien();
                    check = true;
                }
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay du an nay!\n");
        }
    }

    public DuAn timKiemDuAn(int maDuAn) {
        return this.getDanhSachDuAn().stream().filter(h -> h.getMaDuAn() == maDuAn).findFirst().get();
    }

    public List<DuAn> timKiemDuAn(String tuKhoa) {
        return this.getDanhSachDuAn().stream().filter(h -> h.getTenDuAn().equalsIgnoreCase(tuKhoa)
                || CauHinh.f.format(h.getNgayBatDau()).equalsIgnoreCase(tuKhoa)
                || CauHinh.f.format(h.getNgayKetThuc()).equalsIgnoreCase(tuKhoa)
        ).collect(Collectors.toList());
    }

    public void sapXepGiamTheoKinhPhi() {
        this.getDanhSachDuAn().sort((h1, h2) -> {
            double h11 = h1.getTongKinhPhi();
            double h22 = h2.getTongKinhPhi();
            return h11 > h22 ? -1 : (h11 < h22 ? 1 : 0);
        });
    }

    public void sapXepTangTheoKinhPhi() {
        this.getDanhSachDuAn().sort((h1, h2) -> {
            double h11 = h1.getTongKinhPhi();
            double h22 = h2.getTongKinhPhi();
            return h11 > h22 ? 1 : (h11 < h22 ? -1 : 0);
        });
    }

    public void themDuAn(DuAn duAn) {
        if (this.getDanhSachDuAn().size() == 0) {
            this.getDanhSachDuAn().add(duAn);
        } else {
//            boolean check = false;
//            for (int i = 0; i < this.danhSachDuAn.size(); i++) {
//                if (this.danhSachDuAn.get(i).getMaDuAn()== duAn.getMaDuAn()
//                        || this.danhSachDuAn.get(i).getTenDuAn().equalsIgnoreCase(duAn.getTenDuAn()) == false) {
//                    this.danhSachDuAn.add(duAn);
//                    check = true;
//                }
//            }
//            if (check == false) {
//                System.out.println("Khong tim thay du an!\n");
//            }
this.getDanhSachDuAn().add(duAn);
        }
    }

    public void nhapVaTaoDuAn() throws ParseException {
        System.out.println("Nhap ten du an: ");
        String tenDuAn = CauHinh.sc.nextLine();
        System.out.println("Nhap ngay bat dau du an: ");
        Date ngayBatDau = CauHinh.f.parse(CauHinh.sc.nextLine());
        System.out.println("Nhap ngay ket thuc du an: ");
        Date ngayKetThuc = CauHinh.f.parse(CauHinh.sc.nextLine());
        System.out.println("Nhap tong kinh phi du an: ");
        double tongKinhPhi = CauHinh.sc.nextDouble();
        DuAn daEmty = new DuAn(tenDuAn, CauHinh.f.format(ngayBatDau), CauHinh.f.format(ngayKetThuc), tongKinhPhi);
        this.getDanhSachDuAn().add(daEmty);
    }

    public void themNguoiChuNhiem(int maDuAn, NhanVien nguoiChuNhiem) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
            if (this.getDanhSachDuAn().get(i).getMaDuAn() == maDuAn) {
                this.getDanhSachDuAn().get(i).chiDinhNguoiChuNhiem(nguoiChuNhiem);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay du an nay trong danh sach!\n");
        }
    }

    public void themNhanVien(int maDuAn, NhanVien nhanVien) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
            if (this.getDanhSachDuAn().get(i).getMaDuAn() == maDuAn) {
                this.getDanhSachDuAn().get(i).themNhanVien(nhanVien);
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay du an nay trong danh sach!\n");
        }
    }

    public void xoaDuAn(DuAn duAn) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
            if (this.getDanhSachDuAn().get(i).getTenDuAn() == duAn.getTenDuAn()) {
                this.getDanhSachDuAn().remove(i);
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay du an nay trong danh sach!\n");
        }
    }

    public void xoaDuAn(int maDuAn) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
            if (this.getDanhSachDuAn().get(i).getMaDuAn() == maDuAn) {
                this.getDanhSachDuAn().remove(i);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay du an ban muon xoa trong danh sach!\n");
        }
    }

    public void xoaDuAn(String tuKhoa) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
            if (this.getDanhSachDuAn().get(i).getTenDuAn().equalsIgnoreCase(tuKhoa)
                    || CauHinh.f.format(this.getDanhSachDuAn().get(i).getNgayBatDau()).equalsIgnoreCase(tuKhoa)
                    || CauHinh.f.format(this.getDanhSachDuAn().get(i).getNgayKetThuc()).equalsIgnoreCase(tuKhoa)
                    || this.getDanhSachDuAn().get(i).getTongKinhPhi() == Double.parseDouble(tuKhoa)
                    || this.getDanhSachDuAn().get(i).getNguoiChuNhiem().getTenNhanVien().equalsIgnoreCase(tuKhoa)) {
                this.getDanhSachDuAn().remove(i);
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay du an nay trong danh sach!\n");
        }
    }

    public void xoaToanBoDuAn() {
        this.getDanhSachDuAn().clear();
    }

    public void xoaNguoiChuNhiem(int maDuAn) {
        boolean check = false;
        for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
            if (this.getDanhSachDuAn().get(i).getMaDuAn() == maDuAn) {
                this.getDanhSachDuAn().get(i).xoaNguoiChuNhiem();
            }

        }
        if (check == false) {
            System.out.println("Khong tim thay du an ban muon xoa trong danh sach!\n");
        }
    }

    public void suaDuAn() throws ParseException { // muon sua case 5 va 6 phai co danh sach toan bo nhan vien moi xu ly duoc 
        int dem = -1;
        do {
            boolean check = false;
            this.hienThiDanhSachDuAn();
            System.out.print("Nhap MA DU AN ban muon sua: ");
            int maDuAnMuonSua = Integer.parseInt(CauHinh.sc.nextLine());
            for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
                if (this.getDanhSachDuAn().get(i).getMaDuAn() == maDuAnMuonSua) {
                    check = true;
                    System.out.print("\n1. Ten du an\n2.Ngay bat dau\n3. Ngay ket thuc\n4. Tong kinh phi\n5. Thoat\n= = = Nhap lua chon ban muon sua(1-4): ");
                    Scanner sc1 = new Scanner(System.in);
                    int luaChon = Integer.parseInt(sc1.nextLine());
                    switch (luaChon) {
                        case 1 -> {
                            System.out.print("Nhap ten ban muon sua: ");
                            String t = sc1.nextLine();
                            this.getDanhSachDuAn().get(i).setTenDuAn(t);
                            break;
                        }
                        case 2 -> {
                            System.out.println("Nhap thoi diem bat dau ban muon sua(dd/MM/yyyy): ");
                            Date b = CauHinh.f.parse(sc1.nextLine());
                            this.getDanhSachDuAn().get(i).setNgayBatDau(b);
                            break;
                        }

                        case 3 -> {
                            System.out.println("Nhap thoi diem ket thuc ban muon sua(dd/MM/yyyy): ");
                            Date t = CauHinh.f.parse(sc1.nextLine());
                            this.getDanhSachDuAn().get(i).setNgayKetThuc(t);
                            break;
                        }

                        case 4 -> {
                            System.out.println("Nhap tong kinh phi ban muon sua: ");
                            double a = sc1.nextDouble();
                            this.getDanhSachDuAn().get(i).setTongKinhPhi(a);
                            break;
                        }

                    }
                }
            }
            if (check == false) {
                System.out.println("Khong tim thay du an ban muon sua trong danh sach!\n");
                break;
            }
            System.out.println("Da sua du an thanh cong!\n");
            System.out.println("Ban co muon tiep tuc sua du an nay nua khong? (1.Co 2.Khong)\n");
            dem = Integer.parseInt(CauHinh.sc.nextLine());
        } while (dem == 1);
    }

    public void suaDuAn(QLNhanVien qlnv) { // muon sua case 5 va 6 phai co danh sach toan bo nhan vien moi xu ly duoc 
        int dem1 = -1;
        do {
            boolean check = false;
            this.hienThiDanhSachDuAn();
            System.out.print("Nhap MA DU AN ban muon sua: ");
            int maDuAnMuonSua1 = Integer.parseInt(CauHinh.sc.nextLine());
            for (int i = 0; i < this.getDanhSachDuAn().size(); i++) {
                if (this.getDanhSachDuAn().get(i).getMaDuAn() == maDuAnMuonSua1) {
                    check = true;
                    System.out.print("\n1.Sua nguoi chu nhiem\n2. Sua danh sach nhan vien\n3. Thoat= = = Nhap lua chon ban muon sua(1-3): ");
                    Scanner sc1 = new Scanner(System.in);
                    int luaChon = Integer.parseInt(sc1.nextLine());
                    if (luaChon == 3) {
                        break;
                    }
                    switch (luaChon) {
                        case 1 -> {
                            System.out.println("\n= = = Danh sach nhan vien dang lam viec tai cong ty = = =\n");
                            qlnv.hienThiDanhSachNhanVien();
                            System.out.println("Ban co muon thay doi nguoi chu nhiem? 1.Co 2.Khong");
                            int tam = Integer.parseInt(sc1.nextLine());
                            if (tam == 1) {
                                System.out.println("Nhap ma nhan vien ban muon chon lam nguoi chu nhiem: ");
                                int maNhanVienChuNhiem = Integer.parseInt(sc1.nextLine());
                                this.getDanhSachDuAn().get(i).chiDinhNguoiChuNhiem(qlnv.timKiemNhanVien(maNhanVienChuNhiem));
                            }
                            break;
                        }

                        case 2 -> {
                            System.out.println("\n= = = Danh sach nhan vien dang tham gia du an nay = = =");
                            this.getDanhSachDuAn().get(i).hienThiDanhSachNhanVien();
                            System.out.println("\n= = = Danh sach toan bo nhan vien dang lam viec tai cong ty = = =\n");
                            qlnv.hienThiDanhSachNhanVien();
                            System.out.println("Ban muon THEM hay XOA nhan vien khoi du an nay: 1.Them 2.Xoa 3.Thoat");

                            if (Integer.parseInt(sc1.nextLine()) == 1) {
                                System.out.println("Nhap ma nhan vien ban muon THEM vao du an: ");
                                for (NhanVien nv : qlnv.timKiemNhanVien(sc1.nextLine())) {
                                    this.getDanhSachDuAn().get(i).themNhanVien(nv);
                                    nv.themDuAn(this.getDanhSachDuAn().get(i));
                                }
                            } else if (Integer.parseInt(sc1.nextLine()) == 2) {
                                System.out.println("Nhap ma nhan vien ban muon XOA vao du an: ");
                                for (NhanVien nv : qlnv.timKiemNhanVien(sc1.nextLine())) {
                                    this.getDanhSachDuAn().get(i).xoaNhanVien(nv);
                                    nv.xoaDuAn(this.getDanhSachDuAn().get(i));
                                }
                            }
                        }

                    }
                }
            }
                if (check == false) {
                    System.out.println("Khong tim thay du an ban muon sua trong danh sach!\n");
                    break;
                }
                System.out.println("Da sua du an thanh cong!\n");
                System.out.println("Ban co muon tiep tuc sua du an nay nua khong? (1.Co 2.Khong)\n");
                dem1 = Integer.parseInt(CauHinh.sc.nextLine());
            } while (dem1 == 1);
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
}

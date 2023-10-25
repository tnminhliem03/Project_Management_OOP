/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuForUser;

import NhanVien.*;
import CauHinh.*;
import DuAn.*;
import PhongBan.*;
import ThanNhan.ThanNhan;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kitj3
 */
public class MenuForUser {

    public static void main(String[] args) throws ParseException {
        // TAO PHONG BAN
        PhongBan pb1 = new PhongBan("IT");
        PhongBan pb2 = new PhongBan("Kinh doanh");
        PhongBan pb3 = new PhongBan("Tai chinh");

        //TAO QUAN LY PHONG BAN
        QLPhongBan qlpb = new QLPhongBan();
        qlpb.themPhongBan(pb1);
        qlpb.themPhongBan(pb2);
        qlpb.themPhongBan(pb3);

        // TAO NHAN VIEN
        NhanVien nv1 = new NhanVienBinhThuong("Tran Tuan Kiet", "31/07/2003", "kitj317@gmail.com", "Nam", 9.5, pb1);
        pb1.themNhanVien(nv1);
        NhanVien nv2 = new NhanVienDacBiet("Tran Nguyen Minh Liem", "18/12/2000", "liem@gmail.com", "Nam", 9.5, pb1, "31/07/2022");
        pb1.themNhanVien(nv2);
        NhanVien nv3 = new LapTrinhVien("Nguyen Duy Tan", "08/05/1995", "tan@gmail.com", "Nam", 4.9, pb2, 3.7);
        pb2.themNhanVien(nv3);
        NhanVien nv4 = new KiemThuVien("Nguyen Trung Kien", "15/09/2005", "kien@gmail.com", "Nam", 6.9, pb3, 7);
        pb3.themNhanVien(nv4);
        NhanVien nv5 = new ThietKeVien("Nguyen Ngoc Nhung", "22/02/2002", "nhung317@gmail.com", "Nu", 4.3, pb3, 2.9);
        pb3.themNhanVien(nv5);
        NhanVien nv6 = new NhanVienBinhThuong("Dam Trung Kien", "11/02/2003", "kien112@gmail.com", "Nam", 1.5, pb1);
        pb1.themNhanVien(nv6);
        NhanVien nv7 = new LapTrinhVien("Tui La Nu", "05/03/1999", "nu@gmail.com", "Nu", 5.6, pb2, 7.6);
        pb2.themNhanVien(nv7);

        //TAO QUAN LY NHAN VIEN
        QLNhanVien qlnv = new QLNhanVien();
        qlnv.themNhanVien(nv1);
        qlnv.themNhanVien(nv2);
        qlnv.themNhanVien(nv3);
        qlnv.themNhanVien(nv4);
        qlnv.themNhanVien(nv5);
        qlnv.themNhanVien(nv6);
        qlnv.themNhanVien(nv7);

        // TAO DU AN
        DuAn da1 = new DuAn("Xay dung landmark", "01/04/2019", "12/04/2030", 1000);
        da1.themNhanVien(nv1);
        nv1.themDuAn(da1);
        da1.themNhanVien(nv2);
        nv2.themDuAn(da1);
        da1.themNhanVien(nv3);
        nv3.themDuAn(da1);
        da1.themNhanVien(nv4);
        nv4.themDuAn(da1);
        da1.themNhanVien(nv5);
        nv5.themDuAn(da1);

        DuAn da2 = new DuAn("Sua cau Sai Gon", "15/03/2015", "21/08/2025", 5000);
        da2.themNhanVien(nv2);
        nv2.themDuAn(da2);
        da2.themNhanVien(nv3);
        nv3.themDuAn(da2);
        da2.themNhanVien(nv4);
        nv4.themDuAn(da2);
        da2.themNhanVien(nv5);
        nv5.themDuAn(da2);
        da2.themNhanVien(nv6);
        nv6.themDuAn(da2);
        da2.themNhanVien(nv7);
        nv7.themDuAn(da2);

        DuAn da3 = new DuAn("Son mau nha tho Duc Ba", "23/01/2022", "24/07/2024", 9730);
        da3.themNhanVien(nv1);
        nv1.themDuAn(da3);
        da3.themNhanVien(nv2);
        nv2.themDuAn(da3);
        da3.themNhanVien(nv3);
        nv3.themDuAn(da3);
        da3.themNhanVien(nv4);
        nv4.themDuAn(da3);
        da3.themNhanVien(nv5);
        nv5.themDuAn(da3);
        da3.themNhanVien(nv6);
        nv6.themDuAn(da3);
        da3.themNhanVien(nv7);
        nv7.themDuAn(da3);

        // TAO QUAN LY DU AN
        QLDuAn qlda = new QLDuAn();
        qlda.themDuAn(da1);
        qlda.themDuAn(da2);
        qlda.themDuAn(da3);

        //Set du an cho nhan vien
        // TAO THAN NHAN
        ThanNhan tn1 = new ThanNhan("Lam Van Doi", "Nam", "10/10/1999", "Anh Trai");
        ThanNhan tn2 = new ThanNhan("Nguyen Thi Anh Vien", "Nu", "24/06/2003", "Chi Gai");
        ThanNhan tn3 = new ThanNhan("Thang Quoc Hau", "Nam", "07/07/2003", "Bo");
        ThanNhan tn4 = new ThanNhan("Nguyen Hoai Tam", "Nam", "17/10/2003", "Anh Trai");
        ThanNhan tn5 = new ThanNhan("Tran Hoang Quan", "Nam", "01/01/2003", "Chu");
        ThanNhan tn6 = new ThanNhan("Ton Tang Ton Nu", "Nu", "09/09/2003", "Di");
        ThanNhan tn7 = new ThanNhan("Ta Thi My Linh", "Nu", "11/11/2003", "Thim");

        // SET THAN NHAN CHO NHAN VIEN
        nv1.themThanNhan(tn1);
        nv1.themThanNhan(tn2);
        tn2.themNhanVien(nv1);

        nv3.themThanNhan(tn2);
        tn2.themNhanVien(nv3);

        nv4.themThanNhan(tn4);
        nv4.themThanNhan(tn7);
        tn4.themNhanVien(nv4);
        tn7.themNhanVien(nv4);

        nv5.themThanNhan(tn5);
        nv5.themThanNhan(tn6);
        tn5.themNhanVien(nv5);
        tn6.themNhanVien(nv5);

        nv7.themThanNhan(tn7);
        nv7.themThanNhan(tn3);
        nv7.themThanNhan(tn2);
        tn7.themNhanVien(nv7);
        tn3.themNhanVien(nv7);
        tn2.themNhanVien(nv7);

        System.out.println("\n= = = CHAO MUNG BAN DEN VOI CONG TY K&L = = =\n");
        int check = -1;
        do {
            System.out.println("\nBan muon lam gi?\n1. Quan ly DU AN cua cong ty\n2. Quan ly NHAN VIEN cua cong ty\n3. Thoat MENU\n");
            System.out.println("Hay nhap lua chon cua ban: ");
            Scanner sc2 = new Scanner(System.in);
            int luaChonMenu = Integer.parseInt(sc2.nextLine());
            if (luaChonMenu == 3) {
                break;
            }
            switch (luaChonMenu) {
                // lua chon menu
                case 1 -> {
                    System.out.println("\n= = = QUAN LY DU AN = = =\n");
                    System.out.println("1. Them du an\n2. Xoa du an\n3. Sua du an\n4. Xem danh sach nhan vien cua du an\n"
                            + "5. Tim kiem du an\n6. Gan chu nhiem du an\n7. Gan nhan vien cho du an\n8. Hien thi danh sach du an\n9. Thoat");
                    System.out.println("\nHay nhap lua chon cua ban: ");
                    int tam111 = Integer.parseInt(sc2.nextLine());
                    if (tam111 == 9) {
                        break;
                    }
                    switch (tam111) {
                        // them du an
                        case 1 -> {
                            do {
                                qlda.nhapVaTaoDuAn();
                                System.out.println("\nDa tao thanh cong!\n1. Tao them du an\n2. Thoat\n");
                            } while (sc2.nextLine().equalsIgnoreCase("1"));
                            break;
                        }
                        // xoa du an
                        case 2 -> {
                            do {
                                qlda.hienThiDanhSachDuAn();
                                System.out.print("Nhap ID du an: ");
                                int idDuAn = Integer.parseInt(sc2.nextLine());
                                qlda.xoaDuAn(idDuAn);
                                qlnv.getDanhSachNhanVien().forEach(h -> h.xoaDuAn(qlda.timKiemDuAn(idDuAn -1)));
                                System.out.println("\"Da xoa thanh cong!\n1. Xoa them du an\n2. Thoat");
                            } while (Integer.parseInt(sc2.nextLine()) == 1);
                            break;
                        } // sua du an

                        case 3 -> {
                            do {
                                System.out.println("1. Sua ten du an - ngay bat dau - ngay ket thuc - Tong kinh phi\n");
                                System.out.println("2. Sua nguoi chu nhiem - danh sach nhan vien\n");
                                System.out.println("3. Thoat\n");
                                System.out.println("Hay nhap lua chon cua ban: ");
                                int dem13 = Integer.parseInt(sc2.nextLine());
                                if (dem13 == 3) {
                                    break;
                                }
                                switch (dem13) {
                                    case 1 -> {
                                        qlda.suaDuAn();
                                        break;
                                    }
                                    case 2 -> {
                                        qlda.suaDuAn(qlnv);
                                        break;
                                    }
                                }
                                System.out.println("\nDa sua thanh cong!\n"
                                        + "1. Sua them du an\n2. Thoat");
                            } while (Integer.parseInt(sc2.nextLine()) == 1);
                            break;
                        }
                        // Liem
                        case 4 -> {
                            int maDuAnNv, luaChon14;
                            do {
                                qlda.hienThiDanhSachDuAn();
                                System.out.println("\nNhap ma du an can xem:");
                                maDuAnNv = Integer.parseInt(sc2.nextLine());
                                qlda.hienThiNhanVienCuaDuAn(maDuAnNv);
                                System.out.println("1. Xem them danh sach nhan vien cua du an khac\n2. Thoat");
                                luaChon14 = Integer.parseInt(sc2.nextLine());
                            } while (luaChon14 == 1);
                            break;
                        }

                        case 5 -> {
                            do {
                                System.out.println("\n1. Theo ID du an\n2. Theo keyword\n3. Thoat\n");
                                System.out.println("Hay nhap lua chon(1 - 3)");
                                int luaChon15 = Integer.parseInt(sc2.nextLine());
                                if (luaChon15 == 3) {
                                    break;
                                }
                                switch (luaChon15) {
                                    case 1 -> {
                                        System.out.println("\nHay nhap id cua du an do: ");
                                        int idDuAn1 = Integer.parseInt(sc2.nextLine());
                                        if (qlda.timKiemDuAn(idDuAn1) == null) {
                                            System.out.println("\nKhong tim thay du an nao!");
                                        } else {
                                            qlda.timKiemDuAn(idDuAn1).hienThiDuAn();
                                        }
                                        break;
                                    }
                                    case 2 -> {
                                        System.out.println("Ten du an - Ngay bat dau - Ngay ket thuc - Tong kinh phi - Ten nguoi chu nhiem\n");
                                        System.out.println("Hay nhap keyword de xoa du an ban muon:  ");
                                        String tuKhoa = sc2.nextLine();
                                        if (qlda.timKiemDuAn(tuKhoa).size() == 0) {
                                            System.out.println("Khong tim thay du an nao!");
                                        } else {
                                            qlda.timKiemDuAn(tuKhoa).forEach(h -> h.hienThiDuAn());
                                        }
                                        break;
                                    }
                                }

                                System.out.println("\n1. Tiep tuc tim kiem\n 2. Thoat");

                            } while (Integer.parseInt(sc2.nextLine()) == 1);
                            break;
                        }

                        case 6 -> {
                            int demM;
                            do {
                                System.out.println("1. Chi dinh nguoi chu nhiem\n2.Xoa nguoi chu nhiem");
                                int luaChon16 = Integer.parseInt(sc2.nextLine());
                                switch (luaChon16) {
                                    case 1 -> {
                                        int tam16;
                                        do {
                                            qlda.hienThiDanhSachDuAn();
                                            System.out.println("Ban muon sua nguoi chu nhiem cua du an nao(Nhap ID du an): ");
                                            int idDuAn = Integer.parseInt(sc2.nextLine());
                                            System.out.println("\n1. Chi dinh nhan vien co san trong danh sach nhan vien\n2. Tao nhan vien moi hoan toan lam nguoi chu nhiem\n3. Thoat\n");
                                            System.out.println("Nhap lua chon cua ban (1-3): ");
                                            int fs = Integer.parseInt(sc2.nextLine());
                                            if (fs == 3) {
                                                break;
                                            }
                                            switch (fs) {
                                                case 1 -> {
                                                    qlnv.hienThiDanhSachNhanVien();
                                                    System.out.println("Ban muon chi dinh nhan vien nao lam nguoi chu nhiem du an nay(nhap ID): ");
                                                    int tambo = Integer.parseInt(sc2.nextLine());
                                                    qlda.timKiemDuAn(idDuAn).chiDinhNguoiChuNhiem(qlnv.timKiemNhanVien(tambo));
                                                    qlda.timKiemDuAn(idDuAn).getNguoiChuNhiem().hienThiNhanVien();
                                                    break;
                                                }
                                                case 2 -> {
                                                    System.out.print("Nhap ID phong ban de them vao cho nhan vien chuan bi tao: ");
                                                    int tambo2 = Integer.parseInt(sc2.nextLine());
                                                    qlpb.hienThiDanhSachPhongBan();
                                                    System.out.print("Chon ID phong ban: ");
                                                    int idPhongBan = Integer.parseInt(sc2.nextLine());
                                                    NhanVien nvtam = qlnv.nhapVaTaoNhanVien(qlpb.timKiemPhongBan(idPhongBan));
                                                    qlda.themNguoiChuNhiem(idDuAn, nvtam);
                                                    qlda.timKiemDuAn(idDuAn).getNguoiChuNhiem().hienThiNhanVien();
                                                    break;
                                                }
                                            }
                                            System.out.println("\n1. Tiep tuc chi dinh nguoi chu nhiem vao du an\n 2. Thoat");
                                            tam16 = Integer.parseInt(sc2.nextLine());
                                        } while (tam16 == 1);
                                        break;
                                    }
                                    case 2 -> {
                                        qlda.hienThiDanhSachDuAn();
                                        System.out.print("Hay chon id du an:");
                                        int tam162 = Integer.parseInt(sc2.nextLine());
                                        if (qlda.timKiemDuAn(tam162).getNguoiChuNhiem() == null) {
                                            System.out.println("Khong co nguoi chu nhiem de xoa!\n");
                                        } else {
                                            qlda.timKiemDuAn(tam162).getNguoiChuNhiem().hienThiNhanVien();
                                        }
                                        break;
                                    }
                                }
                                demM = Integer.parseInt(sc2.nextLine());
                            } while (demM == 1);
                            break;
                        }
                        case 7 -> {
                            System.out.println("\n1. Tao nhan vien moi va them vao du an\n2. Them nhan vien da co san vao du an\n3. Thoat\n");
                            System.out.print("Nhap lua chon(1-3): ");
                            switch (Integer.parseInt(sc2.nextLine())) {
                                case 1 -> {
                                    qlda.hienThiDanhSachDuAn();
                                    System.out.print("Nhap ID du an ban muon them: ");
                                    int maDuAnMuonThem = Integer.parseInt(sc2.nextLine());
                                    if (qlda.timKiemDuAn(maDuAnMuonThem) == null) {
                                        System.out.println("Khong tim thay du an!\n");
                                    } else {
                                        qlnv.nhapVaTaoNhanVien(qlpb.timKiemPhongBan(maDuAnMuonThem));
                                        qlda.timKiemDuAn(maDuAnMuonThem).themNhanVien(qlnv.getDanhSachNhanVien().get(qlnv.getDanhSachNhanVien().size() - 1));
                                        qlnv.getDanhSachNhanVien().get(qlnv.getDanhSachNhanVien().size() - 1).themDuAn(qlda.timKiemDuAn(maDuAnMuonThem));
                                    }
                                }
                                case 2 -> {
                                    qlnv.hienThiDanhSachNhanVien();
                                    System.out.print("\nNhap ID nhan vien ban muon them vao du an: ");
                                    int maNhanVienTemp = Integer.parseInt(sc2.nextLine());
                                    if (qlnv.timKiemNhanVien(maNhanVienTemp) == null) {
                                        System.out.println("Khong tim thay nhan vien nay!\n");
                                    } else {
                                        qlda.hienThiDanhSachDuAn();
                                        System.out.print("Nhap ID du an ban muon them nhan vien: ");
                                        int maDuAnTemp = Integer.parseInt(sc2.nextLine());
                                        if (qlda.timKiemDuAn(maDuAnTemp) == null) {
                                            System.out.println("\nKhong tim thay du an!\n");
                                        } else {
                                            qlda.themNhanVien(maDuAnTemp, qlnv.timKiemNhanVien(maNhanVienTemp));
                                        }
                                    }
                                }
                                case 3 -> {
                                    break;
                                }
                            }
                            break;
                        }
                        case 8 -> {
                            qlda.hienThiDanhSachDuAn();
                        }
                    }

                } // lua chon menu

                case 2 -> {
                    System.out.println("\n= = = QUAN LY NHAN VIEN = = =\n");
                    System.out.println("1. Them nhan vien\n2. Xoa nhan vien\n3. Tinh luong cac nhan vien\n4. Tim kiem\n"
                            + "5. Xem danh sach du an cua nhan vien\n6. Xem danh sach than nhan cua nhan vien\n7. Hien thi danh sach nhan vien\n8. Thoat\n");
                    int chon2 = Integer.parseInt(sc2.nextLine());
                    if (chon2 == 8) {
                        break;
                    }
                    switch (chon2) {
                        // lua chon menu quan ly nhan vien
                        case 1 -> {
                            qlpb.hienThiDanhSachPhongBan();
                            System.out.print("Nhap ID phong ban cho nhan vien nay: ");
                            int idNv1 = Integer.parseInt(CauHinh.sc.nextLine());
                            qlnv.themNhanVien(qlnv.nhapVaTaoNhanVien(qlpb.timKiemPhongBan(idNv1)));
                            break;
                        }
                        case 2 -> {
                            qlnv.hienThiDanhSachNhanVien();
                            System.out.println("Nhap ID nhan vien ban muon xoa: ");
                            int idNv2 = Integer.parseInt(CauHinh.sc.nextLine());
                            qlnv.xoaNhanVien(qlnv.timKiemNhanVien(idNv2).getMaNhanVien());
                            break;
                        }
                        case 3 -> {
                            qlnv.hienThiDanhSachNhanVien();
                            System.out.println("\nNhap ID nhan vien ban muon tinh luong: ");
                            int idnv3 = Integer.parseInt(sc2.nextLine());
                            qlnv.timKiemNhanVien(idnv3).tinhLuong();
                            qlnv.timKiemNhanVien(idnv3).hienThiNhanVien();
                            break;
                        }
                        case 4 -> {
                            int dem = 0;
                            do {
                                System.out.println("\1. Tim nhan vien theo id\n2. Tim theo ho ten: \n3. Tim theo ngay sinh\n4. Theo phong ban\n5. Theo do tuoi chinh xac\n6. Theo khoang do tuoi\n7. Thoat\n");
                                System.out.print("Nhap lua chon: ");
                                int luaChon4 = Integer.parseInt(CauHinh.sc.nextLine());
                                if (luaChon4 == 7) {
                                    break;
                                }
                                switch (luaChon4) {
                                    case 1 -> {
                                        qlnv.hienThiDanhSachNhanVien();
                                        System.out.print("Nhap ID: ");
                                        int idFind = Integer.parseInt(CauHinh.sc.nextLine());
                                        qlnv.timKiemNhanVien(idFind).hienThiNhanVien();
                                        break;
                                    }
                                    case 2 -> {
                                        qlnv.hienThiDanhSachNhanVien();
                                        System.out.print("Nhap ho ten: ");
                                        String s = sc2.nextLine();
                                        qlnv.timKiemNhanVien(s).forEach(h -> h.hienThiNhanVien());
                                        break;
                                    }
                                    case 3 -> {
                                        qlnv.hienThiDanhSachNhanVien();
                                        System.out.print("Nhap ngay sinh(dd/MM/yyyy): ");
                                        String sn = sc2.nextLine();
                                        qlnv.timKiemNhanVien(sn).forEach(h -> h.hienThiNhanVien());
                                        break;
                                    }
                                    case 4 -> {
                                        qlpb.hienThiDanhSachPhongBan();
                                        System.out.print("Nhap ID phong ban ban muon xem danh sach nhan vien: ");
                                        int idPb = Integer.parseInt(sc2.nextLine());
                                        qlpb.timKiemPhongBan(idPb).hienThiNhanVien();
                                        break;
                                    }
                                    case 5 -> {
                                        qlnv.hienThiDanhSachNhanVien();
                                        System.out.print("Nhap do tuoi: ");
                                        int doTuoi = Integer.parseInt(sc2.nextLine());
                                        qlnv.timKiemNhanVienTheoTuoi(doTuoi).forEach(h -> h.hienThiNhanVien());
                                        break;
                                    }
                                    case 6 -> {
                                        qlnv.hienThiDanhSachNhanVien();
                                        System.out.print("Nhap do tuoi bat dau: ");
                                        int doTuoiBd = Integer.parseInt(sc2.nextLine());
                                        System.out.print("Nhap do tuoi ket thuc: ");
                                        int doTuoikt = Integer.parseInt(sc2.nextLine());
                                        qlnv.timKiemNhanVienTheoTuoi(doTuoiBd, doTuoikt).forEach(h -> h.hienThiNhanVien());
                                    }
                                }
                            } while (true);
                        }
                        case 5 -> {
                            qlnv.hienThiDanhSachNhanVien();
                            System.out.print("Nhap ID nhan vien ban muon xem danh sach du an: ");
                            int idNv5 = Integer.parseInt(sc2.nextLine());
                            qlnv.timKiemNhanVien(idNv5).hienThiDuAnThamGia();
                        }
                        case 6 -> {
                            qlnv.hienThiDanhSachNhanVien();
                            System.out.print("Nhap ID nhan vien ban muon xem danh sach than nhan: ");
                            int idNv5 = Integer.parseInt(sc2.nextLine());
                            qlnv.timKiemNhanVien(idNv5).hienThiDanhSachThanNhan();
                        }
                        case 7 -> {
                            qlnv.hienThiDanhSachNhanVien();
                        }
                    }
                }
            }
            System.out.println("\n1.tiep tuc su dung Menu\n2. Thoat chuong trinh\nHay nhap lua chon cua ban (1-2): ");
            check = Integer.parseInt(sc2.nextLine());
        } while (check == 1);
        System.out.println("Da thoat menu thanh cong! HenGapLai!\n");
    }
}

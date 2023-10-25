package PhongBan;

import NhanVien.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QLPhongBan {

    private List<PhongBan> dsPhongBan = new ArrayList<>();

    public QLPhongBan() {

    }

    public void xoaPhongBan(int maPhongBan) {
        if (this.getDsPhongBan().size() == 0) {
            System.out.println("Khong co phong ban nao de xoa!\n");
        } else {
            boolean check = false;
            for (int i = 0; i < this.getDsPhongBan().size(); i++) {
                if (this.getDsPhongBan().get(i).getMaPhongBan() == maPhongBan) {
                    this.getDsPhongBan().remove(i);
                    check = true;
                }
            }
            if (check == false) {
                System.out.println("Khong tim thay phong ban!\n");
            }
        }
    }

    public void xoaPhongBan(String tuKhoa) {
        if (this.getDsPhongBan().size() == 0) {
            System.out.println("Khong co phong ban nao de xoa!\n");
        } else {
            boolean check = false;
            for (int i = 0; i < this.getDsPhongBan().size(); i++) {
                if (this.getDsPhongBan().get(i).getTenPhongBan().equalsIgnoreCase(tuKhoa)) {
                    this.getDsPhongBan().remove(i);
                    check = true;
                }
            }
            if (check == false) {
                System.out.println("Khong tim thay phong ban!\n");
            }
        }
    }

    public PhongBan timKiemPhongBan(int maPhongBan) {
        return this.getDsPhongBan().stream().filter(h -> h.getMaPhongBan() == maPhongBan).findFirst().get();
    }

    public List<PhongBan> timKiemPhongBan(String tuKhoa) {
        return this.getDsPhongBan().stream().filter(h -> h.getTenPhongBan().equalsIgnoreCase(tuKhoa)).collect(Collectors.toList());
    }

    public void themPhongBan(PhongBan phongBan) {
        if (this.getDsPhongBan().size() == 0) {
            this.getDsPhongBan().add(phongBan);
        } else {
            boolean check = false;
            for (int i = 0; i < this.getDsPhongBan().size(); i++) {
                if (this.getDsPhongBan().get(i).getMaPhongBan() != phongBan.getMaPhongBan()
                        || this.getDsPhongBan().get(i).getTenPhongBan().equalsIgnoreCase(phongBan.getTenPhongBan()) == false) {
                    this.getDsPhongBan().add(phongBan);
                    check = true;
                }
            }
            if (check == false) {
                System.out.println("Khong tim thay phong ban!\n");
            }
        }
    }

    public void themNhanVienVaoPhongBan(NhanVien nhanVien, int maPhongBan) {
        boolean check = false;
        for (int i = 0; i < this.getDsPhongBan().size(); i++) {
            if (this.getDsPhongBan().get(i).getMaPhongBan() == maPhongBan) {
                if (this.getDsPhongBan().get(i).getNhanVienPhongBan().stream().filter(h -> h.getMaNhanVien() == nhanVien.getMaNhanVien()).collect(Collectors.toList()).isEmpty()) {
                    this.getDsPhongBan().get(i).themNhanVien(nhanVien);
                    check = true;
                } else {
                    System.out.println("Nhan vien nay da co trong phong ban!\n");
                }
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay phong ban!\n");
        }
    }

    public void hienThiDanhSachPhongBan() {
        if (this.getDsPhongBan().size() == 0) {
            System.out.println("Khong co phong ban nao trong danh sach!\n");
        } else {
            this.getDsPhongBan().forEach(h -> h.hienThiPhongBan());
        }
    }

    /**
     * @return the dsPhongBan
     */
    public List<PhongBan> getDsPhongBan() {
        return dsPhongBan;
    }

    /**
     * @param dsPhongBan the dsPhongBan to set
     */
    public void setDsPhongBan(List<PhongBan> dsPhongBan) {
        this.dsPhongBan = dsPhongBan;
    }

}

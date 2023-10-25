package PhongBan;


import NhanVien.NhanVien;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhongBan {

    public static int dem = 0;

    private int maPhongBan = ++dem;

    private String tenPhongBan;

    private List<NhanVien> nhanVienPhongBan = new ArrayList<>();

    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public void themNhanVien(NhanVien... nhanVien) {
        this.getNhanVienPhongBan().addAll(Arrays.asList(nhanVien));
    }

    public void hienThiPhongBan() {
        System.out.printf("\n= = = =\nMa phong ban: %d\nTen phong ban: %s\n", this.getMaPhongBan(), this.getTenPhongBan());
    }

    public void hienThiNhanVien() {
        if (this.getNhanVienPhongBan().size() == 0) {
            System.out.println("Khong co nhan vien trong phong ban!\n");
        } else {
            this.getNhanVienPhongBan().forEach(h -> h.hienThiNhanVien());
        }
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        if (this.getNhanVienPhongBan().size() == 0) {
            System.out.println("Khong co nhan vien trong phong ban!\n");
        } else {
            boolean check = false;
            for (int i = 0; i < this.getNhanVienPhongBan().size(); i++) {
                if (this.getNhanVienPhongBan().get(i).getTenNhanVien().equalsIgnoreCase(nhanVien.getTenNhanVien()) == true) {
                    this.getNhanVienPhongBan().remove(i);
                    check = true;
                }
            }
            if (check == true) {
                System.out.println("Da xoa nhan vien thanh cong!\n");
            } else {
                System.out.println("Khong tim thay nhan vien trong phong ban nay!\n");
            }
        }
    }

    /**
     * @return the maPhongBan
     */
    public int getMaPhongBan() {
        return maPhongBan;
    }

    /**
     * @param maPhongBan the maPhongBan to set
     */
    public void setMaPhongBan(int maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    /**
     * @return the tenPhongBan
     */
    public String getTenPhongBan() {
        return tenPhongBan;
    }

    /**
     * @param tenPhongBan the tenPhongBan to set
     */
    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    /**
     * @return the nhanVienPhongBan
     */
    public List<NhanVien> getNhanVienPhongBan() {
        return nhanVienPhongBan;
    }

    /**
     * @param nhanVienPhongBan the nhanVienPhongBan to set
     */
    public void setNhanVienPhongBan(List<NhanVien> nhanVienPhongBan) {
        this.nhanVienPhongBan = nhanVienPhongBan;
    }

}

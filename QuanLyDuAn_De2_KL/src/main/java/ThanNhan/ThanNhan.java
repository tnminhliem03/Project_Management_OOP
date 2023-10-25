package ThanNhan;


import CauHinh.CauHinh;
import NhanVien.NhanVien;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ThanNhan {

    private String hoTen;

    private String gioiTinh;

    private Date ngaySinh;

    private String moiQuanHe;

    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    public ThanNhan(String hoTen, String gioiTinh, Date ngaySinh, String moiQuanHe) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.moiQuanHe = moiQuanHe;
    }

    public ThanNhan(String hoTen, String gioiTinh, String ngaySinh, String moiQuanHe) throws ParseException {
        this(hoTen, gioiTinh, CauHinh.f.parse(ngaySinh), moiQuanHe);
    }

    public void hienThi() {
        System.out.printf("\n= = = = =\nTen than nhan: %s\nGioi tinh: %s\nNgay sinh: %s\nMoi quan he: %s\n", getHoTen(), getGioiTinh(), CauHinh.f.format(getNgaySinh()), getMoiQuanHe());
    }

    public void hienThiDanhSachNhanVien() {
        if (this.getDanhSachNhanVien().size() == 0) {
            System.out.println("Than nhan nay khong co quan he voi nhan vien nao!\n");
        } else {
            this.getDanhSachNhanVien().forEach(h -> h.hienThiNhanVien());
        }
    }
    
    public void themNhanVien(NhanVien nhanVien) {
        if (this.getDanhSachNhanVien().stream().filter(h -> h.getMaNhanVien() == nhanVien.getMaNhanVien()).collect(Collectors.toList()).size() == 0) {
            this.getDanhSachNhanVien().add(nhanVien);
        }
        else
            System.out.println("Nhan vien va Than nhan nay da co san moi quan he!");
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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
     * @return the moiQuanHe
     */
    public String getMoiQuanHe() {
        return moiQuanHe;
    }

    /**
     * @param moiQuanHe the moiQuanHe to set
     */
    public void setMoiQuanHe(String moiQuanHe) {
        this.moiQuanHe = moiQuanHe;
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

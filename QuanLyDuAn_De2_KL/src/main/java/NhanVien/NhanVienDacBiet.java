package NhanVien;


import CauHinh.CauHinh;
import PhongBan.PhongBan;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVienDacBiet extends NhanVien {

    private Date ngayNhamChuc;

    private List<PhongBan> quanLiPhongBan = new ArrayList<>();

    public NhanVienDacBiet(Date ngaySinh, String tenNhanVien, String email, String gioiTinh, double heSo, PhongBan phongBan, Date ngayNhamChuc) {
        super(tenNhanVien, ngaySinh, email, gioiTinh, heSo, phongBan);
        this.ngayNhamChuc = ngayNhamChuc;
    }

    public NhanVienDacBiet( String tenNhanVien, String ngaySinh ,String email, String gioiTinh, double heSo, PhongBan phongBan, String ngayNhamChuc) throws ParseException {
        super(tenNhanVien, CauHinh.f.parse(ngaySinh), email, gioiTinh, heSo, phongBan);
        this.ngayNhamChuc = CauHinh.f.parse(ngayNhamChuc);
    }
    
//    public NhanVienDacBiet(PhongBan phongBan) throws ParseException {
//        super(phongBan);
//        System.out.print("Nhan vien dac biet - Nhap ngay nham chuc phong ban(dd/MM/yyyy): ");
//        this.ngayNhamChuc = CauHinh.f.parse(CauHinh.sc.nextLine());
//    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong();
    }

    @Override
    public String loaiNhanVien() {
        return "Nhan vien dac biet";
    }

    @Override
    public void hienThiNhanVien() {
        System.out.println("Loai nhan vien: " + this.loaiNhanVien());
        super.hienThiNhanVien();
        System.out.println("Ngay nham chuc phong ban: " + CauHinh.f.format(this.getNgayNhamChuc()));
    }

    public void themPhongBanQuanLy(PhongBan pb) {
        if (this.getQuanLiPhongBan().size() < 2) {
            this.getQuanLiPhongBan().add(pb);
        } else {
            System.out.println("Nhan vien dac biet nay da quan ly toi da 2 phong ban!\n");
        }
    }

    public void xoaPhongBanQuanLy(PhongBan pb) {
        if (this.getQuanLiPhongBan().size() == 0) {
            System.out.println("Nhan vien dac biet chua quan ly phong ban nao!\n");
        } else {
            boolean check = false;
            for (int i = 0; i < this.getQuanLiPhongBan().size(); i++) {
                if (this.getQuanLiPhongBan().get(i).getMaPhongBan() == pb.getMaPhongBan()
                        || this.getQuanLiPhongBan().get(i).getTenPhongBan().equalsIgnoreCase(pb.getTenPhongBan()) == true) {
                    this.getQuanLiPhongBan().remove(i);
                }
            }
        }
    }

    /**
     * @return the ngayNhamChuc
     */
    public Date getNgayNhamChuc() {
        return ngayNhamChuc;
    }

    /**
     * @param ngayNhamChuc the ngayNhamChuc to set
     */
    public void setNgayNhamChuc(Date ngayNhamChuc) {
        this.ngayNhamChuc = ngayNhamChuc;
    }

    /**
     * @return the quanLiPhongBan
     */
    public List<PhongBan> getQuanLiPhongBan() {
        return quanLiPhongBan;
    }

    /**
     * @param quanLiPhongBan the quanLiPhongBan to set
     */
    public void setQuanLiPhongBan(List<PhongBan> quanLiPhongBan) {
        this.quanLiPhongBan = quanLiPhongBan;
    }

}

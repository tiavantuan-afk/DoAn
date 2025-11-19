public class BanHang {
    protected DSPhieuNhapHang dspnh = new DSPhieuNhapHang();
    protected DSChiTietPNH dsctpnh = new DSChiTietPNH();
    protected DSHoaDon dshd = new DSHoaDon();
    protected DSChiTietHoaDon dscthd = new DSChiTietHoaDon();
    protected DSNhaCungCap dsncc = new DSNhaCungCap();
    protected DSSanPham dssp = new DSSanPham();
    protected DSNhanVien dsnv = new DSNhanVien();
    protected DSKhachHang dskh = new DSKhachHang();
    protected DSTenHangSanXuat dsth = new DSTenHangSanXuat();
    protected DSLoaiHang dslh = new DSLoaiHang();
    protected DSDouong dsdo = new DSDouong();
    protected DSThucAnNhanh dsta = new DSThucAnNhanh();

    public void docdulieufile() {
        try {
            dsncc.docFile("NhaCungCap.txt");
            dspnh.docFile("PhieuNhapHang.txt");
            dsctpnh.docFile("ChiTietPNH.txt");
            dshd.docFile("HoaDon.txt");
            dscthd.docFile("ChiTietHoaDon.txt");
            dssp.docFile("SanPham.txt");
            dsnv.docFile("NhanVien.txt");
            dskh.docFile("KhachHang.txt");
            dsth.docFile("TenHangSanXuat.txt");
            dslh.docFile("LoaiHang.txt");
            dsdo.docFile("Douong.txt");
            dsta.docFile("ThucAnNhanh.txt");
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}

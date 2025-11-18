import java.util.Scanner;

public class Chitietphieunhap {
    private Scanner sc = new Scanner(System.in);
    private String maNH;
    private String maSP;
    private String ngay;
    private int soluong;
    private double dongia;

    public Chitietphieunhap() {
        maNH = "";
        maSP = "";
        ngay = "";
        soluong = 0;
        dongia = 0;
    }

    public Chitietphieunhap(String maNH, String maSP, String ngay, int soluong, double dongia) {
        this.maNH = maNH;
        this.maSP = maSP;
        this.ngay = ngay;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public Chitietphieunhap(Chitietphieunhap ct) {
        this.maNH = ct.maNH;
        this.maSP = ct.maSP;
        this.ngay = ct.ngay;
        this.soluong = ct.soluong;
        this.dongia = ct.dongia;
    }

    // Nhập thông tin chi tiết phiếu nhập
    // nhapMa = true nếu muốn nhập mã, false nếu giữ mã hiện có
    public void nhap(boolean nhapMa) {
        if (nhapMa) {
            System.out.print("Mã chi tiết nhập hàng: ");
            maNH = sc.nextLine();
        }
        System.out.print("Mã chi tiết sản phẩm: ");
        maSP = sc.nextLine();
        System.out.print("Ngày nhập chi tiết sản phẩm: ");
        ngay = sc.nextLine();
        System.out.print("Số lượng: ");
        soluong = Integer.parseInt(sc.nextLine());
        System.out.print("Đơn giá: ");
        dongia = Double.parseDouble(sc.nextLine());
    }

    // Các getter và setter
    public String getmaNH() {
        return maNH;
    }

    public String getmaSP() {
        return maSP;
    }

    public String getngay() {
        return ngay;
    }

    public int getsoluong() {
        return soluong;
    }

    public double getdongia() {
        return dongia;
    }

    public void setmaNH(String maNH) {
        this.maNH = maNH;
    }

    public void setmaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setngay(String ngay) {
        this.ngay = ngay;
    }

    public void setsoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setdongia(double dongia) {
        this.dongia = dongia;
    }

    // Tính thành tiền
    public double thanhTien() {
        return soluong * dongia;
    }

    // Chuẩn hóa xuất ra màn hình
    @Override
    public String toString() {
        return maNH + " | Sản phẩm: " + maSP + " | Số lượng: " + soluong +
                " | Ngày nhập: " + ngay + " | Đơn giá: " + dongia +
                " | Thành tiền: " + thanhTien();
    }

    // Xuất ra file dễ đọc và đọc lại được
    public String toFileString() {
        return maNH + "-" + maSP + "-" + ngay + "-" + soluong + "-" + dongia;
    }
}

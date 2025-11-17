
import java.util.Scanner;

public abstract class MonAn {
    // Thuộc tính
    public String maSP;
    public String tenSP;
    public double giaBan;
    public int soLuong;

    java.util.Scanner sc = new Scanner(System.in);

    public abstract String getLoai();

    // Hàm thiết lập
    public MonAn() {
        super();
    }

    // Có tham số
    public MonAn(String maSP, String tenSP, double giaBan, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public MonAn(MonAn t) {
        this.maSP = t.maSP;
        this.tenSP = t.tenSP;
        this.giaBan = t.giaBan;
        this.soLuong = t.soLuong;
    }

    // Nhập xuất
    public void nhap() {
        System.out.print("Nhap ma SP: ");
        maSP = sc.nextLine();
        System.out.print("Nhap ten SP: ");
        tenSP = sc.nextLine();
        System.out.print("Nhap gia ban SP: ");
        giaBan = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập so luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf(
                "%-10s | %-20s | %-10.0f | %-10d ",
                maSP, tenSP, giaBan, soLuong);

    }

    // Get & Set
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Đa hình
    // public abstract void hienThiThongTin();

    // public abstract double tinhGiaSauKhuyenMai();

    // public abstract String getLoaiSanPham();

}

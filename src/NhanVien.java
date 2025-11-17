import java.util.Scanner;

public class NhanVien {
    public String maNV;
    public String hoNV;
    public String tenNV;
    public double luongCoBan;
    Scanner sc = new Scanner(System.in);

    public NhanVien() {
        this.maNV = "";
        this.hoNV = "";
        this.tenNV = "";
        this.luongCoBan = 0.0;
    }

    public NhanVien(String maNV, String hoNV, String tenNV, double luongCoBan) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNV = tenNV;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien(NhanVien t) {
        if (t != null) {
            this.maNV = t.maNV;
            this.hoNV = t.hoNV;
            this.tenNV = t.tenNV;
            this.luongCoBan = t.luongCoBan;
        }
    }

    @Override
    public String toString() {
        return maNV + "-" + hoNV + "-" + tenNV + "-" + luongCoBan;
    }

    public void nhap() {

        System.out.print("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        System.out.print("Nhap ho nhan vien: ");
        hoNV = sc.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        tenNV = sc.nextLine();
        System.out.print("Nhap luong co ban: ");
        luongCoBan = sc.nextDouble();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-8s %-15s %-10s %-2f\n", maNV, hoNV, tenNV, luongCoBan);
    }

    // Get
    public String getMaNV() {
        return maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public Double getLuongCoBan() {
        return luongCoBan;
    }

    // Set
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
}

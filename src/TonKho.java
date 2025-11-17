import java.util.Scanner;

public class TonKho {
    public String maKho;
    public String tenSanPham;
    public int soLuongTon;
    public double giaNhap;
    public String ngayNhap;
    public String nhaCungCap;

    public TonKho() {
        this.maKho = "";
        this.tenSanPham = "";
        this.soLuongTon = 0;
        this.giaNhap = 0.0;
        this.ngayNhap = "";
        this.nhaCungCap = "";
    }

    public TonKho(String maKho, String tenSanPham, int soLuongTon, double giaNhap, String ngayNhap, String nhaCungCap) {
        this.maKho = maKho;
        this.tenSanPham = tenSanPham;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.ngayNhap = ngayNhap;
        this.nhaCungCap = nhaCungCap;
    }

    public TonKho(TonKho t) {
        if (t != null) {
            this.maKho = t.maKho;
            this.tenSanPham = t.tenSanPham;
            this.soLuongTon = t.soLuongTon;
            this.giaNhap = t.giaNhap;
            this.ngayNhap = t.ngayNhap;
            this.nhaCungCap = t.nhaCungCap;
        }
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma kho: ");
        maKho = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        tenSanPham = sc.nextLine();
        System.out.print("Nhap so luong ton: ");
        soLuongTon = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap gia nhap: ");
        giaNhap = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap ngay nhap (dd/mm/yyyy): ");
        ngayNhap = sc.nextLine();
        System.out.print("Nhap nha cung cap: ");
        nhaCungCap = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s | %-20s | %-12s | %-12.0f | %-12s | %-15s\n",
                maKho, tenSanPham, soLuongTon, giaNhap, ngayNhap, nhaCungCap);
    }

    @Override
    public String toString() {
        return maKho + "-" + tenSanPham + "-" + soLuongTon + "-" + giaNhap + "-" + ngayNhap + "-" + nhaCungCap;
    }

    // Getter/Setter
    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
}

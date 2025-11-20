import java.util.Scanner;

public class KHO {
    public String maHang;
    public String tenHang;
    public int soLuong;
    public double donGia;
    Scanner sc = new Scanner(System.in);

    // Hàm thiết lập
    public KHO() {
        this.maHang = "";
        this.tenHang = "";
        this.soLuong = 0;
        this.donGia = 0.0;
    }

    // Hàm thiết lập có tham số
    public KHO(String maHang, String tenHang, int soLuong, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Hàm sao chép
    public KHO(KHO t) {
        if (t != null) {
            this.maHang = t.maHang;
            this.tenHang = t.tenHang;
            this.soLuong = t.soLuong;
            this.donGia = t.donGia;
        }
    }

    // Nhập xuất
    public void nhap() {

        System.out.print("Nhap ma hang: ");
        maHang = sc.nextLine();

        System.out.print("Nhap ten hang: ");
        tenHang = sc.nextLine();

        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());
    }

    // loai hang
    public String getLoai() {
        return "K";
    }

    @Override
    public String toString() {
        return "KHO [maHang=" + maHang + ", tenHang=" + tenHang + ", soLuong=" + soLuong + ", donGia=" + donGia + "]";
    }

    public void xuat() {
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("So luong: " + soLuong);
        System.out.println("Don gia: " + donGia);
    }

    // get/set
    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
}
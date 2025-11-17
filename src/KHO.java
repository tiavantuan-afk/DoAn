import java.util.Scanner;

public class KHO {
    private String tenHang;
    private int maHang;
    private int soLuong;
    private double donGia;

    // Hàm thiết lập
    public KHO() {
        tenHang = "";
        maHang = 0;
        soLuong = 0;
        donGia = 0.0;
    }

    // Hàm thiết lập có tham số
    public KHO(String tenHang, int maHang, int soLuong, double donGia) {
        this.tenHang = tenHang;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Hàm sao chép
    public KHO(KHO t) {
        if (t != null) {
            this.tenHang = t.tenHang;
            this.maHang = t.maHang;
            this.soLuong = t.soLuong;
            this.donGia = t.donGia;
        }
    }

    // Nhập xuất
    public void nhap() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên hàng: ");
        tenHang = sc.nextLine();

        System.out.print("Nhập mã hàng: ");
        maHang = sc.nextInt();

        System.out.print("Nhập số lượng: ");
        soLuong = sc.nextInt();

        System.out.print("Nhập đơn giá: ");
        donGia = sc.nextDouble();
    }

    public void xuat() {
        System.out.println("=== Thông tin hàng hóa ===");
        System.out.println("Tên hàng: " + tenHang);
        System.out.println("Mã hàng: " + maHang);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Đơn giá: " + donGia);
    }

    // GET
    public String getTenHang() { 
        return tenHang; 
    }
    public int getMaHang() { 
        return maHang; 
    }
    public int getSoLuong() { 
        return soLuong;
    }
    public double getDonGia() {
        return donGia; 
    }

    // SET
    public void setTenHang(String tenHang) { 
        this.tenHang = tenHang; 
    }
    public void setMaHang(int maHang) { 
        this.maHang = maHang; 
    }
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong; 
    }
    public void setDonGia(double donGia) { 
        this.donGia = donGia; 
    }
}



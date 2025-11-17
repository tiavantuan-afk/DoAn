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

<<<<<<< HEAD
    public void nhap(){
        System.out.println("Mã chi tiet nhập hàng: ");
        maNH=sc.nextLine();
        System.out.println("Mã chi tiet sản phẩm: ");
        maSP=sc.nextLine();
        System.out.println("ngay nhap chi tiet san pham: ");
        ngay=sc.nextLine();
        System.out.println("Số lượng: ");
        soluong=sc.nextInt();
        System.out.println("Đơn giá: ");
        dongia=Double.parseDouble(sc.nextLine());
=======
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
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
    }

    // Các getter và setter
    public String getmaNH() { 
        return maNH; 
    }
    public String getmaSP() { 
        return maSP; 
    }
<<<<<<< HEAD
    public String getngay(){
        return ngay;
    }
    public int getsoluong(){
        return soluong;
=======
    public String getngay() { 
        return ngay; 
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
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
<<<<<<< HEAD
    public void setngay(String ngay){
        this.ngay = ngay;
    }
    public void setsoluong(int soluong){
        this.soluong = soluong;
=======
    public void setmaSP(String maSP) { 
        this.maSP = maSP; 
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
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
<<<<<<< HEAD
    public String toString(){
        return maNH +" | Sản phẩm: " + maSP + " | Số lượng: " + soluong +"| ngay nhap :" + ngay + " | Đơn giá: " + dongia + " | Thành tiền: " +thanhTien();
=======
    public String toString() {
        return maNH + " | Sản phẩm: " + maSP + " | Số lượng: " + soluong +
               " | Ngày nhập: " + ngay + " | Đơn giá: " + dongia +
               " | Thành tiền: " + thanhTien();
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
    }

    // Xuất ra file dễ đọc và đọc lại được
    public String toFileString() {
        return maNH + "-" + maSP + "-" + ngay + "-" + soluong + "-" + dongia;
    }
}

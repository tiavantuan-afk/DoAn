import java.util.Scanner;

public class KHACHHANG {
    private String ho;
    private String ten;
    private String Makh;
    private String SDT;
    Scanner sc = new Scanner(System.in);

    public KHACHHANG() {
        ho = "";
        ten = "";
        Makh = "";
        SDT = "";
    }

    public KHACHHANG(String ho, String ten, String Makh, String SDT) {
        this.ho = ho;
        this.ten = ten;
        this.Makh = Makh;
        this.SDT = SDT;
    }

    public KHACHHANG(KHACHHANG t) {
        if (t != null) {
            this.ho = t.ho;
            this.ten = t.ten;
            this.Makh = t.Makh;
            this.SDT = t.SDT;
        }
    }

    public void nhap() {

        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        Makh = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        SDT = sc.nextLine();
    }

    public void xuat() {
        System.out.println("Thong tin khach hang: ");
        System.out.print("Ho: " + ho + "\n");
        System.out.print("Ten: " + ten + "\n");
        System.out.print("Ma khach hang: " + Makh + "\n");
        System.out.print("So dien thoai: " + SDT + "\n");
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getMaKH() {
        return Makh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMakh(String Makh) {
        this.Makh = Makh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}

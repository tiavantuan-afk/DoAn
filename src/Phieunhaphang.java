
import java.util.Scanner;

public class Phieunhaphang {
    Scanner sc = new Scanner(System.in);
    public String maPNH;
    public String maNV;
    public String ngay;
    public String maNcc;
    public double tongtien;

    Phieunhaphang() {
        maPNH = "";
        maNV = "";
        ngay = "";
        maNcc = "";
        tongtien = 0;
    }

    Phieunhaphang(String maPNH, String maNV, String ngay, String maNcc, double tongtien) {
        this.maPNH = maPNH;
        this.maNV = maNV;
        this.ngay = ngay;
        this.maNcc = maNcc;
        this.tongtien = tongtien;
    }

    Phieunhaphang(Phieunhaphang t) {
        maPNH = t.maPNH;
        maNV = t.maNV;
        maNcc = t.maNcc;
        tongtien = t.tongtien;
    }

    @Override
    public String toString() {
        return String.join("-", maPNH, maNV, ngay, maNcc, String.valueOf(tongtien));
    }

    public void nhap(String maPNH, double tongtien) {
        this.maPNH = maPNH;
        System.out.println("Mã nhân viên: ");
        maNV = sc.nextLine();
        System.out.println("Ngày nhập hàng: ");
        ngay = sc.nextLine();
        System.out.println("Nhà cung cấp: ");
        maNcc = sc.nextLine();
        this.tongtien = tongtien;

    }

    public void xuat() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║               THONG TIN PHIEU NHAP           ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.printf("║ %-17s: %-25s ║%n", "Ma phieu nhap hang", maPNH);
        System.out.printf("║ %-17s: %-25s ║%n", "Ngay nhap", ngay);
        System.out.printf("║ %-17s: %-25s ║%n", "Ma nhan vien", maNV);
        System.out.printf("║ %-17s: %-25.0f ║%n", "Ma nha cung cap", maNcc);
        System.out.printf("║ %-17s: %-25s ║%n", "Tong tien", tongtien);
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public String getmaPNH() {
        return maPNH;
    }

    public void setmaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public String getmaNV() {
        return maNV;
    }

    public void setmaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getngay() {
        return ngay;
    }

    public void setngay(String ngay) {
        this.ngay = ngay;
    }

    public String getmaNcc() {
        return maNcc;
    }

    public void setmaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public Double gettongtien() {
        return tongtien;
    }

    public void settongtien(Double tongtien) {
        this.tongtien = tongtien;
    }

}
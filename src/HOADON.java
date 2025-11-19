import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HOADON {
    private String Mahd;
    private String Manv;
    private String Makh;
    private String Ngay;
    private double Tongtien;
    Scanner sc = new Scanner(System.in);

    public HOADON() {
        Mahd = "";
        Manv = "";
        Makh = "";
        Ngay = "";
        Tongtien = 0.0;
    }

    public HOADON(String Mahd, String Manv, String Makh, String Ngay, double Tongtien) {
        this.Mahd = Mahd;
        this.Manv = Manv;
        this.Makh = Makh;
        this.Ngay = Ngay;
        this.Tongtien = Tongtien;
    }

    public HOADON(HOADON h) {
        if (h != null) {
            this.Mahd = h.Mahd;
            this.Manv = h.Manv;
            this.Makh = h.Makh;
            this.Ngay = h.Ngay;
            this.Tongtien = h.Tongtien;
        }
    }

    public void nhap(String Mahd, double Tongtien) {
        this.Mahd = Mahd;
        System.out.print("Nhap ma nhan vien: ");
        Manv = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        Makh = sc.nextLine();
        System.out.print("Nhap ngay xuat hoa don: ");
        Ngay = sc.nextLine();
        this.Tongtien = 0.0;
    }

    public void xuat() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15d\n",
                Mahd, Manv, Makh, Ngay, Tongtien);
    }

    public String getMahd() {
        return Mahd;
    }

    public String getManv() {
        return Manv;
    }

    public String getMakh() {
        return Makh;
    }

    public String getNgay() {
        return Ngay;
    }

    public double getTongtien() {
        return Tongtien;
    }

    public void setMahd(String Mahd) {
        this.Mahd = Mahd;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public void setMakh(String Makh) {
        this.Makh = Makh;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public void setTongTien(double Tongtien) {
        this.Tongtien = Tongtien;
    }

    @Override
    public String toString() {
        return Mahd + "-" + Manv + "-" + Makh + "-" + Ngay + "-" + Tongtien;
    }

    public void ghiFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("HoaDonout.txt", true))) {
            bw.write(Mahd + "," + Manv + "," + Makh + "," + Ngay + "," + Tongtien);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
}

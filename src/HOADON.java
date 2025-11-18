import java.util.Scanner;
public class HOADON {
    private String Mahd;
    private String Manv;
    private String Makh;
    private String Ngay;
    private double Tongtien;  
    public HOADON(){
        Mahd = "";
        Manv = "";
        Makh = "";
        Ngay = "";
        Tongtien = 0.0;
    }
    public HOADON(String Mahd, String Manv, String Makh, String Ngay, double Tongtien){
        this.Mahd = Mahd;
        this.Manv = Manv;
        this.Makh = Makh;
        this.Ngay = Ngay;
        this.Tongtien = Tongtien;
    }
    public HOADON(HOADON h){
        if (h != null){
        this.Mahd = h.Mahd;
        this.Manv = h.Manv;
        this.Makh = h.Makh;
        this.Ngay = h.Ngay;
        this.Tongtien = h.Tongtien;
        }
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        Mahd = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        Manv = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        Makh = sc.nextLine();
        System.out.print("Nhap ngay xuat hoa don: ");
        Ngay = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        Tongtien = sc.nextDouble();
    }
    public void xuat(){
        System.out.println("Hoa don: ");
        System.out.println("Ma hoa don: "+Mahd);
        System.out.println("Ma nhan vien: "+Manv);
        System.out.println("Ma khach hang: "+Makh);
        System.out.println("Ngay xuat: "+Ngay);
        System.out.println("Tong tien: "+Tongtien);
    }
    public String getMahd(){
        return Mahd;
    }
    public String getManv(){
        return Manv;
    }
    public String getMakh(){
        return Makh;
    }
    public String getNgay(){
        return Ngay;
    }    
    public double getTongtien(){
        return Tongtien;
    }
    public void setMahd(String Mahd){
        this.Mahd = Mahd;
    }
    public void setManv(String Manv){
        this.Manv = Manv;
    }
    public void setMakh(String Makh){
        this.Makh = Makh;
    }
    public void setNgay(String Ngay){
        this.Ngay = Ngay;
    }
    public void setTongTien(double Tongtien){
        this.Tongtien = Tongtien;
    }
}

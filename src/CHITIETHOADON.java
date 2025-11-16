import java.util.Scanner;
public class CHITIETHOADON {
    private String Mahd;
    private String Masp;
    private String Makh;
    private int SL;
    private double DG;
    private double Thanhtien;
    public CHITIETHOADON(){
        Mahd = "";
        Masp = "";
        Makh = "";
        SL = 0;
        DG = 0;
        Thanhtien = 0.0;
    }
    public CHITIETHOADON(String Mahd, String Masp, String Makh, int SL, double DG, double Thanhtien){
        this.Mahd = Mahd;
        this.Masp = Masp;
        this.Makh = Makh;
        this.SL = SL;
        this.DG = DG;
        this.Thanhtien = Thanhtien;
    }
    public CHITIETHOADON(CHITIETHOADON t){
        if (t != null){
        this.Mahd = t.Mahd;
        this.Masp = t.Masp;
        this.Makh = t.Makh;
        this.SL = t.SL;
        this.DG = t.DG;
        this.Thanhtien = t.Thanhtien;
        }
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        Mahd = sc.nextLine();
        System.out.print("Nhap ma san pham:");
        Masp = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        Makh = sc.nextLine();
        System.out.print("Nhap so luong: ");
        SL = sc.nextInt();
        System.out.print("Nhap don gia: ");
        DG = sc.nextInt();
        System.out.print("Nhap so thanh tien: ");
        Thanhtien = sc.nextDouble();
        sc.close();
    }
    public void xuat(){
        System.out.println("Chi tiet hoa don: ");
        System.out.println("Ma hoa don: "+Mahd);
        System.out.println("Ma san phan: "+Masp);
        System.out.println("Ma khach hang: "+Makh);
        System.out.println("So luong: "+SL);
        System.out.println("Don gia: "+DG);
        System.out.println("Thanh tien: "+Thanhtien);
    }
    public String getMahd(){
        return Mahd;
    }
    public String getMasp(){
        return Masp;
    }
    public String getMakh(){
        return Makh;
    }
    public int getSL(){
        return SL;
    }
    public double getDG(){
        return DG;
    }
    public double getThanhtien(){
        return Thanhtien;
    }
    public void setMahd(String Mahd){
        this.Mahd = Mahd;
    }
    public void setMasp(String Masp){
        this.Masp = Masp;
    }
    public void setMakh(String Makh){
        this.Makh = Makh;
    }
    public void setSL(int SL){
        this.SL = SL;
    }
    public void setDG(double DG){
        this.DG = DG;
    }
    public void setThanhtien(double Thanhtien){
        this.Thanhtien = Thanhtien;
    }
    
}

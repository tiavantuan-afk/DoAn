import java.util.Scanner;

public class Nguyenlieu {
    Scanner sc = new Scanner(System.in);
    private String maNL;
    private String tenNL;
    private double dongia;
    
    public Nguyenlieu(){
        maNL="";
        tenNL="";
        dongia=0;
    }
    public Nguyenlieu(String maNL,String tenNL,double dongia){
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.dongia = dongia;
    }
    public void nhap(){
        System.out.print("Mã nguyên liệu: ");
        maNL = sc.nextLine();
        System.out.print("Tên nguyên liệu: ");
        tenNL = sc.nextLine();
        System.out.print("Đơn giá: ");
        dongia = Double.parseDouble(sc.nextLine());
    }

    public void xuat(){
        System.out.println(this.toString());
    }
    public String getmaNL(){
        return maNL;
    }
    public void setmaNL(String maNL){
        this.maNL = maNL;
    }
    public String gettenNL(){
        return tenNL;
    }
    public void settenNL(String tenNL){
        this.tenNL = tenNL;
    }
    public double getdongia(){
        return dongia;
    }
    public void setdongia(double dongia){
        this.dongia = dongia;
    }
    @Override
    public String toString(){
        return maNL + " | " + tenNL + " | Đơn giá: " +dongia;
    }
}

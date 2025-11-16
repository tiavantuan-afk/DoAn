import java.util.Scanner;
public class Chitietphieunhap{
    Scanner sc= new Scanner(System.in);
    private String maNH;
    private String maSP;
    private int soluong;
    private double dongia;

    public Chitietphieunhap(){
        maNH="";
        maSP="";
        soluong=0;
        dongia=0;
    }
    public Chitietphieunhap(String maNH,String maSP,int soluong,double dongia){
        this.maNH = maNH;
        this.maSP = maSP;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    public Chitietphieunhap(Chitietphieunhap ct){
        this.maNH = ct.maNH;
        this.maSP = ct.maSP;
        this.soluong = ct.soluong;
        this.dongia = ct.dongia;
    }

    public void nhap(){
        System.out.println("Mã nhập hàng: ");
        maNH=sc.nextLine();
        System.out.println("Mã sản phẩm: ");
        maSP=sc.nextLine();
        System.out.println("Số lượng: ");
        soluong=sc.nextInt();
        System.out.println("Đơn giá: ");
        dongia=Double.parseDouble(sc.nextLine());
    }
    
    public String getmaNH(){
        return maNH;
    }
    public String getmaSP(){
        return maSP;
    }
    public int getsoluong(){
        return soluong;
    }
    public double getdongia(){
        return dongia;
    }
    public void setmaNH(String maNH){
        this.maNH = maNH;
    }
    public void setmaSP(String maSP){
        this.maSP = maSP;
    }
    public void setsoluong(int soluong){
        this.soluong = soluong;
    }
    public void setdongia(double dongia){
        this.dongia = dongia;
    }
    public double thanhTien(){
        return soluong * dongia;
    }
    @Override
    public String toString(){
        return maNH +" | Sản phẩm: " + maSP + " | Số lượng: " + soluong + " | Đơn giá: " + dongia + " | Thành tiền: " +thanhTien();
    }
}
import java.util.ArrayList;
import java.util.Scanner;
public class Phieunhaphang {
    Scanner sc = new Scanner(System.in);
    private String maPNH;
    private String maNV;
    private String ngay;
    private String maNcc;
    private ArrayList<Chitietphieunhap> Danhsachchitiet;
    
    public Phieunhaphang(){
        Danhsachchitiet = new ArrayList<>();
    }
    public String getmaPNH(){
        return maPNH;
    }
    public void setmaPNH(String maPNH){
        this.maPNH = maPNH;
    }
    public String getmaNV(){
        return maNV;
    }
    public void setmaNV(String maNV){
        this.maNV = maNV;
    }
    public String getngay(){
        return ngay;
    }
    public void setngay(String ngay){
        this.ngay = ngay;
    }
    public String getmaNcc(){
        return maNcc;
    }
    public void setmaNcc(String maNcc){
        this.maNcc = maNcc;
    }
    public ArrayList<Chitietphieunhap> getDanhsachchitiet(){
        return Danhsachchitiet;
    }
    public void setDanhsachchitiet(ArrayList<Chitietphieunhap> Danhsachchitiet){
        this.Danhsachchitiet = Danhsachchitiet;
    }
    public void nhap(){
        System.out.println("Mã phiếu nhập hàng: ");
        maPNH = sc.nextLine();
        System.out.println("Mã nhân viên: ");
        maNV = sc.nextLine();
        System.out.println("Ngày nhập hàng: ");
        ngay = sc.nextLine();
        System.out.println("Nhà cung cấp: ");
        maNcc = sc.nextLine();
        System.out.println("Số mặt hàng: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<n;i++){
            System.out.println("Chi tiết hàng "+(i+1));
            Chitietphieunhap ct = new Chitietphieunhap();
            ct.nhap();
            Danhsachchitiet.add(ct);
        }
    }
    public double tien(){
        double s = 0;
        for(Chitietphieunhap ct : Danhsachchitiet) {
            s+=ct.thanhTien();
        }
        return s;
    }
    @Override
    public String toString(){
        String s = " Phiếu nhập hàng";
        s+= "Mã PN: " + maPNH +"| Ngày nhập hàng: " + ngay + "\n";
        s+= "Nhà cung cấp: " + maNcc +"\n Danh sách chi tiết \n";

        for(Chitietphieunhap ct : Danhsachchitiet){
            s+= ct.toString() + "\n";
        }
        s+="\nTổng tiền: " + tien() + "VND\n";
        return s;
    }
}
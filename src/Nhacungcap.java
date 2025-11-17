import java.util.Scanner;
public class Nhacungcap{
    Scanner sc = new Scanner(System.in);
    private String maNCC;
    private String hoNCC;
    private String tenNCC;
    private String diachi;
    private String sdt;
    
    public Nhacungcap(){
        maNCC="";
        hoNCC="";
        tenNCC="";
        diachi="";
        sdt="";
    }
    public Nhacungcap(String maNCC,String hoNCC, String tenNCC,String diachi,String sdt){
        this.maNCC = maNCC;
        this.hoNCC = hoNCC;
        this.tenNCC = tenNCC;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public Nhacungcap(Nhacungcap ncc) {
        this.maNCC = ncc.maNCC;
        this.hoNCC = ncc.hoNCC;
        this.tenNCC = ncc.tenNCC;
        this.diachi = ncc.diachi;
        this.sdt = ncc.sdt;
    }


    public void nhap(){
        System.out.print("Nhập mã nhà cung cấp: ");
        maNCC = sc.nextLine();
        System.out.print("Nhập họ nhà cung cấp: ");
        hoNCC = sc.nextLine();
        System.out.print("Nhập tên nhà cung cấp: ");
        tenNCC = sc.nextLine();
        System.out.print("Địa chỉ nhà cung cấp: ");
        diachi = sc.nextLine();
        System.out.print("Số điện thoại: ");
        sdt = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%-8s %-15s %-10s %-20s %-10s\n", maNCC, hoNCC, tenNCC,diachi,sdt );
    }
    public String getmaNCC() {
        return maNCC;
    }

    public void setmaNCC(String maNCC){
        this.maNCC = maNCC;
    }
    
    public String gethoNCC(){
        return hoNCC;
    }

    public void sethoNCC(String hoNCC){
        this.hoNCC = hoNCC;
    }
    public String gettenNCC(){
        return tenNCC;
    }

    public void settenNCC(String tenNCC){
        this.tenNCC = tenNCC;
    }

    public String getdiachi(){
        return diachi;
    }

    public void setdiachi(String diachi){
        this.diachi = diachi;
    }

    public String getsdt(){
        return sdt;
    }

    public void setsdt(String sdt){
        this.sdt = sdt;
    }

    @Override
    public String toString(){
        return "Nhacungcap{" + "maNCC='" + maNCC + '\'' + ", tenNCC='" + tenNCC +'\'' + ", diachi='" + diachi +'\'' +", sdt ='" + sdt + '\'' +'}';
    }
}
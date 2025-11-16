import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Phieunhaphang {
    Scanner sc = new Scanner(System.in);
    private String maNH;
    private String maNV;
    private String ngay;
    private String maNCC;
    private ArrayList<Chitietphieunhap> Danhsachchitiet;
    
    public Phieunhaphang(){
        Danhsachchitiet = new ArrayList<>();
    }
    public String getmaNH(){
        return maNH;
    }
    public void setmaPN(String maNH){
        this.maNH = maNH;
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
    public String getmaNCC(){
        return maNCC;
    }
    public void setncc(String maNCC){
        this.maNCC = maNCC;
    }
    public ArrayList<Chitietphieunhap> getDanhsachchitiet(){
        return Danhsachchitiet;
    }
    public void setDanhsachchitiet(ArrayList<Chitietphieunhap> Danhsachchitiet){
        this.Danhsachchitiet = Danhsachchitiet;
    }
    public void nhap(){
        System.out.println("Mã phiếu nhập hàng: ");
        maNH = sc.nextLine();
        System.out.println("Mã nhân viên: ");
        maNV = sc.nextLine();
        System.out.println("Ngày nhập hàng: ");
        ngay = sc.nextLine();
        System.out.println("Nhà cung cấp: ");
        maNCC = sc.nextLine();
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
        s+= "Mã PN: " + maNH +"| Ngày nhập hàng: " + ngay + "\n";
        s+= "Nhà cung cấp: " + maNCC +"\n Danh sách chi tiết \n";

        for(Chitietphieunhap ct : Danhsachchitiet){
            s+= ct.toString() + "\n";
        }
        s+="\nTổng tiền: " + tien() + "VND\n";
        return s;
    }
    public void docFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            maNH = br.readLine();
            maNV = br.readLine();
            ngay = br.readLine();
            maNCC = br.readLine();
            
            int n = Integer.parseInt(br.readLine());
            Danhsachchitiet = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Chitietphieunhap ct = new Chitietphieunhap();
                ct.docFile(br);
                Danhsachchitiet.add(ct);
            }

        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
    public void ghiFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(maNH); bw.newLine();
            bw.write(maNV); bw.newLine();
            bw.write(ngay); bw.newLine();
            bw.write(maNCC); bw.newLine();
            bw.write(String.valueOf(Danhsachchitiet.size())); bw.newLine();
            for (Chitietphieunhap ct : Danhsachchitiet) {
                ct.ghiFile(bw);
            }

            System.out.println("Ghi file thành công!");

        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
    public class MenuPhieuNhap{
        Phieunhaphang phieu = new Phieunhaphang();
        int chon = -1;
        do{
            System.out.println("MENU PHIẾU NHẬP");
            System.out.println("1. Nhập phiếu nhập");
            System.out.println("2. Xem phiếu nhập");
            System.out.println("3. Chi tiết phiếu nhập");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();
        switch (chon) {
                case 1:
                    nhap();
                    break;

                case 2:
                    System.out.println(phieu.toString());
                    break;

                case 3:
                    Chitietphieunhap ct = new Chitietphieunhap();
                    ct.menuchitietphieunhap();
                    break;

                case 0:
                    System.out.println("Thoat");
                    break;

                default:
                    System.out.println("Chon lai");
            }

        }while(chon != 0);
    }
}
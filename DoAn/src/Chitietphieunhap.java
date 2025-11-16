import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Chitietphieunhap{
    Scanner sc= new Scanner(System.in);
    private String maNH;
    private String maSP;
    private int soluong;
    private double dongia;
    private ArrayList<Chitietphieunhap> ds = new ArrayList<>();

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
    
    public void themtheoma() {
        System.out.print("Nhap ma can them: ");
        String macanthem = sc.nextLine();
        for (Chitietphieunhap ct : ds) {
            if (ct.getmaNH().equalsIgnoreCase(macanthem)) {
                System.out.println("Ma đa ton tai:");
                System.out.println(ct);
                return;
            }
        }
        Chitietphieunhap newCT = new Chitietphieunhap();
        newCT.nhap();
        ds.add(newCT);
        System.out.println("Đa them");
    }
    public void suatheoma() {
        System.out.print("Nhap ma can sua: ");
        String macansua = sc.nextLine();
        for (Chitietphieunhap ct : ds) {
            if (ct.getmaNH().equalsIgnoreCase(macansua)) {
                System.out.println("Tim thay:");
                System.out.println(ct);
                System.out.println("Nhap thong tin can sua:");
                ct.nhap();
                System.out.println("Đa sua");
                return;
            }
        }
        System.out.println("Khong tim thay ma");
    }
    public void xoatheoma() {
        System.out.print("Nhap ma can xoa: ");
        String macanxoa = sc.nextLine();
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getmaNH().equalsIgnoreCase(macanxoa)) {
                ds.remove(i);
                System.out.println("Da xoa");
                return;
            }
        }
        System.out.println("Khong tim thay ma");
    }
    public void timtheoma() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã nhập hàng cần tìm: ");
        String ma = sc.nextLine();
        for(Chitietphieunhap ct : ds) {
            if (ct.getmaNH().equalsIgnoreCase(ma)) {
                System.out.println("Tìm thấy:");
                System.out.println(ct);
                return;
            }
        }
        System.out.println("Không tìm thấy mã trong danh sách!");
    }
    public void ghiFile(BufferedWriter bw) throws IOException {
        bw.write(maNH); 
        bw.newLine();
        bw.write(maSP); 
        bw.newLine();
        bw.write(String.valueOf(soluong)); 
        bw.newLine();
        bw.write(String.valueOf(dongia)); 
        bw.newLine();
    }
    
    public void docFile(BufferedReader br) throws IOException {
        maNH = br.readLine();
        maSP = br.readLine();
        soluong = Integer.parseInt(br.readLine());
        dongia = Double.parseDouble(br.readLine());
    }
    public void menuchitietphieunhap(){
        int chon = -1;
        do {
            System.out.println("CHI TIẾT PHIẾU NHẬP");
            System.out.println("1. Nhap chi tiet phieu nhap");
            System.out.println("2. them theo ma nhap hang");
            System.out.println("3. sua theo ma nhap hang");
            System.out.println("4. xoa theo ma nhap hang");
            System.out.println("5. Tim theo ma nhap hang");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch(chon) {
                case 1: 
                    nhap(); 
                    break;
                case 2: 
                    themtheoma(); 
                    break;
                case 3: 
                    xoatheoma(); 
                    break;
                case 4: 
                    suatheoma(); 
                    break;
                case 5:
                    timtheoma();
                    break;
                case 0: 
                    System.out.println("Thoát menu"); 
                    return;
                default:  
                    System.out.println("Lua chon khac");
                    break;
            }

        } while (chon != 0);
        sc.close();
    }
    public static void main(String[] args){
        Chitietphieunhap ctpn = new Chitietphieunhap();
        ctpn.menuchitietphieunhap();
    }
}
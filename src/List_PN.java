import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List_PN{
    Scanner sc = new Scanner(System.in);
    private int n;
    private Phieunhaphang[] ds = new Phieunhaphang[100];

    public void nhap() {
        System.out.print("So luong phieu nhap hang: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Phieu nhap hang thu " + (i + 1) + ":");
            ds[i] = new Phieunhaphang();
            ds[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("DANH SACH PHIEU NHAP HANG");
        for (int i = 0; i < n; i++) {
            System.out.println(ds[i]);
        }
    }
    
    public void docFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            Phieunhaphang x = null;
            ds = new Phieunhaphang[0];
            while ((line = br.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 3){
                    x = new Phieunhaphang();
                    x.setmaPNH(t[0]);
                    x.setmaNV(t[1]); 
                    x.setngay(t[2]);
                    x.setmaNcc((t[3]));
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    System.out.println("Doc: " + x.getmaPNH() + " - " + x.getmaNV() + " " + x.getngay()+" "+x.getmaNcc());

                } 
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: "+ n);
        }catch (IOException e){
            System.out.println("Loi doc file: "+e.getMessage());
        }
    }
    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i=0; i<n; i++){
                if (ds[i] != null){
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: "+n+ " khach");
        }catch (IOException e){
            System.out.println("Loi ghi file");
        }   
    }
     public boolean OneIDPN(String mapn){
        if(mapn == null)
        return false;
        for(int i = 0;i<ds.length;i++){
            if(ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(mapn)){
                return true;
            }
        }
        return false;
    }
    public void themtheoma(){
        System.out.println("Them nha cung cap");
        Phieunhaphang pnmoi = new Phieunhaphang();
        pnmoi.nhap();
        if(!OneIDPN(pnmoi.getmaPNH())){
            System.out.print("Ma nha cung cap" + pnmoi.getmaPNH()+ "da ton tai");
        }
        ds = Arrays.copyOf(ds,ds.length + 1);
        ds[ds.length - 1] =pnmoi;
    }

    public void timTheoMa(String macantim) {
         boolean tim = false;
          for(int i = 0;i < ds.length; i++){
            if (ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(macantim)){
            ds[i].toString();
            tim = true;
            break;  
            }
        }
        if (!tim)
            System.out.println("Khong tim thay!!! ");
    }
    
    
    public void xoatheoma(String macanxoa){
       boolean xoa = false;
           for(int i =0;i<ds.length;i++){
            if(ds[i] != null && ds[i].getmaPNH() != null &&  ds[i].getmaPNH().equalsIgnoreCase(macanxoa)){
                ds[i].toString();
                for (int j = i;j < ds.length -1;j++){
                    ds[j] = ds[j+1];
                }
                ds = Arrays.copyOf(ds,ds.length-1);
                System.out.print("Xoa thanh cong");
                xoa = true;
                return;
            }
           }
        if (!xoa) {
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã " + macanxoa);
        }
    }

    public void suatheoma(){
        System.out.println("Mã cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;
        for(int i = 0; i < n; i++){
            if(ds[i].getmaPNH().equalsIgnoreCase(macansua)){
                System.out.println("Tìm thấy phieu nhap hang: ");
                ds[i].toString();
                System.out.println("Thông tin cần sửa cho phieu nhap hang: ");
                ds[i] = new Phieunhaphang();
                ds[i].toString();
                System.out.println("Đã sửa thông tin cho phieu nhap hang có mã "+ macansua);
                dasua = true;
                return;
            }
        }
        if(!dasua){
            System.out.println("Không tìm thấy phieu nhap hang có mã "+ macansua);
        }
    }
    public void thongketheongay() {
        String[] ngaydadem = new String[100];
        int[] soLuong = new int[100];
        int dem = 0;
        for (int i = 0; i < n; i++) {
            String ho = ds[i].getngay();
            int index = -1;
            for (int j = 0; j < dem; j++) {
                if (ngaydadem[j].equalsIgnoreCase(ho)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) { 
                ngaydadem[dem] = ho;
                soLuong[dem] = 1;
                dem++;
            } else {
                soLuong[index]++;
            }
        }
        System.out.println("\nThong ke theo ho");
        System.out.printf("%-15s %-10s\n", "Họ", "Số lượng");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-15s %-10d\n", ngaydadem[i], soLuong[i]);
        }
    }
}


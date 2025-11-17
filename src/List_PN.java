import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List_PN {
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

    public void themtheoma(){
        System.out.println("Mã cần thêm: ");
        String macanthem = sc.nextLine();
        boolean themma = false;
        for(int i = 0;i < n; i++){
            if(ds[i].getmaPNH().equalsIgnoreCase(macanthem)){
                themma = true;
                return;
                }
            }
            if(themma){
                System.out.print("Mã " + macanthem + "đã tồn tại trong danh sách");
            }
            if(n >= 100){
                System.out.print("Danh sách đã đầy");
                return;
            }
            System.out.println("Nhập thông tin phiêu nhap hang mới có mã " + macanthem);
            ds[n] = new Phieunhaphang();
            ds[n].nhap();
            ds[n].setmaPNH(macanthem);
            n++;
    }

    public void timTheoMa() {
        System.out.print("Nhap ma can tim: ");
        String ma = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getmaPNH().equalsIgnoreCase(ma)) {
                System.out.println("Tim thay: " + ds[i]);
                return;
            }
        }
        System.out.println("Khong tim thay!");
    }
    
    public void xoatheoma(){
        System.out.print("Mã cần xoá: ");
        String macanxoa = sc.nextLine();
        boolean daxoa = false;
        for(int i = 0;i < n; i++){
            if(ds[i].getmaPNH().equalsIgnoreCase(macanxoa)){
                for(int j = i;j < n-1;j++){
                    ds[j] = ds[j+1];
                }
                ds[n-1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá phieu nhap hang có mã " + macanxoa);
                return;
            }
        }
        if(!daxoa){
            System.out.println("Không tìm thấy phieu nhap hang có mã" + macanxoa);
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


import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.BufferedWriter;
=======
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List_CTPN {
    Scanner sc = new Scanner(System.in);
    private int n;
    private Chitietphieunhap[] ds = new Chitietphieunhap[100];

<<<<<<< HEAD
=======
    // Nhập danh sách
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
    public void nhap() {
        System.out.print("So luong chi tiet phieu nhap: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Chi tiet phieu nhap " + (i + 1) + ":");
            ds[i] = new Chitietphieunhap();
<<<<<<< HEAD
            ds[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("DANH SACH CHI TIET PHIEU NHAP");
        for (int i = 0; i < n; i++) {
            System.out.println(ds[i]);
        }
    }
    
=======
            ds[i].nhap(true);
        }
    }

    // Xuất danh sách
    public void xuat() {
        System.out.println("DANH SACH CHI TIET PHIEU NHAP");
        for (int i = 0; i < n; i++) {
            if(ds[i] != null)
                System.out.println(ds[i]);
        }
    }

    // Thống kê theo ngày
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
    public void thongketheongay() {
        String[] ngaydadem = new String[100];
        int[] soLuong = new int[100];
        int dem = 0;
<<<<<<< HEAD
        for (int i = 0; i < n; i++) {
            String ho = ds[i].getngay();
            int index = -1;
            for (int j = 0; j < dem; j++) {
                if (ngaydadem[j].equalsIgnoreCase(ho)) {
=======

        for (int i = 0; i < n; i++) {
            String ngay = ds[i].getngay();
            int index = -1;
            for (int j = 0; j < dem; j++) {
                if (ngaydadem[j].equalsIgnoreCase(ngay)) {
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
                    index = j;
                    break;
                }
            }
<<<<<<< HEAD
            if (index == -1) { 
                ngaydadem[dem] = ho;
=======
            if (index == -1) {
                ngaydadem[dem] = ngay;
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
                soLuong[dem] = 1;
                dem++;
            } else {
                soLuong[index]++;
            }
        }
<<<<<<< HEAD
        System.out.println("\nThong ke theo ho");
        System.out.printf("%-15s %-10s\n", "Họ", "Số lượng");
=======

        System.out.println("\nThong ke theo ngay nhap");
        System.out.printf("%-15s %-10s\n", "Ngay", "So luong");
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-15s %-10d\n", ngaydadem[i], soLuong[i]);
        }
    }
<<<<<<< HEAD
public void docFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            Chitietphieunhap x = null;
            ds = new Chitietphieunhap[0];
=======

    // Đọc file
    public void docFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            ds = new Chitietphieunhap[0]; // reset mảng
            n = 0; // reset số lượng

>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
            while ((line = br.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] t = line.split("-");
<<<<<<< HEAD
                if (t.length >= 4){
                    x = new Chitietphieunhap();
=======
                if (t.length >= 5){
                    Chitietphieunhap x = new Chitietphieunhap();
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
                    x.setmaNH(t[0]);
                    x.setmaSP(t[1]); 
                    x.setngay(t[2]);
                    x.setsoluong(Integer.parseInt(t[3]));
                    x.setdongia(Double.parseDouble(t[4]));
<<<<<<< HEAD
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    System.out.println("Doc: " + x.getmaNH() + " - " + x.getmaSP() + " " + x.getngay()+" "+x.getsoluong()+" "+x.getdongia());

                } 
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: "+ n);
=======

                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    n = ds.length; // cập nhật số lượng
                    System.out.println("Doc: " + x.getmaNH() + " - " + x.getmaSP() + " " + x.getngay()+" "+x.getsoluong()+" "+x.getdongia());
                } 
            }
            System.out.println("Doc file thanh cong, so chi tiet da doc: "+ n);
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
        }catch (IOException e){
            System.out.println("Loi doc file: "+e.getMessage());
        }
    }
<<<<<<< HEAD
    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i=0; i<n; i++){
=======

    // Ghi file
    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i = 0; i < n; i++){
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
                if (ds[i] != null){
                    writer.println(ds[i].toString());
                }
            }
<<<<<<< HEAD
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
            if(ds[i].getmaNH().equalsIgnoreCase(macanthem)){
                themma = true;
                return;
                }
            }
            if(themma){
                System.out.print("Mã chi tiết phiếu nhập " + macanthem + "đã tồn tại trong danh sách");
            }
            if(n >= 100){
                System.out.print("Danh sách chi tiết phiếu nhập đã đầy");
                return;
            }
            System.out.println("Nhập thông tin chi tiết phiếu nhập mới có mã " + macanthem);
            ds[n] = new Chitietphieunhap();
            ds[n].nhap();
            ds[n].setmaNH(macanthem);
            n++;
    }

=======
            System.out.println("Ghi file thanh cong: "+n+" chi tiet");
        }catch (IOException e){
            System.out.println("Loi ghi file: "+e.getMessage());
        }   
    }

    // Thêm theo mã
    public void themtheoma(){
        System.out.print("Mã cần thêm: ");
        String macanthem = sc.nextLine();

        for(int i = 0; i < n; i++){
            if(ds[i].getmaNH().equalsIgnoreCase(macanthem)){
                System.out.println("Mã chi tiết phiếu nhập " + macanthem + " đã tồn tại trong danh sách");
                return;
            }
        }

        if(n >= 100){
            System.out.println("Danh sách chi tiết phiếu nhập đã đầy");
            return;
        }

        System.out.println("Nhập thông tin chi tiết phiếu nhập mới có mã " + macanthem);
        ds[n] = new Chitietphieunhap();
        ds[n].nhap(true);
        ds[n].setmaNH(macanthem);
        n++;
        System.out.println("Đã thêm chi tiết phiếu nhập có mã " + macanthem);
    }

    // Tìm theo mã
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
    public void timTheoMa() {
        System.out.print("Nhap ma can tim: ");
        String ma = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getmaNH().equalsIgnoreCase(ma)) {
                System.out.println("Tim thay: " + ds[i]);
                return;
            }
        }
        System.out.println("Khong tim thay!");
    }
<<<<<<< HEAD
    
=======

    // Xoá theo mã
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
    public void xoatheoma(){
        System.out.print("Mã cần xoá: ");
        String macanxoa = sc.nextLine();
        boolean daxoa = false;
<<<<<<< HEAD
=======

>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
        for(int i = 0;i < n; i++){
            if(ds[i].getmaNH().equalsIgnoreCase(macanxoa)){
                for(int j = i;j < n-1;j++){
                    ds[j] = ds[j+1];
                }
                ds[n-1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá chi tiết phiếu nhập có mã " + macanxoa);
                break;
            }
        }
<<<<<<< HEAD
        if(!daxoa){
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã" + macanxoa);
        }
    }

    public void suatheoma(){
        System.out.println("Mã cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;
        for(int i = 0; i < n; i++){
            if(ds[i].getmaNH().equalsIgnoreCase(macansua)){
                System.out.println("Tìm thấy chi tiết phiếu nhập: ");
                ds[i].toString();
                System.out.println("Thông tin cần sửa cho chi tiết phiếu nhập: ");
                ds[i] = new Chitietphieunhap();
                ds[i].toString();
                System.out.println("Đã sửa thông tin cho chi tiết phiếu nhập có mã "+ macansua);
=======

        if(!daxoa){
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã " + macanxoa);
        }
    }

    // Sửa theo mã
    public void suatheoma(){
        System.out.print("Mã cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;

        for(int i = 0; i < n; i++){
            if(ds[i].getmaNH().equalsIgnoreCase(macansua)){
                System.out.println("Tìm thấy chi tiết phiếu nhập: " + ds[i]);
                System.out.println("Nhập thông tin mới cho chi tiết phiếu nhập (mã giữ nguyên): ");
                ds[i].nhap(true);
                ds[i].setmaNH(macansua);
                System.out.println("Đã sửa thông tin cho chi tiết phiếu nhập có mã " + macansua);
>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
                dasua = true;
                break;
            }
        }
<<<<<<< HEAD
=======

>>>>>>> 6224f9e8d9a59491c1826d7736468cf708bfd88d
        if(!dasua){
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã "+ macansua);
        }
    }
}

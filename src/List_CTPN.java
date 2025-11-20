import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List_CTPN {
    Scanner sc = new Scanner(System.in);
    private int n;
    private Chitietphieunhap[] ds = new Chitietphieunhap[100];

    // Nhập danh sách
    public void nhap() {
        System.out.print("So luong chi tiet phieu nhap: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < ds.length; i++) {
            System.out.println("Chi tiet phieu nhap " + (i + 1) + ":");
            ds[i] = new Chitietphieunhap();
            ds[i].nhap();
        }
    }

    // Xuất danh sách
    public void xuat() {
        System.out.println("DANH SACH CHI TIET PHIEU NHAP");
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null)
                System.out.println(ds[i]);
        }
    }

    // Thống kê theo ngày
    public void thongketheongay() {
        String[] ngaydadem = new String[100];
        int[] soLuong = new int[100];
        int dem = 0;

        for (int i = 0; i < n; i++) {
            String ngay = ds[i].getngay();
            int index = -1;
            for (int j = 0; j < dem; j++) {
                if (ngaydadem[j].equalsIgnoreCase(ngay)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                ngaydadem[dem] = ngay;
                soLuong[dem] = 1;
                dem++;
            } else {
                soLuong[index]++;
            }
        }

        System.out.println("\nThong ke theo ngay nhap");
        System.out.printf("%-15s %-10s\n", "Ngay", "So luong");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-15s %-10d\n", ngaydadem[i], soLuong[i]);
        }
    }

    // Đọc file
    public void docFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            ds = new Chitietphieunhap[0]; // reset mảng
            n = 0; // reset số lượng

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 5) {
                    Chitietphieunhap x = new Chitietphieunhap();
                    x.setmaNH(t[0]);
                    x.setmaSP(t[1]);
                    x.setngay(t[2]);
                    x.setsoluong(Integer.parseInt(t[3]));
                    x.setdongia(Double.parseDouble(t[4]));

                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    n = ds.length; // cập nhật số lượng
                    System.out.println("Doc: " + x.getmaNH() + " - " + x.getmaSP() + " " + x.getngay() + " "
                            + x.getsoluong() + " " + x.getdongia());
                }
            }
            System.out.println("Doc file thanh cong, so chi tiet da doc: " + n);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Ghi file
    public void ghiFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: " + n + " chi tiet");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }
    public boolean OneIDNCC(String mactpn){
        if(mactpn == null)
        return false;
        for(int i = 0;i<ds.length;i++){
            if(ds[i] != null && ds[i].getmaNH() != null && ds[i].getmaNH().equalsIgnoreCase(mactpn)){
                return true;
            }
        }
        return false;
    }

    // Tìm theo mã
    public void timtheoma(String macantim) {
          boolean tim = false;
          for(int i = 0;i < ds.length; i++){
            if (ds[i] != null && ds[i].getmaNH() != null && ds[i].getmaNH().equalsIgnoreCase(macantim)){
            ds[i].xuat();
            tim = true;
            break;  
            }
         }
        if (!tim)
            System.out.println("Khong tim thay!!! ");
    }

    // Thêm theo mã
    public void themTheoMa(){
        System.out.println("Them nha cung cap");
        Chitietphieunhap ctpnmoi = new Chitietphieunhap();
        ctpnmoi.nhap();
        if(!OneIDNCC(ctpnmoi.getmaNH())){
            System.out.print("Ma nha cung cap" + ctpnmoi.getmaNH()+ "da ton tai");
        }
        ds = Arrays.copyOf(ds,ds.length + 1);
        ds[ds.length - 1] =ctpnmoi;
    }

    // Xoá theo mã
    public void xoatheoma(String macanxoa) {
           boolean xoa = false;
           for(int i =0;i<ds.length;i++){
            if(ds[i] != null && ds[i].getmaNH() != null &&  ds[i].getmaNH().equalsIgnoreCase(macanxoa)){
                ds[i].xuat();
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

    // Sửa theo mã
    public void suatheoma(String macansua) {
        boolean sua = false;
        for (int i = 0; i < ds.length;i++){ 
            if (ds[i] != null && ds[i].getmaNH() != null && ds[i].getmaNH().equalsIgnoreCase(macansua)) {
                int chon;
                do{
                    System.out.print("1.Sua ma");
                    System.out.print("2.Sua san pham");
                    System.out.print("3.Sua ngay");
                    System.out.print("4.Sua so luong");
                    System.out.print("5.Sua don gia");
                    System.out.print("0.Hoan thanh sua");
                    chon = sc.nextInt();
                    sc.nextLine();
                    switch(chon){
                        case 1:
                            String mamoi = sc.nextLine();
                            ds[i].setmaNH(mamoi);
                            break;
                        case 2:
                            String sanphammoi = sc.nextLine();
                            ds[i].setmaSP(sanphammoi);
                            break;
                        case 3:
                            String ngaymoi = sc.nextLine();
                            ds[i].setngay(ngaymoi);
                            break;
                        case 4:
                            int soluongmoi = sc.nextInt();
                            ds[i].setsoluong(soluongmoi);
                            break;
                        case 5:
                            double dongiamoi = Double.parseDouble(sc.nextLine());
                            ds[i].setdongia(dongiamoi);
                            break;
                        case 0:
                            System.out.println("Hoan thanh sua");
                            break;
                        default:
                            System.out.println("Khong hop le");
                            break;
                    }
                }        
                while (chon != 0); 
                    System.out.println("Da sua hoan tat");
                }
        }
    }
}
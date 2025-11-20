import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List_PN {
    Scanner sc = new Scanner(System.in);
    private int n;
    private Phieunhaphang[] ds = new Phieunhaphang[100];

    public void nhap(String maPNH, double tongtien) {
        System.out.print("So luong phieu nhap hang: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Phieu nhap hang thu " + (i + 1) + ":");
            ds[i] = new Phieunhaphang();
            ds[i].nhap(maPNH, 0);
        }
    }

    public void xuat() {
        System.out.println("DANH SACH PHIEU NHAP HANG");
        for (int i = 0; i < n; i++) {
            System.out.println(ds[i]);
        }
    }

    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_PN.txt"))) {
            String line;
            Phieunhaphang x = null;
            ds = new Phieunhaphang[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 3) {
                    x = new Phieunhaphang();
                    x.setmaPNH(t[0]);
                    x.setmaNV(t[1]);
                    x.setngay(t[2]);
                    x.setmaNcc((t[3]));
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    System.out.println(
                            "Doc: " + x.getmaPNH() + " - " + x.getmaNV() + " " + x.getngay() + " " + x.getmaNcc());

                }
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: " + ds.length);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_PN.txt"))) {
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: " + n + " khach");
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
<<<<<<< HEAD

    public boolean OneIDPN(String mapn) {
        if (mapn == null)
            return false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(mapn)) {
=======
     public boolean OneIDPN(String mapn){
        if(mapn == null)
        return false;
        for(int i = 0;i < n;i++){
            if(ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(mapn)){
>>>>>>> c2f8e2ac9b0667321a94bad01043749a22dd6288
                return true;
            }
        }
        return false;
    }

    public void capnhattongtien(String maPNH, double tongtien) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getmaPNH().equalsIgnoreCase(maPNH)) {
                ds[i].settongtien(tongtien);
            }
        }
    }

    public void them(String maPNH) {
        System.out.println("Them nha cung cap");
        Phieunhaphang pnmoi = new Phieunhaphang();
        System.out.println("Nhap ma: ");

        pnmoi.nhap(maPNH, 0);
        if (!OneIDPN(pnmoi.getmaPNH())) {
            System.out.print("Ma nha cung cap" + pnmoi.getmaPNH() + "da ton tai");
        }
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = pnmoi;
    }

    public void thempn(Phieunhaphang x) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = x;
        ghiFile();
        System.out.println("Đã thêm món ăn thành công!");

    }

<<<<<<< HEAD
    public void timTheoMa(String macantim) {
        boolean tim = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(macantim)) {
                ds[i].toString();
                tim = true;
                break;
=======
    public void timtheoma(String macantim) {
         boolean tim = false;
          for(int i = 0;i < ds.length; i++){
            if (ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(macantim)){
            ds[i].toString();
            tim = true;
            break;  
>>>>>>> c2f8e2ac9b0667321a94bad01043749a22dd6288
            }
        }
        if (!tim)
            System.out.println("Khong tim thay!!! ");
    }

    public void xoatheoma(String macanxoa) {
        boolean xoa = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(macanxoa)) {
                ds[i].toString();
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.print("Xoa thanh cong");
                xoa = true;
                return;
            }
        }
        if (!xoa) {
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã " + macanxoa);
        }
    }

    public void sua() {
        System.out.println("\n===== SUA THONG TIN PHIEU NHAP HANG =====");
        System.out.print("Nhap Ma Phieu Nhap Hang can sua: ");
        String macansua = sc.nextLine().trim();

        int v = -1;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getmaPNH().equalsIgnoreCase(macansua)) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            System.out.println(" Khong tim thay Phieu Nhap Hang co ma: " + macansua);
            return;
        }

        // 2. Hiển thị thông tin hiện tại
        System.out.println("--- THONG TIN PHIEU NHAP HIEN TAI ---");

        System.out.println(ds[v].toString());

        int choice;
        do {
            System.out.println("\n=== CHON THUOC TINH CAN SUA ===");
            System.out.println("1. Sua Ma Phieu Nhap Hang (MaPNH)");
            System.out.println("2. Sua Ma Nhan Vien (MaNV)");
            System.out.println("3. Sua Ngay Nhap");
            System.out.println("4. Sua Ma Nha Cung Cap (MaNCC)");
            System.out.println("9. Sua tat ca (Nhap lai)");
            System.out.println("0. Hoan thanh sua & Quay lai");
            System.out.print("Lua chon: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                choice = -1;
                sc.nextLine();
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhap Ma PNH moi: ");
                    String maMoi = sc.nextLine().trim();
                    ds[v].setmaPNH(maMoi);
                    System.out.println(" Da cap nhat Ma PNH.");
                    break;

                case 2:
                    System.out.print("Nhap Ma NV moi: ");
                    String maNVMoi = sc.nextLine().trim();
                    ds[v].setmaNV(maNVMoi);
                    System.out.println(" Da cap nhat Ma NV.");
                    break;

                case 3:
                    System.out.print("Nhap Ngay Nhap moi (vd: DD/MM/YYYY): ");
                    String ngayMoi = sc.nextLine().trim();
                    ds[v].setngay(ngayMoi);
                    System.out.println(" Da cap nhat Ngay Nhap.");
                    break;

                case 4:
                    System.out.print("Nhap Ma NCC moi: ");
                    String maNCCMoi = sc.nextLine().trim();
                    ds[v].setmaNcc(maNCCMoi);
                    System.out.println(" Da cap nhat Ma NCC.");
                    break;

                case 9:
                    System.out.println("--- NHAP LAI TOAN BO THONG TIN ---");
                    ds[v] = new Phieunhaphang(); // Tạo đối tượng mới
                    ds[v].nhap(sc.nextLine(), 0);
                    System.out.println("Da cap nhat tat ca thong tin.");
                    break;

                case 0:
                    System.out.println("Hoan tat sua Phieu Nhap Hang.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

            // Hiển thị lại thông tin sau mỗi lần sửa (trừ trường hợp thoát)
            if (choice != 0) {
                System.out.println("\n--- THONG TIN SAU KHI SUA ---");
                System.out.println(ds[v].toString());
            }

        } while (choice != 0);

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

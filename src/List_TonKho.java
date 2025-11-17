import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class List_TonKho {
    private TonKho[] ds;
    private int n;
    private Scanner sc = new Scanner(System.in);

    public List_TonKho() {
        n = 0;
        ds = new TonKho[0];
    }

    public List_TonKho(int n) {
        this.n = n;
        ds = new TonKho[n];
    }

    // Getter/Setter
    public TonKho[] getDs() {
        return ds;
    }

    public void setDs(TonKho[] ds) {
        this.ds = ds;
    }

    public int getN() {
        return ds.length;
    }

    public void setN(int n) {
        this.n = n;
    }

    private void tuDongCapNhatFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_TonKho.txt"))) {
            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Da tu dong luu thong tin vao file!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void nhapds() {
        System.out.print("Nhap so luong san pham ton kho: ");
        n = sc.nextInt();
        sc.nextLine();
        ds = new TonKho[n];

        for (int i = 0; i < ds.length; i++) {
            System.out.println("\n--- Nhap thong tin san pham " + (i + 1) + " ---");
            ds[i] = new TonKho();
            ds[i].nhap();
        }

        tuDongCapNhatFile();
        System.out.println("Da nhap xong " + n + " san pham ton kho");
    }

    public void xuat() {
        if (ds.length == 0) {
            System.out.println("Danh sach ton kho rong!");
            return;
        }

        System.out.println("So luong san pham ton kho: " + ds.length);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-12s | %-12s | %-12s | %-15s\n",
                "Ma Kho", "Ten San Pham", "SL Ton", "Gia Nhap", "Ngay Nhap", "Nha CC");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null) {
                ds[i].xuat();
            }
        }
    }

    public boolean OneIDKho(String maKho) {
        if (maKho == null)
            return true;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaKho() != null &&
                    ds[i].getMaKho().equalsIgnoreCase(maKho)) {
                return false;
            }
        }
        return true;
    }

    public boolean TonTai(String maKho) {
        if (maKho == null)
            return false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaKho() != null &&
                    ds[i].getMaKho().equalsIgnoreCase(maKho)) {
                return true;
            }
        }
        return false;
    }

    public void them() {
        System.out.println("\n---- THEM SAN PHAM TON KHO MOI ----");
        TonKho khoMoi = new TonKho();
        khoMoi.nhap();

        // Check trùng mã
        if (!OneIDKho(khoMoi.getMaKho())) {
            System.out.println("Ma kho da ton tai!");
            return;
        }

        // Add vào mảng
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = khoMoi;

        tuDongCapNhatFile();
        System.out.println("Da them san pham ton kho moi thanh cong!");
    }

    public void sua() {
        if (ds.length == 0) {
            System.out.println("Danh sach ton kho rong!");
            return;
        }

        System.out.print("Nhap ma kho can sua: ");
        String maKho = sc.nextLine();

        int v = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaKho() != null &&
                    ds[i].getMaKho().equalsIgnoreCase(maKho)) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            System.out.println("Khong tim thay san pham co ma: " + maKho);
            return;
        }

        System.out.println("=== THONG TIN HIEN TAI ===");
        System.out.printf("%-10s | %-20s | %-12s | %-12s | %-12s | %-15s\n",
                "Ma Kho", "Ten San Pham", "SL Ton", "Gia Nhap", "Ngay Nhap", "Nha CC");
        System.out.println("--------------------------------------------------------------------------------");
        ds[v].xuat();
        System.out.println();

        int choice;
        do {
            System.out.println("=== SUA THONG TIN TON KHO ===");
            System.out.println("1. Sua ma kho");
            System.out.println("2. Sua ten san pham");
            System.out.println("3. Sua so luong ton");
            System.out.println("4. Sua gia nhap");
            System.out.println("5. Sua ngay nhap");
            System.out.println("6. Sua nha cung cap");
            System.out.println("7. Sua tat ca thong tin");
            System.out.println("0. Hoan thanh sua");
            System.out.print("Lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma kho moi: ");
                    String maMoi = sc.nextLine();
                    ds[v].setMaKho(maMoi);
                    System.out.println("Da cap nhat ma kho!");
                    break;
                case 2:
                    System.out.print("Nhap ten san pham moi: ");
                    String tenMoi = sc.nextLine();
                    ds[v].setTenSanPham(tenMoi);
                    System.out.println("Da cap nhat ten san pham!");
                    break;
                case 3:
                    System.out.print("Nhap so luong ton moi: ");
                    int soLuongMoi = sc.nextInt();
                    sc.nextLine();
                    ds[v].setSoLuongTon(soLuongMoi);
                    System.out.println("Da cap nhat so luong ton!");
                    break;
                case 4:
                    System.out.print("Nhap gia nhap moi: ");
                    double giaMoi = sc.nextDouble();
                    sc.nextLine();
                    ds[v].setGiaNhap(giaMoi);
                    System.out.println("Da cap nhat gia nhap!");
                    break;
                case 5:
                    System.out.print("Nhap ngay nhap moi: ");
                    String ngayMoi = sc.nextLine();
                    ds[v].setNgayNhap(ngayMoi);
                    System.out.println("Da cap nhat ngay nhap!");
                    break;
                case 6:
                    System.out.print("Nhap nha cung cap moi: ");
                    String nhaCCMoi = sc.nextLine();
                    ds[v].setNhaCungCap(nhaCCMoi);
                    System.out.println("Da cap nhat nha cung cap!");
                    break;
                case 7:
                    System.out.println("Nhap lai tat ca thong tin:");
                    ds[v].nhap();
                    System.out.println("Da cap nhat tat ca thong tin!");
                    break;
                case 0:
                    System.out.println("Hoan thanh sua san pham ton kho!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

            if (choice >= 1 && choice <= 7) {
                System.out.println("\n=== THONG TIN SAU KHI SUA ===");
                ds[v].xuat();
                System.out.println();
            }

        } while (choice != 0);

        tuDongCapNhatFile();
        System.out.println("Da luu thay doi vao file!");
    }

    public void xoaTheoMa(String maKho) {
        if (ds.length == 0) {
            System.out.println("Danh sach ton kho rong!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaKho() != null &&
                    ds[i].getMaKho().equalsIgnoreCase(maKho)) {

                System.out.println("San pham ton kho can xoa:");
                ds[i].xuat();
                System.out.println();

                // Dịch chuyển
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }

                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Da xoa thanh cong!");
                found = true;

                tuDongCapNhatFile();
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma kho: " + maKho);
        }
    }

    public void timKiemMa(String maKho) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaKho() != null &&
                    ds[i].getMaKho().equalsIgnoreCase(maKho)) {
                System.out.println("Da tim thay san pham ton kho:");
                ds[i].xuat();
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma kho: " + maKho);
        }
    }

    public void timKiemTen() {
        if (ds.length == 0) {
            System.out.println("Danh sach ton kho rong!");
            return;
        }

        System.out.print("Nhap ten san pham can tim: ");
        String tenSP = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].tenSanPham != null &&
                    ds[i].tenSanPham.toLowerCase().contains(tenSP.toLowerCase())) {
                if (!found) {
                    System.out.println("Ket qua tim kiem:");
                    found = true;
                }
                ds[i].xuat();
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham co ten: " + tenSP);
        }
    }

    public void thongKe() {
        if (ds.length == 0) {
            System.out.println("Danh sach ton kho rong!");
            return;
        }

        System.out.println("\n========== THONG KE TON KHO ==========");
        System.out.println("Tong so mat hang: " + ds.length);

        int tongSoLuongTon = 0;
        double tongGiaTriTon = 0;
        int sanPhamSapHet = 0;
        int sanPhamTonNhieu = 0;

        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null) {
                tongSoLuongTon += ds[i].getSoLuongTon();
                tongGiaTriTon += ds[i].getSoLuongTon() * ds[i].getGiaNhap();

                if (ds[i].getSoLuongTon() < 10) {
                    sanPhamSapHet++;
                } else if (ds[i].getSoLuongTon() > 100) {
                    sanPhamTonNhieu++;
                }
            }
        }

        System.out.println("Tong so luong ton kho: " + tongSoLuongTon);
        System.out.printf("Tong gia tri ton kho: %.2f VND\n", tongGiaTriTon);
        System.out.printf("Gia tri trung binh/san pham: %.2f VND\n",
                (ds.length > 0 ? tongGiaTriTon / ds.length : 0));

        System.out.println("\n--- CANH BAO TON KHO ---");
        System.out.println("San pham sap het hang (< 10): " + sanPhamSapHet);
        System.out.println("San pham ton kho nhieu (> 100): " + sanPhamTonNhieu);

        if (sanPhamSapHet > 0) {
            System.out.println("\nDANH SACH SAN PHAM SAP HET:");
            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null && ds[i].getSoLuongTon() < 10) {
                    System.out.printf("- %s: %d (Con %d)\n",
                            ds[i].getTenSanPham(), ds[i].getSoLuongTon(), ds[i].getSoLuongTon());
                }
            }
        }
        System.out.println("=====================================");
    }

    public void ghiFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong! " + ds.length + " san pham");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            ds = new TonKho[0]; // Reset mảng

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] t = line.split("-");
                if (t.length >= 6) {
                    TonKho kho = new TonKho(
                            t[0],
                            t[1],
                            Integer.parseInt(t[2]),
                            Double.parseDouble(t[3]),
                            t[4],
                            t[5]);

                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = kho;
                }
            }

            System.out.println("Doc file thanh cong! So san pham: " + ds.length);

        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi parse du lieu: " + e.getMessage());
        }
    }
}
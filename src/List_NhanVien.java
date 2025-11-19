import java.util.Scanner;
import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class List_NhanVien {
    private NhanVien[] ds;
    private int n;
    private Scanner sc = new Scanner(System.in);

    public List_NhanVien() {
        n = 0;
        ds = new NhanVien[0];
    }

    // getset
    public NhanVien[] getDs() {
        return ds;
    }

    public void setDs(NhanVien[] ds) {
        this.ds = ds;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List_NhanVien(int n) {
        this.n = n;
        ds = new NhanVien[n];
    }

    public void nhapds() {
        System.out.print("Nhap so luong nhan vien: ");
        n = sc.nextInt();
        sc.nextLine();
        ds = new NhanVien[n];

        for (int i = 0; i < ds.length; i++) {
            System.out.println("\n--- Nhap thong tin nhan vien" + (i + 1) + "---");
            ds[i] = new NhanVien();
            ds[i].nhap();
        }
        System.out.println("Da nhap xong " + n + " nhan vien");
    }

    public void xuat() {
        if (ds.length == 0) {
            System.out.println("Danh sach empty!");
            return;
        }
        System.out.println("So luong nhan vien: " + ds.length);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-15s | %-10s\n",
                "Ma NV", "Ho NV", "Ten NV", "Luong");
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null) {
                ds[i].xuat();
            }
        }
    }

    private void tuDongCapNhatFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_NV.txt"))) {
            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Da tu dong luu thong tin vao file ");
        } catch (IOException e) {
            System.out.println("Loi ghi file " + e.getMessage());
        }

    }

    public boolean OneIDNV(String maNV) {
        if (maNV == null)
            return true;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaNV() != null &&
                    ds[i].getMaNV().equalsIgnoreCase(maNV)) {
                return false;
            }
        }
        return true;
    }

    public void them() {
        System.out.println(" \n---- THEM NHAN VIEN MOI ----");
        NhanVien nvMoi = new NhanVien();
        nvMoi.nhap();

        // Check trùng mã
        if (!OneIDNV(nvMoi.getMaNV())) {
            System.out.println("Ma nhan vien da ton tai ");
            return;
        }

        // Add vào mảng
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = nvMoi;
        System.out.println("Da them nhan vien moi ");
    }

    public NhanVien[] getArray() {
        return ds;
    }

    public void timNVMa(String maNV) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaNV() != null &&
                    ds[i].getMaNV().equalsIgnoreCase(maNV)) {
                System.out.println("Da tim thay san pham ");
                ds[i].xuat();
                System.out.println();
                found = true;
                break;
            }
        } 
        if (!found) {
            System.out.println("Khong tim thay ma nhan vien ");
        }
    }

        public void timNVHo() {
        if (ds.length == 0) {
            System.out.println("Empty");
            return;
        }
        boolean found = false;
        System.out.println("Nhap ma can tim: ");
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].hoNV !=null  ){
                System.out.println("Da tim thay san pham");
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }
    

    public void xoaMaNV(String maNV) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaNV() != null &&
                    ds[i].getMaNV().equalsIgnoreCase(maNV)) {
                System.out.println("Da tim thay ma nhan vien can xoa");
                ds[i].xuat();

                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }

                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Da xoa ma thanh cong ");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma can xoa");
        }
    }

    public void suaNV() {
        if (ds.length == 0) {
            System.out.println("Danh sach empty ");
            return;
        }
        System.out.print("Nhap ma nhan vien can sua ");
        String maNV = sc.nextLine();

        // Tìm theo mã
        int v = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaNV() != null &&
                    ds[i].getMaNV().equalsIgnoreCase(maNV)) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            System.out.println("Khong tim thay nhan vien nao co ma: " + maNV);
            return;
        }

        System.out.println("Thong tin hien tai cua nhan vien: ");
        System.out.printf("%-8s %-15s %-10s %-15s\n", "Ma NV", "Ho NV", "Ten NV", "Luong Co Ban");
        System.out.println("----------------------------------------------------");
        ds[v].xuat();

        System.out.println("\n---- SUA THONG TIN NHAN VIEN ----");
        System.out.println("1. Sua ho nhan vien ");
        System.out.println("2. Sua ten nhan vien ");
        System.out.println("3. Sua luong nhan vien ");
        System.out.println("4. Sua tat ca thong tin ");
        System.out.println("0.Huy");
        System.out.print("Chon thong tin can sua: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Nhap ho moi: ");
                String hoMoi = sc.nextLine();
                ds[v].setHoNV(hoMoi);
                System.out.println("Da cap nhat thong tin nhan vien ");
                break;

            case 2:
                System.out.print("Nhap ten moi: ");
                String tenMoi = sc.nextLine();
                ds[v].setTenNV(tenMoi);
                System.out.println("Da cap nhat thong tin nhan vien ");
                break;

            case 3:
                System.out.print("Nhap luong co ban moi: ");
                Double luongMoi = sc.nextDouble();
                sc.nextLine();
                ds[v].setLuongCoBan(luongMoi);
                System.out.println("Da cap nhat thong tin nhan vien ");
                break;

            case 4:
                System.out.print("Nhap ho moi: ");
                ds[v].setHoNV(sc.nextLine());
                System.out.print("Nhap ten moi: ");
                ds[v].setTenNV(sc.nextLine());
                System.out.print("Nhap luong moi: ");
                ds[v].setLuongCoBan(sc.nextDouble());
                sc.nextLine();
                System.out.println("Da cap nhat tat ca thong tin ");
                break;

            case 0:
                System.out.println("Huy sua thong tin ");
                return;

            default:
                System.out.println("Lua chon khong hop le ");
                return;
        }
        System.out.println("\nThong tin sau khi sua:");
        System.out.printf("%-8s %-15s %-10s %-15s\n", "Ma NV", "Ho NV", "Ten NV", "Luong Co Ban");
        System.out.println("----------------------------------------------------");

        tuDongCapNhatFile();
        System.out.println("Da sua thanh cong!");
        ds[v].xuat();
    }

    public void ThongKeLuongCoBan() {
        if (ds.length == 0) {
            System.out.println("Danh sach empty");
            return;
        }

        System.out.println("=== THONG KE LUONG CO BAN ===");
        System.out.println("Tong so nhan vien" + ds.length);

        // Các biến
        double tongLuong = 0;
        double luongCaoNhat = ds[0].getLuongCoBan();
        double luongThapNhat = ds[0].getLuongCoBan();
        String nvLuongCao = ds[0].getMaNV() + " " + ds[0].getHoNV() + " " + ds[0].getTenNV();
        String nvLuongThap = ds[0].getMaNV() + " " + ds[0].getHoNV() + " " + ds[0].getTenNV();

        // Phân loại
        int luongThap = 0;
        int luongCao = 0;
        int luongTrungBinh = 0;

        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null) {
                double luong = ds[i].getLuongCoBan();
                tongLuong += luong;

                // Tìm lương cao thap
                if (luong > luongCaoNhat) {
                    luongCaoNhat = luong;
                    nvLuongCao = ds[i].getMaNV() + " " + ds[i].getHoNV() + " " + ds[i].getTenNV();
                }

                if (luong < luongThapNhat) {
                    luongThapNhat = luong;
                    nvLuongThap = ds[i].getMaNV() + " " + ds[i].getHoNV() + " " + ds[i].getHoNV();
                }

                // Muc luong
                if (luong < 5000000) {
                    luongThap++;
                } else if (luong <= 5000000) {
                    luongTrungBinh++;
                } else if (luong > 5000000) {
                    luongCao++;
                }
            }
        }

        System.out.printf("Tong quy luong: %.2f VND\n", tongLuong);
        System.out.printf("Luong trung binh: %.2f VND\n", tongLuong / ds.length);

        System.out.println("\n--- PHAN LOAI THEO MUC LUONG ---");
        System.out.println("Luong thap (< 5 trieu): " + luongThap + " nguoi");
        System.out.println("Luong trung binh (5-10 trieu): " + luongTrungBinh + " nguoi");
        System.out.println("Luong cao (> 10 trieu): " + luongCao + " nguoi");

        System.out.println("\n--- MIN/MAX ---");
        System.out.printf("Luong cao nhat: %.2f VND (%s)\n", luongCaoNhat, nvLuongCao);
        System.out.printf("Luong thap nhat: %.2f VND (%s)\n", luongThapNhat, nvLuongThap);

        // Tỷ lệ phần trăm
        System.out.println("\n--- TY LE PHAN TRAM ---");
        System.out.printf("Luong thap: %.1f%%\n", (double) luongThap / ds.length * 100);
        System.out.printf("Luong trung binh: %.1f%%\n", (double) luongTrungBinh / ds.length * 100);
        System.out.printf("Luong cao: %.1f%%\n", (double) luongCao / ds.length * 100);
    }

    public void ghiFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong! " + ds.length + " nhan vien");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            ds = new NhanVien[0]; // Reset mảng

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] t = line.split("-");
                if (t.length >= 4) { // Format: maNV-hoNV-tenNV-luong
                    NhanVien nv = new NhanVien(
                            t[0], // maNV
                            t[1], // hoNV
                            t[2], // tenNV
                            Double.parseDouble(t[3]) // luongCoBan
                    );

                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = nv;
                }
            }

            System.out.println("Doc file thanh cong! So nhan vien: " + ds.length);

        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi parse du lieu: " + e.getMessage());
        }
    }
}

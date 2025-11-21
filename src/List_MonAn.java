import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class List_MonAn implements dataB {
    private MonAn[] ds;
    private int n;
    private Scanner sc = new Scanner(System.in);

    public List_MonAn() {
        n = 0;
        ds = new MonAn[0];
        docFile("src/data/List_MonAn.txt");
    }

    public List_MonAn(int n) {
        this.n = n;
        ds = new MonAn[n];
    }

    public MonAn[] getDs() {
        return ds;
    }

    public void setDs(MonAn[] ds) {
        this.ds = ds;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private void tuDongCapNhatFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_MonAn.txt"))) {
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

    @Override
    public void nhapds() {
        System.out.println("Nhap so luong: ");
        n = sc.nextInt();
        sc.nextLine();
        ds = new MonAn[n];
        for (int i = 0; i < ds.length; i++) {
            String temp;
            int temT;
            do {
                temT = 1;
                System.out.println("\nNhap mon an so " + (i + 1) + " :");
                System.out.println("T. THUC AN");
                System.out.println("U. NUOC UONG");
                temp = sc.nextLine();
                if (temp.toUpperCase().contains("T")) {
                    ds[i] = new ThucAn();
                } else if (temp.toUpperCase().contains("U")) {
                    ds[i] = new NuocUong();
                } else {
                    temT = 0;
                }
            } while (temT != 1);
            ds[i].nhap();
        }

        tuDongCapNhatFile();
    }

    @Override
    public void xuat() {
        if (ds.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("So luong mon an: " + ds.length);
        System.out.println("\n================= DANH SACH MON AN =================");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-12s | %-12s | %-12s | %-8s\n",
                "Ma SP", "Ten SP", "Gia Ban", "So Luong", "Co thit/da", "Bot ngot/gas", "Tinh bot", "Chai/Lon");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < ds.length; i++)
            ds[i].xuat();
    }

    public boolean OneIDFood(String maSP) {
        if (maSP == null)
            return true;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null &&
                    ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                return false;
            }
        }
        return true;
    }

    public void CapNhatSoLuong(String maSP, int soLuong) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                ds[i].setSoLuong(ds[i].getSoLuong() + soLuong);
                tuDongCapNhatFile();
                System.out.println(" Da cong them " + soLuong + " vao kho.");
                return;
            }
        }
    }

    public boolean GiamSoLuong(String maSP, int soluong) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                if (ds[i].getSoLuong() >= soluong) {
                    ds[i].setSoLuong(ds[i].getSoLuong() - soluong);
                    tuDongCapNhatFile();
                    return true;
                } else {
                    System.out.println(" Kho khong du hang! Hien chi con: " + ds[i].getSoLuong());
                    return false;
                }
            }
        }
        return false;
    }

    public boolean TonTai(String maSP) {
        if (maSP == null)
            return false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null &&
                    ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                return true;
            }
        }
        return false;
    }

    public void themsp(MonAn sp) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = sp;
        tuDongCapNhatFile();
        System.out.println("Da them mon an thanh cong ");
    }

    public void themloaisp(int loai) {
        if (loai == 1) {
            ThucAn ta = new ThucAn();
            ta.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = ta;
            n++;
        } else if (loai == 2) {
            NuocUong nu = new NuocUong();
            nu.nhap();
            ds = Arrays.copyOf(ds, ds.length + 1);
            ds[ds.length - 1] = nu;
            n++;
        } else {
            System.out.println("Loai san pham khong hop le!");

        }
        tuDongCapNhatFile();
        System.out.println("Da them mon an thanh cong ");
    }

    public void sua() {
        if (ds.length == 0) {
            System.out.println("Danh sach empty");
            return;
        }

        System.out.print("Nhap ma san pham can sua: ");
        String maSP = sc.nextLine();

        int v = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(maSP)) {
                v = i;
                break;
            }
        }
        if (v == -1) {
            System.out.println("Khong tim thay san pham co ma: " + maSP);
            return;
        }
        System.out.println("--- THONG TIN HIEN TAI ---");
        ds[v].xuat();
        System.out.println();

        int choice;
        do {
            System.out.println("\n=== CHON TINH CHAT CAN SUA ===");
            System.out.println("1. Sua ma san pham");
            System.out.println("2. Sua ten san pham");
            System.out.println("3. Sua gia ban");
            System.out.println("4. Sua so luong");

            // Menu ThucAn
            if (ds[v] instanceof ThucAn) {
                System.out.println("5. Sua tinh chat co thit");
                System.out.println("6. Sua tinh chat co tinh bot");
                System.out.println("7. Sua tinh chat co bot ngot");
            }

            if (ds[v] instanceof NuocUong) {
                System.out.println("5. Sua tinh chat co da");
                System.out.println("6. Sua tinh chat co gas");
                System.out.println("7. Sua loai lon");
                System.out.println("7. Sua loai chai");
            }

            System.out.println("9.Sua tat ca thong tin ");
            System.out.println("0.Hoan thanh sua ");
            System.out.print("Lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma san pham moi: ");
                    String maMoi = sc.nextLine();
                    ds[v].maSP = maMoi;
                    System.out.println("Da cap nhat san pham");
                    break;

                case 2:
                    System.out.print("Nhap ten san pham moi: ");
                    String tenMoi = sc.nextLine();
                    ds[v].tenSP = tenMoi;
                    System.out.println("Da cap nhat san pham");
                    break;

                case 3:
                    System.out.println("Nhap gia ban moi: ");
                    double donGiamoi = sc.nextDouble();
                    sc.nextLine();
                    ds[v].donGia = donGiamoi;
                    System.out.println("Da cap nhat gia ban");
                    break;

                case 4:
                    System.out.println("Nhap so luong moi: ");
                    int soMoi = sc.nextInt();
                    ds[v].soLuong = soMoi;
                    break;

                case 5:
                    if (ds[v] instanceof ThucAn) {
                        System.out.println("Co thit khong? (true/false): ");
                        boolean coThit = sc.nextBoolean();
                        sc.nextLine();
                        ((ThucAn) ds[v]).setCoThit(coThit);
                        System.out.println("Da cap nhat co thit");
                    } else if (ds[v] instanceof NuocUong) {
                        System.out.println("Co da khong? (true/false): ");
                        boolean coDa = sc.nextBoolean();
                        ((NuocUong) ds[v]).setCoDa(coDa);
                        System.out.println("Da cap nhat co da");
                    }
                    break;

                case 6: // Thuộc tính đặc biệt 2
                    if (ds[v] instanceof ThucAn) {
                        System.out.print("Co tinh bot khong? (true/false): ");
                        boolean coTinhBot = sc.nextBoolean();
                        sc.nextLine();
                        ((ThucAn) ds[v]).setCoTinhBot(coTinhBot);
                        System.out.println("Da cap nhat tinh chat co tinh bot!");
                    } else if (ds[v] instanceof NuocUong) {
                        System.out.print("Co gas khong? (true/false): ");
                        boolean coGas = sc.nextBoolean();
                        sc.nextLine();
                        ((NuocUong) ds[v]).setCoGas(coGas);
                        System.out.println("Da cap nhat tinh chat co gas!");
                    }
                    break;

                case 7: // Thuộc tính ThucAn
                    if (ds[v] instanceof ThucAn) {
                        System.out.print("Co bot ngot khong? (true/false): ");
                        boolean coBotNgot = sc.nextBoolean();
                        sc.nextLine();
                        ((ThucAn) ds[v]).setCoBotNgot(coBotNgot);
                        System.out.println("Da cap nhat tinh chat co bot ngot!");
                    } else if (ds[v] instanceof NuocUong) {
                        System.out.print("Loai lon khong? (true/false): ");
                        boolean loaiLon = sc.nextBoolean();
                        sc.nextLine();
                        ((NuocUong) ds[v]).setLoaiLon(loaiLon);
                        System.out.println("Da cap nhat loai lon!");
                    }
                    break;
                case 8: // Thuộc tính NuocUong
                    if (ds[v] instanceof NuocUong) {
                        System.out.print("Loai chai khong? (true/false): ");
                        boolean loaiChai = sc.nextBoolean();
                        sc.nextLine();
                        ((NuocUong) ds[v]).setLoaiChai(loaiChai);
                        System.out.println("Da cap nhat loai chai!");
                    } else {
                        System.out.println("Lua chon khong hop le cho loai san pham nay!");
                    }
                    break;

                case 9: // Sửa tất cả
                    System.out.println("Nhap lai tat ca thong tin:");
                    ds[v].nhap();
                    System.out.println("Da cap nhat tat ca thong tin!");
                    break;

                case 0:
                    System.out.println("Hoan thanh sua san pham!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
            if (choice >= 1 && choice <= 9) {
                System.out.println("=== THONG TIN SAU KHI SUA ===");
                ds[v].xuat();
                System.out.println();
            }
        } while (choice != 0);
        tuDongCapNhatFile();
        System.out.println("Da luu thay doi vao file");
    }

    // Xoa theo Ma
    public void xoaTheoMa(String maSP) {
        if (ds.length == 0) {
            System.out.println("Danh sach empty");
            return;
        }
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null &&
                    ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                System.out.println("San pham can xoa: ");
                ds[i].xuat();
                System.out.println();
                // Dich chuyen ob
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                // Giam kich thuoc cua Array
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Da xoa thanh cong ");
                found = true;

                tuDongCapNhatFile();
                return;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham: " + maSP);
        }
    }

    public void timKiemMa(String maSP) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null &&
                    ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                System.out.println("Da tim thay san pham: ");
                ds[i].xuat();
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham" + maSP);
        }
    }

    public Double getdonGia(String id) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getMaSP().equalsIgnoreCase(id)) {
                return ds[i].getdonGia();
            }
        }
        return 0.0;
    }

    public MonAn[] timKiemTheoTen(String tenSP) {
        int d = 0;
        boolean timthay = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenSP().equalsIgnoreCase(tenSP)) {
                d++;
                timthay = true;
            }
        }
        MonAn[] kq = new MonAn[d];
        int d1 = 0;
        for (int i = 0; i < n; i++) {
            if (ds[i].getTenSP().equalsIgnoreCase(tenSP)) {
                kq[d1] = ds[i];
                d1++;
            }
        }
        if (!timthay)
            System.out.println("khong tim thay");
        return kq;
    }

    // Thống kê danh sách món ăn
    public void thongKe() {
        if (ds.length == 0) {
            System.out.println("Danh sach empty");
            return;
        }

        int tongSoMon = ds.length;
        int soThucAn = 0;
        int soNuocUong = 0;
        double tongGiaTri = 0;

        // ThucAn
        int thucAnCoThit = 0;
        int thucAnCoTinhBot = 0;
        int thucAnCoBotNgot = 0;

        // NuocUong
        int nuocUongCoDa = 0;
        int nuocUongCoGas = 0;
        int nuocUongLoaiChai = 0;
        int nuocUongLoaiLon = 0;

        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null) {
                tongGiaTri += ds[i].getdonGia();
                if (ds[i] instanceof ThucAn) {
                    soThucAn++;
                    ThucAn ta = (ThucAn) ds[i];
                    if (ta.isCoThit())
                        thucAnCoThit++;
                    if (ta.isCoBotNgot())
                        thucAnCoBotNgot++;
                    if (ta.isCoTinhBot())
                        thucAnCoTinhBot++;
                } else if (ds[i] instanceof NuocUong) {
                    soNuocUong++;
                    NuocUong nu = (NuocUong) ds[i];
                    if (nu.isCoDa())
                        nuocUongCoDa++;
                    if (nu.isCoGas())
                        nuocUongCoGas++;
                    if (nu.isLoaiLon())
                        nuocUongLoaiLon++;
                    if (nu.isLoaiChai())
                        nuocUongLoaiChai++;

                }
            }
        }
        System.out.println("\n========== THONG KE DANH SACH MON AN ==========");
        System.out.println("Tong so mon: " + tongSoMon);
        System.out.println("So luong Thuc An: " + soThucAn);
        System.out.println("So luong Nuoc Uong: " + soNuocUong);
        System.out.printf("Tong gia tri: %.2f VND\n", tongGiaTri);
        System.out.printf("Gia tri trung binh: %.2f VND\n", (tongSoMon > 0 ? tongGiaTri / tongSoMon : 0));

        System.out.println("\n---THONG KE THUC AN--- ");
        System.out.println("Thuc an co thit: " + thucAnCoThit + "/" + soThucAn);
        System.out.println("Thuc an co bot ngot: " + thucAnCoBotNgot + "/" + soThucAn);
        System.out.println("Thuc an co tinh bot: " + thucAnCoTinhBot + "/" + soThucAn);

        System.out.println("\n---THONG KE NUOC UONG");
        System.out.println("Nuoc uong co da: " + nuocUongCoDa + "/" + soNuocUong);
        System.out.println("Nuoc uong co gas: " + nuocUongCoGas + "/" + soNuocUong);
        System.out.println("Chon loai lon: " + nuocUongLoaiLon + "/" + soNuocUong);
        System.out.println("Chon loai chai: " + nuocUongLoaiChai + "/" + soNuocUong);
        System.out.println("-----------------------------------------------------");

    }

    public void docFile(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            ds = new MonAn[0];
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] t = line.split("-");
                if (t.length >= 5) {
                    MonAn x = null;
                    // Xử lý dữ liệu mẫu của bạn (T-MA001-Com Ga...)
                    if (t[0].trim().equalsIgnoreCase("T")) {
                        x = new ThucAn(t[1], t[2], Double.parseDouble(t[3]), Integer.parseInt(t[4]),
                                Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), Boolean.parseBoolean(t[7]));
                    } else if (t[0].trim().equalsIgnoreCase("N")) {
                        x = new NuocUong(t[1], t[2], Double.parseDouble(t[3]), Integer.parseInt(t[4]),
                                Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]), Boolean.parseBoolean(t[7]),
                                Boolean.parseBoolean(t[8]));
                    }
                    if (x != null) {
                        ds = Arrays.copyOf(ds, ds.length + 1);
                        ds[ds.length - 1] = x;
                    }
                }
            }
            n = ds.length;
        } catch (IOException e) {
            System.out.println("Lỗi đọc file MonAn: " + e.getMessage());
        }
    }

    public void ghiFile(String name) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(name))) {
            for (MonAn sp : ds) {
                if (sp instanceof ThucAn) {
                    ThucAn ta = (ThucAn) sp;
                    bw.write("T-" + ta.getMaSP() + "-" + ta.getTenSP() + "-" + (long) ta.getdonGia() + "-"
                            + ta.getSoLuong() + "-" +
                            ta.isCoThit() + "-" + ta.isCoBotNgot() + "-" + ta.isCoTinhBot());
                } else if (sp instanceof NuocUong) {
                    NuocUong nu = (NuocUong) sp;
                    bw.write("N-" + nu.getMaSP() + "-" + nu.getTenSP() + "-" + (long) nu.getdonGia() + "-"
                            + nu.getSoLuong() + "-" +
                            nu.isCoGas() + "-" + nu.isCoDa() + "-" + nu.isLoaiChai() + "-" + nu.isLoaiLon());
                }
                bw.newLine();
            }
        } catch (IOException e) {
        }
    }

    public double getDonGia(String maCanTim) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null && ds[i].getMaSP().equalsIgnoreCase(maCanTim)) {
                return ds[i].getdonGia();
            }
        }
        return 0;
    }
}

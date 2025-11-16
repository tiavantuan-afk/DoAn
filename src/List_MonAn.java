import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class List_MonAn {
    private MonAn[] ds;
    private int n;
    private Scanner sc = new Scanner(System.in);

    public List_MonAn() {
        n = 0;
        ds = new MonAn[0];
    }

    public List_MonAn(int n) {
        this.n = n;
        ds = new MonAn[n];
    }

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
                System.out.println("T. Thuc An");
                System.out.println("U. Uong Nuoc");
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
    }

    public void xuat() {
        if (ds.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("So luong mon an: " + ds.length);
        System.out.printf(
                "%-8s | %-8s | %-20s | %-20s | %-6s |",
                "Mon An", "Thuc An", "Nuoc Uong", "So Luong", "Gia Ban");
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        for (int i = 0; i < ds.length; i++)
            ds[i].xuat();
    }

    public boolean OneIDFood(String maSP) {
        if (maSP == null)
            return true;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maSP != null &&
                    ds[i].maSP.equalsIgnoreCase(maSP)) {
                return false;
            }
        }
        return true;
    }

    public boolean TonTai(String maSP) {
        if (maSP == null)
            return false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maSP != null &&
                    ds[i].maSP.equalsIgnoreCase(maSP)) {
                return true;
            }
        }
        return false;
    }

    public void them() {
        ds = Arrays.copyOf(ds, ds.length + 1);
        MonAn MonAnL = null;
        String temp;
        int temT;
        do {
            temT = 1;
            System.out.println("Nhap thong tin mon an can them: ");
            System.out.println("T. thuc an");
            System.out.println("U uong nuoc");
            temp = sc.nextLine();
            if (temp.toUpperCase().contains("T")) {
                MonAnL = new ThucAn();
            } else if (temp.toUpperCase().contains("U")) {
                MonAnL = new NuocUong();
            } else {
                temT = 0;
            }
        } while (temT != 1);
        MonAnL.nhap();
        ds[ds.length - 1] = MonAnL;
    }

    public void sua() {
        if (ds.length == 0) {
            System.out.println("Khong co trong danh sach!");
            return;
        }

        System.out.print("Nhap ma san pham can sua: ");
        String maSP = sc.nextLine();

        // Tìm vị trí cần sửa
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

        System.out.println("Thong tin hien tai:");
        ds[v].xuat();

        System.out.println("\nChon cach sua:");
        System.out.println("1. Sua toan bo thong tin");
        System.out.println("2. Sua tung phan");
        System.out.print("Lua chon: ");

        int luaChon = sc.nextInt();
        sc.nextLine(); // Đọc bỏ enter

        if (luaChon == 1) {
            // Tạo món ăn mới
            MonAn monAnMoi = null;
            System.out.println("Chon loai san pham moi:");
            System.out.println("1. Thuc An");
            System.out.println("2. Nuoc Uong");
            System.out.print("Lua chon: ");

            int loai = sc.nextInt();
            sc.nextLine();

            if (loai == 1) {
                monAnMoi = new ThucAn();
            } else if (loai == 2) {
                monAnMoi = new NuocUong();
            } else {
                System.out.println("Lua chon khong hop le!");
                return;
            }

            System.out.println("Nhap thong tin moi:");
            monAnMoi.nhap();
            ds[v] = monAnMoi;

        } else if (luaChon == 2) {
            System.out.println("Nhap lai thong tin:");
            ds[v].nhap();

        } else {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        System.out.println("Da sua thanh cong!");
        System.out.println("Thong tin sau khi sua:");
        ds[v].xuat();
    }

    // Xoa theo Ma
    public void xoaTheoMa(String maSP) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maSP != null &&
                    ds[i].maSP.equalsIgnoreCase(maSP)) {
                System.out.println("San pham can xoa");
                ds[i].xuat();

                // Push ob to front
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }

                // Giảm kích thước Arrays
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Da xoa thanh cong ");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham co ma:" + maSP);
        }
    }

    // Xoa theo Ten
    public void xoaTheoTen(String tenSP) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].tenSP != null &&
                    ds[i].tenSP.equalsIgnoreCase(tenSP)) {
                System.out.println("San pham can xoa ");
                ds[i].xuat();

                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }

                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Da xoa thanh cong ");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ten san pham " + tenSP);
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

    public void timKiemTen(String tenSP) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getTenSP() != null &&
                    ds[i].getTenSP().equalsIgnoreCase(tenSP)) {
                System.out.println("Da tim thay san pham: ");
                ds[i].xuat();
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham: ");
        }
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
                tongGiaTri += ds[i].getGiaBan();
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

    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_MonAn.txt"))) {
            String line;
            MonAn x = null;

            // Reset Arrays
            ds = new MonAn[0];

            while ((line = br.readLine()) != null) {
                String[] t = line.split("-");
                if (t.length >= 8) {
                    String type = t[0].toUpperCase();

                    if (type.contains("T")) {
                        x = new ThucAn();
                        x.maSP = t[1];
                        x.tenSP = t[2].replace("_", " ");
                        x.soLuong = t[3];
                        x.giaBan = Double.parseDouble(t[4]);

                        ((ThucAn) x).setCoThit(Boolean.parseBoolean(t[5]));
                        ((ThucAn) x).setCoTinhBot(Boolean.parseBoolean(t[6]));
                        ((ThucAn) x).setCoBotNgot(Boolean.parseBoolean(t[7]));

                    } else if (type.contains("N")) {

                        if (t.length >= 9) {
                            x = new NuocUong();
                            x.maSP = t[1];
                            x.tenSP = t[2].replace("_", " ");
                            ;
                            x.soLuong = t[3];
                            x.giaBan = Double.parseDouble(t[4]);

                            ((NuocUong) x).setCoDa(Boolean.parseBoolean(t[5]));
                            ((NuocUong) x).setCoGas(Boolean.parseBoolean(t[6]));
                            ((NuocUong) x).setLoaiLon(Boolean.parseBoolean(t[7]));
                            ((NuocUong) x).setLoaiChai(Boolean.parseBoolean(t[8]));
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }

                    // Chỉ thêm khi x != null
                    if (x != null) {
                        ds = Arrays.copyOf(ds, ds.length + 1);
                        ds[ds.length - 1] = x;
                        System.out.println("Doc: " + x.maSP + " - " + x.tenSP);
                    }
                }
            }

            System.out.println("Doc file thanh cong ");
            System.out.println("So mon da doc: " + ds.length);

        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi format so: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/List_MonAn.txt"))) {
            bw.write("==== DANH SACH MON AN ====\n");
            bw.write("So luong mon an: " + ds.length + "\n");

            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null) {
                    if (ds[i] instanceof ThucAn) {
                        ThucAn ta = (ThucAn) ds[i];
                        bw.write("T-" + ta.maSP + "-" + ta.tenSP + "-" +
                                ta.soLuong + "-" + ta.giaBan + "-" +
                                ta.isCoThit() + "-" + ta.isCoTinhBot() + "-" +
                                ta.isCoBotNgot() + "\n");
                    } else if (ds[i] instanceof NuocUong) {
                        NuocUong nu = (NuocUong) ds[i];
                        bw.write("N-" + nu.maSP + "-" + nu.tenSP + "-" +
                                nu.soLuong + "-" + nu.giaBan + "-" +
                                nu.isCoDa() + "-" + nu.isCoGas() + "-" +
                                nu.isLoaiLon() + "-" + nu.isLoaiChai() + "\n");
                    }
                }
            }
            System.out.println("Ghi file thanh cong ");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List_MonAn ds = new List_MonAn();
        System.out.println("Bat dau doc file...");
        ds.docFile();
        System.out.println("Hien thi ket qua:");
        ds.xuat();
    }

}

// public void xoa() {
// if (ds.length == 0) {
// System.out.println("Khong co trong danh sach");
// return;
// }
// System.out.println("Nhap san pham can xoa ");
// String maSP = sc.nextLine();

// int v = -1;
// for (int i = 0; i < ds.length; i++) {
// {
// if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(maSP))
// {
// v = i;
// break;
// }
// }
// if (v == -1) {
// System.out.println("Khong tim thay san pham" + maSP);
// return;
// }
// System.out.println("Tim thay san pham: ");
// ds[v].xuat();
// }
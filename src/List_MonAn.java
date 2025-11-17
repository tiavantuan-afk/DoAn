import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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

    // getset
    public MonAn[] getDs() {
        return ds;
    }

    public void setDs(MonAn[] ds) {
        this.ds = ds;
    }

    public int getN() {
        return ds.length;
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

        // THÊM: Tự động lưu file
        tuDongCapNhatFile();
    }

    public void xuat() {
        if (ds.length == 0) {
            System.out.println("Danh sach rong");
            return;
        }
        System.out.println("So luong mon an: " + ds.length);
        System.out.println(
                "----------------------------------------------------------------------------------------------");
        // In tiêu đề động hơn
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s\n",
                "Ma SP", "Ten SP", "Gia Ban", "So Luong", "Chi tiet 1", "Chi tiet 2", "Chi tiet 3", "Chi tiet 4");
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
            System.out.println("T. THUC AN");
            System.out.println("U NUOC UONG");
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

        // THÊM: Tự động lưu file
        tuDongCapNhatFile();
    }

    // public void sua() {
    // if(ds.length == 0){
    // System.out.println("Danh sach empty");
    // return;
    // }

    // System.out.print("Nhap san pham can sua: ");
    // String maSP = sc.nextLine();

    // int v = -1;
    // for(int i = 0; i < ds.length; i++){
    // if(ds[i] !=null && ds[i].maSP !=null && ds[i].maSP.equalsIgnoreCase(maSP)){
    // v = i;
    // break;
    // }
    // }

    // if(v == -1){
    // System.out.println("Khong tim thay san pham co ma: " + maSP);
    // return;
    // }

    // System.out.println("Thong tin hien tai: ");
    // ds[v].xuat();

    // System.out.println("Chon cach sua:");
    // System.out.println("1.Sua toan bo");
    // System.out.println("2.Sua tung phan");
    // System.out.print("Lua chon: ");

    // int choice = sc.nextInt();
    // sc.nextLine();

    // if(choice == 2) {
    // System.out.println("Nhap lai thong tin: ");
    // ds[v].nhap();
    // }else{
    // System.out.println("Lua chon khong hop le");
    // return;
    // }

    // System.out.printl
    // }

    // Xoa theo Ma
    public void xoaTheoMa(String maSP) {
        if (ds.length == 0) {
            System.out.println("Danh sach empty");
            return;
        }

        boolean found = false;
        for (int i = 0; i < ds.length - 1; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null &&
                    ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                System.out.println("San pham can xoa: ");
                ds[i].xuat();
                System.out.println();

                // Dich chuyen ob
                for (int j = i; j < ds.length; j++) {
                    ds[j] = ds[j + 1];
                }
                // Giam kich thuoc cua Array
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Da xoa thanh cong ");
                found = true;

                tuDongCapNhatFile();
                break;
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

    public void timKiemTen() {
        if (ds.length == 0) {
            System.out.println("Danh sach empty");
            return;
        }

        System.out.print("Nhap ten san pham can tim ");
        String tenSP = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].tenSP != null &&
                    ds[i].tenSP.equalsIgnoreCase(tenSP)) {
                if (!found) {
                    System.out.println("Ket qua tim kiem: ");
                    found = true;
                }
                ds[i].xuat();
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham co ten: " + tenSP);
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

    public void ghiFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong!" + ds.length + " mon ");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Reset mảng trước khi đọc
            ds = new MonAn[0];

            String line;
            MonAn x = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] t = line.split("-");
                if (t.length >= 8) {
                    String type = t[0].toUpperCase();

                    if (type.contains("T")) {
                        x = new ThucAn(t[1], t[2], Double.parseDouble(t[4]), Integer.parseInt(t[3]),
                                Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]),
                                Boolean.parseBoolean(t[7]));

                    } else if (type.contains("N") && t.length >= 9) {
                        x = new NuocUong(t[1], t[2], Double.parseDouble(t[4]), Integer.parseInt(t[3]),
                                Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]),
                                Boolean.parseBoolean(t[7]), Boolean.parseBoolean(t[8]));
                    } else {
                        System.out.println("Bo qua dong khong hop le: " + line);
                        continue;
                    }

                    if (x != null) {
                        ds = Arrays.copyOf(ds, ds.length + 1);
                        ds[ds.length - 1] = x;
                    }
                }
            }
            System.out.println("Doc file thanh cong! So mon: " + ds.length);

        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}
// public void ghiFileALL() {
// try (BufferedWriter bw = new BufferedWriter(new
// FileWriter("src/data/List_MonAn.txt"))) {
// for (int i = 0; i < ds.length; i++) {
// if (ds[i] != null) {
// bw.write(ds[i].toString());
// bw.newLine();
// }
// }
// System.out.println("Ghi thanh cong");
// } catch (IOException e) {
// System.out.println("Loi ghi file ");
// }
// }

// public void ghiFileONE() {
// if (ds.length > 0) {
// try (BufferedWriter bw = new BufferedWriter(new
// FileWriter("src/data/List_MonAn.txt"))) {
// bw.write(ds[ds.length - 1].toString());
// bw.newLine();
// System.out.println("Ghi thanh cong ");
// } catch (IOException e) {
// System.out.println("Loi ghi file ");
// }
// } else {
// System.out.println("Khong co file nao de ghi ");
// }
// }
// }

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
// public void docFile() {
// try (BufferedReader br = new BufferedReader(new
// FileReader("src/data/List_MonAn.txt"))) {
// String line;
// MonAn x;
// while ((line = br.readLine()) != null) {
// String[] t = line.split("-");
// if (t.length >= 8) {
// String type = t[0].toUpperCase();

// if (type.contains("T")) {
// x = new ThucAn(t[1], t[2], Double.parseDouble(t[4]), Integer.parseInt(t[3]),
// Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[6]),
// Boolean.parseBoolean(t[7]));

// } else if (type.contains("N")) {
// x = new NuocUong(t[1], t[2], Double.parseDouble(t[4]),
// Integer.parseInt(t[3]),
// Boolean.parseBoolean(t[6]), Boolean.parseBoolean(t[8]),
// Boolean.parseBoolean(t[5]), Boolean.parseBoolean(t[7]));

// } else {
// continue;
// }

// // Add vao mang
// if (x != null) {
// ds = Arrays.copyOf(ds, ds.length + 1);
// ds[ds.length - 1] = x;
// System.out.println("Doc: " + x.maSP + " - " + x.tenSP);
// }
// }
// }
// System.out.println("Doc file thanh cong ");
// System.out.println("So mon an da doc: " + ds.length);

// } catch (IOException e) {
// System.out.println("Loi khong doc duoc file " + e.getMessage());
// }
// }
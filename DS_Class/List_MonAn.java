package DoAn.DS_Class;

import java.util.Scanner;
import java.util.Arrays;

import DoAn.Classchinh.MonAn;
import DoAn.Classchinh.NuocUong;
import DoAn.Classchinh.ThucAn;

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
        if(ds.length == 0){
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
        for (int i = 0; i < ds.length - 1; i++) {
            if (maSP.toUpperCase().contains(ds[i].maSP.toUpperCase()) && ds[i].maSP != null) {
                return false;
            }
        }
        return true;
    }

    public boolean TonTai(String maSP) {
        for (int i = 0; i < ds.length - 1; i++) {
            if (maSP.toUpperCase().contains(ds[i].maSP.toUpperCase()) && ds[i].maSP != null) {
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
            System.out.println("Khong co trong danh sach! ");
            return;
        }
        System.out.print("Nhap ma san pham can sua: ");
        String maSP = sc.nextLine();

        // Tìm vị trí cần sửa
        int v = -1;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.toUpperCase().equals(maSP.toUpperCase())) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            System.out.println("Khong tim thay san pham co ma:" + maSP);
            return;
        }

        System.out.println("Thong tin hien tai: ");
        ds[v].xuat();

        System.out.print("Chon cach sua: ");
        System.out.print("1. Sua toan bo thong tin");
        System.out.print("2. Sua tung phan:");
        String luaChon = sc.nextLine();

        if (luaChon.equals("1")) {
            // Tạo cái mới
            MonAn MonAnL = null;
            String temp;
            int temT;
            do {
                temT = 1;
                System.out.println("Chon san pham loai moi");
                System.out.println("T: Thuc An");
                System.out.println("U Nuoc Uong ");
                temp = sc.nextLine();
                if (temp.toUpperCase().contains("T")) {
                    MonAnL = new ThucAn();
                } else if (temp.toUpperCase().contains("U")) {
                    MonAnL = new NuocUong();
                } else {
                    temT = 0;
                    System.out.println("Lua chon khong hop le");
                }
            } while (temT != 1);

            MonAnL.nhap();
            ds[v] = MonAnL;
        } else if (luaChon.equals("2")) {

            System.out.println("Nhap lai thong tin cho san pham: ");
            ds[v].nhap();
        } else {
            System.out.println("Lua chon khong co");
            return;
        }
        System.out.println("Da sua");
        System.out.println("Thong da sua");
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

    // }

    public void timKiemMa(String maSP) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maSP != null &&
                    ds[i].maSP.equalsIgnoreCase(maSP)) {
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
            if (ds[i] != null && ds[i].tenSP != null &&
                    ds[i].tenSP.equalsIgnoreCase(tenSP)) {
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

    public void menu() {
        int luaChon = -1;
        do {
            System.out.println("\n--- MENU QUAN LY MON AN ---");
            System.out.println("1.Nhap danh sach mon an: ");
            System.out.println("2.Xuat danh sach mon an: ");
            System.out.println("3.Them mot mon an: ");
            System.out.println("4.Sua thong tin mon an:");
            System.out.println("5.Xoa mot mon an: (Theo ma)");
            System.out.println("6.Xoa mot mon an(Theo ten)");
            System.out.println("7.Tim mot mon an(Theo Ma)");
            System.out.println("8.Tim mot mon an(Theo ten)");
            System.out.println("Thoat");
            System.out.println("Vui long chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    nhapds();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    them();
                    break;
                case 4:
                    sua();
                    break;
                case 5:
                    if (ds.length == 0) {
                        System.out.println("Danh sach empty ");
                    } else {
                        System.out.print("Nhap ma san pham can xoa: ");
                        String maCanXoa = sc.nextLine();
                        xoaTheoMa(maCanXoa);
                    }
                    break;
                case 6:
                    if (ds.length == 0) {
                        System.out.println("Danh sach empty ");
                    } else {
                        System.out.print("Nhap ten can xoa: ");
                        String tenCanXoa = sc.nextLine();
                        xoaTheoTen(tenCanXoa);
                    }
                    break;
                case 7:
                    if (ds.length == 0) {
                        System.out.println("Danh sach empty");
                    } else {
                        System.out.print("Nhap ma can tim: ");
                        String maCanTim = sc.nextLine();
                        timKiemMa(maCanTim);
                    }
                    break;
                case 8:
                    if (ds.length == 0) {
                        System.out.println("Danh sach empty");
                    } else {
                        System.out.print("Nhap ten can tim: ");
                        String tenCanTim = sc.nextLine();
                        timKiemTen(tenCanTim);
                    }
                case 0:
                    System.out.println("Xong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
                    break;
            }
        } while (luaChon != 0);
        sc.close();

    }

    public static void main(String[] args) {
        List_MonAn quanly = new List_MonAn();
        quanly.menu();

    }

}

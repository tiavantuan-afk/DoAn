import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class List_CTHD {
    Scanner sc = new Scanner(System.in);
    private CHITIETHOADON[] dscthd;

    public List_CTHD() {
        dscthd = new CHITIETHOADON[0];
    }

    public List_CTHD(int n) {
        dscthd = new CHITIETHOADON[n];
    }

    // Ham thiet lap
    public CHITIETHOADON[] getDscthd() {
        return dscthd;
    }

    public void setDscthd(CHITIETHOADON[] dscthd) {
        this.dscthd = dscthd;
    }

    public int getN() {
        return dscthd.length;
    }

    private void tuDongCapNhatFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_CTHD.txt"))) {
            for (int i = 0; i < dscthd.length; i++) { // SỬA: Dùng length
                if (dscthd[i] != null) {
                    writer.println(dscthd[i].toString());
                }
            }
            System.out.println("Da tu dong luu thong tin vao file!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void nhap(String Mahd, String Masp, double DG) {
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        sc.nextLine();
        dscthd = new CHITIETHOADON[n];
        for (int i = 0; i < dscthd.length; i++) {
            System.out.println("Nhap chi tiet hoa don thu: " + (i + 1));
            dscthd[i] = new CHITIETHOADON();
            dscthd[i].nhap(Mahd, Masp, DG);
        }
        tuDongCapNhatFile();
        System.out.println("Da nhap xong " + dscthd.length);
    }

    public void xuat() {
        if (dscthd.length == 0) {
            System.out.println("Danh sach chi tiet hoa don rong!");
            return;
        }

        System.out.println("So luong chi tiet: " + dscthd.length);
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i] != null) {
                dscthd[i].xuat();
            }
        }
    }

    public void timkiemtheomahoadon(String mahdcantim) {
        boolean timkiem = false;
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i].getMahd().equalsIgnoreCase(mahdcantim)) {
                dscthd[i].xuat();
                System.out.println();
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void suachitietmahd() {
        if (dscthd.length == 0) {
            System.out.println("Danh sach chi tiet rong!");
            return;
        }

        System.out.print("Nhap ma hoa don can sua: ");
        String mahd = sc.nextLine();

        int v = -1;
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i] != null && dscthd[i].getMahd() != null &&
                    dscthd[i].getMahd().equalsIgnoreCase(mahd)) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            System.out.println("Khong tim thay hoa don co ma: " + mahd);
            return;
        }

        System.out.println("=== THONG TIN HIEN TAI ===");
        dscthd[v].xuat();
        System.out.println();

        int choice;
        do {
            System.out.println("=== SUA CHI TIET HOA DON ===");
            System.out.println("1. Sua ma hoa don");
            System.out.println("2. Sua ma san pham");
            System.out.println("4. Sua so luong");
            System.out.println("5. Sua don gia: ");
            System.out.println("6. Sua thanh tien: ");
            System.out.println("7. Sua tat ca thong tin");
            System.out.println("0. Hoan thanh sua");
            System.out.print("Lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma hoa don moi: ");
                    String maMoi = sc.nextLine();
                    dscthd[v].setMahd(maMoi);
                    System.out.println("Da cap nhat ma hoa don!");
                    break;
                case 2:
                    System.out.print("Nhap ma san pham moi: ");
                    String spMoi = sc.nextLine();
                    dscthd[v].setMasp(spMoi);
                    System.out.println("Da cap nhat ma san pham!");
                    break;
                case 4:
                    System.out.print("Nhap so luong moi: ");
                    int slMoi = sc.nextInt();
                    dscthd[v].setSL(slMoi);
                    System.out.println("Da cap nhat SDT!");
                    break;
                case 5:
                    System.out.println("Nhap don gia moi: ");
                    double dgMoi = sc.nextDouble();
                    dscthd[v].setDG(dgMoi);
                    System.out.println("Da cap nhat don gia");
                    break;
                case 6:
                    System.out.println("Nhap thanh tien moi: ");
                    double ttMoi = sc.nextDouble();
                    dscthd[v].setThanhtien(ttMoi);
                    System.out.println("Da cap nhat thanh tien moi");
                    break;
                case 7:
                    System.out.println("Nhap lai tat ca thong tin:");
                    System.out.print("Nhap ma hoa don: ");
                    String mahdMoi = sc.nextLine();
                    System.out.print("Nhap ma san pham: ");
                    String maspMoi = sc.nextLine();
                    System.out.print("Nhap don gia: ");
                    double dgia = sc.nextDouble();
                    sc.nextLine();
                    dscthd[v].nhap(mahdMoi, maspMoi, dgia);
                    System.out.println("Da cap nhat tat ca thong tin!");
                    break;
                case 0:
                    System.out.println("Hoan thanh sua chi tiet hoa don!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

            if (choice >= 1 && choice <= 5) {
                System.out.println("\n=== THONG TIN SAU KHI SUA ===");
                dscthd[v].xuat();
                System.out.println();
            }

        } while (choice != 0);

        tuDongCapNhatFile();
        System.out.println("Da luu thay doi vao file!");
    }

    public boolean TonTai(String mact) {
        if (mact == null)
            return false;
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i] != null && dscthd[i].getMahd() != null &&
                    dscthd[i].getMahd().equalsIgnoreCase(mact)) {
                return true;
            }
        }
        return false;
    }

    public void them(CHITIETHOADON ctMoi) {
        if (ctMoi == null) {
            System.out.println("Loi: Doi tuong chi tiet hoa don khong hop le!");
            return;
        }
        dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
        dscthd[dscthd.length - 1] = ctMoi;

        tuDongCapNhatFile();
        System.out.println(" Da them chi tiet hoa don (" + ctMoi.getMahd() + " - " + ctMoi.getMasp() + ") thanh cong!");
    }

    public void them(String Mahd, String Masp, double DG) {
        dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
        CHITIETHOADON x = new CHITIETHOADON();
        x.nhap(Mahd, Masp, DG);
        dscthd[dscthd.length - 1] = x;
        tuDongCapNhatFile();

    }

    public int Soluongmon(String Mahd, String Masp) {
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i].getMahd().equalsIgnoreCase(Mahd) && dscthd[i].getMasp().equalsIgnoreCase(Masp)) {
                return dscthd[i].getSL();
            }
        }
        return 0;
    }

    public void xoaALL(String Mahd) {
        int count = 0;
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i].getMahd().equalsIgnoreCase(Mahd)) {
                count++;
                for (int j = i; j < dscthd.length - 1; j++) {
                    dscthd[i] = dscthd[i + 1];
                }
            }
            dscthd = Arrays.copyOf(dscthd, dscthd.length - count);
            System.out.println("Da xoa chi tiet co ma sach " + Mahd);
        }
    }

    public double Tinhtongtien(String Mahd) {
        double tongtien = 0;
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i].getMahd().equalsIgnoreCase(Mahd)) {
                tongtien += dscthd[i].Thanhtien;
            }
        }
        return tongtien;
    }

    public List_CTHD LietKeChiTiet(String Mahd) {
        List_CTHD temp = new List_CTHD();
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i].getMahd().equalsIgnoreCase(Mahd)) {
                temp.them(dscthd[i]);
            }
        }
        return temp;
    }

    public void xoachitietmahd(String mahd) {
        if (dscthd.length == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }
        boolean timkiem = false;
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i] != null && dscthd[i].getMahd() != null && dscthd[i].getMahd().equalsIgnoreCase(mahd)) {
                for (int j = i; j < dscthd.length - 1; j++) {
                    dscthd[j] = dscthd[j + 1];
                }
                dscthd = Arrays.copyOf(dscthd, dscthd.length - 1);
                System.out.println("Da xoa chi tiet hoa don co ma: " + mahd);
                timkiem = true;

                tuDongCapNhatFile();
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay chi tiet hoa don co ma: " + mahd);
        }
    }

    public void thongKeTongBanCuaSanPham() {
        if (dscthd.length == 0) {
            System.out.println("Danh sach chi tiet rong!");
            return;
        }

        System.out.print("Nhap ma san pham can thong ke: ");
        String maSP = sc.nextLine();

        int tongSoLuong = 0;
        double tongTienThuDuoc = 0;
        int soLanXuatHien = 0;

        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i] != null && dscthd[i].getMasp().equalsIgnoreCase(maSP)) {
                tongSoLuong += dscthd[i].getSL();
                tongTienThuDuoc += dscthd[i].getThanhtien();
                soLanXuatHien++;
            }
        }

        if (soLanXuatHien > 0) {
            System.out.println("\n=== THONG KE SAN PHAM: " + maSP.toUpperCase() + " ===");
            System.out.println("So hoa don da xuat hien: " + soLanXuatHien);
            System.out.println("Tong so luong da ban: " + tongSoLuong);
            System.out.printf("Tong tien thu ve tu san pham nay: %,.0f \n", tongTienThuDuoc);
        } else {
            System.out.println("San pham '" + maSP + "' chua ban duoc cai nao!");
        }
    }

    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_CTHD.txt"))) {
            String line;
            CHITIETHOADON x = null;
            dscthd = new CHITIETHOADON[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 6) {
                    x = new CHITIETHOADON(
                            t[0],
                            t[1],
                            Integer.parseInt(t[2]),
                            Double.parseDouble(t[3]),
                            Double.parseDouble(t[4]));
                    dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
                    dscthd[dscthd.length - 1] = x;

                }
            }
            System.out.println("Doc file thanh cong, So chi tiet da doc: " + dscthd.length);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_CTHD"))) {
            for (int i = 0; i < dscthd.length; i++) {
                if (dscthd[i] != null) {
                    writer.println(dscthd[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: ");
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
}

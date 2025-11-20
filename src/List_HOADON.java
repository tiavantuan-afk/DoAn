import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class List_HOADON {
    Scanner sc = new Scanner(System.in);
    private HOADON[] dshd;

    public List_HOADON() {
        dshd = new HOADON[0];
    }

    public List_HOADON(int n) {
        dshd = new HOADON[n];
    }

    public List_HOADON(List_HOADON x) {
        dshd = Arrays.copyOf(x.getDshd(), x.getN());
    }

    public HOADON[] getDshd() {
        return dshd;
    }

    public void setDshd(HOADON[] dshd) {
        this.dshd = dshd;
    }

    public int getN() {
        return dshd.length;
    }

    private void tuDongCapNhatFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_HOADON.txt"))) {
            for (int i = 0; i < dshd.length; i++) {
                if (dshd[i] != null) {
                    writer.println(dshd[i].toString());
                }
            }
            System.out.println("Da tu dong luu thong tin vao file!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void nhap() {
        System.out.print("Nhap n hoa don: ");
        int n = sc.nextInt();
        sc.nextLine();
        dshd = new HOADON[n];

        for (int i = 0; i < dshd.length; i++) {
            System.out.println("Nhap hoa don thu: " + (i + 1));
            dshd[i] = new HOADON();
            String Mahd;
            do {
                System.out.println("Nhap ma phieu nhap: ");
                Mahd = sc.nextLine();
                if (!ONEID(Mahd)) {
                    System.out.println("Ma phieu nhap da ton tai! Vui long nhap lai.");
                }
            } while (!ONEID(Mahd));
            dshd[i].nhap(Mahd, 0.0);
        }
        tuDongCapNhatFile();
        System.out.println("Da nhap xong " + dshd.length + " hoa don");
    }

    public boolean ONEID(String Mahd) {
        if (Mahd == null) {
            return true;
        }
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null && dshd[i].getMahd() != null && dshd[i].getMahd().equalsIgnoreCase(Mahd)) {
                return false;
            }
        }
        return true;
    }

    public void xuat() {
        if (dshd.length == 0) {
            System.out.println("Danh sach hoa don rong!");
            return;
        }

        System.out.println("So luong hoa don: " + dshd.length);
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null) {
                dshd[i].xuat();
            }
        }
    }

    public boolean TonTai(String mahd) {
        if (mahd == null)
            return false;
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null && dshd[i].getMahd() != null &&
                    dshd[i].getMahd().equalsIgnoreCase(mahd)) {
                return true;
            }
        }
        return false;
    }

    public void timkiemtheomahd(String hdcantim) {
        boolean timkiem = false;
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null && dshd[i].getMahd() != null && dshd[i].getMahd().equalsIgnoreCase(hdcantim)) {
                timkiem = true;
                dshd[i].xuat();
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void capnhattongtien(String Mahd, double Tongtien) {
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i].getMahd().equalsIgnoreCase(Mahd)) {
                dshd[i].setTongTien(Tongtien);
            }
        }
    }

    public void suahoadon() {
        if (dshd.length == 0) {
            System.out.println("Danh sach hoa don rong!");
            return;
        }
        System.out.print("Nhap ma hoa don can sua: ");
        String MA = sc.nextLine();

        int v = -1;
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null && dshd[i].getMahd() != null && dshd[i].getMahd().equalsIgnoreCase(MA)) {
                v = i;
                break;
            }
        }
        if (v == -1) {
            System.out.println("Khong tim thay khach hang co ma: " + MA);
            return;
        }
        System.out.println("--- THONG TIN HIEN TAI ---");
        dshd[v].xuat();
        System.out.println();

        int choice;
        do {
            System.out.println("\n=== CHON THUOC TINH CAN SUA ===");
            System.out.println("1. Sua ma hoa don");
            System.out.println("2. Sua ma nhan vien");
            System.out.println("3. Sua ma khach hang");
            System.out.println("4. Sua ngay ");
            System.out.println("5.Sua tong tien ");
            System.out.println("0.Hoan thanh sua ");
            System.out.print("Lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma hoa don moi: ");
                    String maMoi = sc.nextLine();
                    dshd[v].setMahd(maMoi);
                    System.out.println("Da cap nhat ma hoa don");
                    break;

                case 2:
                    System.out.print("Nhap ma nhan vien moi: ");
                    String nvMoi = sc.nextLine();
                    dshd[v].setManv(nvMoi);
                    System.out.println("Da cap nhat ma nhan vien");
                    break;

                case 3:
                    System.out.println("Nhap ma khach hang moi: ");
                    String khMoi = sc.nextLine();
                    dshd[v].setManv(khMoi);
                    System.out.println("Da cap nhat ma khach hang");
                    break;

                case 4:
                    System.out.println("Nhap so ngay moi: ");
                    String ngayMoi = sc.nextLine();
                    dshd[v].setNgay(ngayMoi);
                    System.out.println("Da cap nhat ngay");
                    break;
                case 5:
                    System.out.println("Nhap tong tien moi: ");
                    Double tongMoi = sc.nextDouble();
                    sc.nextLine();
                    dshd[v].setTongTien(tongMoi);
                    System.out.println("Da cap nhat ngay");
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
                dshd[v].xuat();
                System.out.println();
            }
        } while (choice != 0);
        tuDongCapNhatFile();
        System.out.println("Da luu thay doi vao file");
    }

    public void themhoadon(String Mahd) {
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        HOADON temp = new HOADON();
        temp.nhap(Mahd, 0);
        dshd[dshd.length - 1] = temp;
        tuDongCapNhatFile();
    }

    public void them(HOADON a) {
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[dshd.length - 1] = new HOADON(a);
    }

    public void xoahoadon(String MAHD) {
        if (dshd.length == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }
        boolean found = false;
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null && dshd[i].getMahd() != null && dshd[i].getMahd().equalsIgnoreCase(MAHD)) {
                System.out.println("Hoa don can xoa: ");
                dshd[i].xuat();
                System.out.println();

                for (int j = i; j < dshd.length - 1; j++) {
                    dshd[j] = dshd[j + 1];
                }
                dshd = Arrays.copyOf(dshd, dshd.length - 1);
                System.out.println("Da xoa thanh cong ");
                found = true;

                tuDongCapNhatFile();
                return;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham: " + MAHD);
        }
    }

    public void thongKeDoanhThu() {
        if (dshd.length == 0) {
            System.out.println("Danh sach hoa don rong, khong the thong ke!");
            return;
        }

        double tongDoanhThu = 0;
        double maxTien = -1;
        double minTien = Double.MAX_VALUE;
        String maMax = "", maMin = "";

        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null) {
                double tien = dshd[i].getTongtien();
                tongDoanhThu += tien;

                if (tien > maxTien) {
                    maxTien = tien;
                    maMax = dshd[i].getMahd();
                }
                if (tien < minTien) {
                    minTien = tien;
                    maMin = dshd[i].getMahd();
                }
            }
        }

        System.out.println("\n========== BAO CAO DOANH THU ==========");
        System.out.printf("Tong so hoa don: %d\n", dshd.length);

        System.out.printf("Tong doanh thu toan bo: %,.0f \n", tongDoanhThu);
        System.out.printf("Trung binh moi hoa don: %,.0f \n", (tongDoanhThu / dshd.length));
        System.out.println("---------------------------------------");
        System.out.printf("Hoa don cao nhat: %s (%,.0f )\n", maMax, maxTien);
        System.out.printf("Hoa don thap nhat: %s (%,.0f )\n", maMin, minTien);
        System.out.println("=======================================");
    }

    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_HOADON.txt"))) {
            String line;
            HOADON x = null;
            dshd = new HOADON[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 5) {
                    x = new HOADON(t[0], t[1], t[2], t[3], Double.parseDouble(t[4]));
                    dshd = Arrays.copyOf(dshd, dshd.length + 1);
                    dshd[dshd.length - 1] = x;

                }
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: " + dshd.length);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_HOADON.txt"))) {
            for (int i = 0; i < dshd.length; i++) {
                if (dshd[i] != null) {
                    writer.println(dshd[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: " + dshd.length + " hoa don");
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
}

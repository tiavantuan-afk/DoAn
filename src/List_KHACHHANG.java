import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class List_KHACHHANG {
    private KHACHHANG[] dskh; // SỬA: Bỏ private int n
    private Scanner sc = new Scanner(System.in);

    // Constructor giống MonAn
    public List_KHACHHANG() {
        dskh = new KHACHHANG[0]; // SỬA: Khởi tạo mảng rỗng
    }

    public List_KHACHHANG(int n) {
        dskh = new KHACHHANG[n];
    }

    public KHACHHANG[] getDskh() {
        return dskh;
    }

    public void setDskh(KHACHHANG[] dskh) {
        this.dskh = dskh;
    }

    public int getN() {
        return dskh.length;
    }

    // Tự động lưu file giống MonAn
    private void tuDongCapNhatFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_KHACHHANG.txt"))) {
            for (int i = 0; i < dskh.length; i++) { // SỬA: Dùng length
                if (dskh[i] != null) {
                    writer.println(dskh[i].toString());
                }
            }
            System.out.println("Da tu dong luu thong tin vao file!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void nhap() {
        System.out.print("Nhap so luong khach hang: ");
        int n = sc.nextInt(); // SỬA: Biến cục bộ
        sc.nextLine();
        dskh = new KHACHHANG[n]; // SỬA: Tạo mảng mới

        for (int i = 0; i < dskh.length; i++) {
            System.out.println("\nNhap khach hang thu " + (i + 1) + ":");
            dskh[i] = new KHACHHANG();
            dskh[i].nhap();
        }

        tuDongCapNhatFile(); // Tự động lưu
        System.out.println("Da nhap xong " + dskh.length + " khach hang");
    }

    public void xuat() {
        if (dskh.length == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        System.out.println("So luong khach hang: " + dskh.length);
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null) {
                dskh[i].xuat();
            }
        }
    }

    public boolean OneIDKH(String makh) {
        if (makh == null)
            return true;
        for (int i = 0; i < dskh.length; i++) { // SỬA: Dùng length
            if (dskh[i] != null && dskh[i].getMaKH() != null &&
                    dskh[i].getMaKH().equalsIgnoreCase(makh)) {
                return false;
            }
        }
        return true;
    }

    public boolean TonTai(String makh) {
        if (makh == null)
            return false;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getMaKH() != null &&
                    dskh[i].getMaKH().equalsIgnoreCase(makh)) {
                return true;
            }
        }
        return false;
    }

    // SỬA: Thêm khách hàng giống MonAn
    public void themkhachhang() {
        System.out.println("\n---- THEM KHACH HANG MOI ----");
        KHACHHANG khMoi = new KHACHHANG();
        khMoi.nhap();
        
        if (!OneIDKH(khMoi.getMaKH())) {
                System.out.println(" Ma khach hang '" + khMoi.getMaKH() + "' da ton tai!");

            }

        // Add vào mảng giống MonAn
        dskh = Arrays.copyOf(dskh, dskh.length + 1);
        dskh[dskh.length - 1] = khMoi;

        tuDongCapNhatFile();
        System.out.println("Da them khach hang moi thanh cong!");
    }

    // SỬA: Sửa khách hàng giống MonAn
    public void suakhachhang() {
        if (dskh.length == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        System.out.print("Nhap ma khach hang can sua: ");
        String maKH = sc.nextLine();

        int v = -1;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getMaKH() != null &&
                    dskh[i].getMaKH().equalsIgnoreCase(maKH)) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            System.out.println("Khong tim thay khach hang co ma: " + maKH);
            return;
        }

        System.out.println("=== THONG TIN HIEN TAI ===");
        dskh[v].xuat();
        System.out.println();

        int choice;
        do {
            System.out.println("=== SUA THONG TIN KHACH HANG ===");
            System.out.println("1. Sua ma khach hang");
            System.out.println("2. Sua ho khach hang");
            System.out.println("3. Sua ten khach hang");
            System.out.println("4. Sua so dien thoai");
            System.out.println("5. Sua tat ca thong tin");
            System.out.println("0. Hoan thanh sua");
            System.out.print("Lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma khach hang moi: ");
                    String maMoi = sc.nextLine();
                    dskh[v].setMakh(maMoi);
                    System.out.println("Da cap nhat ma khach hang!");
                    break;
                case 2:
                    System.out.print("Nhap ho moi: ");
                    String hoMoi = sc.nextLine();
                    dskh[v].setHo(hoMoi);
                    System.out.println("Da cap nhat ho!");
                    break;
                case 3:
                    System.out.print("Nhap ten moi: ");
                    String tenMoi = sc.nextLine();
                    dskh[v].setTen(tenMoi);
                    System.out.println("Da cap nhat ten!");
                    break;
                case 4:
                    System.out.print("Nhap SDT moi: ");
                    String sdtMoi = sc.nextLine();
                    dskh[v].setSDT(sdtMoi);
                    System.out.println("Da cap nhat SDT!");
                    break;
                case 5:
                    System.out.println("Nhap lai tat ca thong tin:");
                    dskh[v].nhap();
                    System.out.println("Da cap nhat tat ca thong tin!");
                    break;
                case 0:
                    System.out.println("Hoan thanh sua khach hang!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

            if (choice >= 1 && choice <= 5) {
                System.out.println("\n=== THONG TIN SAU KHI SUA ===");
                dskh[v].xuat();
                System.out.println();
            }

        } while (choice != 0);

        tuDongCapNhatFile();
        System.out.println("Da luu thay doi vao file!");
    }

    // SỬA: Xóa khách hàng giống MonAn
    public void xoakhachhang(String maKH) {
        if (dskh.length == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        boolean found = false;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getMaKH() != null &&
                    dskh[i].getMaKH().equalsIgnoreCase(maKH)) {

                System.out.println("Khach hang can xoa:");
                dskh[i].xuat();
                System.out.println();

                // Dịch chuyển giống MonAn
                for (int j = i; j < dskh.length - 1; j++) {
                    dskh[j] = dskh[j + 1];
                }

                dskh = Arrays.copyOf(dskh, dskh.length - 1);
                System.out.println("Da xoa thanh cong!");
                found = true;

                tuDongCapNhatFile();
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay khach hang co ma: " + maKH);
        }
    }

    // Tìm kiếm giống MonAn
    public void timkiemtheoma(String macantim) {
        boolean found = false;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getMaKH() != null &&
                    dskh[i].getMaKH().equalsIgnoreCase(macantim)) {
                System.out.println("Da tim thay khach hang:");
                dskh[i].xuat();
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay khach hang co ma: " + macantim);
        }
    }

    public void timkiemtheoten() {
        if (dskh.length == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        System.out.print("Nhap ten khach hang can tim: ");
        String tenCanTim = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getTen() != null &&
                    dskh[i].getTen().toLowerCase().contains(tenCanTim.toLowerCase())) {
                if (!found) {
                    System.out.println("Ket qua tim kiem:");
                    found = true;
                }
                dskh[i].xuat();
            }
        }
        if (!found) {
            System.out.println("Khong tim thay khach hang co ten: " + tenCanTim);
        }
    }
    public void thongKeKhachHangTheoHo() {
        if (dskh.length == 0) {
            System.out.println("Danh sach khach hang rong!");
            return;
        }

        System.out.print("Nhap ho khach hang can thong ke: ");
        String hoCanThongKe = sc.nextLine().trim();
        
        int count = 0;
        System.out.println("\n--- DANH SACH KHACH HANG HO: " + hoCanThongKe.toUpperCase() + " ---");

        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getHo().equalsIgnoreCase(hoCanThongKe)) {
                dskh[i].xuat(); 
                count++;
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("=> Tong so khach hang ho " + hoCanThongKe + ": " + count);
    }

    public void ghiFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < dskh.length; i++) {
                if (dskh[i] != null) {
                    writer.println(dskh[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong! " + dskh.length + " khach hang");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void docfile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            dskh = new KHACHHANG[0];

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] t = line.split("-");
                if (t.length >= 4) {
                    KHACHHANG x = new KHACHHANG();
                    x.setMakh(t[0]);    
                    x.setHo(t[1]);      
                    x.setTen(t[2]);     
                    x.setSDT(t[3]);
                    dskh = Arrays.copyOf(dskh, dskh.length + 1);
                    dskh[dskh.length - 1] = x;
                }
            }

            System.out.println("Doc file thanh cong! So khach hang: " + dskh.length);

        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}

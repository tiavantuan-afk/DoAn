import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class List_HOADON {
    Scanner sc = new Scanner(System.in);
    private int n;
    private HOADON[] dshd = new HOADON[100];

    public void nhap() {
        System.out.print("Nhap n hoa don: ");
        n = sc.nextInt();
        for (int i = 0; i < dshd.length; i++) {
            System.out.print("Nhap hoa don thu: " + (i + 1));
            dshd[i] = new HOADON();
            dshd[i].nhap();
            sc.close();
        }
    }

    public void xuat() {
        System.out.println("Danh sach hoa don: ");
        for (int i = 0; i < dshd.length; i++) {
            dshd[i].xuat();
        }
    }

    public HOADON[] getDshd() {
        return dshd;
    }

    public void setDshd(HOADON[] dshd) {
        this.dshd = dshd;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
        private void tuDongCapNhatFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_HOADON.txt"))) {
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null) {
                writer.println(dshd[i].toString());
            }
        }
        System.out.println("Da tu dong luu thong tin vao file ");
    } catch (IOException e) {
        System.out.println("Loi ghi file " + e.getMessage());
    }
    tuDongCapNhatFile();
    }
    public void timkiemtheomahd(String hdcantim) {
        System.out.print("Nhap ma hoa don can tim: ");
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
    //    public void suahoadon() {
    //     System.out.println("Nhap ma hoa don can sua: ");
    //     String MA = sc.nextLine();
    //     boolean timkiem = false;
    //     for (int i = 0; i < dshd.length; i++) {
    //         if (dshd[i].getMahd().equalsIgnoreCase(MA)) {
    //             System.out.println("Da cap nhat thong tin hoa don.");
    //             timkiem = true;
    //             break;
    //         }
    //     }
    //     if (!timkiem) {
    //         System.out.println("Khong tim thay hoa don de sua. ");
    //     }
    // }
    public void suahoadon() {
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
                case 6: // Sửa tất cả
                    System.out.println("Nhap lai tat ca thong tin:");
                    dshd[v].nhap();
                    System.out.println("Da cap nhat tat ca thong tin!");
                    break;

                case 0: // Hoàn thành
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
    //   tuDongCapNhatFile();
    //     System.out.println("Da luu thay doi vao file");
    public boolean IDHD(String mahdon) {
        if (mahdon == null) { 
            return true;
        }
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null && dshd[i].getMahd() != null && dshd[i].getMahd().equalsIgnoreCase(mahdon)) {
                return false;
            }
        }
        return true;
    }

    public void themhoadon() {
        System.out.println("Nhap hoa don can them");
        HOADON hdmoi = new HOADON();
        hdmoi.nhap();
        if (!IDHD(hdmoi.getMahd())) {
            System.out.println("Ma hao don da ton tai");
            return;
        }
        dshd = Arrays.copyOf(dshd, dshd.length + 1);
        dshd[dshd.length - 1] = hdmoi;
        System.out.println("Da them hoa don moi");
    }

    // public void xoahoadon(String MAHD) {
    //     System.out.println("Nhap ma hoa don can xoa: ");
    //     boolean timkiem = false;
    //     for (int i = 0; i < dshd.length; i++) {
    //         if (dshd[i].getMahd().equalsIgnoreCase(MAHD)) {
    //             for (int j = i; j < dshd.length - 1; j++) {
    //                 dshd[i] = dshd[i + 1];
    //             }
    //             dshd[n - 1] = null;
    //             n--;
    //             System.out.println("Da xoa hoa don co ma: " + MAHD);
    //             timkiem = true;
    //             break;
    //         }
    //     }
    //     if (!timkiem) {
    //         System.out.println("Khong tim thay hoa don co ma: " + MAHD);
    //     }
    // }
    public void xoahoadon(String MAHD) {
        boolean found = false;
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i] != null && dshd[i].getMahd() != null && dshd[i].getMahd().equalsIgnoreCase(MAHD)) {
                System.out.println("Hoa don can xoa: ");
                dshd[i].xuat();
                System.out.println();

                // Dich chuyen ob
                for (int j = i; j < dshd.length - 1; j++) {
                    dshd[j] = dshd[j + 1];
                }
                // Giam kich thuoc cua Array
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
    public void thongkenhanvien() {
        int d = 0;
        System.out.print("Nhap ma nhan vien can thong ke: ");
        String manhanvien = sc.nextLine();
        for (int i = 0; i < dshd.length; i++) {
            if (dshd[i].getManv().equalsIgnoreCase(manhanvien)) {
                d++;
            }
        }
        if (d >= 5) {
            System.out.println("Nhan vien uu tu");
        }
    }

    public void docfile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            HOADON x = null;
            dshd = new HOADON[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 5) {               
                        x = new HOADON(t[0], t[1], t[2], t[3], Double.parseDouble(t[4]));
                        // x.setMahd();
                        // ((HOADON) x).setManv(());
                        // ((HOADON) x).setMakh();
                        // x.setNgay();
                        // x.setTongTien();
                        dshd = Arrays.copyOf(dshd, dshd.length+1);
                        dshd[dshd.length-1] = x;
                        System.out.println("Doc: "+x.getMahd()+"-"+x.getManv()+"-"+x.getMakh()+"-");         
                }
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: "+ dshd.length);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } //catch (NumberFormatException e) {
            // System.out.println("Loi format so: " + e.getMessage());
            // }
    }

    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i=0; i<dshd.length; i++){
                if (dshd[i] != null){
                    writer.println(dshd[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: "+dshd.length+ " hoa don");
        }catch (IOException e){
            System.out.println("Loi ghi file");
        }   
    }
}

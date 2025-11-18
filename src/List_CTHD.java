import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        dscthd = new CHITIETHOADON[0]; // SỬA: Khởi tạo mảng rỗng
    }

    public List_CTHD(int n) {
        dscthd = new CHITIETHOADON[n];
    }
    
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

    public void nhap() {
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        for (int i = 0; i < dscthd.length; i++) {
            System.out.print("Nhap chi tiet hoa don thu: " + (i + 1));
            dscthd[i] = new CHITIETHOADON();
            dscthd[i].nhap();
        }
        tuDongCapNhatFile(); // Tự động lưu
        System.out.println("Da nhap xong " + dscthd.length);
    }

    public void xuat() {
        if (dscthd.length == 0) {
            System.out.println("Danh sach chi tiet hoa don rong!");
            return;
        }

        System.out.println("So luong chi tiet: " + dscthd.length);
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s | %-15s | %-10s | %-15s\n", "Ma HD", "Ma SP", "Ma KH");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i] != null){
            dscthd[i].xuat();
            }
        }
    }
    public void timkiemtheomahoadon(String mahdcantim) {
        System.out.print("Nhap ma hoa don can tim: ");
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
            System.out.println("3. Sua ma khach hang");
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
                    dscthd[v].setMakh(maMoi);
                    System.out.println("Da cap nhat ma hoa don!");
                    break;
                case 2:
                    System.out.print("Nhap ma san pham moi: ");
                    String spMoi = sc.nextLine();
                    dscthd[v].setMasp(spMoi);
                    System.out.println("Da cap nhat ma san pham!");
                    break;
                case 3:
                    System.out.print("Nhap ma khach hang moi: ");
                    String mkMoi = sc.nextLine();
                    dscthd[v].setMakh(mkMoi);
                    System.out.println("Da cap nhat ma khach hang!");
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
                    dscthd[v].nhap();
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


    public boolean IDCTHD(String maspham) {
        if (maspham == null) {
            return true;
        }
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i] != null && dscthd[i].getMasp() != null && dscthd[i].getMasp().equalsIgnoreCase(maspham)) {
                return false;
            }
        }
        return true;
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

    public void themchitiet() {
        System.out.println("Nhap ma san pham can them: ");
        CHITIETHOADON ctmoi = new CHITIETHOADON();
        ctmoi.nhap();
        if (!IDCTHD(ctmoi.getMasp())) {
            System.out.println("Ma san pham da ton tai");
            return;
        }
        dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
        dscthd[dscthd.length - 1] = ctmoi;
        System.out.println("Da them ma san pham moi");

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

    public void thongkesanpham() {
        int d = 0;
        System.out.print("Nhap ma san pham can thong ke: ");
        String masanpham = sc.nextLine();
        for (int i = 0; i < dscthd.length; i++) {
            if (dscthd[i].getMasp().equalsIgnoreCase(masanpham)) {
                d++;
            }
        }
        if (d >= 5) {
            System.out.println("San pham ban chay");
        } else if (d >= 1) {
            System.out.println("San pham ban cham");
        } else {
            System.out.println("San pham ban lo");
        }
    }

    public void docfile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            CHITIETHOADON x = null;
            dscthd = new CHITIETHOADON[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 6) {                  
                            x = new CHITIETHOADON(t[0], t[1], t[2], Integer.parseInt(t[3]), Double.parseDouble(t[4]), Double.parseDouble(t[5]));
                            // ((CHITIETHOADON) x).setMahd();
                            // ((CHITIETHOADON) x).setMasp();
                            // ((CHITIETHOADON) x).setMakh();
                            // x.setSL());
                            // x.setDG());
                            // x.setThanhtien();
                        dscthd = Arrays.copyOf(dscthd, dscthd.length+1);
                        dscthd[dscthd.length-1] = x;
                        System.out.println("Doc: "+x.getMahd()+"-"+x.getMakh()+"-"+x.getMasp());
                }
            }
             System.out.println("Doc file thanh cong, So chi tiet da doc: "+ dscthd.length);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }  //catch (NumberFormatException e) {
        // // //     System.out.println("Loi format so: " + e.getMessage());
        // // }
    }

    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i=0; i < dscthd.length; i++){
                if (dscthd[i] != null){
                    writer.println(dscthd[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: ");
        }catch (IOException e){
            System.out.println("Loi ghi file");
        }   
    }
}

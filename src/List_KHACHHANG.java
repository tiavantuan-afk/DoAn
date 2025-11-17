import java.util.Scanner;
import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class List_KHACHHANG {
    Scanner sc = new Scanner(System.in);
    private int n;
    private KHACHHANG[] dskh = new KHACHHANG[100];

    
    public void nhap() {
        System.out.print("Nhap n khach hang: ");
        n = sc.nextInt();
        for (int i = 0; i < dskh.length; i++) {
            System.out.print("Nhap khach hang thu: " + (i + 1) + "\n");
            dskh[i] = new KHACHHANG();
            dskh[i].nhap();
            sc.close();
        }
    }

    public void xuat() {
        System.out.println("Danh sach khach hang: ");
        for (int i = 0; i < dskh.length; i++) {
            dskh[i].xuat();
        }
    }
    public KHACHHANG[] getDskh(){
        return dskh;
    }
    public void setDskh(KHACHHANG[] dskh){
        this.dskh = dskh;
    }
    public int getN(){
        return n;
    }
    public void setN(int n){
        this.n = n;
    }
    private void tuDongCapNhatFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_KHACHHANG.txt"))) {
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null) {
                writer.println(dskh[i].toString());
            }
        }
        System.out.println("Da tu dong luu thong tin vao file ");
    } catch (IOException e) {
        System.out.println("Loi ghi file " + e.getMessage());
    }
    tuDongCapNhatFile();
    }
        public void timkiemtheoma(String macantim) {
        boolean timkiem = false;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getMaKH() != null && dskh[i].getMaKH().equalsIgnoreCase(macantim)) {
                System.out.println("Da tim thay khach hang ");
                dskh[i].xuat();
                System.out.println();
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay khach hang: " + macantim);
        }
    }
    public void xoakhachhang(String MAKH) { 
        boolean timkiem = false;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getMaKH() != null && dskh[i].getMaKH().equalsIgnoreCase(MAKH)) {
                for (int j = i; j < dskh.length - 1; j++) {
                    dskh[j] = dskh[j + 1];
                }
                dskh = Arrays.copyOf(dskh, dskh.length - 1);
                System.out.println("Da xoa khach hang co ma: " + MAKH);
                timkiem = true;
                tuDongCapNhatFile();
                return;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay khach hang co ma: " + MAKH);
        }
    }
    public void suakhachhang() {
        System.out.print("Nhap ma khach hang can sua: ");
        String MA = sc.nextLine();

        int v = -1;
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i] != null && dskh[i].getMaKH() != null && dskh[i].getMaKH().equalsIgnoreCase(MA)) {
                v = i;
                break;
            }
        }
        if (v == -1) {
            System.out.println("Khong tim thay khach hang co ma: " + MA);
            return;
        }
        System.out.println("--- THONG TIN HIEN TAI ---");
        dskh[v].xuat();
        System.out.println();

        int choice;
        do {
            System.out.println("\n=== CHON THUOC TINH CAN SUA ===");
            System.out.println("1. Sua ma khach hang");
            System.out.println("2. Sua ho khach hang");
            System.out.println("3. Sua ten khach hang");
            System.out.println("4. Sua so dien thoai");
            System.out.println("9.Sua tat ca thong tin ");
            System.out.println("0.Hoan thanh sua ");
            System.out.print("Lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma khach hang moi: ");
                    String maMoi = sc.nextLine();
                    dskh[v].setMakh(maMoi);
                    System.out.println("Da cap nhat ma khach hang");
                    break;

                case 2:
                    System.out.print("Nhap ho khach hang moi: ");
                    String hoMoi = sc.nextLine();
                    dskh[v].setHo(hoMoi);
                    System.out.println("Da cap nhat ho khach hang");
                    break;

                case 3:
                    System.out.println("Nhap ten khach hang moi: ");
                    String tenMoi = sc.nextLine();
                    dskh[v].setTen(tenMoi);
                    System.out.println("Da cap nhat ten khach hang");
                    break;

                case 4:
                    System.out.println("Nhap so dien thoai moi: ");
                    String soMoi = sc.nextLine();
                    dskh[v].setSDT(soMoi);
                    System.out.println("Da cap nhat so dien thoai");
                    break; 
                case 5: // Sửa tất cả
                    System.out.println("Nhap lai tat ca thong tin:");
                    dskh[v].nhap();
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
                dskh[v].xuat();
                System.out.println();
            }
        } while (choice != 0);
        tuDongCapNhatFile();
        System.out.println("Da luu thay doi vao file");
    }
    public boolean IDKH(String makh){
        if (makh == null){
            return true;
        }
        for (int i=0; i<dskh.length; i++){
            if(dskh[i] != null && dskh[i].getMaKH() != null && dskh[i].getMaKH().equalsIgnoreCase(makh)){
                return false;
            }
        }
        return true;
    }
    public void themkhachhang(){
        System.out.println("Nhap khach hang can them");
        KHACHHANG khmoi = new KHACHHANG();
        khmoi.nhap();
        if (!IDKH(khmoi.getMaKH())){
            System.out.println("Ma khach hang da ton tai");
            return;
        }
        dskh = Arrays.copyOf(dskh, dskh.length + 1);
        dskh[dskh.length-1] = khmoi;
        System.out.println("Da them khach hang moi");
    }
    public void thongkekhachhang() {
        int d = 0;
        System.out.print("Nhap ma khach hang can thong ke: ");
        String makhachhang = sc.nextLine();
        for (int i = 0; i < dskh.length; i++) {
            if (dskh[i].getMaKH().equalsIgnoreCase(makhachhang)) {
                d++;
            }
        }
        if (d >= 1) {
            System.out.println("Khach hang cu");
        } else {
            System.out.println("Khach hang moi");
        }
    }
    public void docfile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            KHACHHANG x = null;
            dskh = new KHACHHANG[0];
            while ((line = br.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 4){
                    x = new KHACHHANG();
                    x.setMakh(t[0]);
                    x.setHo(t[1]); 
                    x.setTen(t[2]);
                    x.setSDT((t[3]));
                    dskh = Arrays.copyOf(dskh, dskh.length + 1);
                    dskh[dskh.length - 1] = x;
                    System.out.println("Doc: " + x.getMaKH() + " - " + x.getHo() + " " + x.getTen());

                } 
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: "+ dskh.length);
        }catch (IOException e){
            System.out.println("Loi doc file: "+e.getMessage());
        }// catch (NumberFormatException e){
        //     System.out.println("Loi format so: "+e.getMessage());
        // }
    }
    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i=0; i< dskh.length; i++){
                if (dskh[i] != null){
                    writer.println(dskh[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: "+dskh.length+ " khach");
        }catch (IOException e){
            System.out.println("Loi ghi file");
        }   
    }
}

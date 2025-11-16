import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class List_HOADON {
    Scanner sc = new Scanner(System.in);
    private int n;
    private HOADON[] dshd = new HOADON[100];

    public void nhap() {
        System.out.print("Nhap n hoa don: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap hoa don thu: " + (i + 1));
            dshd[i] = new HOADON();
            dshd[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach hoa don: ");
        for (int i = 0; i < n; i++) {
            dshd[i].xuat();
        }
    }
<<<<<<< HEAD

=======
    public HOADON[] getDshd(){
        return dshd;
    }
    public void setDshd(HOADON[] dshd){
        this.dshd = dshd;
    }
    public int getN(){
        return n;
    }
    public void setN(int n){
        this.n = n;
    }
>>>>>>> 3972c5d6ddb938f5cbc76ce297153f28353977ee
    public void timkiemtheomahd(String hdcantim ) {
        System.out.print("Nhap ma hoa don can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd().equalsIgnoreCase(hdcantim)) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheomanv(String nvcantim) {
        System.out.print("Nhap ma nhan vien can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getManv().equalsIgnoreCase(nvcantim)) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheomakh(String khcantim ) {
        System.out.print("Nhap ma khach hang ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMakh().equalsIgnoreCase(khcantim)) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheongay(String ngaycantim) {
        System.out.print("Nhap ngay can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getNgay().equals(ngaycantim)) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach. ");
        }
    }

    public void timkiemtheotongtien(double tongcantim) {
        System.out.print("Tong tien can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getTongtien() == tongcantim) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void suahoadon() {
        System.out.println("Nhap ma hoa don can sua: ");
        String MA = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd().equalsIgnoreCase(MA)) {
                System.out.println("Da cap nhat thong tin hoa don.");
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay hoa don de sua. ");
        }
    }
    public boolean IDHD(String mahdon){
        if (mahdon == null){
            return true;
        }
        for(int i=0; i<n; i++){
            if (dshd[i] != null && dshd[i].getMahd() != null && dshd[i].getMahd().equalsIgnoreCase(mahdon)){
                return false;
            }
        }
        return true;
    }
    public void themhoadon(){
        System.out.println("Nhap hoa don can them");
        HOADON hdmoi = new HOADON();
        hdmoi.nhap();
        if (!IDHD(hdmoi.getMahd())){
            System.out.println("Ma hao don da ton tai");
            return;
        }
        dshd = Arrays.copyOf(dshd, n+1);
        dshd[n-1] = hdmoi;
        System.out.println("Da them hoa don moi");
    }
    public void xoahoadon(String MAHD) {
        System.out.println("Nhap ma hoa don can xoa: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd().equalsIgnoreCase(MAHD)) {
                for (int j = i; j < n; j++) {
                    dshd[i] = dshd[i + 1];
                }
                dshd[n - 1] = null;
                n--;
                System.out.println("Da xoa hoa don co ma: " + MAHD);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay hoa don co ma: " + MAHD);
        }
    }
    public void thongkenhanvien() {
        int d = 0;
        System.out.print("Nhap ma nhan vien can thong ke: ");
        String manhanvien = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (dshd[i].getManv().equalsIgnoreCase(manhanvien)) {
                d++;
            }
        }
        if (d >= 5) {
            System.out.println("Nhan vien uu tu");
        }
    }
    public void docfile(){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\data\\List_HOADON.txt"))){
            String line;
            HOADON x = null;
            dshd = new HOADON[0];
            while ( (line = br.readLine()) != null) {
                String[] t = line .split("-");
                if (t.length >= 8){
                    String type = t[0].toUpperCase();
                    if (type.contains("HD")){
                        if (t.length >= 9){
                            x = new HOADON();
                            x.setMahd(t[1]);
                            ((HOADON) x).setManv((t[2]));
                            ((HOADON) x).setMakh(t[3]);
                            x.setNgay(t[4]);
                            x.setTongTien(Double.parseDouble(t[5]));
                        }else{
                            continue;
                        }
                    }else{
                        continue;
                    }
                    if (x != null){
                        dshd = Arrays.copyOf(dshd, n+1);
                        dshd[n-1] = x;
                        System.out.println("Doc: "+x.getMahd()+"-"+x.getMakh());
                    }
                }
            }
            System.out.println("Doc file thanh cong");
            System.out.println("So hoa don da doc: "+n);
        }catch (IOException e){
            System.out.println("Loi doc file: "+e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("Loi format so: "+e.getMessage());
        }
    }
    public void ghiFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\data\\List_HOADON.txt"))){
            bw.write("=====DANH SACH HOA DON=====\n");
            bw.write("So luong hao don: "+n+"\n");
            for (int i=0; i<n; i++){
                if (dshd[i] != null){
                    if (dshd[i] instanceof HOADON){
                        HOADON hd = (HOADON) dshd[i];
                        bw.write("HD"+hd.getMahd()+"-"+hd.getManv()+"-"+hd.getMakh()+"-"+hd.getNgay()+"-"+hd.getTongtien()+"\n");
                    }
                }
            }
            System.out.println("Ghi file thanh cong");
        }
        catch (IOException e){
            System.out.println("Loi ghi file: "+e.getMessage());
        }
    }
     public static void main (String[] args){
        List_HOADON dshd = new List_HOADON();
        System.out.println("Bat dau doc file.........");
        dshd.docfile();
        System.out.println("Hien thi ket qua: ");
        dshd.xuat();
    }
}

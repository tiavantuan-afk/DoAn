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

    public void timkiemtheomahd(int hdcantim ) {
        System.out.print("Nhap ma hoa don can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd() == hdcantim) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheomanv(int nvcantim) {
        System.out.print("Nhap ma nhan vien can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getManv() == nvcantim) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheomakh(int khcantim ) {
        System.out.print("Nhap ma khach hang ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMakh() == khcantim) {
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
        int MA = sc.nextInt();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd() == MA) {
                System.out.println("Da cap nhat thong tin hoa don.");
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong ti thay hoa don de sua. ");
        }
    }
    public boolean IDHD(int mahdon){
        if (mahdon == 0){
            return true;
        }
        for(int i=0; i<n; i++){
            if (dshd[i] != null && dshd[i].getMahd() != 0 && dshd[i].getMahd() == mahdon){
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
    public void xoahoadon(int MAHD) {
        System.out.println("Nhap ma hoa don can xoa: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd() == MAHD) {
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
        int manhanvien = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (dshd[i].getManv() == manhanvien) {
                d++;
            }
        }
        if (d >= 5) {
            System.out.println("Nhan vien uu tu");
        }
    }
}

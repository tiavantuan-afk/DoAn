import java.util.Scanner;

class List_KHACHHANG {
    Scanner sc = new Scanner(System.in);
    private int n;
    private KHACHHANG[] dskh = new KHACHHANG[100];

    public void nhap() {
        System.out.print("Nhap n khach hang: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap khach hang thu: " + (i + 1));
            dskh[i] = new KHACHHANG();
            dskh[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach khach hang: ");
        for (int i = 0; i < n; i++) {
            dskh[i].xuat();
        }
    }

    public void timkiemtheoma(int macantim) {
        System.out.print("Nhap ma khach hang can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH() == macantim) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheoten(String tencantim) {
        System.out.print("Nhap ten khach hang: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getTen().toLowerCase().equalsIgnoreCase(tencantim.toLowerCase())) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheoho(String hocantim) {
        System.out.print("Nhap ho can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getHo().toLowerCase().equalsIgnoreCase(hocantim.toLowerCase())) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheosdt(int socantim) {
        System.out.print("Nhap sdt can tim: ");
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getSDT() == socantim) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void xoakhachhang(int MAKH) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH() == MAKH) {
                for (int j = i; j < n; j++) {
                    dskh[i] = dskh[j + 1];
                }
                dskh[n - 1] = null;
                n--;
                System.out.println("Da xoa khach hang co ma: " + MAKH);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay khach hang co ma: " + MAKH);
        }
    }

    public void suakhachhang(int MA, KHACHHANG khang) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH() == MA) {
                dskh[i] = khang;
                System.out.println("Da cap nhat thong tin khach hang: " + MA);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay khach hang de sua: ");
        }

    }

    public void thongkekhachhang() {
        int d = 0;
        System.out.print("Nhap ma khach hang can thong ke: ");
        int makhachhang = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH() == makhachhang) {
                d++;
            }
        }
        if (d >= 1) {
            System.out.println("Khach hang cu");
        } else {
            System.out.println("Khach hang moi");
        }
    }
}

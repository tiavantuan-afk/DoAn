public class Menu_CTHD extends Menu_Main {
    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\nMENU QUAN LY CHI TIET HOA DON");
            System.out.println("1. Xuat danh sach chi tiet hoa don: ");
            System.out.println("2. Tim kiem theo ma hoa don: ");
            System.out.println("3. Sua chi tiet theo ma hoa don: ");
            System.out.println("4. Them san pham theo ma: ");
            System.out.println("5. Xoa chi tiet theo ma hoa don: ");
            System.out.println("6. Thong ke san pham: ");
            System.out.println("0. Thoat.");
            System.out.print("Vui long chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    DSCTHD.xuat();
                    break;
                case 2:
                    System.out.print("Nhap ma hoa don can tim: ");
                    String hdcantim = sc.nextLine();
                    DSCTHD.timkiemtheomahoadon(hdcantim);
                    break;
                case 3:
                    DSCTHD.suachitietmahd();
                    break;
                case 4:
                    String Mahd;
                    do {
                        System.out.print("Nhap ma hoa don: ");
                        Mahd = sc.nextLine();
                        if (!DSHD.TonTai(Mahd)) {
                            System.out.println("Ma hoa don khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSHD.TonTai(Mahd));
                    String Masp;
                    do {
                        System.out.print("Nhap ma mon an: ");
                        Masp = sc.nextLine();
                        if (!DSMA.TonTai(Masp)) {
                            System.out.println("Ma mon an khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSMA.TonTai(Masp));
                    DSCTHD.them(Mahd, Masp, DSMA.getdonGia(Masp));
                    DSHD.capnhattongtien(Mahd, DSCTHD.Tinhtongtien(Mahd));
                    DSMA.GiamSoLuong(Masp, DSCTHD.Soluongmon(Mahd, Masp));
                    DSHD.ghiFile();
                    DSMA.ghiFile();
                    break;
                case 5:
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String hdcanxoa = sc.nextLine();
                    DSCTHD.xoachitietmahd(hdcanxoa);
                    break;
                case 6:
                    DSCTHD.thongKeTongBanCuaSanPham();
                    break;
                case 0:
                    System.out.println("Xong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);

    }

}

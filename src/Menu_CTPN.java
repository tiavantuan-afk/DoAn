public class Menu_CTPN extends Menu_Main {
    String name;

    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\n--- MENU CHI TIET PHIEU NHAP (CTPN) ---");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them mot chi tiet ");
            System.out.println("3. Tim kiem (Theo Ma PNH, tra ve danh sach)");
            System.out.println("4. Sua theo Ma PNH");
            System.out.println("5. Xoa theo Ma PNH");
            System.out.println("6. Thong ke theo ngay");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    DSCTPN.xuat();
                    break;
                case 2:
                    String maPNH;
                    do {
                        System.out.print("Nhap ma hoa don: ");
                        maPNH = sc.nextLine();
                        if (!DSMA.TonTai(maPNH)) {
                            System.out.println("Ma hoa don khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSMA.TonTai(maPNH));
                    String maSP;
                    do {
                        System.out.print("Nhap ma mon an: ");
                        maSP = sc.nextLine();
                        if (!DSMA.TonTai(maSP)) {
                            System.out.println("Ma mon an khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSMA.TonTai(maSP));
                    DSCTPN.them(maPNH, maSP, DSMA.getdonGia(maSP), 0.0);
                    DSPN.capnhattongtien(maPNH, DSCTPN.Tinhtongtien(maPNH));
                    DSMA.CapNhatSoLuong(maSP, DSCTPN.Soluongmon(maPNH, maSP));
                    DSPN.ghiFile();
                    DSMA.ghiFile(name);
                    break;
                case 3:
                    timkiemVaHienThiKetQua();
                    break;
                case 4:
                    DSCTPN.sua();
                    break;
                case 5:
                    System.out.print("Nhap ma phieu nhap can xoa: ");
                    String maXoa = sc.nextLine();
                    DSCTPN.xoaALL(maXoa);
                    DSCTPN.ghiFile();
                    break;
                case 6:
                    DSCTPN.thongketheongay();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai (0-8).");
            }

        } while (chon != 0);
    }

    // Xuất của case 4
    private void timkiemVaHienThiKetQua() {
        Chitietphieunhap[] ketQua = DSCTPN.timKiemTheoMaSP();
        if (ketQua.length > 0) {
            System.out.println("\n=== KET QUA TIM KIEM ===");
            for (Chitietphieunhap ct : ketQua) {
                ct.xuat();
            }
        }
    }

}

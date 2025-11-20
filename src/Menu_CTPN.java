
public class Menu_CTPN extends Menu_Main {
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
                    DSMA.ghiFile();
                    break;
                case 3:
                    timkiemVaHienThiKetQua();
                    break;
<<<<<<< HEAD
                case 4:
                    DSCTPN.sua();
                    DSCTPN.ghiFile();
                    break;
                case 5:
                    System.out.print("Nhap Ma PNH can xoa: ");
                    String maXoa = sc.nextLine().trim();
                    DSCTPN.xoatheoma(maXoa, "");
                    DSCTPN.ghiFile();
                    break;
                case 6:
                    DSCTPN.thongketheongay();
=======
                case 4: 
                    list.timtheoma(fileName);
                    break;
                case 5: 
                    list.suatheoma(fileName);
                    break;
                case 6:
                    list.xoatheoma(fileName);
>>>>>>> c2f8e2ac9b0667321a94bad01043749a22dd6288
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

    private void them() {
        System.out.println("\n--- THÊM MỘT CHI TIẾT PHIẾU NHẬP ---");

        // Nhap maPNH
        System.out.print("Nhap Ma Phieu Nhap Hang (PNH): ");
        String maPNH = sc.nextLine().trim();

        // Nhap maSP
        System.out.print("Nhap Ma San Pham (SP) can nhap: ");
        String maSP = sc.nextLine().trim();

        // Nhập maNV
        System.out.print("Nhap Ma Nhan Vien (NV): ");
        String maNV = sc.nextLine().trim();

        // Nhập DG
        System.out.print("Nhap Don Gia nhap vao: ");
        double donGia;
        if (sc.hasNextDouble()) {
            donGia = sc.nextDouble();
            sc.nextLine();
        } else {
            System.out.println(" Loi: Don gia khong hop le.");
            sc.nextLine();
            return;
        }
        Chitietphieunhap ctMoi = new Chitietphieunhap();
        double thanhTienPlaceholder = 0.0;

        ctMoi.nhap(maPNH, maNV, donGia, thanhTienPlaceholder);
        DSCTPN.them(ctMoi);
    }

}

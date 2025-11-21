public class Menu_PN extends Menu_Main {
    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\nMENU CTPN");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them theo ma");
            System.out.println("3. Tim theo ma");
            System.out.println("4. Sua theo ma");
            System.out.println("5. Xoa theo ma");
            System.out.println("6. Thong ke theo ngay");
            System.out.println("7. Quay ve Menu chinh");
            System.out.println("0 Thoat");
            System.out.print("Chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    DSPN.xuat();
                    break;
                case 2:
                    String maPNH;
                    do {
                        System.out.print("Nhap ma phieu nhap: ");
                        maPNH = sc.nextLine();
                        if (!DSPN.ONEID(maPNH)) {
                            System.out.println("Ma phieu nhap da ton tai! Vui long nhap lai.");
                        }
                    } while (!DSPN.ONEID(maPNH));
                    DSPN.them(maPNH);
                    System.out.println("Nhap so luong chi tiet phieu nhap: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        String maSP;
                        do {
                            System.out.print("Nhap ma sp: ");
                            maSP = sc.nextLine();
                            if (!DSPN.TonTai(maSP)) {
                                System.out.println("Khong ton tai san pham nay: ");
                            }
                        } while (!DSPN.TonTai(maSP));

                    }
                case 3:
                    System.out.print("Nhập mã phiếu nhập cần tìm: ");
                    String maTim = sc.nextLine();
                    DSPN.timtheoma(maTim);
                    break;
                case 4:
                    DSPN.sua();
                    break;
                case 5:
                    System.out.print("Nhập mã phiếu nhập cần xóa: ");
                    String maXoa = sc.nextLine();
                    DSPN.xoatheoma(maXoa);
                    break;
                case 6:
                    DSPN.thongketheongay();
                    break;
                case 0:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
                    break;
            }
        } while (chon != 0);

    }
}
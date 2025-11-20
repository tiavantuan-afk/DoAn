
public class Menu_HD extends Menu_Main {
    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\nMENU QUAN LY HOA DON");
            System.out.println("1. Nhap danh sach hoa don: ");
            System.out.println("2. Xuat danh sach hoa don: ");
            System.out.println("3. Tim mot hoa don theo ma hoa don: ");
            System.out.println("4. Sua mot hoa don theo ma hoa don: ");
            System.out.println("5. Them mot hoa don theo ma hoa don: ");
            System.out.println("6. Xoa mot hoa don theo ma hoa don: ");
            System.out.println("7. Thong ke doanh thu: ");
            System.out.println("8. Quay lai man hinh chinh");
            System.out.println("0. Thoat.");
            System.out.print("Vui long chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    DSHD.nhap();
                    break;
                case 2:
                    DSHD.xuat();
                    break;
                case 3:
                    System.out.print("Nhap ma hoa don can tim: ");
                    String hoadoncantim = sc.nextLine();
                    DSHD.timkiemtheomahd(hoadoncantim);
                    break;
                case 4:
                    DSHD.suahoadon();
                    break;
                case 5:
                    themHoaDonMoi();
                    break;
                case 6:
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String hdcanxoa = sc.nextLine();
                    DSHD.xoahoadon(hdcanxoa);
                    break;
                case 7:
                    DSHD.thongKeDoanhThu();
                    break;
                case 8:
                    System.out.println("Quay li menu chinh...");
                    return;
                case 0:
                    System.out.println("Xong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);

    }

    private String taoMaMoi() {
        int newId = DSHD.getN() + 1;
        String maMoi;
        do {
            maMoi = "HD" + String.format("%03d", newId);
            if (DSHD.ONEID(maMoi)) {
                return maMoi;
            }
            newId++;
        } while (true);
    }

    private void themHoaDonMoi() {
        System.out.println("\n--- TAO HOA DON MOI ---");
        String maHDMoi = taoMaMoi();
        System.out.println("Ma Hoa Don moi: " + maHDMoi);

        DSHD.themhoadon(maHDMoi);
        double tongTien = 100000.0;

        DSHD.capnhattongtien(maHDMoi, tongTien);
        System.out.println(" Tao Hoa Don thanh cong! Tong tien: " + tongTien);
    }
}

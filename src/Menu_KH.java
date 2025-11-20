
public class Menu_KH extends Menu_Main {
    @Override
    public void menu() {
        int luaChon = -1;

        do {
            System.out.println("\n--- MENU QUAN LY KHACH HANG ---");
            System.out.println("1. Nhap danh sach khach hang");
            System.out.println("2. Xuat danh sach khach hang");
            System.out.println("3. Them khach hang");
            System.out.println("4. Sua thong tin khach hang");
            System.out.println("5. Xoa khach hang (theo ma)");
            System.out.println("6. Tim khach hang (theo ma)");
            System.out.println("7. Tim khach hang (theo ten)");
            System.out.println("8. Thong ke ho cua khach hang");
            System.out.println("9. Quay lai menu chinh");
            System.out.println("0. Thoat");
            System.out.print("Vui long chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    DSKH.nhap();
                    DSKH.ghiFile();
                    break;
                case 2:
                    DSKH.xuat();
                    break;
                case 3:
                    DSKH.themkhachhang();
                    DSKH.ghiFile();
                    break;
                case 4:
                    DSKH.suakhachhang();
                    DSKH.ghiFile();
                    break;
                case 5:
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String maCanXoa = sc.nextLine().trim();
                    DSKH.xoakhachhang(maCanXoa);
                    DSKH.ghiFile();
                    break;
                case 6:
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine().trim();
                    DSKH.timkiemtheoma(maCanTim);
                    break;
                case 7:
                    DSKH.timkiemtheoten();
                    break;
                case 8:
                    DSKH.thongKeKhachHangTheoHo();
                    break;
                case 9:
                    System.out.println("Quay lai menu chinh...");
                    return;
                case 0:
                    System.out.println("Xong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
                    break;
            }
        } while (luaChon != 0 && luaChon != 9);
    }

}

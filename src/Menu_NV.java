
public class Menu_NV extends Menu_Main {
    @Override
    public void menu() {
        int luaChon = -1;

        do {
            System.out.println("\n--- MENU QUAN LY NHAN VIEN ---");
            System.out.println("1.Nhap danh sach nhan vien: ");
            System.out.println("2.Xuat danh sach nhan vien: ");
            System.out.println("3.Them nhan vien: ");
            System.out.println("4.Sua thong tin nhan vien:");
            System.out.println("5.Xoa mot nhan vien(Theo ma):");
            System.out.println("6.Tim mot nhan vien(Theo Ma):");
            System.out.println("7.Tim mot nhan vien(Theo Ho khong tham so):");
            System.out.println("8.Thong ke luong nhan vien:");
            System.out.println("9.Quay lai menu chinh...");
            System.out.println("0.Thoat");
            System.out.print("Vui long chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    DSNV.nhapds();
                    DSNV.ghiFile();
                    break;

                case 2:
                    DSNV.xuat();
                    DSNV.ghiFile();
                    break;

                case 3:
                    DSNV.them();
                    DSNV.ghiFile();
                    break;

                case 4:
                    DSNV.suaNV();
                    DSNV.ghiFile();
                    break;
                case 5:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maCanXoa = sc.nextLine();
                    DSNV.xoaMaNV(maCanXoa);
                    DSNV.ghiFile();
                    break;
                case 6:

                    System.out.print("Nhap ma nhan vien can tim: ");
                    String maCanTim = sc.nextLine();
                    DSNV.timNVMa(maCanTim);
                    DSNV.ghiFile();
                    break;
                case 7:
                    DSNV.timNVHo();
                    break;
                case 8:
                    DSNV.ThongKeLuongCoBan();
                    break;

                case 0:
                    System.out.println("Cam on, hen gap lai ");
                    break;
                default:
                    System.out.println("Lua chon khong hop le ");
            }

        } while (luaChon != 0 && luaChon != 9);
    }

}

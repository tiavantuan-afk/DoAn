
public class Menu_MonAn extends Menu_Main {
    @Override
    public void menu() {
        int luaChon = -1;

        do {
            System.out.println("\n--- MENU QUAN LY MON AN ---");
            System.out.println("1.Nhap danh sach mon an: ");
            System.out.println("2.Xuat danh sach mon an: ");
            System.out.println("3.Them mot mon an: ");
            System.out.println("4.Sua thong tin mon an:");
            System.out.println("5.Xoa mot mon an: (Theo ma)");
            System.out.println("6.Tim mot mon an(Theo Ma)");
            System.out.println("7.Tim mot mon an(Theo ten khong tham so)");
            System.out.println("8.Thong ke danh sach mon an");
            System.out.println("9.Quay lai menu chinh...");
            System.out.println("0.Thoat");
            System.out.print("Vui long chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    DSMA.nhapds();
                    DSMA.ghiFile();
                    break;
                case 2:
                    DSMA.xuat();
                    break;
                case 3:
                    int loai;
                    do {
                        System.out.println("Chon loai thuc an: ");
                        System.out.println("1.Thuc An");
                        System.out.println("2.Nuoc Uong");
                        System.out.print("Loai: ");
                        loai = sc.nextInt();
                        sc.nextLine();
                        if (loai != 1 && loai != 2) {
                            System.out.println("Vui long chi chon 1 hay 2.");
                        }

                    } while (loai != 1 && loai != 2);
                    DSMA.themloaisp(loai);
                    DSMA.ghiFile();
                    break;
                case 4:
                    DSMA.docFile();
                    DSMA.sua();
                    DSMA.ghiFile();
                    break;
                case 5:
                    System.out.print("Nhap ma san pham can xoa: ");
                    String maCanXoa = sc.nextLine().trim();
                    DSMA.xoaTheoMa(maCanXoa);
                    DSMA.ghiFile();
                    break;
                case 6:
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine().trim();
                    DSMA.timKiemMa(maCanTim);
                    break;
                case 7:
                    System.out.print("Nhap ten can tim: ");
                    String tenCanTim = sc.nextLine().trim();
                    MonAn[] kq = DSMA.timKiemTheoTen(tenCanTim);
                    break;
                case 8:
                    DSMA.thongKe();
                    break;
                case 0:
                    System.out.println("Xong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
                    break;
            }
        } while (luaChon != 0);

    }

}

import java.util.Scanner;

public class Menu_MonAn {
    private List_MonAn quanLy;
    private String fileName;
    private Scanner sc;

    public static void main(String[] args) {
        Menu_MonAn menu = new Menu_MonAn();
        menu.menu();
    }

    public Menu_MonAn() {
        quanLy = new List_MonAn();
        sc = new Scanner(System.in);
        fileName = "DoAn/src/data/List_MonAn.txt";
        quanLy.docFile(fileName);
    }

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
            System.out.println("0.Thoat");
            System.out.print("Vui long chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    quanLy.nhapds();
                    quanLy.ghiFile(fileName);
                    break;
                case 2:
                    quanLy.xuat();
                    break;
                case 3:
                    quanLy.them();
                    quanLy.ghiFile(fileName);
                    break;
                // case 4:
                // quanLy.sua();
                // break;
                case 5:
                    System.out.print("Nhap ma san pham can xoa: ");
                    String maCanXoa = sc.nextLine().trim();
                    quanLy.xoaTheoMa(maCanXoa);
                    quanLy.ghiFile(fileName);
                    break;
                case 6:
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine().trim();
                    quanLy.timKiemMa(maCanTim);
                    break;
                case 7:
                    quanLy.timKiemTen();
                    break;
                case 8:
                    quanLy.thongKe();
                    break;
                case 0:
                    System.out.println("Xong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
                    break;
            }
        } while (luaChon != 0);
        sc.close();
    }

}

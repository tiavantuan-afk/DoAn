import java.util.Scanner;

public class Menu_MonAn {
    private List_MonAn quanLy;
    private Scanner sc;

    public Menu_MonAn() {
        quanLy = new List_MonAn();
        sc = new Scanner(System.in);
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
            System.out.println("6.Xoa mot mon an(Theo ten)");
            System.out.println("7.Tim mot mon an(Theo Ma)");
            System.out.println("8.Tim mot mon an(Theo ten)");
            System.out.println("9.Thong ke danh sach mon an");
            System.out.println("0.Thoat");
            System.out.print("Vui long chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    quanLy.nhapds();
                    break;
                case 2:
                    quanLy.xuat();
                    break;
                case 3:
                    quanLy.them();
                    break;
                case 4:
                    quanLy.sua();
                    break;
                case 5:
                    System.out.print("Nhap ma san pham can xoa: ");
                    String maCanXoa = sc.nextLine();
                    quanLy.xoaTheoMa(maCanXoa);
                    break;
                case 6:
                    System.out.print("Nhap ten can xoa: ");
                    String tenCanXoa = sc.nextLine();
                    quanLy.xoaTheoTen(tenCanXoa);
                    break;
                case 7:
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine();
                    quanLy.timKiemMa(maCanTim);
                    break;
                case 8:
                    System.out.print("Nhap ten can tim: ");
                    String tenCanTim = sc.nextLine();
                    quanLy.timKiemTen(tenCanTim);
                    break;
                case 9:
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

    public static void main(String[] args) {
        Menu_MonAn menu = new Menu_MonAn();
        menu.menu();
    }
}

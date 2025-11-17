import java.util.Scanner;

public class Menu_TonKho {
    private List_TonKho quanLy;
    private Scanner sc;
    private String fileName = "src/data/List_TonKho.txt";

    public Menu_TonKho() {
        quanLy = new List_TonKho();
        sc = new Scanner(System.in);
    }

    public void menu() {
        int luaChon = -1;

        do {
            System.out.println("\n===== MENU QUAN LY TON KHO =====");
            System.out.println("1. Nhap danh sach ton kho");
            System.out.println("2. Xuat danh sach ton kho");
            System.out.println("3. Them san pham ton kho");
            System.out.println("4. Sua thong tin ton kho");
            System.out.println("5. Xoa san pham (theo ma)");
            System.out.println("6. Tim kiem (theo ma)");
            System.out.println("7. Tim kiem (theo ten)");
            System.out.println("8. Thong ke ton kho");
            System.out.println("9. Quay lai menu chinh");
            System.out.println("0. Thoat");
            System.out.print("Vui long chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    quanLy.nhapds();
                    break;
                case 2:
                    quanLy.docFile(fileName);
                    quanLy.xuat();
                    break;
                case 3:
                    quanLy.them();
                    break;
                case 4:
                    quanLy.docFile(fileName);
                    quanLy.sua();
                    break;
                case 5:
                    quanLy.docFile(fileName);
                    System.out.print("Nhap ma kho can xoa: ");
                    String maCanXoa = sc.nextLine();
                    quanLy.xoaTheoMa(maCanXoa);
                    break;
                case 6:
                    quanLy.docFile(fileName);
                    System.out.print("Nhap ma kho can tim: ");
                    String maCanTim = sc.nextLine();
                    quanLy.timKiemMa(maCanTim);
                    break;
                case 7:
                    quanLy.docFile(fileName);
                    quanLy.timKiemTen();
                    break;
                case 8:
                    quanLy.docFile(fileName);
                    quanLy.thongKe();
                    break;
                case 9:
                    System.out.println("Quay lai menu chinh...");
                    return;
                case 0:
                    System.out.println("Cam on ban da su dung!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (luaChon != 0 && luaChon != 9);
    }

    public static void main(String[] args) {
        Menu_TonKho menu = new Menu_TonKho();
        menu.menu();
    }
}

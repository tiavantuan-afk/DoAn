import java.util.Scanner;

public class Menu_KH {
    private List_KHACHHANG quanLy;
    private String fileName;
    private Scanner sc;

    public Menu_KH() {
        quanLy = new List_KHACHHANG();
        sc = new Scanner(System.in);
        fileName = "src/data/List_KHACHHANG.txt";
        quanLy.docfile(fileName);
    }

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
            System.out.println("8. Thong ke khach hang");
            System.out.println("9. Quay lai menu chinh");
            System.out.println("0. Thoat");
            System.out.print("Vui long chon: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    quanLy.nhap();
                    quanLy.ghiFile(fileName);
                    break;
                case 2:
                    quanLy.xuat();
                    break;
                case 3:
                    quanLy.themkhachhang();
                    quanLy.ghiFile(fileName);
                    break;
                case 4:
                    quanLy.docfile(fileName);
                    quanLy.suakhachhang();
                    break;
                case 5:
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String maCanXoa = sc.nextLine().trim();
                    quanLy.xoakhachhang(maCanXoa);
                    quanLy.ghiFile(fileName);
                    break;
                case 6:
                    System.out.print("Nhap ma can tim: ");
                    String maCanTim = sc.nextLine().trim();
                    quanLy.timkiemtheoma(maCanTim);
                    break;
                case 7:
                    quanLy.timkiemtheoten();
                    break;
                case 8:
                    quanLy.thongkekhachhang();
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

        sc.close();
    }

    public static void main(String[] args) {
        Menu_KH menu = new Menu_KH();
        menu.menu();
    }
}

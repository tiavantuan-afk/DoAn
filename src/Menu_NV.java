import java.util.Scanner;

public class Menu_NV {
    private List_NhanVien quanLy;
    private String fileName;
    private Scanner sc;

    public Menu_NV() {
        quanLy = new List_NhanVien();
        sc = new Scanner(System.in);
        fileName = "src/data/List_NV.txt";
        quanLy.docFile(fileName);
    }

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
                    quanLy.ghiFile(fileName);
                    break;

                case 3:
                    quanLy.them();
                    quanLy.ghiFile(fileName);
                    break;

                case 4:
                    quanLy.suaNV();
                    quanLy.ghiFile(fileName);
                    break;
                case 5:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maCanXoa = sc.nextLine();
                    quanLy.xoaMaNV(maCanXoa);
                    quanLy.ghiFile(fileName);
                    break;
                case 6:

                    System.out.print("Nhap ma nhan vien can tim: ");
                    String maCanTim = sc.nextLine();
                    quanLy.timNVMa(maCanTim);
                    quanLy.ghiFile(fileName);
                    break;
                case 7:
                    quanLy.timNVHo();
                    break;
                case 8:
                    quanLy.ThongKeLuongCoBan();
                    break;
                case 9:
                    System.out.println("Quay lai menu chinh...");
                    return;

                case 0:
                    System.out.println("Cam on, hen gap lai ");
                    break;
                default:
                    System.out.println("Lua chon khong hop le ");
            }

        } while (luaChon != 0 && luaChon != 9);
    }

    public static void main(String[] args) {
        Menu_NV menu = new Menu_NV();
        menu.menu();

    }
}

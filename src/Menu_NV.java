import java.util.Scanner;

public class Menu_NV {
    private List_NhanVien quanLy;
    private Scanner sc;

    public Menu_NV() {
        quanLy = new List_NhanVien();
        sc = new Scanner(System.in);
    }

    public void menu() {
        int luaChon = -1;
        do {
            System.out.println("\n--- MENU QUAN LY NHAN VIEN ---");
            System.out.println("1.Doc file nhan vien: ");
            System.out.println("2.Ghi file nhan vien: ");
            System.out.println("3.Nhap danh sach nhan vien: ");
            System.out.println("4.Xuat danh sach nhan vien: ");
            System.out.println("5.Them nhan vien: ");
            System.out.println("6.Sua thong tin nhan vien:");
            System.out.println("7.Xoa mot nhan vien(Theo ma):");
            System.out.println("8.Xoa mot nhan vien(Theo ho):");
            System.out.println("9.Tim mot nhan vien(Theo Ma):");
            System.out.println("10.Tim mot nhan vien(Theo Ho):");
            System.out.println("11.Tim mot nhan vien(Theo Ten):");
            System.out.println("12.Thong ke luong nhan vien:");
            System.out.println("0.Thoat");
            System.out.print("Vui long chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    quanLy.docFile();
                    break;
                case 2:
                    quanLy.ghiFile();
                case 3:
                    quanLy.nhapds();
                    break;

                case 4:
                    quanLy.xuatds();
                    break;

                case 5:
                    quanLy.them();
                    break;

                case 6:
                    quanLy.suaNV();
                    break;

                case 7:
                    System.out.print("Nhap ma nhan vien can xoa: ");
                    String maCanXoa = sc.nextLine();
                    quanLy.xoaMaNV(maCanXoa);
                    break;

                case 8:
                    System.out.print("Nhap ho nhan vien can xoa: ");
                    String hoCanXoa = sc.nextLine();
                    quanLy.xoaHoNV(hoCanXoa);
                    break;

                case 9:
                    System.out.print("Nhap ma nhan vien can tim: ");
                    String maCanTim = sc.nextLine();
                    quanLy.timNVMa(maCanTim);
                    break;

                case 10:
                    System.out.print("Nhap ho nhan vien can tim: ");
                    String hoCanTim = sc.nextLine();
                    quanLy.timNVHo(hoCanTim);
                    break;

                case 11:
                    System.out.print("Nhap ten nhan vien can tim: ");
                    String tenCanTim = sc.nextLine();
                    quanLy.timNVTen(tenCanTim);
                    break;

                case 12:
                    quanLy.ThongKeLuongCoBan();
                    break;

                case 0:
                    System.out.println("Cam on, hen gap lai ");
                    break;
                default:
                    System.out.println("Lua chon khong hop le ");
            }

        } while (luaChon != 0);
    }

    public static void main(String[] args) {
        Menu_NV menu = new Menu_NV();
        menu.menu();

    }
}

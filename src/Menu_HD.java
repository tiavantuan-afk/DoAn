import java.util.Scanner;
public class Menu_HD {
    private List_HOADON quanly;
    private Scanner sc;
    public Menu_HD(){
        quanly = new List_HOADON();
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("MENU QUAN LY HOA DON");
            System.out.println("1. Nhap danh sach hoa don: ");
            System.out.println("2. Xuat danh sach hoa don: ");
            System.out.println("3. Tim mot hoa don theo ma hoa don: ");
            System.out.println("4. Tim mot hoa don theo ma nhan vien: ");
            System.out.println("5. Tim mot hoa don theo ma khach hang: ");
            System.out.println("6. Tim mot hoa don theo ngay: ");
            System.out.println("7. Tim mot hoa don theo tong tien: ");
            System.out.println("8. Sua mot hoa don theo ma hoa don: ");
            System.out.println("9. Them mot hoa don theo ma hoa don: ");
            System.out.println("10. Xoa mot hoa don theo ma hoa don: ");
            System.out.println("11. Thong ke nhan vien: ");
            System.out.println("0. Thoat.");
            System.out.println("Vui long chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    quanly.nhap();
                    break;
                case 2:
                    quanly.xuat();
                    break;
                case 3:
                    System.out.println("Nhap ma hoa don can tim: ");
                    int hoadoncantim = sc.nextInt();
                    quanly.timkiemtheomahd(hoadoncantim);
                    break;
                case 4:
                    System.out.println("Nhap ma nhan vien can tim: ");
                    int nhanviencantim = sc.nextInt();
                    quanly.timkiemtheomanv(nhanviencantim);
                    break;
                case 5:
                    System.out.println("Nhap ma khach hang can tim: ");
                    int khachhangcantim = sc.nextInt();
                    quanly.timkiemtheomakh(khachhangcantim);
                    break;
                case 6:
                    System.out.println("Nhap ngay can tim: ");
                    String ngaycantim = sc.nextLine();
                    quanly.timkiemtheongay(ngaycantim);
                    break;
                case 7:
                    System.out.println("Nhap tong tien can tim: ");
                    double tongtiencantim = sc.nextDouble();
                    quanly.timkiemtheotongtien(tongtiencantim);
                    break;
                case 8:
                    quanly.suahoadon();
                    break;
                case 9:
                    quanly.themhoadon();
                case 10:
                    System.out.println("Nhap ma hoa don can xoa: ");
                    int hdcanxoa = sc.nextInt();
                    quanly.xoahoadon(hdcanxoa);
                    break;
                case 11:
                    quanly.thongkenhanvien();
                    break;
                case 0:
                    System.out.println("Hiphop never die");
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
    }
    public static void main (String[] agrs){
        Menu_HD menu = new Menu_HD();
        menu.menu();
    }
}

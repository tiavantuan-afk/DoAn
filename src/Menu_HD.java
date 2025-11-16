import java.util.Scanner;
public class Menu_HD {
    private List_HOADON quanly;
    private Scanner sc;
    public Menu_HD(){
        quanly = new List_HOADON();
        sc = new Scanner(System.in);
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("\nMENU QUAN LY HOA DON");
            System.out.println("3. Nhap danh sach hoa don: ");
            System.out.println("4. Xuat danh sach hoa don: ");
            System.out.println("5. Tim mot hoa don theo ma hoa don: ");
            System.out.println("6. Tim mot hoa don theo ma nhan vien: ");
            System.out.println("7. Tim mot hoa don theo ma khach hang: ");
            System.out.println("8. Tim mot hoa don theo ngay: ");
            System.out.println("9. Tim mot hoa don theo tong tien: ");
            System.out.println("10. Sua mot hoa don theo ma hoa don: ");
            System.out.println("11. Them mot hoa don theo ma hoa don: ");
            System.out.println("12. Xoa mot hoa don theo ma hoa don: ");
            System.out.println("13. Thong ke nhan vien: ");
            System.out.println("0. Thoat.");
            System.out.print("Vui long chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 3:
                    quanly.nhap();
                    break;
                case 4:
                    quanly.xuat();
                    break;
                case 5:
                    System.out.print("Nhap ma hoa don can tim: ");
                    int hoadoncantim = sc.nextInt();
                    quanly.timkiemtheomahd(hoadoncantim);
                    break;
                case 6:
                    System.out.print("Nhap ma nhan vien can tim: ");
                    int nhanviencantim = sc.nextInt();
                    quanly.timkiemtheomanv(nhanviencantim);
                    break;
                case 7:
                    System.out.print("Nhap ma khach hang can tim: ");
                    int khachhangcantim = sc.nextInt();
                    quanly.timkiemtheomakh(khachhangcantim);
                    break;
                case 8:
                    System.out.print("Nhap ngay can tim: ");
                    String ngaycantim = sc.nextLine();
                    quanly.timkiemtheongay(ngaycantim);
                    break;
                case 9:
                    System.out.print("Nhap tong tien can tim: ");
                    double tongtiencantim = sc.nextDouble();
                    quanly.timkiemtheotongtien(tongtiencantim);
                    break;
                case 10:
                    quanly.suahoadon();
                    break;
                case 11:
                    quanly.themhoadon();
                case 12:
                    System.out.print("Nhap ma hoa don can xoa: ");
                    int hdcanxoa = sc.nextInt();
                    quanly.xoahoadon(hdcanxoa);
                    break;
                case 13:
                    quanly.thongkenhanvien();
                    break;
                case 0:
                    System.out.println("Hiphop never die");
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
        sc.close();
    }
    public static void main (String[] args){
        Menu_HD menu = new Menu_HD();
        menu.menu();
    }
}

import java.util.Scanner;
public class Menu_KH {
    private List_KHACHHANG quanly;
    private Scanner sc;
    public Menu_KH(){
        quanly = new List_KHACHHANG();
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("MENU QUAN LY KHACH HANG");
            System.out.println("1. Nhap danh sach khach hang: ");
            System.out.println("2. Xuat danh sach khach hang: ");
            System.out.println("3. Them khach hang: ");
            System.out.println("4. Sua thong tin khach hang: ");
            System.out.println("5. Xoa mot khach hang (theo ma): ");
            // System.out.println("6. Xoa mot khach hang (theo ho): ");
            // System.out.println("7. Xoa mot khach hang (theo ten): ");
            System.out.println("6. Tim mot khach hang (theo ma): ");
            System.out.println("7. Tim mot khach hang (theo ho): ");
            System.out.println("8. Tim mot khach hang (theo ten): ");
            System.out.println("9. Tim mot khach hang (theo so dien thoai): ");
            System.out.println("10. Thong ke khach hang: ");
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
                    quanly.themkhachhang();
                    break;
                case 4: 
                    quanly.suakhachhang();
                    break;
                case 5:
                    System.out.println("Nhap ma khach hang can xoa: ");
                    int khcanxoa = sc.nextInt();
                    quanly.xoakhachhang(khcanxoa);
                    break;
                case 6:
                    System.out.println("Nhap ma khach hang can tim: ");
                    int makhcantim = sc.nextInt();
                    quanly.timkiemtheoma(makhcantim);
                    break;
                case 7:
                    System.out.println("Nhap ho khach hang can tim: ");
                    String hokhcantim = sc.nextLine();
                    quanly.timkiemtheoten(hokhcantim);
                    break;
                case 8:
                    System.out.println("Nhap ten khach hang can tim: ");
                    String tenkhcantim = sc.nextLine();
                    quanly.timkiemtheoho(tenkhcantim);
                    break;
                case 9:
                    System.out.println("Nhap sdt khach hang can tim: ");
                    int sdtkhcantim = sc.nextInt();
                    quanly.timkiemtheosdt(sdtkhcantim);
                    break;
                case 10:
                    quanly.thongkekhachhang();
                    break;
                case 0:
                    System.out.println("Hip hop never die");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
    }
    public static void main (String[] args){
        Menu_KH menu = new Menu_KH();
        menu.menu();
    }
}

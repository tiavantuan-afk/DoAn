import java.util.Scanner;
public class Menu_KH {
    private List_KHACHHANG quanly;
    private String filename;
    private Scanner sc;

    public static void main(String[] args) {
        Menu_KH menu = new Menu_KH();
        menu.menu();
    }
    public Menu_KH(){
        quanly = new List_KHACHHANG();
        sc = new Scanner(System.in);
        filename = "src/data/List_KHACHHANG.txt";
        quanly.docfile(filename);
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("\nMENU QUAN LY KHACH HANG");
            System.out.println("1. Nhap danh sach khach hang: ");
            System.out.println("2. Xuat danh sach khach hang: ");
            System.out.println("3. Them khach hang: ");
            System.out.println("4. Sua thong tin khach hang: ");
            System.out.println("5. Xoa mot khach hang (theo ma): ");
            System.out.println("6. Tim mot khach hang (theo ma): ");
            System.out.println("7. Thong ke khach hang: ");
            System.out.println("0. Thoat.");
            System.out.print("Vui long chon: ");
            chon = sc.nextInt();
            sc.nextLine();
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
                    System.out.print("Nhap ma khach hang can xoa: ");
                    String khcanxoa = sc.nextLine();
                    quanly.xoakhachhang(khcanxoa);
                    break;
                case 6:
                    System.out.print("Nhap ma khach hang can tim: ");
                    String makhcantim = sc.nextLine();
                    quanly.timkiemtheoma(makhcantim);
                    break;
                case 7:
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
        sc.close();
    }   
}

import java.util.Scanner;
public class Menu_HD {
    private List_HOADON quanly;
    private String filename;
    private Scanner sc;
    public static void main (String[] args){
        Menu_HD menu = new Menu_HD();
        menu.menu();
    }
    public Menu_HD(){
        quanly = new List_HOADON();
        sc = new Scanner(System.in);
        filename = "src/data/List_HOADON.txt";
        quanly.docfile(filename);
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("\nMENU QUAN LY HOA DON");
            System.out.println("1. Nhap danh sach hoa don: ");
            System.out.println("2. Xuat danh sach hoa don: ");
            System.out.println("3. Tim mot hoa don theo ma hoa don: ");
            System.out.println("4. Sua mot hoa don theo ma hoa don: ");
            System.out.println("5. Them mot hoa don theo ma hoa don: ");
            System.out.println("6. Xoa mot hoa don theo ma hoa don: ");
            System.out.println("7. Thong ke nhan vien: ");
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
                    System.out.print("Nhap ma hoa don can tim: ");
                    String hoadoncantim = sc.nextLine();
                    quanly.timkiemtheomahd(hoadoncantim);
                    break;
                case 4:
                    quanly.suahoadon();
                    break;
                case 5:
                    quanly.themhoadon();
                    break;
                case 6:
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String hdcanxoa = sc.nextLine();
                    quanly.xoahoadon(hdcanxoa);
                    break;
                case 7:
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
}

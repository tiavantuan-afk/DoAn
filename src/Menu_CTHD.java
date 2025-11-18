import java.util.Scanner;
public class Menu_CTHD {
    private List_CTHD quanly;
    private String filename;
    private Scanner sc;
    public static void main (String[] args){
        Menu_CTHD menu = new Menu_CTHD();
        menu.menu();
    }
    public Menu_CTHD(){
        quanly = new List_CTHD();
        sc = new Scanner(System.in);
        filename = "src/data/List_CTHD.txt";
        quanly.docfile(filename);
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("\nMENU QUAN LY CHI TIET HOA DON");
            System.out.println("1. Nhap danh sach chi tiet hoa don: ");
            System.out.println("2. Xuat danh sach chi tiet hoa don: ");
            System.out.println("3. Tim kiem theo ma hoa don: ");
            System.out.println("4. Sua chi tiet theo ma hoa don: ");
            System.out.println("5. Them san pham theo ma: ");
            System.out.println("6. Xoa chi tiet theo ma hoa don: ");
            System.out.println("7. Thong ke san pham: ");
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
                    String hdcantim = sc.nextLine();
                    quanly.timkiemtheomahoadon(hdcantim);
                    break;
                case 4:
                    quanly.suachitietmahd();
                    break;
                case 5:
                    quanly.themchitiet();
                    break;
                case 6:
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String hdcanxoa = sc.nextLine();
                    quanly.xoachitietmahd(hdcanxoa);
                    break;
                case 7:
                    quanly.thongkesanpham();
                    break;    
                case 0:
                    System.out.println("Xong");
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
        sc.close();
    }

}

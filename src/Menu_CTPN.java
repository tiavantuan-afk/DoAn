import java.util.Scanner;
public class Menu_CTPN {
    private List_CTPN list;
    private String fileName;
    private Scanner sc;
    public Menu_CTPN() {
        list = new List_CTPN();
        sc = new Scanner(System.in);
        fileName = "src/data/List_CTPN.txt";
        list.docFile(fileName);
    }
    public void menu(){
        int chon = -1;
        do {
            System.out.println("\nMENU CTPN");
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Them theo ma");
            System.out.println("4. Tim theo ma");
            System.out.println("5. Sua theo ma");
            System.out.println("6. Xoa theo ma");
            System.out.println("7. Thong ke theo ngay ");
            System.out.println("8. Quay ve Menu chinh");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1: 
                    list.nhap();
                    break;
                case 2:
                    list.xuat();
                    break;
                case 3: 
                    list.themTheoMa();
                    break;
                case 4: 
                    list.timtheoma();
                    break;
                case 5: 
                    list.suatheoma();
                    break;
                case 6:
                    list.xoatheoma();
                    break;
                case 7:
                    list.thongketheongay();
                    break;
                case 8:
                    System.out.print("Quay lai menu chinh");
                    Menu_Main mainMenu = new Menu_Main();
                    mainMenu.menuChinh();
                    return;
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Khong hop le");
                    break;
            }

        } while (chon != 0);
    }
    public static void main(String[] args) {
        Menu_CTPN menu = new Menu_CTPN();
        menu.menu();
    }
}


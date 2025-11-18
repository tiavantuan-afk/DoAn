import java.util.Scanner;
public class Menu_PN {
    private List_PN list;
    private String fileName;
    private Scanner sc;
    public Menu_PN() {
        list = new List_PN();
        sc = new Scanner(System.in);
        fileName = "src/data/List_PN.txt";
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
            System.out.println("7. Thong ke theo ngay");
            System.out.println("8. Quay ve Menu chinh");
            System.out.println("0 Thoat");
            System.out.print("Chon: ");

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
                    list.themtheoma(); 
                    break;
                case 4: 
                    list.timTheoMa(); 
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
                    System.out.print("Quay lai Menu chinh");
                    Menu_Main mainMenu = new Menu_Main();
                    mainMenu.menuChinh();
                    return;
                case 0:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
                    break;
            }
        } while (chon != 0);
    }
    public static void main(String[] args) {
        Menu_PN menu = new Menu_PN();
        menu.menu();
    }
}

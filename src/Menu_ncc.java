import java.util.Scanner;

public class Menu_ncc {
    private List_NCC list;
    private String fileName;
    private Scanner sc;
    public Menu_ncc() {
        list = new List_NCC();
        sc = new Scanner(System.in);
        fileName = "src/data/List_NCC.txt";
        list.docFile(fileName);
    }
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\n1.Nhap danh sach nha cung cap");
            System.out.println("2.Xuat danh sach nha cung cap");
            System.out.println("3.Tim kiem nha cung cap theo ma");
            System.out.println("4.Them nha cung cap theo ma");
            System.out.println("5.Xoa nha cung cap theo ma");
            System.out.println("6.Sua nha cung cap theo ma");
            System.out.println("7.Thong ke nha cung cap theo ho");
            System.out.println("8.Quay lai Menu chinh");
            System.out.println("0.Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    list.nhap();
                    break;
                case 2:
                    list.xuat();
                    break;
                case 3:
                    list.timtheoma(fileName);
                    break;
                case 4:
                    list.themtheoma();
                    break;
                case 5:
                    list.xoatheoma(fileName);
                    break;
                case 6:
                    list.suatheoma(fileName);
                    break;
                case 7:
                    list.thongketheohoncc();
                    break;
                case 8:
                    System.out.print("Quay ve menu chinh");
                    Menu_Main menuMain = new Menu_Main();
                    menuMain.menuChinh();
                case 0:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
                    break;
            }
        }while (chon != 0);
        sc.close();
    }
    public static void main(String[] args) {
        Menu_ncc menu = new Menu_ncc();
        menu.menu();
    }
}

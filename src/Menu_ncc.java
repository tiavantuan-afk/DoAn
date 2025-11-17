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
            System.out.println("\n1.Nhập danh sách nhà cung cấp");
            System.out.println("2.Xuất danh sách nhà cung cấp");
            System.out.println("3.Tìm kiếm nhà cung cấp theo mã");
            System.out.println("4.Thêm nhà cung cấp theo mã");
            System.out.println("5.Thêm nhà cung cấp theo địa chỉ");
            System.out.println("6.Xoá nhà cung cấp theo mã");
            System.out.println("7.Xoá nhà cung cấp theo số điện thoại");
            System.out.println("8.Sửa nhà cung cấp theo mã");
            System.out.println("9.Thong ke nha cung cap theo ho");
            System.out.println("0.Thoát");
            System.out.print("Chọn chức năng: ");
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
                    list.timkiemtheoma();
                    break;
                case 4:
                    list.themtheoma();
                    break;
                case 5:
                    list.themtheodiachi();
                    break;
                case 6:
                    list.xoatheoma();
                    break;
                case 7:
                    list.xoatheosdt();
                    break;
                case 8:
                    list.suatheoma();
                    break;
                case 9:
                    list.thongketheohoncc();
                    break;
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

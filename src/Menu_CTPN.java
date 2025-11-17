import java.util.Scanner;
public class Menu_CTPN {
    private List_CTPN list;
    private String fileName;
    private Scanner sc;
    public Menu_CTPN() {
        list = new List_CTPN();
        sc = new Scanner(System.in);
        fileName = "src/data/List_NV.txt";
        list.docFile(fileName);
    }
    public void menu(){
        int chon = -1;
        do {
            System.out.println("\nMENU CTPN");
            System.out.println("1. Nhập danh sách");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Thêm theo mã");
            System.out.println("4. Tìm theo mã");
            System.out.println("5. Sửa theo mã");
            System.out.println("6. Xoá theo mã");
            System.out.println("7. Thong ke theo ngay nhap chi tiet phieu nhap hang");
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
                case 0:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }

        } while (chon != 0);
    }
    public static void main(String[] args) {
        Menu_CTPN menu = new Menu_CTPN();
        menu.menu();
    }
}


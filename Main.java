import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Danhsachncc dsncc = new Danhsachncc();
        while(true){
            System.out.println("\n1.Nhập danh sách nhà cung cấp");
            System.out.println("2.Xuất danh sách nhà cung cấp");
            System.out.println("3.Tìm kiếm nhà cung cấp theo mã");
            System.out.println("4.Tìm kiếm nhà cung cấp theo họ");
            System.out.println("5.Tìm kiếm nhà cung cấp theo tên");
            System.out.println("6.Thêm nhà cung cấp theo mã");
            System.out.println("7.Thêm nhà cung cấp theo địa chỉ");
            System.out.println("8.Xoá nhà cung cấp theo mã");
            System.out.println("9.Xoá nhà cung cấp theo số điện thoại");
            System.out.println("10.Sửa nhà cung cấp theo mã");
            System.out.println("0.Thoát");
            System.out.print("Chọn chức năng: ");
            int chon = sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    dsncc.nhap();
                    break;
                case 2:
                    dsncc.xuat();
                    break;
                case 3:
                    dsncc.timkiemtheoho();
                    break;
                   case 4:
                    dsncc.timkiemtheoten();
                    break;
                case 5:
                    dsncc.timkiemtheoma();
                    break;
                case 6:
                    dsncc.themtheoma();
                    break;
                case 7:
                    dsncc.themtheodiachi();
                    break;
                case 8:
                    dsncc.xoatheoma();
                    break;
                case 9:
                    dsncc.xoatheosdt();
                    break;
                case 10:
                    dsncc.suatheoma();
                case 0:
                    System.out.println("Thoat chuong trinh");
                    return;
            }
        }
    }
}
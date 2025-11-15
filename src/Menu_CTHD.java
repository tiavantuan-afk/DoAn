import java.util.Scanner;
public class Menu_CTHD {
    private List_CTHD quanly;
    private Scanner sc;
    public Menu_CTHD(){
        quanly = new List_CTHD();
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("MENU QUAN LY CHI TIET HOA DON");
            System.out.println("1. Nhap danh sach chi tiet hoa don: ");
            System.out.println("2. Xuat danh sach chi tiet hoa don: ");
            System.out.println("3. Tim kiem theo ma hoa don: ");
            System.out.println("4. Tim kiem theo ma san pham: ");
            System.out.println("5. Tim kiem theo ma khach hang: ");
            System.out.println("6. Tim kiem theo so luong: ");
            System.out.println("7. Tim kiem theo don gia: ");
            System.out.println("8. Tim kiem theo thanh tien: ");
            System.out.println("9. Sua chi tiet theo ma hoa don: ");
            System.out.println("10. Them san pham theo ma: ");
            System.out.println("11. Xoa chi tiet theo ma hoa don: ");
            System.out.println("12. Thong ke san pham: ");
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
                    System.out.println("Nhap ma hoa don can tim: ");
                    int hdcantim = sc.nextInt();
                    quanly.timkiemtheomahoadon(hdcantim);
                    break;
                case 4:
                    System.out.println("Nhap ma san pham can tim: ");
                    int spcantim = sc.nextInt();
                    quanly.timkiemtheomasanpham(spcantim);
                    break;
                case 5:
                    System.out.println("Nhap ma khach hang can tim: ");
                    int khcantim = sc.nextInt();
                    quanly.timkiemtheomakhachhang(khcantim);
                    break;
                case 6:
                    System.out.println("Nhap so luong can tim: ");
                    int slcantim = sc.nextInt();
                    quanly.timkiemtheosoluong(slcantim);
                    break;
                case 7:
                    System.out.println("Nhap so don gia can tim:  ");
                    double dgcantim = sc.nextDouble();
                    quanly.timkiemtheodongia(dgcantim);
                    break;
                case 8:
                    System.out.println("Nhap so thanh tien can tim: ");
                    double ttcantim = sc.nextDouble();
                    quanly.timkiemtheothanhtien(ttcantim);
                    break;
                case 9:
                    quanly.suachitietmahd();
                    break;
                case 10:
                    quanly.themchitiet();
                    break;
                case 11:
                    System.out.println("Nhap ma hoa don can xoa: ");
                    int hdcanxoa = sc.nextInt();
                    quanly.xoachitietmahd(hdcanxoa);
                    break;
                case 12:
                    quanly.thongkesanpham();
                    break;    
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
    }
    public static void main (String[] args){
        Menu_CTHD menu = new Menu_CTHD();
        menu.menu();
    }
}

import java.util.Scanner;

public class Menu_Main {
    private Scanner sc;

    public Menu_Main() {
        sc = new Scanner(System.in);
    }

    public void menuChinh() {
        int luaChon = -1;

        do {
            System.out.println("\n===============================================");
            System.out.println("         CHUONG TRINH QUAN LY CUA HANG");
            System.out.println("===============================================");
            System.out.println("1. Quan ly Mon An");
            System.out.println("2. Quan ly Nhan Vien");
            System.out.println("3. Quan ly Khach Hang");
            System.out.println("4. Quan ly Hoa Don");
            System.out.println("5. Quan ly Kho Hang");
            System.out.println("6. Quan ly Ton Kho");

            System.out.println("8. Sao luu du lieu");
            System.out.println("9. Quan ly Nguyen Lieu");
            System.out.println("10. Quan ly Combo");
            System.out.println("12. Thong ke tong quan");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("===============================================");
            System.out.print("Vui long chon chuc nang: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    quanLyMonAn();
                    break;
                case 2:
                    quanLyNhanVien();
                    break;
                case 3:
                    quanLyKhachHang();
                    break;
                case 4:
                    quanLyHoaDon();
                    break;
                case 5:
                    quanLyKhoHang();
                    break;
                case 6:
                    quanLyTonKho();
                    break;
                case 7:
                    quanLyKhoHang();
                    break;
                case 8:
                    quanLyCOMBO();
                    break;
                case 9:
                    quanLyNguyenLieu();
                    break;
                case 11:
                    thongKeTongQuan();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    System.out.println("Hen gap lai!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le! Vui long thu lai.");
                    break;
            }
        } while (luaChon != 0);

        sc.close();
    }

    private void quanLyMonAn() {
        System.out.println("\n=== CHUYEN DEN QUAN LY MON AN ===");
        Menu_MonAn menuMonAn = new Menu_MonAn();
        menuMonAn.menu();
    }

    private void quanLyNhanVien() {
        System.out.println("\n=== CHUYEN DEN QUAN LY NHAN VIEN ===");
        Menu_NV menuNV = new Menu_NV();
        menuNV.menu();

    }

    private void quanLyKhachHang() {
        System.out.println("\n=== QUAN LY KHACH HANG ===");
        System.out.println("Chuc nang dang phat trien...");

    }

    private void quanLyHoaDon() {
        System.out.println("\n=== QUAN LY HOA DON ===");
        System.out.println("Chuc nang dang phat trien...");

    }

    private void quanLyKhoHang() {
        System.out.println("\n=== QUAN LY KHO HANG ===");
        System.out.println("Chuc nang dang phat trien...");
        Menu_KHO menuKho = new Menu_KHO();
        menuKho.menu();

    }

    private void quanLyNguyenLieu() {
        System.out.println("\n=== CHUYEN DEN QUAN LY NGUYEN LIEU ===");
        Menu_Nguyenlieu menuNguyenlieu = new Menu_Nguyenlieu();
        menuNguyenlieu.menu();
    }

    private void quanLyCOMBO() {
        System.out.println("\n=== CHUYEN DEN QUAN LY COMBO ===");
        Menu_COMBO menuCombo = new Menu_COMBO();
        menuCombo.menu();
    }

    private void quanLyTonKho() {
        System.out.println("\n=== QUAN LY TON KHO ===");
        Menu_TonKho menuTK = new Menu_TonKho();
        menuTK.menu();

    }

    private void thongKeTongQuan() {
        System.out.println("\n=== CHUYEN DEN THONG KE TONG QUAN ===");
        THONGKETOANBO thongKe = new THONGKETOANBO();
        thongKe.menu();
    }

    private void saoLuuDuLieu() {
        System.out.println("\n=== SAO LUU DU LIEU ===");
        System.out.println("1. Sao luu tat ca");
        System.out.println("2. Khoi phuc du lieu");
        System.out.println("3. Xuat ra Excel");
        System.out.println("Chuc nang dang phat trien...");
    }

    public static void main(String[] args) {
        Menu_Main mainMenu = new Menu_Main();
        mainMenu.menuChinh();
    }
}

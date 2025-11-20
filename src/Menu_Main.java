import java.util.Scanner;

public class Menu_Main {
    protected List_PN DSPN = new List_PN();
    protected List_CTPN DSCTPN = new List_CTPN();
    protected List_HOADON DSHD = new List_HOADON();
    protected List_CTHD DSCTHD = new List_CTHD();
    protected List_NCC DSNCC = new List_NCC();
    protected List_MonAn DSMA = new List_MonAn();
    protected List_NhanVien DSNV = new List_NhanVien();
    protected List_KHACHHANG DSKH = new List_KHACHHANG();
    protected List_Nguyenlieu DSNL = new List_Nguyenlieu();
    protected List_KHO DSK = new List_KHO();
    protected List_COMBO DSC = new List_COMBO();
    private Menu_Main QL;
    protected Scanner sc = new Scanner(System.in);

    public void menu() {
        int luaChon = -1;
        docdulieuFile();
        do {
            System.out.println("\n===============================================");
            System.out.println("         CHUONG TRINH QUAN LY CUA HANG");
            System.out.println("===============================================");
            System.out.println("1. Quan ly Mon An");
            System.out.println("2. Quan ly Nhan Vien");
            System.out.println("3. Quan ly Khach Hang");
            System.out.println("4. Quan ly Hoa Don");
            System.out.println("5. Quan ly Chi Tiet Hoa Don");
            System.out.println("6. Quan ly Kho Hang");
            System.out.println("7. Quan ly Ton Kho");
            System.out.println("8. Quan ly Combo");
            System.out.println("9. Quan ly chi tiet phieu nhap");
            System.out.println("10. Quan ly phieu nhap");
            System.out.println("11. Quan ly nha cung cap");
            System.out.println("12. Quan ly Nguyen Lieu");
            System.out.println("13. Thong ke tong quan");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("===============================================");
            System.out.print("Vui long chon chuc nang: ");

            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    QL = new Menu_MonAn();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 2:
                    QL = new Menu_NV();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 3:
                    QL = new Menu_KH();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 4:
                    QL = new Menu_HD();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 5:
                    QL = new Menu_CTHD();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 6:
                    QL = new Menu_KHO();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                // case 7:
                // quanLyTonKho();
                // break;
                case 8:
                    QL = new Menu_COMBO();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 9:
                    QL = new Menu_CTPN();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 10:
                    QL = new Menu_PN();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                    break;
                case 11:
                    QL = new Menu_ncc();
                    ChiaSeDuLieu(QL);
                    QL.menu();

                case 12:
                    QL = new Menu_Nguyenlieu();
                    ChiaSeDuLieu(QL);
                    QL.menu();
                case 13:
                    // QL = new Menu();
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
    }

    private void docdulieuFile() {
        try {

            DSNCC.docFile();
            DSPN.docFile();
            DSCTPN.docFile("src/data/List_CTPN.txt");
            DSCTHD.docFile();
            DSHD.docFile();
            DSMA.docFile();
            DSNV.docFile();
            DSKH.docFile();
            DSK.docFile();
            DSC.docFile();
            DSNL.docFile();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    private void ChiaSeDuLieu(Menu_Main qlcon) {
        qlcon.DSPN = this.DSPN;
        qlcon.DSCTPN = this.DSCTPN;
        qlcon.DSHD = this.DSHD;
        qlcon.DSCTHD = this.DSCTHD;
        qlcon.DSNCC = this.DSNCC;
        qlcon.DSMA = this.DSMA;
        qlcon.DSNV = this.DSNV;
        qlcon.DSKH = this.DSKH;
        qlcon.DSNL = this.DSNL;
        qlcon.DSK = this.DSK;
        qlcon.DSC = this.DSC;
    }
}

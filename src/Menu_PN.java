
public class Menu_PN extends Menu_Main {
    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\nMENU CTPN");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them theo ma");
            System.out.println("3. Tim theo ma");
            System.out.println("4. Sua theo ma");
            System.out.println("5. Xoa theo ma");
            System.out.println("6. Thong ke theo ngay");
            System.out.println("7. Quay ve Menu chinh");
            System.out.println("0 Thoat");
            System.out.print("Chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    DSPN.xuat();
                    break;
                case 2:
                    DSPN.thempn();
                    break;
                case 3:
                    DSPN.timTheoMa();
                    break;
                case 4:
                    DSPN.sua();
                    break;
                case 5:
                    DSPN.xoatheoma();
                    break;
                case 6:
                    DSPN.thongketheongay();
                    break;
                case 0:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
                    break;
            }
        } while (chon != 0);

    }
}
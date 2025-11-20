public class Menu_ncc extends Menu_Main {
    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\n1.Nhap danh sach nha cung cap");
            System.out.println("2.Xuat danh sach nha cung cap");
            System.out.println("3.Tim kiem nha cung cap theo ma");
            System.out.println("4.Them nha cung cap theo ma");
            System.out.println("5.Them nha cung cap theo đia chi");
            System.out.println("6.Xoa nha cung cap theo ma");
            System.out.println("7.Xoa nha cung cap theo so đien thoai");
            System.out.println("8.Sua nha cung cap theo ma");
            System.out.println("9.Thong ke nha cung cap theo ho");
            System.out.println("10.Quay lai Menu chinh");
            System.out.println("0.Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    DSNCC.nhap();
                    break;
                case 2:
                    DSNCC.xuat();
                    break;
                case 3:
                    System.out.print("Nhập tên nhà cung cấp cần tìm: ");
                    String ten = sc.nextLine();
                    DSNCC.timKiemTheoTen(ten);
                    break;
                case 4:
                    DSNCC.themtheoma();
                    break;
                case 5:
                    DSNCC.themtheodiachi();
                    break;
                case 6:
                    DSNCC.xoatheoma();
                    break;
                case 7:
                    DSNCC.xoatheosdt();
                    break;
                case 8:
                    DSNCC.sua();
                    break;
                case 9:
                    DSNCC.thongketheohoncc();
                    break;

                case 0:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
                    break;
            }
        } while (chon != 0);
        sc.close();
    }

}

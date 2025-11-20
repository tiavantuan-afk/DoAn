// import java.util.Scanner;

// public class Menu_TonKho extends Menu_Main {

// public void menu() {
// int luaChon = -1;

// do {
// System.out.println("\n===== MENU QUAN LY TON KHO =====");
// System.out.println("1. Nhap danh sach ton kho");
// System.out.println("2. Xuat danh sach ton kho");
// System.out.println("3. Them san pham ton kho");
// System.out.println("4. Sua thong tin ton kho");
// System.out.println("5. Xoa san pham (theo ma)");
// System.out.println("6. Tim kiem (theo ma)");
// System.out.println("7. Tim kiem (theo ten)");
// System.out.println("8. Thong ke ton kho");
// System.out.println("9. Quay lai menu chinh");
// System.out.println("0. Thoat");
// System.out.print("Vui long chon: ");

// luaChon = sc.nextInt();
// sc.nextLine();

// switch (luaChon) {
// case 1:
// DSTK.nhapds();
// break;
// case 2:
// DSTK.docFile(fileName);
// DSTK.xuat();
// break;
// case 3:
// DSTK.them();
// break;
// case 4:
// DSTK.docFile(fileName);
// DSTK.sua();
// break;
// case 5:
// DSTK.docFile(fileName);
// System.out.print("Nhap ma kho can xoa: ");
// String maCanXoa = sc.nextLine();
// DSTK.xoaTheoMa(maCanXoa);
// break;
// case 6:
// DSTK.docFile(fileName);
// System.out.print("Nhap ma kho can tim: ");
// String maCanTim = sc.nextLine();
// DSTK.timKiemMa(maCanTim);
// break;
// case 7:
// DSTK.docFile(fileName);
// DSTK.timKiemTen();
// break;
// case 8:
// DSTK.docFile(fileName);
// DSTK.thongKe();
// break;
// case 9:
// System.out.println("Quay lai menu chinh...");
// Menu_Main mainMenu = new Menu_Main();
// mainMenu.menuChinh();
// case 0:
// System.out.println("Cam on ban da su dung!");
// System.exit(0);
// break;
// default:
// System.out.println("Lua chon khong hop le!");
// break;
// }
// } while (luaChon != 0 && luaChon != 9);
// }

// }

import java.util.Scanner;

public class Menu_KHO {
	private List_KHO quanLy;
	private Scanner sc;

	public Menu_KHO() {
		quanLy = new List_KHO();
		sc = new Scanner(System.in);
	}

	public void menu() {
		int luaChon = -1;
		quanLy.docFile();
		do {
			System.out.println("\n--- MENU QUAN LY KHO HANG ---");
			System.out.println("1. Nhap danh sach hang hoa: ");
			System.out.println("2. Xuat danh sach hang hoa: ");
			System.out.println("3. Them mot hang hoa: ");
			System.out.println("4. Sua thong tin hang hoa:");
			System.out.println("5. Xoa mot hang hoa (Theo ma)");
			System.out.println("6. Xoa mot hang hoa (Theo ten)");
			System.out.println("7. Tim mot hang hoa (Theo ma)");
			System.out.println("8. Tim mot hang hoa (Theo ten)");
			System.out.println("9. Thong ke hang hoa");
			System.out.println("0. Thoat");
			System.out.print("Vui long chon: ");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
				case 1:
					quanLy.nhap();
					break;
				case 2:
					quanLy.xuat();
					break;
				case 3:
					quanLy.them();
					break;
				case 4:
					System.out.print("Nhap ma hang can sua: ");
					String maSua = sc.nextLine();
					System.out.println("Nhap thong tin moi:");
					KHO khoSua = new KHO();
					khoSua.nhap();
					quanLy.suahang(maSua, khoSua);
					break;
				case 5:
					System.out.print("Nhap ma hang can xoa: ");
					String maCanXoa = sc.nextLine();
					quanLy.xoahang(maCanXoa);
					break;
				case 6:
					System.out.print("Nhap ten can xoa: ");
					String tenCanXoa = sc.nextLine();
					quanLy.xoahangtheoten(tenCanXoa);
					break;
				case 7:
					System.out.print("Nhap ma hang can tim: ");
					String maCanTim = sc.nextLine();
					quanLy.timkiemtheoma(maCanTim);
					break;
				case 8:
					System.out.print("Nhap ten hang can tim: ");
					String tenCanTim = sc.nextLine();
					quanLy.timkiemtheoten();
					break;
				case 9:
					quanLy.thongkeKho();
					break;
				case 0:
					System.out.println("Thoat chuong trinh.");
					break;
				default:
					System.out.println("Lua chon khong hop le, vui long chon lai.");
					break;
			}
		} while (luaChon != 0);
		sc.close();
	}

	public static void main(String[] args) {
		Menu_KHO menu = new Menu_KHO();
		menu.menu();
	}
}
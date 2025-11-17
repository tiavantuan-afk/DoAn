import java.util.Scanner;

public class Menu_COMBO {
	private List_COMBO quanLy;
	private Scanner sc;

	//Hàm thiết lập
	public Menu_COMBO() {
		quanLy = new List_COMBO();
		sc = new Scanner(System.in);
	}

	public void menu() {
		int luaChon = -1;
		quanLy.docFile();
		do {
			System.out.println("\n--- MENU QUAN LY COMBO ---");
			System.out.println("1. Nhap danh sach combo: ");
			System.out.println("2. Xuat danh sach combo: ");
			System.out.println("3. Them mot combo: ");
			System.out.println("4. Sua thong tin combo:");
			System.out.println("5. Xoa mot combo (Theo ma)");
			System.out.println("6. Xoa mot combo (Theo ten)");
			System.out.println("7. Tim mot combo (Theo ma)");
			System.out.println("8. Tim mot combo (Theo ten)");
			System.out.println("9. Thong ke combo");
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
					System.out.print("Nhap ma combo can sua: ");
					String maSua = sc.nextLine();
					System.out.println("Nhap thong tin moi:");
					COMBO comboSua = new COMBO();
					comboSua.nhap();
					quanLy.suacombo(maSua, comboSua);
					break;
				case 5:
					System.out.print("Nhap ma combo can xoa: ");
					String maCanXoa = sc.nextLine();
					quanLy.xoacombo(maCanXoa);
					break;
				case 6:
					System.out.print("Nhap ten combo can xoa: ");
					String tenCanXoa = sc.nextLine();
					boolean found = false;
					for (int i = 0; i < quanLy.getN(); i++) {
						if (quanLy.getDs()[i] != null && quanLy.getDs()[i].tenSP != null && 
							quanLy.getDs()[i].tenSP.equalsIgnoreCase(tenCanXoa)) {
							quanLy.xoacombo(quanLy.getDs()[i].maSP);
							found = true;
							break;
						}
					}
					if (!found) System.out.println("Khong tim thay combo co ten: " + tenCanXoa);
					break;
				case 7:
					System.out.print("Nhap ma combo can tim: ");
					String maCanTim = sc.nextLine();
					quanLy.timKiemTheoMa(maCanTim);
					break;
				case 8:
					quanLy.timkiemtheoten();
					break;
				case 9:
					System.out.print("Nhap ma combo can thong ke: ");
					quanLy.thongKeCombo();
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
		Menu_COMBO menu = new Menu_COMBO();
		menu.menu();
	}
}

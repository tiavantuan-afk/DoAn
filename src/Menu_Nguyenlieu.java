
public class Menu_Nguyenlieu extends Menu_Main {
	@Override
	public void menu() {
		int luaChon = -1;

		do {
			System.out.println("\n--- MENU QUAN LY NGUYEN LIEU ---");
			System.out.println("1. Nhap danh sach nguyen lieu: ");
			System.out.println("2. Xuat danh sach nguyen lieu: ");
			System.out.println("3. Them mot nguyen lieu: ");
			System.out.println("4. Sua thong tin nguyen lieu:");
			System.out.println("5. Xoa mot nguyen lieu (Theo ma)");
			System.out.println("6. Xoa mot nguyen lieu (Theo ten)");
			System.out.println("7. Tim mot nguyen lieu (Theo ma)");
			System.out.println("8. Tim mot nguyen lieu (Theo ten)");
			System.out.println("9. Thong ke nguyen lieu");
			System.out.println("10. Quay lai meunu chinh");
			System.out.println("0. Thoat");
			System.out.print("Vui long chon: ");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
				case 1:
					DSNL.nhap();
					break;
				case 2:
					DSNL.xuat();
					break;
				case 3:
					DSNL.them();
					break;
				case 4:
					DSNL.suanguyen();
					break;
				case 5:
					System.out.print("Nhap ma nguyen lieu can xoa: ");
					String maCanXoa = sc.nextLine();
					DSNL.xoanguyen(maCanXoa);
					break;
				case 6:
					System.out.print("Nhap ten can xoa: ");
					String tenCanXoa = sc.nextLine();
					DSNL.xoanguyentheoten(tenCanXoa);
					break;
				case 7:
					System.out.print("Nhap ma can tim: ");
					String maCanTim = sc.nextLine();
					DSNL.timkiemtheoma(maCanTim);
				case 8:
					System.out.print("Nhap ten can tim: ");
					String tenCanTim = sc.nextLine();
					DSNL.timkiemtheoten();
					break;
				case 9:
					DSNL.thongkeNguyenLieu();
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

}

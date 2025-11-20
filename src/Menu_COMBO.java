public class Menu_COMBO extends Menu_Main {
	@Override
	public void menu() {
		int luaChon = -1;

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
			System.out.println("10. Quay lai meunu chinh");
			System.out.println("0. Thoat");
			System.out.print("Vui long chon: ");

			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
				case 1:
					DSC.nhap();
					break;
				case 2:
					DSC.xuat();
					break;
				case 3:
					DSC.them();
					break;
				case 4:
					DSC.suacombo();
					break;
				case 5:
					System.out.print("Nhap ma combo can xoa: ");
					String maCanXoa = sc.nextLine();
					DSC.xoacombo(maCanXoa);
					break;
				case 6:
					System.out.print("Nhap ma combo can tim: ");
					String maCanTim = sc.nextLine();
					DSC.timKiemTheoMa(maCanTim);
					break;
				case 7:
					DSC.timkiemtheoten();
					break;
				case 8:
					DSC.thongKeCombo();
					break;
				case 0:
					System.out.println("Thoat chuong trinh.");
					break;
				default:
					System.out.println("Lua chon khong hop le, vui long chon lai.");
					break;
			}
		} while (luaChon != 0 && luaChon != 9);
	}
}

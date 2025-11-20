
public class Menu_KHO extends Menu_Main {
	@Override
	public void menu() {
		int luaChon = -1;
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
			System.out.println("10. Quay lai meunu chinh");
			System.out.println("0. Thoat");
			System.out.print("Vui long chon: ");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
				case 1:
					DSK.nhap();
					break;
				case 2:
					DSK.xuat();
					break;
				case 3:
					DSK.them();
					DSK.ghiFile();
					break;
				case 4:
					DSK.suahang();
					DSK.ghiFile();
					break;
				case 5:
					System.out.print("Nhap ma hang can xoa: ");
					String maCanXoa = sc.nextLine();
					DSK.xoahang(maCanXoa);
					break;
				case 6:
					System.out.print("Nhap ten can xoa: ");
					String tenCanXoa = sc.nextLine();
					DSK.xoahangtheoten(tenCanXoa);
					break;
				case 7:
					System.out.print("Nhap ma hang can tim: ");
					String maCanTim = sc.nextLine();
					DSK.timkiemtheoma(maCanTim);
					break;
				case 8:
					System.out.print("Nhap ten hang can tim: ");
					String tenCanTim = sc.nextLine();
					DSK.timkiemtheoten();
					break;
				case 9:
					DSK.thongkeKho();
					break;
				case 0:
					System.out.println("Thoat chuong trinh.");
					break;
				default:
					System.out.println("Lua chon khong hop le, vui long chon lai.");
					break;
			}
		} while (luaChon != 0);
	}

}
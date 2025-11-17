import java.util.Scanner;

class List_Nguyenlieu {
	Scanner sc = new Scanner(System.in);
	private int n;
	private Nguyenlieu[] ds = new Nguyenlieu[100];

	public void nhap() {
		System.out.print("Nhap n nguyen lieu: ");
		n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap nguyen lieu thu: " + (i + 1));
			ds[i] = new Nguyenlieu();
			ds[i].nhap();
		}
	}

	public void xuat() {
		System.out.println("Danh sach nguyen lieu: ");
		for (int i = 0; i < n; i++) {
			if (ds[i] != null) ds[i].xuat();
		}
	}

	// tìm kiếm theo mã
	public void timkiemtheoma() {
		System.out.print("Nhap ma nguyen lieu can tim: ");
		String macantim = sc.nextLine();
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null && ds[i].getmaNL().equalsIgnoreCase(macantim)) {
				timkiem = true;
				ds[i].xuat();
			}
		}
		if (!timkiem) System.out.println("Khong co trong danh sach.");
	}

	// tìm kiếm theo tên
	public void timkiemtheoten() {
		System.out.print("Nhap ten nguyen lieu can tim: ");
		String tencantim = sc.nextLine();
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].gettenNL() != null && ds[i].gettenNL().equalsIgnoreCase(tencantim)) {
				timkiem = true;
				ds[i].xuat();
			}
		}
		if (!timkiem) System.out.println("Khong co trong danh sach.");
	}

	// sửa nguyen lieu theo mã
	public void suanguyen(String MA, Nguyenlieu c) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null && ds[i].getmaNL().equalsIgnoreCase(MA)) {
				ds[i] = c;
				System.out.println("Da cap nhat thong tin nguyen lieu: " + MA);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay nguyen lieu de sua: " + MA);
	}

	// xóa nguyen lieu theo mã
	public void xoanguyen(String MAC) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null && ds[i].getmaNL().equalsIgnoreCase(MAC)) {
				for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
				ds[n - 1] = null;
				n--;
				System.out.println("Da xoa nguyen lieu co ma: " + MAC);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay nguyen lieu co ma: " + MAC);
	}

	// thêm một nguyen lieu
	public void them() {
		if (n >= ds.length) {
			ds = java.util.Arrays.copyOf(ds, ds.length + 10);
		}
		Nguyenlieu nguyen = new Nguyenlieu();
		nguyen.nhap();
		ds[n] = nguyen;
		n++;
		System.out.println("Da them nguyen lieu thanh cong.");
	}

	// thống kê nguyen lieu theo mã
	public void thongkeguyen(String macantke) {
		System.out.print("Nhap ma nguyen lieu can thong ke: ");
		macantke = sc.nextLine();
		int d = 0;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null && ds[i].getmaNL().equalsIgnoreCase(macantke)) d++;
		}
		if (d >= 1) System.out.println("Nguyen lieu ton tai");
		else System.out.println("Nguyen lieu khong ton tai");
	}

	// get/set
	public Nguyenlieu[] getDs() {
		return ds;
	}

	public void setDs(Nguyenlieu[] ds) {
		this.ds = ds;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}

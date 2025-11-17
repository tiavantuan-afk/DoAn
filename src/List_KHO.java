import java.util.Scanner;

class List_KHO {
	Scanner sc = new Scanner(System.in);
	private int n;
	private KHO[] ds = new KHO[100];

	public void nhap() {
		System.out.print("Nhap n hang hoa: ");
		n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap hang hoa thu: " + (i + 1));
			ds[i] = new KHO();
			ds[i].nhap();
		}
	}

	public void xuat() {
		System.out.println("Danh sach hang hoa: ");
		for (int i = 0; i < n; i++) {
			if (ds[i] != null) ds[i].xuat();
		}
	}

	// thêm một hàng
	public void them() {
		if (n >= ds.length) {
			ds = java.util.Arrays.copyOf(ds, ds.length + 10);
		}
		KHO hang = new KHO();
		hang.nhap();
		ds[n] = hang;
		n++;
		System.out.println("Da them hang hoa thanh cong.");
	}
	
	// sửa hang theo mã
	public void suahang(int MA, KHO kho) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getMaHang() == MA) {
				ds[i] = kho;
				System.out.println("Da cap nhat thong tin hang hoa: " + MA);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay hang hoa de sua: " + MA);
	}

	// tìm kiếm theo mã có tham số
	public void timkiemtheoma(int macantim) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getMaHang() == macantim) {
				timkiem = true;
				ds[i].xuat();
			}
		}
		if (!timkiem) System.out.println("Khong co trong danh sach.");
	}

	// tìm kiếm theo tên không tham số
	public void timkiemtheoten() {
		System.out.print("Nhap ten hang hoa can tim: ");
		String tenCanTim = sc.nextLine();

		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getTenHang() != null && ds[i].getTenHang().equalsIgnoreCase(tenCanTim)) {
				timkiem = true;
				ds[i].xuat();
			}
		}
		if (!timkiem) System.out.println("Khong co trong danh sach.");
	}

	// xóa hàng theo mã
	public void xoahang(int MAC) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getMaHang() == MAC) {
				for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
				ds[n - 1] = null;
				n--;
				System.out.println("Da xoa hang hoa co ma: " + MAC);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay hang hoa co ma: " + MAC);
	}

	// xóa hàng theo tên
	public void xoahangtheoten(String TENC) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getTenHang() != null && ds[i].getTenHang().equalsIgnoreCase(TENC)) {
				for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
				ds[n - 1] = null;
				n--;
				System.out.println("Da xoa hang hoa co ten: " + TENC);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay hang hoa co ten: " + TENC);
	}

	// thống kê hàng theo mã
	public void thongkehang(int mahang) {
		int d = 0;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getMaHang() == mahang) d++;
		}
		if (d >= 1) System.out.println("Hang hoa ton tai");
		else System.out.println("Hang hoa khong ton tai");
	}

	// get/set
	public KHO[] getDs() {
		return ds;
	}

	public void setDs(KHO[] ds) {
		this.ds = ds;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}

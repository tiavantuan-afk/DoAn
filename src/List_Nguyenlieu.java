import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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

	// sửa nguyen lieu theo mã
	public void suanguyen(String MA, Nguyenlieu c) {
		boolean timkiem = false;

		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].maNL != null && ds[i].maNL.equalsIgnoreCase(MA)) {
				ds[i] = c;
				System.out.println("Da cap nhat thong tin nguyen lieu: " + MA);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay nguyen lieu de sua: " + MA);
	}

	// tìm kiếm theo mã có tham số
	public void timkiemtheoma(String macantim) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null && ds[i].getmaNL().equalsIgnoreCase(macantim)) {
				timkiem = true;
				ds[i].xuat();
			}
		}

		if (!timkiem) System.out.println("Khong co trong danh sach.");
	}

	// tìm kiếm theo tên không tham số
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

	//xóa nguyen lieu theo ten
	public void xoanguyentheoten(String TEN) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].gettenNL() != null && ds[i].gettenNL().equalsIgnoreCase(TEN)) {
				for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
				ds[n - 1] = null;
				n--;
				System.out.println("Da xoa nguyen lieu co ten: " + TEN);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay nguyen lieu co ten: " + TEN);
	}

	// thống kê nguyen lieu theo mã
	public void thongkeguyen() {
		System.out.print("Nhap ma nguyen lieu can thong ke: ");
		String maCanTke = sc.nextLine();
		int d= 0;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null && ds[i].getmaNL().equalsIgnoreCase(maCanTke)) d++;
		}
		System.out.println("So luong nguyen lieu co ma " + maCanTke + " la: " + d);
	}

	//Doc ghi file
	public void docFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_Nguyenlieu.txt"))) {
			String line;
			Nguyenlieu x = null;

			ds = new Nguyenlieu[0];
			n = 0;

			while ((line = br.readLine()) != null) {
				if (line.startsWith("===") || line.startsWith("So luong")) {
					continue;
				}
				String[] t = line.split("-");
				if (t.length >= 3) {
					x = new Nguyenlieu(t[0], t[1], Double.parseDouble(t[2]));
					
					// add vao mang
					ds = Arrays.copyOf(ds, ds.length + 1);
					ds[ds.length -1] = x;
					n++;
					System.out.println("Doc: " + x.maNL + " - " + x.tenNL);
				}
			}
			System.out.println("Da doc file thanh cong.");
			System.out.println("So luong nguyen lieu: " + n);
		
		} catch (IOException e) {
			System.out.println("Loi doc file: " + e.toString());
		} 

	}

	//ghi file
	public void ghiFile(String tenFile){
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/List_Nguyenlieu.txt"))) {
			bw.write("==== DANH SACH NGUYEN LIEU ====\n");
			bw.write("So luong nguyen lieu: " + n + "\n");

			for (int i = 0; i < n; i++) {
				if (ds[i] != null) {
					bw.write("NGUYENLIEU-" + ds[i].maNL + "-" + ds[i].tenNL + "-" + ds[i].dongia + "\n");
				}
			}
			System.out.println("Da ghi file thanh cong.");
		} catch (IOException e) {
			System.out.println("Loi ghi file: " + e.toString());
		}
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

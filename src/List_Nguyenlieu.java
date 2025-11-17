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
	public void thongkeNguyenLieu() {
    if (n == 0) {
        System.out.println("Danh sach nguyen lieu rong!");
        return;
    }

    int dem = n;
    double tongGia = 0;
    double giaCaoNhat = ds[0].getdongia();
    double giaThapNhat = ds[0].getdongia();
    String tenCao = ds[0].gettenNL();
    String tenThap = ds[0].gettenNL();

    for (int i = 0; i < n; i++) {
        if (ds[i] != null) {
            double gia = ds[i].getdongia();
            tongGia += gia;

            if (gia > giaCaoNhat) {
                giaCaoNhat = gia;
                tenCao = ds[i].gettenNL();
            }
            if (gia < giaThapNhat) {
                giaThapNhat = gia;
                tenThap = ds[i].gettenNL();
            }
        }
    }

    System.out.println("=== THONG KE TOAN BO NGUYEN LIEU ===");
    System.out.println("So luong nguyen lieu: " + dem);
    System.out.printf("Tong gia tri: %.2f VND\n", tongGia);
    System.out.printf("Gia cao nhat: %.2f VND (%s)\n", giaCaoNhat, tenCao);
    System.out.printf("Gia thap nhat: %.2f VND (%s)\n", giaThapNhat, tenThap);

    // Phân loại giá trị
    int giaThap = 0, giaTrungBinh = 0, giaCao = 0;
    for (int i = 0; i < n; i++) {
        if (ds[i] != null) {
            double g = ds[i].getdongia();
            if (g < 10000) giaThap++;
            else if (g <= 30000) giaTrungBinh++;
            else giaCao++;
        }
    }

    System.out.println("\n--- PHAN LOAI THEO GIA ---");
    System.out.println("Gia thap (<10k): " + giaThap + " mat hang");
    System.out.println("Gia trung binh (10k-30k): " + giaTrungBinh + " mat hang");
    System.out.println("Gia cao (>30k): " + giaCao + " mat hang");

    System.out.println("\n--- TY LE PHAN TRAM ---");
    System.out.printf("Gia thap: %.1f%%\n", (double) giaThap / dem * 100);
    System.out.printf("Gia trung binh: %.1f%%\n", (double) giaTrungBinh / dem * 100);
    System.out.printf("Gia cao: %.1f%%\n", (double) giaCao / dem * 100);
}


	//Doc ghi file
	public void docFile(String tenFile){ {
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

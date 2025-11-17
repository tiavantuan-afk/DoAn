import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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
	public void suahang(String MA, KHO c) {
		boolean timkiem = false;

		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].maHang != null && ds[i].maHang.equalsIgnoreCase(MA)) {
				ds[i] = c;
				System.out.println("Da cap nhat thong tin hang hoa: " + MA);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay hang hoa de sua: " + MA);
	}

	// tìm kiếm theo mã có tham số
	public void timkiemtheoma(String macantim) {
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
	public void xoahang(String MAC) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].maHang != null && ds[i].maHang.equalsIgnoreCase(MAC)) {
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
	public void xoahangtheoten(String TEN) {
		boolean timkiem = false;
		for (int i = 0; i < n; i++) {
			if (ds[i] != null && ds[i].getTenHang() != null && ds[i].getTenHang().equalsIgnoreCase(TEN)) {
				for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
				ds[n - 1] = null;
				n--;
				System.out.println("Da xoa hang hoa co ten: " + TEN);
				timkiem = true;
				break;
			}
		}
		if (!timkiem) System.out.println("Khong tim thay hang hoa co ten: " + TEN);
	}

	// thống kê hàng theo mã
	public void thongkeKho() {
    if (n == 0) {
        System.out.println("Danh sach hang hoa rong!");
        return;
    }

    System.out.println("=== THONG KE KHO HANG HOA ===");
    System.out.println("Tong so mat hang: " + n);

    int tongSoLuong = 0;
    double tongGiaTri = 0.0;

    double giaCaoNhat = ds[0].getDonGia();
    double giaThapNhat = ds[0].getDonGia();
    String tenGiaCao = ds[0].getTenHang();
    String tenGiaThap = ds[0].getTenHang();

    int giaRe = 0;
    int giaTrungBinh = 0;
    int giaCao = 0;

    for (int i = 0; i < n; i++) {
        if (ds[i] != null) {
            int soLuong = ds[i].getSoLuong();
            double donGia = ds[i].getDonGia();

            tongSoLuong += soLuong;
            tongGiaTri += soLuong * donGia;

            // Tìm giá cao/ thấp
            if (donGia > giaCaoNhat) {
                giaCaoNhat = donGia;
                tenGiaCao = ds[i].getTenHang();
            }
            if (donGia < giaThapNhat) {
                giaThapNhat = donGia;
                tenGiaThap = ds[i].getTenHang();
            }

            // Phân loại giá
            if (donGia < 10000) {
                giaRe++;
            } else if (donGia <= 30000) {
                giaTrungBinh++;
            } else {
                giaCao++;
            }
        }
    }

    System.out.println("Tong so luong hang: " + tongSoLuong);
    System.out.printf("Tong gia tri hang hoa: %.2f VND\n", tongGiaTri);

    System.out.println("\n--- PHAN LOAI THEO DON GIA ---");
    System.out.println("Gia re (<10k): " + giaRe + " mat hang");
    System.out.println("Gia trung binh (10k-30k): " + giaTrungBinh + " mat hang");
    System.out.println("Gia cao (>30k): " + giaCao + " mat hang");

    System.out.println("\n--- GIA MAX/MIN ---");
    System.out.printf("Gia cao nhat: %.2f VND (%s)\n", giaCaoNhat, tenGiaCao);
    System.out.printf("Gia thap nhat: %.2f VND (%s)\n", giaThapNhat, tenGiaThap);

    System.out.println("\n--- TY LE PHAN TRAM ---");
    System.out.printf("Gia re: %.1f%%\n", (double) giaRe / n * 100);
    System.out.printf("Gia trung binh: %.1f%%\n", (double) giaTrungBinh / n * 100);
    System.out.printf("Gia cao: %.1f%%\n", (double) giaCao / n * 100);
}



	//Doc file
	public void docFile(String tenFile) {
		try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_KHO.txt"))) {
			String line;
			KHO x = null;

			ds = new KHO[0];
			n = 0;

			while ((line = br.readLine()) != null) {
				if (line.startsWith("====") || line.startsWith("So luong")) {
					continue;
				}
				String[] t = line.split("-");
				if (t.length >= 4) {
					x = new KHO(t[0], t[1], Integer.parseInt(t[2]), Double.parseDouble(t[3]));

					// add vao mang
					ds = Arrays.copyOf(ds, ds.length + 1);
					ds[ds.length - 1] = x;
					n++;
					System.out.println("Doc: " + x.maHang + " - " + x.tenHang);
				}
			}
			System.out.println("Da doc file thanh cong.");
			System.out.println("So luong hang hoa: " + n);
		} catch (IOException e) {
			System.out.println("Loi doc file: " + e.getMessage());
		}
	}

		//Ghi file
	public void ghiFile(String tenFile) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/List_KHO.txt"))) {
			bw.write("=== DANH SACH HANG HOA ===\n");
			bw.write("So luong hang hoa: " + n + "\n");

			for (int i = 0; i < n; i++) {
				if (ds[i] != null) {
					bw.write(ds[i].tenHang + ";" + ds[i].maHang + ";" + ds[i].soLuong + ";" + ds[i].donGia + "\n");
				}
			}
			System.out.println("Da ghi file thanh cong.");
		} catch (IOException e) {
			System.out.println("Loi ghi file: " + e.getMessage());
		}
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

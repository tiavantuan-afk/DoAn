import java.util.Scanner;

public class COMBO {
	public String maSP;
	public String tenSP;
	public double giaBan;
	public int soLuong;
	private double giaNiemYet;

	//hàm thiết lập không tham số
	public COMBO() {
		this.maSP = "";
		this.tenSP = "";
		this.giaBan = 0.0;
		this.soLuong = 0;
		this.giaNiemYet = 0.0;
	}

	// hàm thiết lập có tham số
	public COMBO(String maSP, String tenSP, double giaBan, int soLuong, double giaNiemYet) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.giaNiemYet = giaNiemYet;
	}

	// hàm sao chép
	public COMBO(COMBO t) {
		if (t == null) {
			this.maSP = t.maSP;
			this.tenSP = t.tenSP;
			this.giaBan = t.giaBan;
			this.soLuong = t.soLuong;
			this.giaNiemYet = t.giaNiemYet;
		}
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma combo: ");
		this.maSP = sc.nextLine();

		System.out.print("Nhap ten combo: ");
		this.tenSP = sc.nextLine();

		System.out.print("Nhap gia ban: ");
		this.giaBan = Double.parseDouble(sc.nextLine());

		System.out.print("Nhap so luong: ");
		this.soLuong = Integer.parseInt(sc.nextLine());

		System.out.print("Nhap gia niem yet: ");
		this.giaNiemYet = Double.parseDouble(sc.nextLine());
	}
	// loại combo
	public String getLoai() {
		return "C";
	}

	@Override
	public String toString() {
		return "COMBO [maSP=" + maSP + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", soLuong=" + soLuong
				+ ", giaNiemYet=" + giaNiemYet + "]";
	}

	// Output
	public void xuat() {
		System.out.println("Ma combo: " + maSP);
		System.out.println("Ten combo: " + tenSP);
		System.out.println("Gia ban: " + giaBan);
		System.out.println("So luong: " + soLuong);
		System.out.println("Gia niem yet: " + giaNiemYet);
	}

	// Get/Set
	public String getMaSP() { 
		return maSP; 
	}
	public void setMaSP(String maSP) { 
		this.maSP = maSP; 
	}

	public String getTenSP() { 
		return tenSP; 
	}
	public void setTenSP(String tenSP) { 
		this.tenSP = tenSP; 
	}

	public double getGiaBan() { 
		return giaBan; 
	}
	public void setGiaBan(double giaBan) { 
		this.giaBan = giaBan; 
	}

	public int getSoLuong() { 
		return soLuong; 
	}
	public void setSoLuong(int soLuong) { 
		this.soLuong = soLuong; 
	}

	public double getGiaNiemYet() { 
		return giaNiemYet; 
	}
	public void setGiaNiemYet(double giaNiemYet) { 
		this.giaNiemYet = giaNiemYet; 
	}
}
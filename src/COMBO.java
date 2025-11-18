import java.util.Scanner;

public class COMBO {
    public String maSP;
    public String tenSP;
    public double giaBan;
    public int soLuong;
    public double giaNiemYet;

    // Hàm thiết lập không tham số
    public COMBO() {
        this.maSP = "";
        this.tenSP = "";
        this.giaBan = 0.0;
        this.soLuong = 0;
        this.giaNiemYet = 0.0;
    }

    // Hàm thiết lập có tham số
    public COMBO(String maSP, String tenSP, double giaBan, int soLuong, double giaNiemYet) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.giaNiemYet = giaNiemYet;
    }

    // Hàm thiết lập sao chép
    public COMBO(COMBO c) {
        if (c != null) {
            this.maSP = c.maSP;
            this.tenSP = c.tenSP;
            this.giaBan = c.giaBan;
            this.soLuong = c.soLuong;
            this.giaNiemYet = c.giaNiemYet;
        }
    }

    // Nhập 
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
    
    // loại 
    public String getLoai() { 
        return "C"; 
    }

    // Xuất
    public void xuat() {
        System.out.println("Ma combo: " + maSP);
        System.out.println("Ten combo: " + tenSP);
        System.out.println("Gia ban: " + giaBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("Gia niem yet: " + giaNiemYet);
    }

    @Override
    public String toString() {
        return "COMBO [maSP=" + maSP + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", giaNiemYet=" + giaNiemYet + "]"; 
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

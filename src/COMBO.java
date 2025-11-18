import java.util.Scanner;

public class COMBO extends MonAn {
    private double giaNiemYet;

    // Hàm thiết lập không tham số
    public COMBO() {
        super();
        this.giaNiemYet = 0.0;
    }

    // Hàm thiết lập có tham số
    public COMBO(String maSP, String tenSP, double giaBan, int soLuong, double giaNiemYet) {
        super(maSP, tenSP, giaBan, soLuong);
        this.giaNiemYet = giaNiemYet;
    }

    // Hàm sao chép
    public COMBO(COMBO t) {
        super(t); // gọi constructor sao chép của MonAn
        this.giaNiemYet = t.giaNiemYet;
    }

    // Nhập thông tin
    @Override
    public void nhap() {
        super.nhap(); // nhập thuộc tính từ lớp cha
        System.out.print("Nhap gia niem yet: ");
        giaNiemYet = Double.parseDouble(sc.nextLine());
    }

    // Xuất thông tin
    @Override
    public void xuat() {
        super.xuat();  // xuất thuộc tính chung
        System.out.printf("| %-12.0f\n", giaNiemYet);
    }

    // Loại combo
    @Override
    public String getLoai() {
        return "C";
    }

    @Override
    public String toString() {
        return "COMBO [maSP=" + maSP + ", tenSP=" + tenSP + ", giaBan=" + giaBan 
                + ", soLuong=" + soLuong + ", giaNiemYet=" + giaNiemYet + "]";
    }

    // Get/set
    public double getGiaNiemYet() {
        return giaNiemYet;
    }

    public void setGiaNiemYet(double giaNiemYet) {
        this.giaNiemYet = giaNiemYet;
    }
}

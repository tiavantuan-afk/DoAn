import java.util.ArrayList;
import java.util.Scanner;

public class Phieunhaphang {
    Scanner sc = new Scanner(System.in);
    private String maNH;
    private String maNV;
    private String ngay;
    private String maNCC;
    private ArrayList<Chitietphieunhap> Danhsachchitiet;

    public Phieunhaphang() {
        Danhsachchitiet = new ArrayList<>();
        this.maNH = "";
        this.maNV = "";
        this.ngay = "";
        this.maNCC = "";
    }

    public Phieunhaphang(String maNH, String maNV, String ngay, String maNCC) {
        this.maNH = maNH;
        this.maNV = maNV;
        this.ngay = ngay;
        this.maNCC = maNCC;
        Danhsachchitiet = new ArrayList<>();
    }

    public Phieunhaphang(Phieunhaphang t) {
        if (t != null) {
            this.maNH = t.maNH;
            this.maNV = t.maNV;
            this.ngay = t.ngay;
            this.maNCC = t.maNCC;
        }
    }

    // GETSET
    public String getmaNH() {
        return maNH;
    }

    public void setmaPN(String maNH) {
        this.maNH = maNH;
    }

    public String getmaNV() {
        return maNV;
    }

    public void setmaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getngay() {
        return ngay;
    }

    public void setngay(String ngay) {
        this.ngay = ngay;
    }

    public String getmaNCC() {
        return maNCC;
    }

    public void setncc(String maNCC) {
        this.maNCC = maNCC;
    }

    public ArrayList<Chitietphieunhap> getDanhsachchitiet() {
        return Danhsachchitiet;
    }

    public void setDanhsachchitiet(ArrayList<Chitietphieunhap> Danhsachchitiet) {
        this.Danhsachchitiet = Danhsachchitiet;
    }

    public void nhap() {
        System.out.println("Mã phiếu nhập hàng: ");
        maNH = sc.nextLine();
        System.out.println("Mã nhân viên: ");
        maNV = sc.nextLine();
        System.out.println("Ngày nhập hàng: ");
        ngay = sc.nextLine();
        System.out.println("Nhà cung cấp: ");
        maNCC = sc.nextLine();
        System.out.println("Số mặt hàng: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Chi tiết hàng " + (i + 1));
            Chitietphieunhap ct = new Chitietphieunhap();
            ct.nhap();
            Danhsachchitiet.add(ct);
        }
    }

    public double tien() {
        double s = 0;
        for (Chitietphieunhap ct : Danhsachchitiet) {
            s += ct.thanhTien();
        }
        return s;
    }

    @Override
    public String toString() {
        String s = " Phiếu nhập hàng";
        s += "Mã PN: " + maNH + "| Ngày nhập hàng: " + ngay + "\n";
        s += "Nhà cung cấp: " + maNCC + "\n Danh sách chi tiết \n";

        for (Chitietphieunhap ct : Danhsachchitiet) {
            s += ct.toString() + "\n";
        }
        s += "\nTổng tiền: " + tien() + "VND\n";
        return s;
    }
}
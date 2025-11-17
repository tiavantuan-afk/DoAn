import java.util.Scanner;

public class ThucAn extends MonAn {

    private boolean coThit;
    private boolean coTinhBot;
    private boolean coBotNgot;
    Scanner sc = new Scanner(System.in);

    public ThucAn() {
        super();
    }

    public ThucAn(String maSP, String tenSP, double giaBan, int soLuong, boolean coThit, boolean coTinhBot,
            boolean coBotNgot) {
        super(maSP, tenSP, giaBan, soLuong);
        this.coThit = coThit;
        this.coTinhBot = coTinhBot;
        this.coBotNgot = coBotNgot;
    }

    public ThucAn(ThucAn t) {
        super(t.getMaSP(), t.getTenSP(), t.getGiaBan(), t.getSoLuong());
        this.coThit = t.coThit;
        this.coTinhBot = t.coTinhBot;
        this.coBotNgot = t.coBotNgot;
    }

    @Override
    public void nhap() {
        super.nhap();

        System.out.print("Nhap co thit (true/false): ");
        coThit = sc.nextBoolean();
        System.out.print("Nhap co tinh bot (true/false): ");
        coTinhBot = sc.nextBoolean();
        System.out.print("Nhap co bot ngot (true/false): ");
        coBotNgot = sc.nextBoolean();
        sc.nextLine();
    }

    @Override
    public String getLoai() {
        return "T";
    }

    @Override
    public String toString() {
        return String.join("-", getLoai(),
                maSP,
                tenSP,
                String.valueOf(giaBan),
                String.valueOf(soLuong),
                String.valueOf(coThit),
                String.valueOf(coTinhBot),
                String.valueOf(coBotNgot));
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-10s ", (coThit ? "True " : "False"));
        System.out.printf("%-10s ", (coTinhBot ? "True" : "False"));
        System.out.printf("%-10s\n", (coBotNgot ? "True" : "False"));
    }

    // GetSet
    public boolean isCoThit() {
        return coThit;
    }

    public void setCoThit(boolean coThit) {
        this.coThit = coThit;
    }

    public boolean isCoTinhBot() {
        return coTinhBot;
    }

    public void setCoTinhBot(boolean coTinhBot) {
        this.coTinhBot = coTinhBot;
    }

    public boolean isCoBotNgot() {
        return coBotNgot;
    }

    public void setCoBotNgot(boolean coBotNgot) {
        this.coBotNgot = coBotNgot;
    }

    // @Override
    // public void hienThiThongTin() {
    // System.out.println("== Thức ăn ==");
    // System.out.println("Mã SP" + getMaSP());
    // System.out.println("Tên SP" + getTenSP());
    // System.out.println("Giá Bán" + getGiaBan());
    // System.out.println("Số Lượng" + getSoLuong());
    // System.out.println("Có thịt" + (coThit ? "Có" : "Không"));
    // System.out.println("Có tinh bột" + (coTinhBot ? "Có" : "Không"));
    // }

    // @Override
    // public double tinhGiaSauKhuyenMai() {
    // return getGiaBan() * 0.9;// Giảm 10%
    // }

    // @Override
    // public String getLoaiSanPham() {
    // return "Thuc An";
    // }

}

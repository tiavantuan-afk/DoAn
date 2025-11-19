import java.util.Scanner;

public class ThucAn extends MonAn {

    private boolean coThit;
    private boolean coTinhBot;
    private boolean coBotNgot;
    Scanner sc = new Scanner(System.in);

    public ThucAn() {
        super();
    }

    public ThucAn(String maSP, String tenSP, double donGia, int soLuong, boolean coThit, boolean coTinhBot,
            boolean coBotNgot) {
        super(maSP, tenSP, donGia, soLuong);
        this.coThit = coThit;
        this.coTinhBot = coTinhBot;
        this.coBotNgot = coBotNgot;
    }

    public ThucAn(ThucAn t) {
        super(t.getMaSP(), t.getTenSP(), t.getdonGia(), t.getSoLuong());
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
                String.valueOf(donGia),
                String.valueOf(soLuong),
                String.valueOf(coThit),
                String.valueOf(coTinhBot),
                String.valueOf(coBotNgot));
    }

    @Override
    public void xuat() {
        super.xuat();
        String coThitVal = this.coThit ? "Thịt" : "";
        String coBotNgotVal = this.coBotNgot ? "Bột Ngọt" : "";
        String coTinhBotVal = this.coTinhBot ? "Tinh Bột" : "";
        System.out.printf("%-12s | %-12s | %-12s | %-8s\n",
                coThitVal,
                coBotNgotVal,
                coTinhBotVal,
                "");
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
    // System.out.println("Giá Bán" + getdonGia());
    // System.out.println("Số Lượng" + getSoLuong());
    // System.out.println("Có thịt" + (coThit ? "Có" : "Không"));
    // System.out.println("Có tinh bột" + (coTinhBot ? "Có" : "Không"));
    // }

    // @Override
    // public double tinhGiaSauKhuyenMai() {
    // return getdonGia() * 0.9;// Giảm 10%
    // }

    // @Override
    // public String getLoaiSanPham() {
    // return "Thuc An";
    // }

}

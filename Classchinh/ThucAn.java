package DoAn.Classchinh;

import java.util.Scanner;

import DoAn.DS_Class.List_MonAn;

public class ThucAn extends MonAn {

    private boolean coThit;
    private boolean coTinhBot;
    private boolean coBotNgot;

    public ThucAn() {
        super();
    }

    public ThucAn(String maSP, String tenSP, double giaBan, String soLuong, boolean coThit, boolean coTinhBot,
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap co thit (true/false): ");
        coThit = sc.nextBoolean();
        System.out.print("Nhap co tinh bot (true/false): ");
        coTinhBot = sc.nextBoolean();
        System.out.print("Nhap co bot ngot (true/false): ");
        coBotNgot = sc.nextBoolean();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-10s ", (coThit ? "True " : "False"));
        System.out.printf("%-10s ", (coTinhBot ? "True" : "False"));
        System.out.printf("%-10\n ", (coBotNgot ? "True" : "False"));
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

    public static void main(String[] args) {
        ThucAn quanly = new ThucAn();
        quanly.nhap();
    }
}

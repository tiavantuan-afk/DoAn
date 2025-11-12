package DoAn.Classchinh;

import java.util.Scanner;

public class NuocUong extends MonAn {
    // Thuộc tính
    private boolean coGas;
    private boolean loaiChai;
    private boolean coDa;

    public NuocUong() {
        super();
    }

    public NuocUong(String maSP, String tenSP, double giaBan, String soLuong, boolean coGas, boolean loaiChai,
            boolean coDa) {
        super(maSP, tenSP, giaBan, soLuong);
        this.coGas = coGas;
        this.loaiChai = loaiChai;
        this.coDa = coDa;
    }

    public NuocUong(NuocUong t) {
        super(t.getMaSP(), t.getTenSP(), t.getGiaBan(), t.getSoLuong());
        this.coDa = t.coDa;
        this.coGas = t.coGas;
        this.loaiChai = t.loaiChai;
    }

    // Nhập xuất
    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap co da ? (true/false): ");
        coDa = sc.nextBoolean();
        System.out.print("Nhap co gas ? (true/false): ");
        coGas = sc.nextBoolean();
        System.out.print("Nhap loai chai ? (lon/chai): ");
        String loaiChaiStr = sc.nextLine();
        loaiChai = loaiChaiStr.equalsIgnoreCase("Lon");
        loaiChai = loaiChaiStr.equalsIgnoreCase("Chai");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-10s ", (coDa ? "True" : "False"));
        System.out.printf("%-10s ", (coGas ? "True" : "False"));
        System.out.printf("%-10s\n ", (loaiChai ? "Lon" : "Chai"));
    }

    // GetSet
    public boolean isCoGas() {
        return coGas;
    }

    public void setCoGas(boolean coGas) {
        this.coGas = coGas;
    }

    public boolean isLoaiChai() {
        return loaiChai;
    }

    public void setLoaiChai(boolean loaiChai) {
        this.loaiChai = loaiChai;
    }

    public boolean isCoDa() {
        return coDa;
    }

    public void setCoDa(boolean coDa) {
        this.coDa = coDa;
    }

    // @Override
    // public void hienThiThongTin() {
    // System.out.println("== Drinks ==");
    // System.out.println("Ma SP" + getMaSP());
    // System.out.println("Ten SP" + getTenSP());
    // System.out.println("Gia Ban" + getGiaBan());
    // System.out.println("So Luong" + getSoLuong());
    // System.out.println("Co Gas" + (coGas ? "Co" : "Khong"));
    // System.out.println("Co Da" + (coDa ? "Co" : "Khong"));
    // System.out.println("Loai Chai" + (loaiChai ? "Co" : "Khong"));
    // System.out.println("Tinh gia sau khuyen mai: " + tinhGiaSauKhuyenMai());
    // }

    // @Override
    // public double tinhGiaSauKhuyenMai() {
    // double gia = getGiaBan();
    // if (coDa)
    // gia += 2000;
    // if (coGas)
    // gia += 5000;
    // return gia;
    // }

    // @Override
    // public String getLoaiSanPham() {
    // return "Nuoc Uong";
    // }
}

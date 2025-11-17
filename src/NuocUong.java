import java.util.Scanner;

public class NuocUong extends MonAn {
    // Thuộc tính
    private boolean coGas;
    private boolean loaiChai;
    private boolean loaiLon;
    private boolean coDa;
    java.util.Scanner sc = new Scanner(System.in);

    public NuocUong() {
        super();
    }

    public NuocUong(String maSP, String tenSP, double giaBan, int soLuong, boolean coGas, boolean loaiChai,
            boolean coDa, boolean loaiLon) {
        super(maSP, tenSP, giaBan, soLuong);
        this.coGas = coGas;
        this.loaiChai = loaiChai;
        this.coDa = coDa;
        this.loaiLon = loaiLon;
    }

    public NuocUong(NuocUong t) {
        super(t.getMaSP(), t.getTenSP(), t.getGiaBan(), t.getSoLuong());
        this.coDa = t.coDa;
        this.coGas = t.coGas;
        this.loaiChai = t.loaiChai;
        this.loaiLon = t.loaiLon;
    }

    // Nhập xuất
    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Nhap co da ? (true/false): ");
        coDa = sc.nextBoolean();
        System.out.print("Nhap co gas ? (true/false): ");
        coGas = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Nhap loai bao bi ? (lon/chai): ");
        String loaiBaoBi = sc.nextLine().trim();

        if (loaiBaoBi.equalsIgnoreCase("lon")) {
            loaiLon = true;
            loaiChai = false;
        } else if (loaiBaoBi.equalsIgnoreCase("chai")) {
            loaiLon = false;
            loaiChai = true;
        }
        sc.nextLine();
    }

    @Override
    public String getLoai() {
        return "N";
    }

    @Override
    public String toString() {
        return String.join("-", getLoai(),
                maSP,
                tenSP,
                String.valueOf(giaBan),
                String.valueOf(soLuong),
                String.valueOf(coGas),
                String.valueOf(loaiChai),
                String.valueOf(coDa),
                String.valueOf(loaiLon));
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-10s ", (coDa ? "True" : "False"));
        System.out.printf("%-10s ", (coGas ? "True" : "False"));
        System.out.printf("%-10s\n ", (loaiChai ? "Chai" : "Lon"));
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

    public boolean isLoaiLon() {
        return loaiLon;
    }

    public void setLoaiLon(boolean LoaiLon) {
        this.loaiLon = LoaiLon;
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

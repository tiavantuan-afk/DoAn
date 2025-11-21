import java.util.Scanner;

public class Nguyenlieu {
    public String maNL;
    public String tenNL;
    public double dongia;
    public int SL;
    Scanner sc = new Scanner(System.in);

    // hàm thiết lập không tham số
    public Nguyenlieu() {
        maNL = "";
        tenNL = "";
        SL = 0;
        dongia = 0.0;

    }

    // hàm thiết lập có tham số
    public Nguyenlieu(String maNL, String tenNL, double dongia, int SL) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.dongia = dongia;
        this.SL = SL;
    }

    // hàm sao chép
    public Nguyenlieu(Nguyenlieu n) {
        if (n != null) {
            this.maNL = n.maNL;
            this.tenNL = n.tenNL;
            this.dongia = n.dongia;
            this.SL = n.SL;
        }
    }

    public void nhap() {

        System.out.print("Ma nguyen lieu: ");
        maNL = sc.nextLine();

        System.out.print("Ten nguyen lieu: ");
        tenNL = sc.nextLine();

        System.out.print("So luong nguyen lieu: ");
        SL = sc.nextInt();
        sc.nextLine();

        System.out.print("Don gia: ");
        dongia = Double.parseDouble(sc.nextLine());
    }

    // loại nguyên liệu
    public String getLoai() {
        return "N";
    }

    @Override
    public String toString() {
        return "Nguyenlieu [maNL=" + maNL + ", tenNL=" + tenNL + ",SL=" + SL + ", dongia=" + dongia + "]";
    }

    public void xuat() {
        System.out.println("Ma nguyen lieu: " + maNL);
        System.out.println("Ten nguyen lieu: " + tenNL);
        System.out.println("Don gia: " + dongia);
    }

    // get/set
    public String getmaNL() {
        return maNL;
    }

    public void setmaNL(String maNL) {
        this.maNL = maNL;
    }

    public String gettenNL() {
        return tenNL;
    }

    public void settenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public double getdongia() {
        return dongia;
    }

    public void setdongia(double dongia) {
        this.dongia = dongia;
    }

    public int SL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }
}

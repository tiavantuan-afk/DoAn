import java.util.Scanner;

public class Nguyenlieu {
    public String maNL;
    public String tenNL;
    public double dongia;
    
    //hàm thiết lập không tham số
    public Nguyenlieu(){
        this.maNL = "";
        this.tenNL = "";
        this.dongia = 0.0;
    }

    //hàm thiết lập có tham số
    public Nguyenlieu(String maNL,String tenNL,double dongia){
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.dongia = dongia;
    }

    //hàm sao chép
    public Nguyenlieu(Nguyenlieu n){
        if(n != null){
            this.maNL = n.maNL;
            this.tenNL = n.tenNL;
            this.dongia = n.dongia;
        }
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Mã nguyên liệu: ");
        maNL = sc.nextLine();

        System.out.print("Tên nguyên liệu: ");
        tenNL = sc.nextLine();

        System.out.print("Đơn giá: ");
        dongia = Double.parseDouble(sc.nextLine());
    }

    //loại nguyên liệu
    public String getLoai(){
        return "N";
    }

    @Override
    public String toString(){
        return "Nguyenlieu [maNL=" + maNL + ", tenNL=" + tenNL + ", dongia=" + dongia + "]";
    }

    public void xuat(){
        System.out.println("Mã nguyên liệu: " + maNL);
        System.out.println("Tên nguyên liệu: " + tenNL);
        System.out.println("Đơn giá: " + dongia);
    }

    //get/set
    public String getmaNL(){
        return maNL;
    }
    public void setmaNL(String maNL){
        this.maNL = maNL;
    }

    public String gettenNL(){
        return tenNL;
    }
    public void settenNL(String tenNL){
        this.tenNL = tenNL;
    }

    public double getdongia(){
        return dongia;
    }
    public void setdongia(double dongia){
        this.dongia = dongia;
    }
}
    
import java.util.Arrays;
import java.util.Scanner;

class List_CTHD {
    Scanner sc = new Scanner(System.in);
    private int n;
    private CHITIETHOADON[] dscthd = new CHITIETHOADON[100];   

    public void nhap(){
        System.out.print("Nhap n: ");
        n = sc.nextInt();
        for(int i = 0; i<n; i++){
            System.out.print("Nhap chi tiet hoa don thu: "+(i+1));
            dscthd[i] = new CHITIETHOADON();
            dscthd[i].nhap();
        }
    }
    public void xuat(){
        System.out.println("Danh sach chi tiet hoa don.");
        for (int i=0; i<n; i++){
            dscthd[i].xuat();
        }
    }
    public void timkiemtheomahoadon(int mahdcantim){
        System.out.print("Nhap ma hoa don can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMahd() == mahdcantim){
            timkiem = true;
            dscthd[i].xuat();
            }
        }
        if (!timkiem){
            System.out.println("Khong co trong danh sach.");
        }
    }
    public void timkiemtheomasanpham(int maspcantim){
        System.out.print("Nhap ma san pham can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMasp() == maspcantim){
                timkiem = true;
                dscthd[i].xuat();
            }
        }
        if (!timkiem){
            System.out.println("Khong co trong danh sach.");
        }
    }
    public void timkiemtheomakhachhang(int makhcantim){
        System.out.print("Nhap ma khach hang can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMakh() == makhcantim){
                timkiem = true;
                dscthd[i].xuat();
            }
        }
        if (!timkiem){
            System.out.println("Khong co trong danh sach.");
        }
    }
    public void timkiemtheosoluong(int soluongcantim){
        System.out.print("Nhap so luong can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getSL() == soluongcantim){
            timkiem = true;
            dscthd[i].xuat();
            }
        }
        if(!timkiem){
            System.out.println("Khong co trong danh sach.");
        }
    }
    public void timkiemtheodongia(double dongiacantim){
        System.out.print("Nhap don gia can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getDG() == dongiacantim){
                timkiem = true;
                dscthd[i].xuat();
            }
        }
        if(!timkiem){
            System.out.println("Khong co trong danh sach. ");
        }
    }
    public void timkiemtheothanhtien(double thanhtiencantim){
        System.out.print("Nhap thanh tien can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getThanhtien() == thanhtiencantim){
                timkiem = true;
                dscthd[i].xuat();
            }
        }
        if(!timkiem){
            System.out.println("Khong co trong danh sach. ");
        }
    }
    public void suachitietmahd(){
        System.out.println("Nhap ma hoa don can sua chi tiet: ");
        int HD = sc.nextInt();
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMahd() == HD){
                System.out.println("Da cap nhat chi tiet hoa don.");
                timkiem = true;
                break;
            }
        }
        if(!timkiem){ 
            System.out.println("Khong tim thay ma hoa don de sua");
        }
    }  
    public boolean IDCTHD(int maspham){
        if (maspham == 0){
            return true;
        }
        for (int i=0; i<n; i++){
            if(dscthd[i] != null && dscthd[i].getMasp()!= 0 && dscthd[i].getMasp() == maspham){
                return false;
            }
        }
        return true;
    }
    public void themchitiet(){
        System.out.println("Nhap ma san pham can them: ");
        CHITIETHOADON ctmoi = new CHITIETHOADON();
        ctmoi.nhap();
        if (!IDCTHD(ctmoi.getMasp())){
            System.out.println("Ma san pham da ton tai");
            return;
        }
        dscthd = Arrays.copyOf(dscthd, n+1);
        dscthd[n-1] = ctmoi;
        System.out.println("Da them ma san pham moi");

    }
    public void xoachitietmahd(int mahd){
        System.out.println("Nhap ma hoa don can sua chi tiet: ");
        boolean timkiem = false;
        for(int i=0; i<n; i++){
            if (dscthd[i].getMahd() == mahd){
                for (int j=i; j<n; j++){
                    dscthd[i] = dscthd[i+1];
                }
                dscthd[i-1] = null;
                n--;
                System.out.println("Da xoa chi tiet hoa don co ma: "+mahd);
                timkiem = true;
                break;
            }
        }
        if(!timkiem){
            System.out.println("Khong tim thay chi tiet hoa don co ma: "+mahd);
        }
    }
    public void thongkesanpham(){
        int d=0 ;
        System.out.print("Nhap ma san pham can thong ke: ");
        int masanpham = sc.nextInt();
        for (int i=0; i<n; i++){
            if (dscthd[i].getMasp() == masanpham){
                d++;
            }
        }
        if (d>=5){
            System.out.println("San pham ban chay");
        }else if (d>=1){
            System.out.println("San pham ban cham");
        } else{
            System.out.println("San pham ban lo");
        }
    }
}

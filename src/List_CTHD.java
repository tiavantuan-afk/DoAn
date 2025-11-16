import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public CHITIETHOADON[] getDscthd(){
        return dscthd;
    }
    public void setDscthd(CHITIETHOADON[] dscthd){
        this.dscthd = dscthd;
    }
    public int getN(){
        return n;
    }
    public void setN(int n){
        this.n = n;
    }
    public void timkiemtheomahoadon(String mahdcantim){
        System.out.print("Nhap ma hoa don can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMahd().equalsIgnoreCase(mahdcantim)){
            timkiem = true;
            dscthd[i].xuat();
            }
        }
        if (!timkiem){
            System.out.println("Khong co trong danh sach.");
        }
    }
    public void timkiemtheomasanpham(String maspcantim){
        System.out.print("Nhap ma san pham can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMasp().equalsIgnoreCase(maspcantim)){
                timkiem = true;
                dscthd[i].xuat();
            }
        }
        if (!timkiem){
            System.out.println("Khong co trong danh sach.");
        }
    }
    public void timkiemtheomakhachhang(String makhcantim){
        System.out.print("Nhap ma khach hang can tim: ");
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMakh().equalsIgnoreCase(makhcantim)){
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
        String HD = sc.nextLine();
        boolean timkiem = false;
        for (int i=0; i<n; i++){
            if (dscthd[i].getMahd().equalsIgnoreCase(HD)){
                System.out.println("Da cap nhat chi tiet hoa don.");
                timkiem = true;
                break;
            }
        }
        if(!timkiem){ 
            System.out.println("Khong tim thay ma hoa don de sua");
        }
    }  
    public boolean IDCTHD(String maspham){
        if (maspham == null){
            return true;
        }
        for (int i=0; i<n; i++){
            if(dscthd[i] != null && dscthd[i].getMasp()!= null && dscthd[i].getMasp().equalsIgnoreCase(maspham)){
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
    public void xoachitietmahd(String mahd){
        System.out.println("Nhap ma hoa don can sua chi tiet: ");
        boolean timkiem = false;
        for(int i=0; i<n; i++){
            if (dscthd[i].getMahd().equalsIgnoreCase(mahd)){
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
        String masanpham = sc.nextLine();
        for (int i=0; i<n; i++){
            if (dscthd[i].getMasp().equalsIgnoreCase(masanpham)){
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
    public void docfile(){
        try (BufferedReader br = new BufferedReader(new FileReader("src\\data\\List_CTHD.txt"))){
            String line;
            CHITIETHOADON x= null;
            dscthd = new CHITIETHOADON[0];
            while ((line = br.readLine()) != null){
                String[] t = line.split("-");
                if (t.length >= 8){
                    String type = t[0].toUpperCase();
                    if (type.contains("CT")){
                        if (t.length >= 9){
                            x = new CHITIETHOADON();
                            ((CHITIETHOADON) x).setMahd(t[1]);
                            ((CHITIETHOADON) x).setMasp(t[2]);
                            ((CHITIETHOADON) x).setMakh(t[3]);
                            x.setSL(Integer.parseInt(t[4]));
                            x.setDG(Integer.parseInt(t[5]));
                            x.setThanhtien(Double.parseDouble(t[6]));
                        }else{
                            continue;
                        }
                    }else{
                        continue;
                    }
                    if (x != null){
                        dscthd = Arrays.copyOf(dscthd, n+1);
                        dscthd[n-1] = x;
                        System.out.println("Doc: "+x.getMahd()+"-"+x.getMasp()+"-"+x.getSL()+"-"+x.getDG()+"-"+x.getThanhtien()+"\n");
                    }
                }
            }
            System.out.println("Doc file thanh cong");
            System.out.println("So chi tiet da doc: "+n);
        }catch (IOException e){
            System.out.println("Loi doc file: "+e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("Loi format so: "+e.getMessage());
        }
    }
    public void ghiFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\data\\List_CTHD.txt"))){
            bw.write("====DANH SACH CHI TIET HOA DON=====");
            bw.write("So luong chi tiet: "+n+"\n");
            for (int i=0; i<n; i++){
                if(dscthd[i] != null){
                    if (dscthd[i] instanceof CHITIETHOADON){
                        CHITIETHOADON ct = (CHITIETHOADON) dscthd[i];
                        bw.write("CT-"+ct.getMahd()+"-"+ct.getMasp()+"-"+ct.getMakh()+"-"+ct.getSL()+"-"+ct.getDG()+"-"+ct.getThanhtien());
                    }
                }
            }
            System.out.println("Ghi file thanh cong");
        }
        catch (IOException e){
            System.out.println("Loi ghi file: "+e.getMessage());
        }
    }
     public static void main (String[] args){
        List_CTHD dscthd = new List_CTHD();
        System.out.println("Bat dau doc file.........");
        dscthd.docfile();
        System.out.println("Hien thi ket qua: ");
        dscthd.xuat();
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class TestMonAn {
    private Scanner sc;

    public TestMonAn() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        TestMonAn test = new TestMonAn();
        test.sua();

    }

    public void nhapds() {
        System.out.println("Nhap so luong mon: ");
        n = sc.nextInt;
        sc.nextLine();
        ds = new MonAn[n];
        for (int i = 0; i < ds.length; i++) {
            String temp;
            int temT;
            do {
                System.out.println("Nhap so mon:" + (i + 1));
                System.out.println("T");
                System.out.println("U");
                temp = sc.nextLine();
                if (temp.toUpperCase().contains("T")) {
                    ds[i] = new ThucAn();
                } else if (temp.toUpperCase().contains("U")) {
                    ds[i] = new NuocUong();
                } else
                    temT = 0;

            } while (temT != 1);
            ds[i].nhap();
        }

    }

    public void nhap() {
        System.out.println("So luong mon: ");
        n = sc.nextInt();
        sc.nextLine();
        ds = new MonAn[n];
        for (int i = 0; i < ds.length; i++) {
            System.out.println("Nhap thong tin nhan vien: " + (i + 1));
            ds[i].nhap();
        }

    }

    public void xuatds() {
        if (ds.length == 0) {
            System.out.println("Empty");
        }
        System.out.print("So luong mon: " + ds.length);
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuatds();
        }

    }

    public void timkiem(String maSP) {
        boolean found = false;
        for(int i = 0; i < ds.length; i++){
            if(ds[i] !=null && ds[i].getMaSP() !=null && ds[i].getMaSP().equalsIgnoreCase(maSP)){
                System.out.println("Da tim thay");
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }
        if(!found){
            System.out.println("Khong tim thay: ");
        }
    }

    public void timkiem() {
        if (ds.length == 0) {
            System.out.printkn("Empty");
            return;
        }
        boolean found = false;
        System.out.println("Nhap ma can tim: ");
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maSP.equalsIgnore(maSP) !=null) {
                System.out.println("Da tim thay san pham");
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("None");
        }
    }

    public void xoa(String maSP) {
        boolean found = false;
        for(int i = 0; i < ds.length; i++){
            if(ds[i] !=null && ds[i].getMaSP() !=null && ds[i].getMaSP().equalsIgnoreCase(maSP)){
                System.out.println("Da tim thay thu can xoa");
                ds[i].xuat();

                for(int j = i; j < ds.length-1; j++){
                    ds[j]=ds[j+1];
                }

                ds = Arrays.copyOf(ds, ds.length-1);
                found = true;
            }
        }
    }

    public void them() {
        TestMonAn testmoi = new TestMonAn();
        testmoi.nhap();

        if (!ONEID(testmoi.getMaSP())) {
            System.out.println("Trung");
            return;
        }

        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = testmoi;
        System.out.println("Da them vao mang");

    }

    public void themds(){
        MonAn monan1 = null;
        String temp;
        int temT;
        do{
            temT = 0;
            System.out.println("T");
            System.out.println("N");
            temp = sc.nextLine();
            if(temp.toUpperCase().contains("T")){
                monan = new ThucAn();
            }else 
            if(temp.toUpperCase().contains("N")){
                monan = new NuocUong();
            }else{
                temT = 0;
            }
        }while(temT != 1);
        ds[i].xuat();
    }
    

    public boolean ONEID(String maSP) {
        if (maSP == null) {
            return true;
        }
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null && ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                return false;
            }
        }
        return true;
    }

   public sua(){
    if(ds.length == 0){
        return;
    }
    int v = -1;
    for(int i = 0; i < ds.length; i++){
        if(ds[i] !=null && ds[i].maSP() != null && ds[i].maSP().equalsIgnoreCase(maSP)){
            v = i;
            break;
        }
    }
    if(v == -1){
        System.out.println("Khong tim thay: ");
        return;
    }
    System.out.println("Thong tin hien tai:");
    ds[i].xuat();

    int choice = sc.nextInt();
    sc.nextLine();

    switch(chocie){
        case 1:
            String maMoi = sc.nextLine();
            ds[v].setMaSP(maMoi);
            break;

        case 0:
            return;
        default:
            return;
    }

   }
}

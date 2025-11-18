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
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaSP() != null && ds[i].getMaSP().equalsIgnoreCase(maSP)) {
                System.out.println("Da tim thay ma san pham: ");
                ds[i].xuat();
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma sp");
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
            if (ds[i] != null && ds[i].maSP.equalsIgnore(maSP)) {
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

    public void xoa(String maSP){
       boolean found = false;
        for(int i = 0; i < ds.length; i++){
            if(ds[i] !=null && ds[i].getMaSP() !=null && ds[i].)
        }
}
}
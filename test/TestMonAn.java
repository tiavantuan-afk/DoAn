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

    public void nhap() {
        System.out.println("Nhap so luong: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < ds.length; i++) {
            String temp;
            int temT;
            do {
                System.out.println("Nhap mon so" + (i + 1));
                System.out.println("T");
                System.out.println("U");
                if (temp.toUpperCase().contains("T")) {
                    ds[i] = new ThucAn();
                } else if (temp.toUpperCase().contains("U")) {
                    ds[i] = new NuocUong();
                } else
                    temp = 0;

            } while (temT != -1);
            ds[i].nhap();
        }
        tuDongCapNhatFile();
    }

    public void them() {
        ds = Arrays.copyOf(ds, ds.length + 1);
        MonAn MonAnL = null;
        String temp;
        int temT;
        do {
            System.out.println("Nhap thong tin mon an can them: ");
            System.out.println("T");
            System.out.println("U");
            if (temp.toUpperCase().contains("T")) {
                ds[i] = new ThucAn();
            } else if (temp.toUpperCase().contains("U")) {
                ds[i] = new NuocUong();
            } else
                temp = 0;
        } while (temT != -1);
        ds[i].nhap();
    }

}

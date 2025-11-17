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
        n = sc.nexInt();
        sc.nextLine();
        ds = new MonAn();
        for(int i = 0; i < ds.legnth; i++){
            String temp;
            int temT;
            do{
                temT = -1;
                System.out.println("Nhap so mon an: " + (i+1) );
                System.out.println("T");
                System.out.println("U");
                if(temp.toUpperCase().contains("T")){
                    ds = new ThucAn();
                }else 
                if(temp.toUpperCase().contains("U")){
                    ds = new NuocUong
                }
            }
        }
    }
}
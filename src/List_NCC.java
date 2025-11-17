import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class List_NCC {
    Scanner sc = new Scanner(System.in);
    private int n;
    private Nhacungcap[] dsncc = new Nhacungcap[100];
    public void nhap(){
        System.out.print("Số lượng nhà cung cấp: ");
        n = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i < n;i++){
            System.out.print("Nhà cung cấp thứ " + (i+1) + "\n");
            dsncc[i] = new Nhacungcap();
            dsncc[i].nhap();
        }
 
    }
    public void xuat(){
        System.out.println("Danh sách nhà cung cấp");
        for(int i = 0;i < n; i++){
            dsncc[i].xuat();
        }
    }
    public void timkiemtheoma(){
        System.out.println("Mã nhà cung cấp cần tìm: ");
        String macantim = sc.nextLine();
        boolean timkiem = false;
        for(int i = 0;i < n; i++){
            if(dsncc[i].getmaNCC().equalsIgnoreCase(macantim)){
                timkiem = true;
                dsncc[i].xuat();
            }
        }
        if(!timkiem){
            System.out.print("Không có trong danh sách");
        }
    }

    public void themtheoma(){
        System.out.println("Mã nhà cung cấp cần thêm: ");
        String macanthem = sc.nextLine();
        boolean themma = false;
        for(int i = 0;i < n; i++){
            if(dsncc[i].getmaNCC().equalsIgnoreCase(macanthem)){
                themma = true;
                break;
                }
            }
            if(themma){
                System.out.print("Mã nhà cung cấp " + macanthem + "đã tồn tại trong danh sách");
            }
            if(n >= 100){
                System.out.print("Danh sách nhà cung cấp đã đầy");
            }
            System.out.println("Nhập thông tin nhà cung cấp mới có mã " + macanthem);
            dsncc[n] = new Nhacungcap();
            dsncc[n].nhap();
            dsncc[n].setmaNCC(macanthem);
            n++;
    }
    public void themtheodiachi(){
        System.out.println("Địa chỉ nhà cung cấp cần thêm: ");
        String diachicanthem = sc.nextLine();
        boolean dathem = false;
        for(int i = 0;i < n; i++){
            if(dsncc[i].getdiachi().equalsIgnoreCase(diachicanthem)){
               dathem = true;
               break;
            }
        }
        if(dathem){
            System.out.println("Địa chỉ nhà cung cấp " + diachicanthem + " đã tồn tại trong danh sách");
        }
        if(n >= 100){
            System.out.println("Danh sách đã đầy");
        }
        System.out.println("Nhập thông tin nhà cung cấp mới");
        dsncc[n] = new Nhacungcap();
        dsncc[n].nhap();
        dsncc[n].setdiachi(diachicanthem);
        n++;
    }
    public void xoatheoma(){
        System.out.print("Mã nhà cung cấp cần xoá: ");
        String macanxoa = sc.nextLine();
        boolean daxoa = false;
        for(int i = 0;i < n; i++){
            if(dsncc[i].getmaNCC().equalsIgnoreCase(macanxoa)){
                for(int j = i;j < n-1;j++){
                    dsncc[j] = dsncc[j+1];
                }
                dsncc[n-1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá nhà cung cấp có mã " + macanxoa);
                break;
            }
        }
        if(!daxoa){
            System.out.println("Không tìm thấy nhà cung cấp có mã" + macanxoa);
        }
    }
    public void xoatheosdt(){
        System.out.print("Số điện thoại của nhà cung cấp cần xoá: ");
        String sdtcanxoa = sc.nextLine();
        boolean daxoa = false;
        for(int i = 0; i < n; i++){
            if(dsncc[i].getsdt().equalsIgnoreCase(sdtcanxoa)){
                for(int j = i; j < n - 1; j++){
                    dsncc[j] = dsncc[j+1];
                }
                dsncc[n-1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá nhà cung cấp có số điện thoai:" +sdtcanxoa);
                break; 
            }
        }
        if(!daxoa){
            System.out.println("Không tìm thấy nhà cung cấp có mã");
        }
    }
    public void suatheoma(){
        System.out.println("Mã nhà cung cấp cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;
        for(int i = 0; i < n; i++){
            if(dsncc[i].getmaNCC().equalsIgnoreCase(macansua)){
                System.out.println("Tìm thấy nhà cung cấp: ");
                dsncc[i].xuat();
                System.out.println("Thông tin cần sửa cho nhà cung cấp: ");
                dsncc[i] = new Nhacungcap();
                dsncc[i].xuat();
                System.out.println("Đã sửa thông tin cho nhà cung cấp có mã "+ macansua);
                dasua = true;
                break;
            }
        }
        if(!dasua){
            System.out.println("Không tìm thấy nhà cung cấp có mã "+ macansua);
        }
    }
    public void thongketheohoncc() {
        String[] hoDaDem = new String[100];
        int[] soLuong = new int[100];
        int demHo = 0;
        for (int i = 0; i < n; i++) {
            String ho = dsncc[i].gethoNCC();
            int index = -1;
            for (int j = 0; j < demHo; j++) {
                if (hoDaDem[j].equalsIgnoreCase(ho)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) { 
                hoDaDem[demHo] = ho;
                soLuong[demHo] = 1;
                demHo++;
            } else {
                soLuong[index]++;
            }
        }
        System.out.println("\nThong ke theo ho");
        System.out.printf("%-15s %-10s\n", "Họ", "Số lượng");
        for (int i = 0; i < demHo; i++) {
            System.out.printf("%-15s %-10d\n", hoDaDem[i], soLuong[i]);
        }
    }

    public void docFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            Nhacungcap x = null;
            dsncc = new Nhacungcap[0];
            while ((line = br.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 4){
                    x = new Nhacungcap();
                    x.setmaNCC(t[0]);
                    x.sethoNCC(t[1]); 
                    x.settenNCC(t[2]);
                    x.setdiachi((t[3]));
                    x.setsdt(t[4]);
                    dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
                    dsncc[dsncc.length - 1] = x;
                    System.out.println("Doc: " + x.getmaNCC() + " - " + x.gethoNCC() + " " + x.gettenNCC() + " " + x.getdiachi()+ " " +x.getsdt());

                } 
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: "+ n);
        }catch (IOException e){
            System.out.println("Loi doc file: "+e.getMessage());
        }
    }
    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i=0; i<n; i++){
                if (dsncc[i] != null){
                    writer.println(dsncc[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: "+n+ " khach");
        }catch (IOException e){
            System.out.println("Loi ghi file");
        }   
    }
}

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public void timkiemtheoho(){
        System.out.println("Họ nhà cung cấp cần tìm: ");
        String hocantim = sc.nextLine();
        boolean timkiem = false;
        for(int i = 0; i < n; i++){
            if(dsncc[i].gethoNCC().equalsIgnoreCase(hocantim)){
                timkiem = true;
                dsncc[i].xuat();
            }
        }
        if(!timkiem){
            System.out.print("Không có trong danh sách");
        }
    }
    public void timkiemtheoten(){
        System.out.println("Tên nhà cung cấp cần tìm: ");
        String tencantim = sc.nextLine();
        boolean timkiem = false;
        for(int i = 0; i < n; i++){
            if(dsncc[i].gettenNCC().equalsIgnoreCase(tencantim)){
                timkiem = true;
                dsncc[i].xuat();
            }
        }
        if(!timkiem){
            System.out.println("Không có trong danh sách");
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

    public void docFileTXT(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            n = 0;
            while ((line = br.readLine()) != null && n < 100) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    dsncc[n] = new Nhacungcap();
                    dsncc[n].setmaNCC(parts[0].trim());
                    dsncc[n].sethoNCC(parts[1].trim());
                    dsncc[n].settenNCC(parts[2].trim());
                    dsncc[n].setdiachi(parts[3].trim());
                    dsncc[n].setsdt(parts[4].trim());
                    n++;
                }
            }
            System.out.println("Đọc file thành công, tổng số nhà cung cấp: " + n);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void WriteOne(String tenFile, int index) {
        if (index < 0 || index >= n) {
            System.out.println("Vị trí không hợp lệ!");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            String line =
                dsncc[index].getmaNCC() + "," +
                dsncc[index].gethoNCC() + "," +
                dsncc[index].gettenNCC() + "," +
                dsncc[index].getdiachi() + "," +
                dsncc[index].getsdt();
            bw.write(line);
            bw.newLine();
            System.out.println(">> Đã ghi ONE vào file!");
       }catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public void WriteAll(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (int i = 0; i < n; i++) {
                String line =
                    dsncc[i].getmaNCC() + "," +
                    dsncc[i].gethoNCC() + "," +
                    dsncc[i].gettenNCC() + "," +
                    dsncc[i].getdiachi() + "," +
                    dsncc[i].getsdt();
                bw.write(line);
                bw.newLine();
            }
            System.out.println(">> Đã ghi ALL vào file!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void menu() {
        int chon = -1;
        do {
            System.out.println("\n1.Nhập danh sách nhà cung cấp");
            System.out.println("2.Xuất danh sách nhà cung cấp");
            System.out.println("3.Tìm kiếm nhà cung cấp theo mã");
            System.out.println("4.Tìm kiếm nhà cung cấp theo họ");
            System.out.println("5.Tìm kiếm nhà cung cấp theo tên");
            System.out.println("6.Thêm nhà cung cấp theo mã");
            System.out.println("7.Thêm nhà cung cấp theo địa chỉ");
            System.out.println("8.Xoá nhà cung cấp theo mã");
            System.out.println("9.Xoá nhà cung cấp theo số điện thoại");
            System.out.println("10.Sửa nhà cung cấp theo mã");
            System.out.println("11.Đọc danh sách nhà cung cấp từ file");
            System.out.println("12.Ghi danh sách nhà cung cấp ra file ");
            System.out.println("0.Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch(chon){
                case 1:
                    nhap();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    timkiemtheoho();
                    break;
                   case 4:
                    timkiemtheoten();
                    break;
                case 5:
                    timkiemtheoma();
                    break;
                case 6:
                    themtheoma();
                    break;
                case 7:
                    themtheodiachi();
                    break;
                case 8:
                    xoatheoma();
                    break;
                case 9:
                    xoatheosdt();
                    break;
                case 10:
                    suatheoma();
                    break;
                case 11:
                    System.out.print("Nhập tên file TXT cần đọc: ");
                    String fileDoc = sc.nextLine();
                    docFileTXT(fileDoc);
                    break;
                case 12:
                    System.out.print("Nhập vị trí muốn ghi ONE: ");
                    int vt = sc.nextInt(); sc.nextLine();
                    WriteOne("one.txt", vt);
                    break;
                case 13:
                    WriteAll("all.txt");
                    break;
                case 0:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
                    break;
            }
        }while (chon != 0);
        sc.close();
    }
    public static void main(String[] args){
        List_NCC qly = new List_NCC();
        qly.menu();
    }
}

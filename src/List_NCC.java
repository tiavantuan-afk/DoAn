import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
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
        for(int i = 0;i < dsncc.length;i++){
            System.out.print("Nhà cung cấp thứ " + (i+1) + "\n");
            dsncc[i] = new Nhacungcap();
            dsncc[i].nhap();
        }
 
    }
    public void xuat(){
        System.out.println("Danh sách nhà cung cấp");
        for(int i = 0;i < dsncc.length; i++){
            dsncc[i].xuat();
        }
    }
    public boolean OneIDNCC(String mancc){
        if(mancc == null)
        return false;
        for(int i = 0;i<dsncc.length;i++){
            if(dsncc[i] != null && dsncc[i].getmaNCC() != null && dsncc[i].getmaNCC().equalsIgnoreCase(mancc)){
                return true;
            }
        }
        return false;
    }
    public void timtheoma(String macantim){
        boolean tim = false;
          for(int i = 0;i < dsncc.length; i++){
            if (dsncc[i] != null && dsncc[i].getmaNCC() != null && dsncc[i].getmaNCC().equalsIgnoreCase(macantim)){
            dsncc[i].toString();
            tim = true;
            break;  
            }
         }
        if (!tim)
            System.out.println("Khong tim thay!!! ");
    }
    

    public void themtheoma(){
        System.out.println("Them nha cung cap");
        Nhacungcap nccmoi = new Nhacungcap();
        nccmoi.nhap();
        if(!OneIDNCC(nccmoi.getmaNCC())){
            System.out.print("Ma nha cung cap" + nccmoi.getmaNCC()+ "da ton tai");
        }
        dsncc = Arrays.copyOf(dsncc,dsncc.length + 1);
        dsncc[dsncc.length - 1] =nccmoi;
    }
    public void xoatheoma(String macanxoa){
        boolean xoa = false;
           for(int i =0;i<dsncc.length;i++){
            if(dsncc[i] != null && dsncc[i].getmaNCC() != null &&  dsncc[i].getmaNCC().equalsIgnoreCase(macanxoa)){
                dsncc[i].xuat();
                for (int j = i;j < dsncc.length -1;j++){
                    dsncc[j] = dsncc[j+1];
                }
                dsncc = Arrays.copyOf(dsncc,dsncc.length-1);
                System.out.print("Xoa thanh cong");
                xoa = true;
                return;
            }
           }
        if (!xoa) {
            System.out.println("Khong tim thay nha cung cap co ma " + macanxoa);
        }
    }
    public void suatheoma(String macansua){
        boolean sua = false;
        for(int i = 0;i<dsncc.length;i++){
            if(dsncc[i] !=null && dsncc[i].getmaNCC() != null && dsncc[i].getmaNCC().equalsIgnoreCase(macansua)){
                int chon;
                do { 
                    System.out.println("1.Sua ma");
                    System.out.println("2.Sua ho");
                    System.out.println("3.Sua ten");
                    System.out.println("4.Sua dia chi");
                    System.out.println("5.Sua so dien thoai");
                    System.out.println("0. Thoat");
                    chon = sc.nextInt();
                    sc.nextLine();
                    switch(chon){
                        case 1:
                            String mamoi = sc.nextLine();
                            dsncc[i].setmaNCC(mamoi);
                            break;
                        case 2:
                            String homoi = sc.nextLine();
                            dsncc[i].sethoNCC(homoi);
                            break;
                        case 3:
                            String tenmoi = sc.nextLine();
                            dsncc[i].settenNCC(tenmoi);
                            break;
                        case 4:
                            String diachimoi = sc.nextLine();
                            dsncc[i].setdiachi(diachimoi);
                            break;
                        case 5:
                            String sdtmoi = sc.nextLine();
                            dsncc[i].setsdt(sdtmoi);
                            break;
                        case 6:
                            System.out.println("Thoat");
                            break;
                        default:
                            System.out.println("Khong hop le");
                            break;
                    }
                } while (chon != 0);
                System.out.println("Da sua hoan tat");
            }
        }
    }
    public void thongketheohoncc() {
        String[] hoDaDem = new String[100];
        int[] soLuong = new int[100];
        int demHo = 0;
        for (int i = 0; i < dsncc.length; i++) {
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

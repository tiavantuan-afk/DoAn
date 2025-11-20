import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//TRAN CHI LOC HAS BEEN HERE
public class ListCook {
    public cook[] ds;
    private int n;
    private Scanner sc = new Scanner(System.in);

    ListCook() {
        n = 0;
        ds = new cook[0];
    }

    ListCook(int n) {
        this.n = n;
        ds = new cook[n];
    }

    ListCook(ListCook x) {
        this.n = ds.length;
        this.ds = Arrays.copyOf(ds, ds.length);
    }

    public int getN() {
        return ds.length;
    }

    public void setds(cook[] x) {
        ds = x;
    }

    public cook[] getds() {
        return ds;
    }

    public void xuat() {
        System.out.println("so luong cong thuc: " + ds.length);
        for (int i = 0; i < ds.length; i++) {
            ds[i].Xuat();
        }
    }

    public void fileReader() {
        File f = new File();
        if (!f.exists()) {
            System.out.println("File chưa tồn tại!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split("-");
                if (t.length >= 3) {
                    String[] temp = t[2].split("/");
                    cook a = new cook(t[0].trim(), t[1].trim(), temp);
                    them(a);
                }
            }
            System.out.println("Doc file thanh cong (" + n + " NXB).");
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void fileWriterALL() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter())) {
            for (int i = 0; i < n; i++) {
                bw.write(ds[i].toString());
                bw.newLine();
            }
            System.out.println("Ghi toan bo danh sach CT thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    public void them(cook x) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = x;
    }

    public void them(String ID_CT, String ID_sp, String[] Ma_CNL) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        cook x = new cook();
        x.nhap(ID_CT, ID_sp, Ma_CNL);
        ds[ds.length - 1] = x;
    }

    public boolean TonTai(String ID_CT) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].ID_CT.equalsIgnoreCase(ID_CT)) {
                return false;
            }
        }
        return true;
    }

    public boolean OneID(String ID_CT) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].ID_CT.equalsIgnoreCase(ID_CT)) {
                return true;
            }
        }
        return false;
    }

    public cook timkiemIDCT(String id) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].ID_CT.equalsIgnoreCase(id)) {
                return ds[i];
            }
        }
        return null;
    }

    public cook timkiemIDSP(String id) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].ID_sp.equalsIgnoreCase(id)) {
                return ds[i];
            }
        }
        return null;
    }

    public String getIDSP(String id) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].ID_CT.equalsIgnoreCase(id.trim())) {
                return ds[i].ID_sp;
            }
        }
        return null;
    }

    public String[] getCNL(String id) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].ID_CT.equalsIgnoreCase(id.trim())) {
                return ds[i].Ma_CNL;
            }
        }
        return null;
    }

    public void sua(String id) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].ID_CT.equalsIgnoreCase(id)) {
                int temp = 0;
                String tempS;
                do {
                    System.out.println("chon thong tin can sua:");
                    System.out.println("1. sua ma cong thuc");
                    System.out.println("2. sua ma san pham");
                    System.out.println("3. sua cac nguyen lieu");
                    System.out.println("0. thoat");
                    switch (temp) {
                        case 1:
                            do {
                                System.out.println("nhap ma cong thuc moi:");
                                tempS = sc.nextLine();
                                if (!TonTai(tempS)) {
                                    System.out.println("da ton tai ma");
                                }
                            } while (!TonTai(tempS));
                            ds[i].setID_CT(tempS);
                            break;
                        case 2:
                            System.out.println("nhap ma san pham:");
                            tempS = sc.nextLine();
                            ds[i].setID_sp(tempS);
                            break;
                        case 3:
                            System.out.println("nhap so luong nguyen lieu: ");
                            int dem = sc.nextInt();
                            sc.nextLine();
                            String[] NL = new String[dem];
                            for (int j = 0; i < dem; j++) {
                                System.out.print("nhap nguyen lieu thu " + (j + 1) + ":");
                                NL[j] = sc.nextLine();
                            }
                            ds[i].setCNL(NL);
                        case 0:
                            break;
                        default:
                            break;
                    }
                } while (temp != 0);
            }
        }
    }
}

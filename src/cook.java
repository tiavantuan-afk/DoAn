import java.util.*;

//TRAN CHI LOC HAS BEEN HERE
public class cook {
    public String ID_CT;
    public String ID_sp;
    public String[] Ma_CNL;

    cook() {
        ID_CT = "";
        ID_sp = "";
        Ma_CNL = new String[0];
    }

    cook(String ID_CT, String ID_sp, String[] Ma_CNL) {
        this.ID_CT = ID_CT;
        this.ID_sp = ID_sp;
        this.Ma_CNL = Arrays.copyOf(Ma_CNL, Ma_CNL.length);
    }

    cook(cook x) {
        ID_CT = x.ID_CT;
        ID_sp = x.ID_sp;
        Ma_CNL = Arrays.copyOf(Ma_CNL, Ma_CNL.length);
    }

    public void nhap(String ID_CT, String ID_sp, String[] Ma_CNL) {
        this.ID_CT = ID_CT;
        this.ID_sp = ID_sp;
        this.Ma_CNL = Arrays.copyOf(Ma_CNL, Ma_CNL.length);
    }

    public void Xuat() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                       Cong thuc nau an                         ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ %-20s│ %-40s ║%n", "Ma cong thuc", ID_CT);
        System.out.printf("║ %-20s│ %-40s ║%n", "Ma san pham", ID_sp);
        for (int i = 0; i < Ma_CNL.length; i++)
            System.out.printf("║ %-20s│ %-40s ║%n", "Nguyen lieu thu" + (i + 1), Ma_CNL[i]);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    @Override
    public String toString() {
        String temp = String.join("/", Ma_CNL);
        return String.join("-", ID_CT, ID_sp, temp);
    }

    public void setID_CT(String ID_CT) {
        this.ID_CT = ID_CT;
    }

    public String getID_CT() {
        return ID_CT;
    }

    public void setID_sp(String ID_sp) {
        this.ID_sp = ID_sp;
    }

    public String getID_sp() {
        return ID_sp;
    }

    public void setCNL(String[] ID_CNL) {
        this.Ma_CNL = Arrays.copyOf(ID_CNL, ID_CNL.length);
    }

    public String[] getCNL() {
        return Ma_CNL;
    }
}

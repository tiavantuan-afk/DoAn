import java.util.*;

public class Menu_Cook extends Menu_Main {
    private Scanner sc = new Scanner(System.in);
    String name;

    @Override
    public void menu() {
        int chon;
        do {
            System.out.println("\n=== QUAN LY NAU AN ===");
            System.out.println("1. Xem danh cong thuc nau an");
            System.out.println("2. them");
            System.out.println("3. Xoa phieu nhap");
            System.out.println("4. Sua phieu nhap");
            System.out.println("5. Tim kiem");
            System.out.println("0. Thoat");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    String id;
                    do {
                        System.out.print("Nhap ma cong thuc: ");
                        id = sc.nextLine();
                        if (!DSCOOK.OneID(id)) {
                            System.out.println("Ma cong thuc da ton tai! Vui long nhap lai.");
                        }
                    } while (!DSCOOK.OneID(id));
                    DSMA.CapNhatSoLuong(DSCOOK.getIDSP(id), 1);
                    DSMA.ghiFile(name);
                    String[] idnl = DSCOOK.getCNL(id);
                    for (int i = 0; i < n; i++) {
                        DSNL.GiamSoLuong(idnl[i], 1);
                    }
                    DSNL.ghiFile();
                case 1:
                    DSCOOK.xuat();
                    break;
                case 2:
                    String id;
                    do {
                        System.out.print("Nhap ma cong thuc: ");
                        id = sc.nextLine();
                        if (!DSCOOK.OneID(id)) {
                            System.out.println("Ma cong thuc da ton tai! Vui long nhap lai.");
                        }
                    } while (!DSCOOK.OneID(id));
                    String idsp;
                    do {
                        System.out.print("Nhap ma san pham: ");
                        idsp = sc.nextLine();
                        if (!DSMA.TonTai(id)) {
                            System.out.println("Ma san pham khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSMA.TonTai(id));
                    System.out.println("nhap so luong nguyen: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    String[] idnl = new String[n];
                    for (int i = 0; i < n; i++) {
                        do {
                            System.out.println("nhap nguyen lieu thu " + (i + 1) + ":");
                            idnl[i] = sc.nextLine();
                            if (!DSNL.TonTai(idnl)) {
                                System.out.println("ma nguyen lieu nay khong ton tai");
                            }
                        } while (!DSNL.TonTai(idnl));
                    }
                    DSCOOK.them(id, idsp, idnl);
                    DSCOOK.fileWriterALL();
                    break;
                case 3:
                    System.out.println("nhap chi tiet phieu nhap");
                    String ID_nhap = sc.nextLine();
                    DSPN.xoa(ID_nhap);
                    DSPN.ghiFile();
                    DSCOOK.xoaALL(ID_nhap);
                    DSCOOK.fileWriterALL();
                    break;
                case 4:
                    System.out.print("Nhap ma phieu can sua: ");
                    DSPN.sua(sc.nextLine());
                    DSPN.fileWriterALL();
                    break;
                case 5:
                    System.out.print("Nhap ma phieu can tim: ");
                    DSPN.timkiem(sc.nextLine());
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh quan ly phieu nhap.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (chon != 0);
    }
}
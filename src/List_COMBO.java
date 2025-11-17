import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class List_COMBO {
    Scanner sc = new Scanner(System.in);
    private int n;
    private COMBO[] ds = new COMBO[100];

    public void nhap() {
        System.out.print("Nhap n combo: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap combo thu: " + (i + 1));
            ds[i] = new COMBO();
            ds[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach combo: ");
        for (int i = 0; i < n; i++) {
            if (ds[i] != null) ds[i].xuat();
        }
    }

    // tìm kiếm theo mã
    public void timKiemTheoMa(String maCanTim) {
    boolean timThay = false;

    for (int i = 0; i < n; i++) {
        if (ds[i] != null && ds[i].getMaSP().equalsIgnoreCase(maCanTim)) {
            timThay = true;
            ds[i].xuat();
        }
    }

    if (!timThay)
        System.out.println("Khong tim thay combo co ma: " + maCanTim);
}


    // tìm kiếm theo tên
    public void timkiemtheoten() {
        System.out.print("Nhap ten combo can tim: ");
        String tencantim = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].tenSP != null && ds[i].tenSP.equalsIgnoreCase(tencantim)) {
                timkiem = true;
                ds[i].xuat();
            }
        }
        if (!timkiem) System.out.println("Khong co trong danh sach.");
    }


    //sửa combo theo mã
    public void suacombo(String MA, COMBO c) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(MA)) {
                ds[i] = c;
                System.out.println("Da cap nhat thong tin combo: " + MA);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) System.out.println("Khong tim thay combo de sua: " + MA);
    }

    //xóa combo theo mã
    public void xoacombo(String MAC) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(MAC)) {
                for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
                ds[n - 1] = null;
                n--;
                System.out.println("Da xoa combo co ma: " + MAC);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) System.out.println("Khong tim thay combo co ma: " + MAC);
    }
    
    //thêm một combo
    public void them() {
        if (n >= ds.length) {
            ds = java.util.Arrays.copyOf(ds, ds.length + 10);
        }
        COMBO combo = new COMBO();
        combo.nhap();
        ds[n] = combo;
        n++;
        System.out.println("Da them combo thanh cong.");
    }
    
    // thống kê combo theo mã
    public void thongkecombo() {
        System.out.print("Nhap ma combo can thong ke: ");
        String macantke = sc.nextLine();
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(macantke)) d++;
        }
        if (d >= 1) System.out.println("Combo ton tai");
        else System.out.println("Combo khong ton tai");
    }

    // Đọc combo từ file
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_COMBO.txt"))) {
            String line;
            COMBO x = null;

            ds = new COMBO[0];
            n = 0;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("====") || line.startsWith("So luong")) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 6) {
                    x = new COMBO();
                    x.maSP = t[1];
                    x.tenSP = t[2].replace("_", " ");
                    x.giaBan = Double.parseDouble(t[3]);
                    x.soLuong = Integer.parseInt(t[4]);
                    x.setGiaNiemYet(Double.parseDouble(t[5]));

                    // add vao mang
                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    n++;
                    System.out.println("Doc: " + x.maSP + " - " + x.tenSP);
                }
            }
            System.out.println("Doc file thanh cong.");
            System.out.println("So combo da doc duoc: " + n);

        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.toString());
        } catch (NumberFormatException e) {
            System.out.println("Loi format so: " + e.toString());
        }
    }

    // Ghi combo vào file
    public void ghiFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/List_COMBO.txt"))) {
            bw.write("==== DANH SACH COMBO ====\n");
            bw.write("So luong combo: " + n + "\n");

            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    bw.write("COMBO-" + ds[i].maSP + "-" +
                            ds[i].tenSP.replace(" ", "_") + "-" +
                            ds[i].getGiaBan() + "-" +
                            ds[i].soLuong + "-" +
                            ds[i].getGiaNiemYet() + "\n");
                }
            }
            System.out.println("Ghi file thanh cong.");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.toString());
        }
    }

    // get/set
    public COMBO[] getDs() { 
        return ds; 
    }
    public void setDs(COMBO[] ds) { 
        this.ds = ds; 
    }
    public int getN() { 
        return n; 
    }
    public void setN(int n) { 
        this.n = n; 
    }
}

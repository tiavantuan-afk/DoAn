import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List_CTPN {
    Scanner sc = new Scanner(System.in);
    private int n;
    private Chitietphieunhap[] ds = new Chitietphieunhap[100];

    // Nhập danh sách
    public void nhap() {
        System.out.print("So luong chi tiet phieu nhap: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Chi tiet phieu nhap " + (i + 1) + ":");
            ds[i] = new Chitietphieunhap();
            ds[i].nhap(true);
        }
    }

    // Xuất danh sách
    public void xuat() {
        System.out.println("DANH SACH CHI TIET PHIEU NHAP");
        for (int i = 0; i < n; i++) {
            if (ds[i] != null)
                System.out.println(ds[i]);
        }
    }

    // Thống kê theo ngày
    public void thongketheongay() {
        String[] ngaydadem = new String[100];
        int[] soLuong = new int[100];
        int dem = 0;

        for (int i = 0; i < n; i++) {
            String ngay = ds[i].getngay();
            int index = -1;
            for (int j = 0; j < dem; j++) {
                if (ngaydadem[j].equalsIgnoreCase(ngay)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) {
                ngaydadem[dem] = ngay;
                soLuong[dem] = 1;
                dem++;
            } else {
                soLuong[index]++;
            }
        }

        System.out.println("\nThong ke theo ngay nhap");
        System.out.printf("%-15s %-10s\n", "Ngay", "So luong");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-15s %-10d\n", ngaydadem[i], soLuong[i]);
        }
    }

    // Đọc file
    public void docFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            ds = new Chitietphieunhap[0]; // reset mảng
            n = 0; // reset số lượng

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 5) {
                    Chitietphieunhap x = new Chitietphieunhap();
                    x.setmaNH(t[0]);
                    x.setmaSP(t[1]);
                    x.setngay(t[2]);
                    x.setsoluong(Integer.parseInt(t[3]));
                    x.setdongia(Double.parseDouble(t[4]));

                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    n = ds.length; // cập nhật số lượng
                    System.out.println("Doc: " + x.getmaNH() + " - " + x.getmaSP() + " " + x.getngay() + " "
                            + x.getsoluong() + " " + x.getdongia());
                }
            }
            System.out.println("Doc file thanh cong, so chi tiet da doc: " + n);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Ghi file
    public void ghiFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: " + n + " chi tiet");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Thêm theo mã
    public void themtheoma() {
        System.out.print("Mã cần thêm: ");
        String macanthem = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (ds[i].getmaNH().equalsIgnoreCase(macanthem)) {
                System.out.println("Mã chi tiết phiếu nhập " + macanthem + " đã tồn tại trong danh sách");
                return;
            }
        }

        if (n >= 100) {
            System.out.println("Danh sách chi tiết phiếu nhập đã đầy");
            return;
        }

        System.out.println("Nhập thông tin chi tiết phiếu nhập mới có mã " + macanthem);
        ds[n] = new Chitietphieunhap();
        ds[n].nhap(true);
        ds[n].setmaNH(macanthem);
        n++;
        System.out.println("Đã thêm chi tiết phiếu nhập có mã " + macanthem);
    }

    // Tìm theo mã
    public void timTheoMa() {
        System.out.print("Nhap ma can tim: ");
        String ma = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getmaNH().equalsIgnoreCase(ma)) {
                System.out.println("Tim thay: " + ds[i]);
                return;
            }
        }
        System.out.println("Khong tim thay!");
    }

    // Xoá theo mã
    public void xoatheoma() {
        System.out.print("Mã cần xoá: ");
        String macanxoa = sc.nextLine();
        boolean daxoa = false;
        for (int i = 0; i < n; i++) {
            if (ds[i].getmaNH().equalsIgnoreCase(macanxoa)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds[n - 1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá chi tiết phiếu nhập có mã " + macanxoa);
                break;
            }
        }

        if (!daxoa) {
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã " + macanxoa);
        }
    }

    // Sửa theo mã
    public void suatheoma() {
        System.out.print("Mã cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;

        for (int i = 0; i < n; i++) {
            if (ds[i].getmaNH().equalsIgnoreCase(macansua)) {
                System.out.println("Tìm thấy chi tiết phiếu nhập: " + ds[i]);
                System.out.println("Nhập thông tin mới cho chi tiết phiếu nhập (mã giữ nguyên): ");
                ds[i].nhap(true);
                ds[i].setmaNH(macansua);
                System.out.println("Đã sửa thông tin cho chi tiết phiếu nhập có mã " + macansua);
                dasua = true;
                break;
            }
        }
        if (!dasua) {
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã " + macansua);
        }
    }
}

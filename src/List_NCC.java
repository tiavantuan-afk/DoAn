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

    public void nhap() {
        System.out.print("Số lượng nhà cung cấp: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhà cung cấp thứ " + (i + 1) + "\n");
            dsncc[i] = new Nhacungcap();
            dsncc[i].nhap();
        }

    }

    public void xuat() {
        System.out.println("Danh sách nhà cung cấp");
        for (int i = 0; i < n; i++) {
            dsncc[i].xuat();
        }
    }

    public boolean OneIDNCC(String mancc) {
        if (mancc == null)
            return false;
        for (int i = 0; i < dsncc.length; i++) {
            if (dsncc[i] != null && dsncc[i].getmaNCC() != null && dsncc[i].getmaNCC().equalsIgnoreCase(mancc)) {
                return true;
            }
        }
        return false;
    }

    public void timkiemtheoma(String macantim) {
        boolean tim = false;
        for (int i = 0; i < dsncc.length; i++) {
            if (dsncc[i] != null && dsncc[i].getmaNCC() != null && dsncc[i].getmaNCC().equalsIgnoreCase(macantim)) {
                dsncc[i].toString();
                tim = true;
                break;
            }
        }
        if (!tim)
            System.out.println("Khong tim thay!!! ");
    }

    public Nhacungcap[] timKiemTheoTen(String tenNCC) {
        int d = 0;
        boolean timthay = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].gettenNCC().equalsIgnoreCase(tenNCC)) {
                d++;
                timthay = true;
            }
        }
        Nhacungcap[] kq = new Nhacungcap[d];
        int d1 = 0;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].gettenNCC().equalsIgnoreCase(tenNCC)) {
                kq[d1] = dsncc[i];
                d1++;
            }
        }
        if (!timthay)
            System.out.println("khong tim thay");
        return kq; // Sửa trả về đúng biến
    }

    public void themtheoma() {
        System.out.println("Them nha cung cap");
        Nhacungcap nccmoi = new Nhacungcap();
        nccmoi.nhap();
        if (!OneIDNCC(nccmoi.getmaNCC())) {
            System.out.print("Ma nha cung cap" + nccmoi.getmaNCC() + "da ton tai");
        }
        dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
        dsncc[dsncc.length - 1] = nccmoi;
    }

    public void themtheodiachi() {
        System.out.println("Địa chỉ nhà cung cấp cần thêm: ");
        String diachicanthem = sc.nextLine();
        boolean dathem = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getdiachi().equalsIgnoreCase(diachicanthem)) {
                dathem = true;
                break;
            }
        }
        if (dathem) {
            System.out.println("Địa chỉ nhà cung cấp " + diachicanthem + " đã tồn tại trong danh sách");
        }
        if (n >= 100) {
            System.out.println("Danh sách đã đầy");
        }
        System.out.println("Nhập thông tin nhà cung cấp mới");
        dsncc[n] = new Nhacungcap();
        dsncc[n].nhap();
        dsncc[n].setdiachi(diachicanthem);
        n++;
    }

    public void xoatheoma() {
        System.out.print("Mã nhà cung cấp cần xoá: ");
        String macanxoa = sc.nextLine();
        boolean daxoa = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getmaNCC().equalsIgnoreCase(macanxoa)) {
                for (int j = i; j < n - 1; j++) {
                    dsncc[j] = dsncc[j + 1];
                }
                dsncc[n - 1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá nhà cung cấp có mã " + macanxoa);
                break;
            }
        }
        if (!daxoa) {
            System.out.println("Không tìm thấy nhà cung cấp có mã" + macanxoa);
        }
    }

    public void xoatheosdt() {
        System.out.print("Số điện thoại của nhà cung cấp cần xoá: ");
        String sdtcanxoa = sc.nextLine();
        boolean daxoa = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getsdt().equalsIgnoreCase(sdtcanxoa)) {
                for (int j = i; j < n - 1; j++) {
                    dsncc[j] = dsncc[j + 1];
                }
                dsncc[n - 1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá nhà cung cấp có số điện thoai:" + sdtcanxoa);
                break;
            }
        }
        if (!daxoa) {
            System.out.println("Không tìm thấy nhà cung cấp có mã");
        }
    }

    public void sua() {
        if (dsncc.length == 0 || n == 0) {
            System.out.println("Danh sach nha cung cap rong!");
            return;
        }

        System.out.println("\n===== SUA THONG TIN NHA CUNG CAP =====");
        System.out.print("Nhap Ma Nha Cung Cap (NCC) can sua: ");
        String macansua = sc.nextLine().trim();

        int v = -1; // Vị trí (index) của NCC cần sửa

        // 1. Tìm vị trí NCC
        for (int i = 0; i < n; i++) {
            if (dsncc[i] != null && dsncc[i].getmaNCC().equalsIgnoreCase(macansua)) {
                v = i;
                break;
            }
        }

        if (v == -1) {
            System.out.println("❌ Khong tim thay Nha Cung Cap co ma: " + macansua);
            return;
        }

        // 2. Hiển thị thông tin hiện tại
        System.out.println("--- THONG TIN HIEN TAI ---");
        dsncc[v].xuat();

        // 3. Thực hiện sửa đổi chi tiết bằng Menu switch-case
        int choice;
        do {
            System.out.println("\n=== CHON THUOC TINH CAN SUA ===");
            System.out.println("1. Sua Ma Nha Cung Cap");
            System.out.println("2. Sua Ho Nha Cung Cap");
            System.out.println("3. Sua Ten Nha Cung Cap");
            System.out.println("4. Sua Dia Chi");
            System.out.println("5. Sua So Dien Thoai (SĐT)");
            System.out.println("7. Sua tat ca (Nhap lai)");
            System.out.println("0. Hoan thanh sua & Luu File");
            System.out.print("Lua chon: ");

            // Xử lý lỗi trôi lệnh/nhập sai kiểu dữ liệu
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                choice = -1;
                sc.nextLine();
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhap Ma NCC moi: ");
                    String maMoi = sc.nextLine().trim();

                    dsncc[v].setmaNCC(maMoi);
                    System.out.println(" Da cap nhat Ma NCC.");
                    break;

                case 2:
                    System.out.print("Nhap Ho NCC moi: ");
                    String hoMoi = sc.nextLine().trim();
                    dsncc[v].sethoNCC(hoMoi);
                    System.out.println(" Da cap nhat Ho NCC.");
                    break;

                case 3:
                    System.out.print("Nhap Ten NCC moi: ");
                    String tenMoi = sc.nextLine().trim();
                    dsncc[v].settenNCC(tenMoi);
                    System.out.println(" Da cap nhat Ten NCC.");
                    break;

                case 4:
                    System.out.print("Nhap Dia Chi moi: ");
                    String diaChiMoi = sc.nextLine().trim();
                    dsncc[v].setdiachi(diaChiMoi);
                    System.out.println(" Da cap nhat Dia Chi.");
                    break;

                case 5:
                    System.out.print("Nhap SDT moi: ");
                    String sdtMoi = sc.nextLine().trim();
                    dsncc[v].setsdt(sdtMoi);
                    System.out.println(" Da cap nhat SDT.");
                    break;

                case 7:
                    System.out.println("--- NHAP LAI TOAN BO THONG TIN ---");
                    String maNCCGoc = dsncc[v].getmaNCC(); // Lưu lại mã gốc
                    dsncc[v] = new Nhacungcap(); // Khởi tạo lại đối tượng
                    dsncc[v].nhap(); // Gọi hàm nhập thông tin
                    dsncc[v].setmaNCC(maNCCGoc); // Gán lại mã gốc
                    System.out.println(" Da cap nhat tat ca thong tin.");
                    break;

                case 0:
                    System.out.println("Hoan tat sua Nha Cung Cap.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

            if (choice >= 1 && choice <= 7) {
                System.out.println("\n--- THONG TIN SAU KHI SUA ---");
                dsncc[v].xuat();
            }

        } while (choice != 0);

        // 4. Ghi file sau khi sửa xong
        ghiFile();
        System.out.println("Đã lưu thay đổi vào file.");
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

    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_NCC.txt"))) {
            String line;
            Nhacungcap x = null;
            dsncc = new Nhacungcap[0];
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 4) {
                    x = new Nhacungcap();
                    x.setmaNCC(t[0]);
                    x.sethoNCC(t[1]);
                    x.settenNCC(t[2]);
                    x.setdiachi((t[3]));
                    x.setsdt(t[4]);
                    dsncc = Arrays.copyOf(dsncc, dsncc.length + 1);
                    dsncc[dsncc.length - 1] = x;

                }
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: " + dsncc.length);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_NCC.txt"))) {
            for (int i = 0; i < n; i++) {
                if (dsncc[i] != null) {
                    writer.println(dsncc[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: " + n + " khach");
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }
}

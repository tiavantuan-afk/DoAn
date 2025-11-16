import java.util.Scanner;

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
            dsncc[i].toString();
        }
    }

    public void timkiemtheoma() {
        System.out.println("Mã nhà cung cấp cần tìm: ");
        String macantim = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getmaNCC().equalsIgnoreCase(macantim)) {
                timkiem = true;
                dsncc[i].toString();
            }
        }
        if (!timkiem) {
            System.out.print("Không có trong danh sách");
        }
    }

    public void timkiemtheoho() {
        System.out.println("Họ nhà cung cấp cần tìm: ");
        String hocantim = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].gethoNCC().equalsIgnoreCase(hocantim)) {
                timkiem = true;
                dsncc[i].toString();
            }
        }
        if (!timkiem) {
            System.out.print("Không có trong danh sách");
        }
    }

    public void timkiemtheoten() {
        System.out.println("Tên nhà cung cấp cần tìm: ");
        String tencantim = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].gettenNCC().equalsIgnoreCase(tencantim)) {
                timkiem = true;
                dsncc[i].toString();
            }
        }
        if (!timkiem) {
            System.out.println("Không có trong danh sách");
        }
    }

    public void themtheoma() {
        System.out.println("Mã nhà cung cấp cần thêm: ");
        String macanthem = sc.nextLine();
        boolean themma = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getmaNCC().equalsIgnoreCase(macanthem)) {
                themma = true;
                break;
            }
        }
        if (themma) {
            System.out.print("Mã nhà cung cấp " + macanthem + "đã tồn tại trong danh sách");
        }
        if (n >= 100) {
            System.out.print("Danh sách nhà cung cấp đã đầy");
        }
        System.out.println("Nhập thông tin nhà cung cấp mới có mã " + macanthem);
        dsncc[n] = new Nhacungcap();
        dsncc[n].nhap();
        dsncc[n].setmaNCC(macanthem);
        n++;
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

    public void suatheoma() {
        System.out.println("Mã nhà cung cấp cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;
        for (int i = 0; i < n; i++) {
            if (dsncc[i].getmaNCC().equalsIgnoreCase(macansua)) {
                System.out.println("Tìm thấy nhà cung cấp: ");
                dsncc[i].toString();
                System.out.println("Thông tin cần sửa cho nhà cung cấp: ");
                dsncc[i] = new Nhacungcap();
                dsncc[i].toString();
                System.out.println("Đã sửa thông tin cho nhà cung cấp có mã " + macansua);
                dasua = true;
                break;
            }
        }
        if (!dasua) {
            System.out.println("Không tìm thấy nhà cung cấp có mã " + macansua);
        }
    }
}

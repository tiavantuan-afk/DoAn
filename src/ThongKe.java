import java.text.DecimalFormat;
import java.util.Scanner;

public class ThongKe {
    private Scanner sc = new Scanner(System.in);
    private List_MonAn dsMonAn;
    private List_NhanVien dsNhanVien;
    private List_TonKho dsTonKho;
    private List_KHO dsKHO;
    private List_Nguyenlieu dsNguyenLieu;
    private List_COMBO dsCOMBO;

    public ThongKe() {
        dsMonAn = new List_MonAn();
        dsNhanVien = new List_NhanVien();
        dsTonKho = new List_TonKho();
        dsKHO = new List_KHO();
        dsNguyenLieu = new List_Nguyenlieu();
        dsCOMBO = new List_COMBO();


        // Đọc dữ liệu từ file
        dsMonAn.docFile("src/data/List_MonAn.txt");
        dsNhanVien.docFile("src/data/List_NV.txt");
        dsTonKho.docFile("src/data/List_TonKho.txt");
        dsKHO.docFile("src/data/List_KHO.txt");
        dsNguyenLieu.docFile("src/data/List_Nguyenlieu.txt");
        dsCOMBO.docFile("src/data/List_COMBO.txt");
    }

    public void menu() {
        int chon;

        do {
            System.out.println("\n===== MENU THONG KE =====");
            System.out.println("1. Thong ke chi tiet");
            System.out.println("2. Thong ke theo quy");
            System.out.println("3. Thong ke doanh thu");
            System.out.println("9. Quay lai menu chinh");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    thongKeChi();
                    break;
                case 2:
                    thongKeQuy();
                    break;
                case 3:
                    thongKeDoanhThu();
                    break;
                case 9:
                    System.out.println("Quay lai menu chinh...");
                    return;
                case 0:
                    System.out.println("Thoat thong ke.");
                    break;
                default:
                    System.out.println("Khong hop le");
            }
        } while (chon != 0 && chon != 9);
    }

    private void thongKeChi() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("\n===== THONG KE CHI TIET =====");
        System.out.printf(/* format: */ "%-15s | ", "Loai");

        String[] categories = { "Mon An", "Nhan Vien", "Ton Kho" };
        for (int i = 0; i < categories.length; i++) {
            System.out.printf(/* format: */ "%-15s |", categories[i]);
        }
        System.out.println("\n" +
                "x: \"\\n---------------------------------------------------------------\"");
        System.out.printf("%-15s |", "Tong So");

        // Tổng số từng loại
        double[] tongSo = { dsMonAn.getN(), dsNhanVien.getN(), dsTonKho.getN() };
        for (int i = 0; i < tongSo.length; i++) {
            System.out.printf(/* format: */ "%-15.0f |", tongSo[i]);
        }

        System.out.printf(/* format: */ "\n%-15s |", "Tong Gia Tri");

        // Tính tổng giá trị
        double tongGiaTriMonAn = 0;
        MonAn[] dsMA = dsMonAn.getDs();
        for (int i = 0; i < dsMA.length; i++) {
            if (dsMA[i] != null) {
                tongGiaTriMonAn += dsMA[i].giaBan * dsMA[i].soLuong;
            }
        }

        double tongLuongNV = 0;
        NhanVien[] dsNV = dsNhanVien.getDs();
        for (int i = 0; i < dsNV.length; i++) {
            if (dsNV[i] != null) {
                tongLuongNV += dsNV[i].getLuongCoBan();
            }
        }

        double tongGiaTriTK = 0;
        TonKho[] dsTK = dsTonKho.getDs();
        for (int i = 0; i < dsTK.length; i++) {
            if (dsTK[i] != null) {
                tongGiaTriTK += dsTK[i].getSoLuongTon() * dsTK[i].getGiaNhap();
            }
        }

        double[] giaTris = { tongGiaTriMonAn, tongLuongNV, tongGiaTriTK };
        for (int i = 0; i < giaTris.length; i++) {
            System.out.printf(/* format: */ "%-15s |", df.format(giaTris[i]));
        }

        System.out.println("\n" +
                "x: \"\\n---------------------------------------------------------------\"");
    }

    private void thongKeQuy() {
        DecimalFormat df = new DecimalFormat(/* pattern: */ "#,###");
        System.out.println("\n===== THONG KE THEO QUY =====");
        System.out.printf(/* format: */ "%-15s | %-25s %-23s |%n", "Bo Phan", "Ten", "");
        System.out.printf(/* format: */ "%-15s |", "Quy");
        System.out.printf(/* format: */ "%-11s | %-10s | %-10s | %-10s |%n", "Quy 1", "Quy 2", "Quy 3", "Quy 4");

        // Giả lập dữ liệu theo quý
        String[] boPhan = { "Mon An", "Nhan Vien", "Ton Kho" };
        for (int i = 0; i < boPhan.length; i++) {
            double[] quy = new double[4];

            // Tính dữ liệu theo quý (giả lập phân bố)
            double tongGiaTri = 0;
            if (i == 0) { // Món ăn
                MonAn[] ds = dsMonAn.getDs();
                for (int j = 0; j < ds.length; j++) {
                    if (ds[j] != null) {
                        tongGiaTri += ds[j].giaBan * ds[j].soLuong;
                    }
                }
            } else if (i == 1) { // Nhân viên
                NhanVien[] ds = dsNhanVien.getDs();
                for (int j = 0; j < ds.length; j++) {
                    if (ds[j] != null) {
                        tongGiaTri += ds[j].getLuongCoBan() * 3; // 3 tháng
                    }
                }
            } else { // Tồn kho
                TonKho[] ds = dsTonKho.getDs();
                for (int j = 0; j < ds.length; j++) {
                    if (ds[j] != null) {
                        tongGiaTri += ds[j].getSoLuongTon() * ds[j].getGiaNhap();
                    }
                }
            }

            // Phân bổ theo quý (có thể tùy chỉnh)
            quy[0] = tongGiaTri * 0.25; // Q1
            quy[1] = tongGiaTri * 0.23; // Q2
            quy[2] = tongGiaTri * 0.27; // Q3
            quy[3] = tongGiaTri * 0.25; // Q4

            System.out.printf(/* format: */ "%-15s | %-10s | %-10s | %-10s | %-10s |%n",
                    boPhan[i],
                    df.format(quy[0]),
                    df.format(quy[1]),
                    df.format(quy[2]),
                    df.format(quy[3]));
        }

        // Tổng cộng theo quý
        double[] tongQuy = new double[4];
        System.out.printf(/* format: */ "%-15s | %-10s | %-10s | %-10s | %-10s |",
                "Tong Cong",
                df.format(tongQuy[0]),
                df.format(tongQuy[1]),
                df.format(tongQuy[2]),
                df.format(tongQuy[3]));

        System.out.println("\n" +
                "x: \"\\n---------------------------------------------------------------\"");
    }

    private void thongKeDoanhThu() {
        DecimalFormat df = new DecimalFormat(/* pattern: */ "#,###");

        System.out.println("\n===== THONG KE DOANH THU =====");

        // Header
        System.out.printf("%-15s | %-15s | %-15s | %-15s%n",
                "Loai SP", "So Luong", "Gia Ban TB", "Doanh Thu");
        System.out.println("----------------------------------------------------------------");

        // Thống kê ThucAn
        int soThucAn = 0;
        double tongGiaThucAn = 0, doanhThuThucAn = 0;

        // Thống kê NuocUong
        int soNuocUong = 0;
        double tongGiaNuocUong = 0, doanhThuNuocUong = 0;

        MonAn[] ds = dsMonAn.getDs();
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null) {
                if (ds[i] instanceof ThucAn) {
                    soThucAn++;
                    tongGiaThucAn += ds[i].giaBan;
                    doanhThuThucAn += ds[i].giaBan * ds[i].soLuong;
                } else if (ds[i] instanceof NuocUong) {
                    soNuocUong++;
                    tongGiaNuocUong += ds[i].giaBan;
                    doanhThuNuocUong += ds[i].giaBan * ds[i].soLuong;
                }
            }
        }


        
        // Hiển thị kết quả
        double giaTBThucAn = soThucAn > 0 ? tongGiaThucAn / soThucAn : 0;
        double giaTBNuocUong = soNuocUong > 0 ? tongGiaNuocUong / soNuocUong : 0;

        System.out.printf("%-15s | %-15d | %-15s | %-15s%n",
                "Thuc An", soThucAn, df.format(giaTBThucAn), df.format(doanhThuThucAn));
        System.out.printf("%-15s | %-15d | %-15s | %-15s%n",
                "Nuoc Uong", soNuocUong, df.format(giaTBNuocUong), df.format(doanhThuNuocUong));

        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-15s | %-15d | %-15s | %-15s%n",
                "TONG CONG", (soThucAn + soNuocUong),
                df.format((tongGiaThucAn + tongGiaNuocUong) / (soThucAn + soNuocUong)),
                df.format(doanhThuThucAn + doanhThuNuocUong));

        // Phân tích thêm
        System.out.println("\n===== PHAN TICH =====");
        double tongDoanhThu = doanhThuThucAn + doanhThuNuocUong;
        if (tongDoanhThu > 0) {
            System.out.printf("- Ty trong Thuc An: %.1f%%\n", (doanhThuThucAn / tongDoanhThu) * 100);
            System.out.printf("- Ty trong Nuoc Uong: %.1f%%\n", (doanhThuNuocUong / tongDoanhThu) * 100);

            if (doanhThuThucAn > doanhThuNuocUong) {
                System.out.println("- Thuc An la san pham chinh ");
            } else {
                System.out.println("- Nuoc Uong la san pham chinh ");
            }
        }
    }
}


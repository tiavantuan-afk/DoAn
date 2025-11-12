// package DoAn.test;

// import DoAn.Classchinh.MonAn;
// import DoAn.Classchinh.ThucAn;
// import DoAn.Classchinh.NuocUong;

// public class TestMonAn {
// public static void main(String[] args) {
// // ========== TEST THUC AN ==========
// System.out.println("*** TESTING THUC AN ***");

// // Test 1: Tạo đối tượng ThucAn bằng constructor có tham số
// System.out.println("=== TEST 1: ThucAn Constructor co tham so ===");
// ThucAn thucAn1 = new ThucAn("TA001", "Burger Bo", 50000, "10", true, true);
// thucAn1.hienThiThongTin();
// System.out.println("Gia sau khuyen mai: " + thucAn1.tinhGiaSauKhuyenMai());
// System.out.println("Loai san pham: " + thucAn1.getLoaiSanPham());

// System.out.println("\n" + "=".repeat(40) + "\n");

// // Test 2: Tạo đối tượng ThucAn bằng constructor không tham số và set giá trị
// System.out.println("=== TEST 2: ThucAn Constructor khong tham so ===");
// ThucAn thucAn2 = new ThucAn();
// thucAn2.setMaSP("TA002");
// thucAn2.setTenSP("Pizza Hai San");
// thucAn2.setGiaBan(75000);
// thucAn2.setSoLuong("5");
// thucAn2.setCoThit(false);
// thucAn2.setCoTinhBot(true);

// thucAn2.hienThiThongTin();
// System.out.println("Gia sau khuyen mai: " + thucAn2.tinhGiaSauKhuyenMai());

// System.out.println("\n" + "=".repeat(60) + "\n");

// // ========== TEST NUOC UONG ==========
// System.out.println("*** TESTING NUOC UONG ***");

// // Test 3: Tạo đối tượng NuocUong bằng constructor có tham số
// System.out.println("=== TEST 3: NuocUong Constructor co tham so ===");
// NuocUong nuocUong1 = new NuocUong("NU001", "Coca Cola", 15000, "20", true,
// true, true);
// nuocUong1.hienThiThongTin();
// System.out.println("Gia sau khuyen mai: " + nuocUong1.tinhGiaSauKhuyenMai());
// System.out.println("Loai san pham: " + nuocUong1.getLoaiSanPham());

// System.out.println("\n" + "=".repeat(40) + "\n");

// // Test 4: Tạo đối tượng NuocUong bằng constructor không tham số và set giá
// trị
// System.out.println("=== TEST 4: NuocUong Constructor khong tham so ===");
// NuocUong nuocUong2 = new NuocUong();
// nuocUong2.setMaSP("NU002");
// nuocUong2.setTenSP("Tra Dao");
// nuocUong2.setGiaBan(25000);
// nuocUong2.setSoLuong("15");
// nuocUong2.setCoGas(false);
// nuocUong2.setLoaiChai(false);
// nuocUong2.setCoDa(true);

// nuocUong2.hienThiThongTin();
// System.out.println("Gia sau khuyen mai: " + nuocUong2.tinhGiaSauKhuyenMai());

// System.out.println("\n" + "=".repeat(40) + "\n");

// // Test 5: Test getter methods cho NuocUong
// System.out.println("=== TEST 5: NuocUong Getter methods ===");
// System.out.println("Ma SP: " + nuocUong2.getMaSP());
// System.out.println("Ten SP: " + nuocUong2.getTenSP());
// System.out.println("Gia ban: " + nuocUong2.getGiaBan());
// System.out.println("So luong: " + nuocUong2.getSoLuong());
// System.out.println("Co gas: " + nuocUong2.isCoGas());
// System.out.println("Loai chai: " + nuocUong2.isLoaiChai());
// System.out.println("Co da: " + nuocUong2.isCoDa());

// System.out.println("\n" + "=".repeat(60) + "\n");

// // ========== TEST DA HINH ==========
// System.out.println("*** TESTING DA HINH ***");

// // Test 6: Test đa hình - sử dụng mảng kiểu MonAn
// System.out.println("=== TEST 6: Da hinh voi mang MonAn ===");
// MonAn[] danhSach = new MonAn[4];
// danhSach[0] = new ThucAn("TA003", "Ga Ran", 40000, "8", true, false);
// danhSach[1] = new NuocUong("NU003", "7Up", 12000, "30", true, true, false);
// danhSach[2] = new ThucAn("TA004", "Banh Mi", 20000, "12", true, true);
// danhSach[3] = new NuocUong("NU004", "Nuoc Cam", 18000, "25", false, false,
// true);

// for (int i = 0; i < danhSach.length; i++) {
// System.out.println("--- San pham " + (i + 1) + " ---");
// danhSach[i].hienThiThongTin();
// System.out.println("Gia sau khuyen mai: " +
// danhSach[i].tinhGiaSauKhuyenMai());
// System.out.println("Loai: " + danhSach[i].getLoaiSanPham());
// System.out.println();
// }

// System.out.println("=== HOAN THANH TAT CA TEST ===");
// }
// }

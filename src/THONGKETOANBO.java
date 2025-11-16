public class THONGKETOANBO {
    // public class khachhang extends KHACHHANG{
    //     public khachhang(){
    //         super();
    //     }
    //     public khachhang(String ho, String ten, int Makh, int SDT){
    //         super(ho, ten, Makh, SDT);
    //     }
    // }
    // public class hoadon extends HOADON{
    //     public hoadon(){
    //         super();
    //     }
    //     public hoadon(int Mahd, int Manv, int Makh, String Ngay, double Tongtien){
    //         super(Mahd, Manv, Makh, Ngay, Tongtien);
    //     }      
    // }
    // public class chitiethoadon extends CHITIETHOADON{
    //     public chitiethoadon(){
    //         super();
    //     }
    //     public chitiethoadon(int Mahd, int Masp, int Makh, int SL, int DG, double Thanhtien){
    //         super(Mahd, Masp, Makh, SL, DG, Thanhtien);
    //     }
    // }   
    private List_HOADON listhoadon;
    private List_KHACHHANG listkhachhang;
    private List_CTHD listchitiethoadon;
    public THONGKETOANBO(List_HOADON listhoadon, List_KHACHHANG listkhachhang, List_CTHD listchitiethoadon){
        this.listhoadon = listhoadon;
        this.listkhachhang = listkhachhang;
        this.listchitiethoadon = listchitiethoadon;
    }
    public void THONGKENHANVIEN(){
        System.out.println("Xep hang nhan vien: ");
        this.listhoadon.thongkenhanvien();
    }
    public void THONGKEKHACHHANG(){
        System.out.println("Phan loai khach hang: ");
        this.listkhachhang.thongkekhachhang();
    }
    public void THONGKESANPHAM(){
        System.out.println("Phan loai san pham: ");
        this.listchitiethoadon.thongkesanpham();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyRoom quanLyRoom = new QuanLyRoom();
        do {
            Menu();
            System.out.println("Nhập lựa chọn: ");
            int selection = sc.nextInt();
            switch (selection) {
                case 1: {
                    quanLyRoom.addHuman();
                    break;
                }
                case 2: {
                    quanLyRoom.displayHuman();
                    break;
                }
                case 3: {
                    sc.nextLine();
                    System.out.println("Nhập CMT khách hàng muốn xóa:");
                    String id = sc.nextLine();
                    quanLyRoom.deleteHuman(id);
                    break;
                }
                case 4: {
                    sc.nextLine();
                    System.out.println("Nhập CMT khách hàng muốn thanh toán:");
                    String id = sc.nextLine();
                    quanLyRoom.payPrice(id);
                    break;
                }
                case 5: {
                    break;
                }
            }
        } while (true);
    }

    private static void Menu() {
        System.out.println("1. Nhập thông tin khách trọ");
        System.out.println("2. Hiển thị thông tin khách trọ");
        System.out.println("3. Xóa thông tin khách trọ");
        System.out.println("4. Tính tiền cần thanh toán");
        System.out.println("5. Thêm thông tin khách trọ");
        System.out.println("0. Thoát");
    }
}

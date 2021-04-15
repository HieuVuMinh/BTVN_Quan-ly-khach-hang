import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyRoom {
    List<Room> roomsList = new ArrayList<>();

    public QuanLyRoom() {
        Human human1 = new Human("Hieu1", 25, "156987453");
        Human human2 = new Human("Hieu2", 15, "156983641");
        Human human3 = new Human("Hieu3", 22, "156987987");
        Human human4 = new Human("Hieu4", 44, "156901234");

        Room quanLyRoom1 = new Room(3, "VIP", 500, human1);
        Room quanLyRoom2 = new Room(1, "NORMAL", 200, human2);
        Room quanLyRoom3 = new Room(5, "NORMAL", 200, human3);
        Room quanLyRoom4 = new Room(2, "NORMAL", 200, human4);

        roomsList.add(quanLyRoom1);
        roomsList.add(quanLyRoom2);
        roomsList.add(quanLyRoom3);
        roomsList.add(quanLyRoom4);
    };

    Scanner sc = new Scanner(System.in);

    //Hàm hiển thị danh sách khách hàng
    public void displayHuman() {
        for (int i = 0; i < roomsList.size(); i++) {
            Room room = roomsList.get(i);
            System.out.println(room.toString());
        }
    }

    //Hàm thêm khách thuê phòng
    public void addHuman() {
        // Điền thông tin khách hàng
        Human human = inputInfoHuman();
        // Điền thông tin phòng
        Room room = inputInfoRoom(human);
        // Thêm thông tin phòng vào mảng
        roomsList.add(room);
    }

    private Room inputInfoRoom(Human human) {
        System.out.println("Nhập ngày thuê phòng: ");
        int dayRent = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập loại phòng: ");
        String typeRent = sc.nextLine();
        System.out.println("Nhập giá phòng: ");
        double priceRent = sc.nextDouble();
        Room room = new Room(dayRent, typeRent, priceRent, human);
        return room;
    }

    private Human inputInfoHuman() {
        System.out.println("Điền thông tin khách hàng bên dưới");
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập số CMT: ");
        String identity = sc.nextLine();
        Human human = new Human(name, age, identity);
        return human;
    }

    // Hàm xóa thông tin 1 khách hàng
    public void deleteHuman(String id) {
        int k = -1;
        int count = -1;
        for (int i = 0; i < roomsList.size(); i++){
            count++;
            Room room = roomsList.get(i);
            String identity = room.getHuman().getIdentity();
            if (identity.equals(id)){
                k = 1;
                break;
            }
        }
        if (k == -1){
            System.out.println("Không tìm thấy khách hàng");
        }else {
            Room room = roomsList.get(count);
            roomsList.remove(room);
        }
    }

     //Hàm tính tổng tiền cần phải trả nếu một khách hàng trả phòng
    public void payPrice(String id) {
        int k = -1;
        int count = -1;
        for (int i = 0; i < roomsList.size(); i++){
            count++;
            Room room = roomsList.get(i);
            String identity = room.getHuman().getIdentity();
            if (identity.equals(id)){
                k = 1;
                break;
            }
        }
        if (k == -1){
            System.out.println("Không tìm thấy khách hàng");
        } else {
            Room room = roomsList.get(count);
            double total = room.getDayRent() * room.getPriceRent();
            System.out.printf("Số tiền cần phải trả trong %d ngày tại loại phòng %s: %fUSD",room.getDayRent(),
                    room.getTypeRent(), total);
        }
    }

}

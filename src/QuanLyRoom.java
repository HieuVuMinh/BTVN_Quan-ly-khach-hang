import java.util.Scanner;

public class QuanLyRoom extends Room{
    public static final int size = 6;

    public QuanLyRoom(){
        Human human1 = new Human("Hieu1", 25, "156987453");
        Human human2 = new Human("Hieu2", 15, "156983641");
        Human human3 = new Human("Hieu3", 22, "156987987");
        Human human4 = new Human("Hieu4", 44, "156901234");
        Human human5 = new Human("Hieu5", 21, "156998732");
        Human human6 = new Human("Hieu6", 12, "156987987");
        room[0] = new Room(3, "VIP", 500, human1);
        room[1] = new Room(1, "NORMAL", 200, human2);
        room[2] = new Room(5, "NORMAL", 200, human3);
        room[3] = new Room(2, "NORMAL", 200, human4);
        room[4] = new Room(4, "VIP", 500, human5);
        room[5] = new Room(6, "VIP", 500, human6);
    };

    Scanner sc = new Scanner(System.in);

    Room[] room = new Room[size];


    //Hàm hiển thị danh sách khách hàng
    public void displayHuman(){
        for (int i = 0; i < room.length; i++){
            System.out.println(room[i]);
        }
    }

    //Hàm thêm khách thuê phòng
    public void addHuman(){
        // Điền thông tin khách hàng
        Human human = inputInfo();

        // Điền thông tin phòng
        System.out.println("Nhập ngày thuê phòng: ");
        int dayRent = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập loại phòng: ");
        String typeRent = sc.nextLine();
        System.out.println("Nhập giá phòng: ");
        double priceRent = sc.nextDouble();
        Room[] newRoom = new Room[size+1];
        for (int i = 0; i < size; i++){
            newRoom[i] = room[i];
        }
        newRoom[size] = new Room(dayRent, typeRent, priceRent, human);
        this.room = newRoom;
    }

    // Hàm tạo thông tin khách hàng
    private Human inputInfo() {
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
    public Room[] deleteHuman(String id){
        int k = -1;
        int count = -1;
        for (int i = 0; i < room.length; i++){
            count++;
            if ((room[i].getHuman().getIdentity()).equals(id)){
                k = 1;
                break;
            }
        }
        if (k == -1){
            System.out.println("Không tìm thấy khách hàng");
        } else {
            Room[] newRoom = new Room[room.length - 1];
            for (int i = 0; i < count; i++){
                newRoom[i] = room[i] ;
            }
            for (int j = count; j < newRoom.length; j++){
                newRoom[j] = room[j + 1];
            }
            this.room = newRoom;
        }
        return this.room;
    }

    // Hàm tính tổng tiền cần phải trả nếu một khách hàng trả phòng
    public Room[] payPrice(String id){
        for (int i = 0; i < room.length; i++){
            if((room[i].getHuman().getIdentity().equals(id))){
                System.out.println("Khách ở tại phòng loại " + (room[i].getTypeRent()) + " có giá: " + (room[i].getPriceRent()) + "USD/Đêm" +
                        ". Tổng số tiền phải trả: " + (room[i].getPriceRent() * room[i].getDayRent()) + " USD");
                break;
            }
        }
        return deleteHuman(id);
    }

}

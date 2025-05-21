import com.sirma.academy.model.Room;
import com.sirma.academy.model.RoomStatus;
import com.sirma.academy.model.RoomType;
import com.sirma.academy.service.RoomManager;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static RoomManager roomManager = new RoomManager();

    public static void main(String[] args) {
        seedSampleRooms();

        while (true) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. View Rooms");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewRooms();
                case 2 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void viewRooms() {
        List<Room> rooms = roomManager.getAllRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    private static void seedSampleRooms() {
        RoomType single = new RoomType("Single", Arrays.asList("WiFi", "TV"), 1);
        RoomType deluxe = new RoomType("Deluxe", Arrays.asList("WiFi", "TV", "AC"), 2);
        RoomType apartment = new RoomType("Apartment", Arrays.asList("WiFi", "TV", "Kitchen"), 4);

        roomManager.addRoom(new Room(101, single, 50.0, 10.0, RoomStatus.AVAILABLE));
        roomManager.addRoom(new Room(102, deluxe, 120.0, 20.0, RoomStatus.HOUSEKEEPING));
        roomManager.addRoom(new Room(103, apartment, 200.0, 30.0, RoomStatus.BOOKED));
    }
}
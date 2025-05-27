
import com.sirma.academy.model.*;
import com.sirma.academy.service.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Главен клас с меню за потребители и резервации
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RoomManager roomManager = new RoomManager();
    private static final UserManager userManager = new UserManager();
    private static final BookingManager bookingManager = new BookingManager();
    private static User currentUser = null;

    public static void main(String[] args) {
        seedSampleRooms();

        while (true) {
            System.out.println("\n=== Hotel System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            switch (scanner.nextInt()) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> System.exit(0);
            }
        }
    }

    private static void register() {
        System.out.print("Username: ");
        String user = scanner.next();
        System.out.print("Password: ");
        String pass = scanner.next();
        User u = userManager.register(user, pass);
        System.out.println(u == null ? "User exists." : "Registered successfully.");
    }

    private static void login() {
        System.out.print("Username: ");
        String user = scanner.next();
        System.out.print("Password: ");
        String pass = scanner.next();
        currentUser = userManager.login(user, pass);
        if (currentUser == null) {
            System.out.println("Invalid credentials.");
        } else {
            userMenu();
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\nWelcome, " + currentUser.getUsername());
            System.out.println("1. View All Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. View My Bookings");
            System.out.println("4. Logout");
            System.out.print("Choice: ");
            switch (scanner.nextInt()) {
                case 1 -> roomManager.getAllRooms().forEach(System.out::println);
                case 2 -> bookRoom();
                case 3 -> currentUser.getBookings().forEach(System.out::println);
                case 4 -> { currentUser = null; return; }
            }
        }
    }

    private static void bookRoom() {
        System.out.print("Enter room type (e.g., Single): ");
        String type = scanner.next();
        List<Room> available = roomManager.getAvailableRoomsByType(type);
        if (available.isEmpty()) {
            System.out.println("No available rooms.");
            return;
        }
        Room room = available.get(0);
        System.out.print("Start date (YYYY-MM-DD): ");
        LocalDate start = LocalDate.parse(scanner.next());
        System.out.print("End date (YYYY-MM-DD): ");
        LocalDate end = LocalDate.parse(scanner.next());
        Booking b = bookingManager.createBooking(currentUser, room, start, end);
        System.out.println("Booked: " + b);
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

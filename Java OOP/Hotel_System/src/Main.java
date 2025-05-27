
package h;

import com.sirma.academy.manager.BookingManager;
import com.sirma.academy.manager.RoomManager;
import com.sirma.academy.manager.UserManager;
import com.sirma.academy.manager.*;
import com.sirma.academy.model.User;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserManager userManager = new UserManager();
    private static final RoomManager roomManager = new RoomManager();
    private static final BookingManager bookingManager = new BookingManager(roomManager);

    public static void main(String[] args) {
        userManager.loadUsers();
        roomManager.loadRooms();
        bookingManager.loadBookings();

        while (true) {
            System.out.println("=== Hotel System ===");
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> userManager.register();
                case "2" -> {
                    User user = userManager.login();
                    if (user != null) {
                        System.out.println("Welcome, " + user.getUsername());
                        showMenu(user);
                    }
                }
                case "3" -> System.exit(0);
            }
        }
    }

    private static void showMenu(User user) {
        if (user.isAdmin()) {
            while (true) {
                System.out.println("=== Admin Menu ===");
                System.out.println("1. View All Rooms");
                System.out.println("2. Update All Rooms");
                System.out.println("3. Delete Booking");
                System.out.println("4. Logout");
                System.out.print("Choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1" -> {
                        roomManager.loadRooms();
                        roomManager.viewRooms();

                        System.out.println("\n=== All Bookings ===");
                        bookingManager.loadBookings();
                        bookingManager.viewAllBookings();
                    }
                    case "2" -> {
                        roomManager.loadRooms();
                        roomManager.updateRoom();
                    }
                    case "3" -> {
                        bookingManager.loadBookings();
                        bookingManager.deleteBookingByRoomId();
                    }
                    case "4" -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } else {
            while (true) {
                System.out.println("1. View All Rooms");
                System.out.println("2. Book a Room");
                System.out.println("3. View My Bookings");
                System.out.println("4. Logout");
                System.out.print("Choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1" -> {
                        roomManager.loadRooms();
                        roomManager.viewRooms();
                    }
                    case "2" -> bookingManager.bookRoom(user);
                    case "3" -> {
                        bookingManager.loadBookings();
                        bookingManager.viewBookings(user);
                    }
                    case "4" -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
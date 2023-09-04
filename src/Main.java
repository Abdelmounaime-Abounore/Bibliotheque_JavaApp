import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        User user1 = new User(1, "email@gmail.com", "abcdef");
//        System.out.println(user1.getId());
//        System.out.println(user1.getEmail());
//        System.out.println(user1.getPassword());
//
//        user1.setId(10);
//        user1.setEmail("gmail@gmail.com");
//        user1.setPassword("123456");
//
//        System.out.println(user1.getId());
//        System.out.println(user1.getEmail());
//        System.out.println(user1.getPassword());

//        Admin admin = new Admin(1, "admin@gmail.com", "abcdef");
//        System.out.println(admin.getId());
//        System.out.println(admin.getEmail());
//        System.out.println(admin.getPassword());
//
//        admin.setId(10);
//        admin.setEmail("gmail@gmail.com");
//        admin.setPassword("123456");
//
//        System.out.println(admin.getId());
//        System.out.println(admin.getEmail());
//        System.out.println(admin.getPassword());


        Reader reader = new Reader(1, "gmail@gmail.com", "12345", "Bonore", 100);
        Reservation res1 = new Reservation(1, new Date(), "emprinte", reader, new Book(1, "Book1", "ISBN1", 5));
        Reservation res2 = new Reservation(2, new Date(), "emprinte", reader, new Book(2, "Book2", "ISBN2", 3));
        reader.addReservation(res1);
        reader.addReservation(res2);
        System.out.println("Reader ID: " + reader.getId());
        System.out.println("Email: " + reader.getEmail());
        System.out.println("Password: " + reader.getPassword());
        System.out.println("Username: " + reader.getUserName());
        System.out.println("Number of Members: " + reader.getNumMember());

        System.out.println("Reservations:");
        for (Reservation reservation : reader.getReservations()) {
            System.out.println("Reservation ID: " + reservation.getId());
            System.out.println("Date of Reservation: " + reservation.getDateOfReservation());
            System.out.println("Status: " + reservation.getStatus());
            System.out.println("book: " + reservation.getBook());
            // Print other reservation details if needed
        }
    }
}
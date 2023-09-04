import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Book {
    private int id;
    private String title;
    private String isbn;
    private int quantity;
    private List<Reservation> reservations;

    public Book(int id, String title, String isbn, int quantity, Reservation res) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.reservations = new ArrayList<>();
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }

    public String getIsbn(){
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}

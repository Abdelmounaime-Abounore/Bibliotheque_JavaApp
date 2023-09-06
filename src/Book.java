import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Book {
    private int id;
    private String title;
    private String isbn;
    private int quantity;
    private int auteurId;
    private List<Reservation> reservations;

    public Book(int id, String title, String isbn, int quantity) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.reservations = new ArrayList<>();
    }

    public Book() {

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
    public int getAuteurId() {
        return auteurId;
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
    public void setAuteurId(int auteurId) {
        this.auteurId = auteurId;
    }
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Add Book
    public Book addBook(Book book){
        Connection con = DbConnection.createDbConection();
        String query = "insert into books values (?,?,?,?,?)";

        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, book.getId());
            pstm.setString(2, book.getTitle());
            pstm.setString(3, book.getIsbn());
            pstm.setInt(4, book.getQuantity());
            pstm.setInt(5, book.getAuteurId());
            int count = pstm.executeUpdate();
            if (count != 0)
                System.out.println("Book inserted Successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }

    // Display Books
    public void displayBook(){
        Connection con = DbConnection.createDbConection();
        String query = "SELECT * FROM books INNER JOIN auteurs WHERE books.auteur_id = auteurs.id";
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%s\t%d\t%s%n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getString(5));
            }
            System.out.println("---------------------------");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

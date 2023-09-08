import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public Book addBook(){
        Connection con = DbConnection.createDbConection();
        String query = "insert into books values (?,?,?,?,?)";

        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, this.id);
            pstm.setString(2, this.title);
            pstm.setString(3, this.isbn);
            pstm.setInt(4, this.quantity);
            pstm.setInt(5, this.auteurId);
            int count = pstm.executeUpdate();
            if (count != 0)
                System.out.println("Book inserted Successfully");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this;
    }

    // Display Books
    public void displayBook(){
        Connection con = DbConnection.createDbConection();
        String query = "SELECT books.*, auteurs.name FROM books INNER JOIN auteurs ON books.auteur_id = auteurs.id";
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%s\t%d\t%s%n",
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("isbn"),
                        result.getInt("quantity"),
                        result.getString("name"));
            }
            System.out.println("---------------------------");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Search Books by Title
    public void searchByTitle(String title){
        Connection con = DbConnection.createDbConection();
        String searchQuery = "SELECT books.*, auteurs.name FROM books INNER JOIN auteurs ON books.auteur_id = auteurs.id where title like ?";

        try {
            PreparedStatement stmt = con.prepareStatement(searchQuery);
            stmt.setString(1, title);

            ResultSet result = stmt.executeQuery();
            if (!result.isBeforeFirst()){
                System.out.println("Book not found");
            } else {
                while (result.next()){
                    System.out.println("id : " + result.getInt("id"));
                    System.out.println("title : " + result.getString("title"));
                    System.out.println("isbn : " + result.getString("isbn"));
                    System.out.println("quantity : " + result.getInt("quantity"));
                    System.out.println("name : " + result.getString("name"));
                }
            }
            System.out.println("---------------------------");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Search Books by Author Name
    public void searchByAuthorName(String authorName){
        Connection con =  DbConnection.createDbConection();
        String query = "SELECT books.*, auteurs.name " +
                "FROM books " +
                "INNER JOIN auteurs ON books.auteur_id = auteurs.id " +
                "WHERE auteurs.name LIKE ?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, authorName );
            ResultSet result = stmt.executeQuery();

            if (!result.isBeforeFirst()){
                System.out.println("Book not found");
            } else {
                while (result.next()){
                    System.out.println("id : " + result.getInt("id"));
                    System.out.println("title : " + result.getString("title"));
                    System.out.println("isbn : " + result.getString("isbn"));
                    System.out.println("quantity : " + result.getInt("quantity"));
                    System.out.println("name : " + result.getString("name"));
                    System.out.println("---------------------------");
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

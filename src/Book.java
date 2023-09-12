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
        String query = "insert into books (title, isbn, quantity, auteur_id) values (?,?,?,?)";

        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, this.title);
            pstm.setString(2, this.isbn);
            pstm.setInt(3, this.quantity);
            pstm.setInt(4, this.auteurId);
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
                System.out.println("Title: " + result.getString("title"));
                System.out.println("Isbn: " + result.getString("isbn"));
                System.out.println("Quantity: " + result.getInt("quantity"));
                System.out.println("Author name: " + result.getString("name"));
                System.out.println("==================================================");
            }
            System.out.println("---------------------------");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Search Books by Title
    public Book searchByTitle(String title){
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
                    System.out.println("title : " + result.getString("title"));
                    System.out.println("isbn : " + result.getString("isbn"));
                    System.out.println("quantity : " + result.getInt("quantity"));
                    System.out.println("Author name : " + result.getString("name"));
                }
            }
            System.out.println("---------------------------");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return this;
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
                    System.out.println("title : " + result.getString("title"));
                    System.out.println("isbn : " + result.getString("isbn"));
                    System.out.println("quantity : " + result.getInt("quantity"));
                    System.out.println("Author name : " + result.getString("name"));
                    System.out.println("---------------------------");
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Check book isbn

    public Boolean checkIsbnBook(String isbn){
        Connection con = DbConnection.createDbConection();
        String query = "select * from books where isbn = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, isbn);
            ResultSet resultSet = stmt.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }

    // Update books
    public void updateBook(String isbn) {
        Connection con = DbConnection.createDbConection();

        String query = "UPDATE `books` SET `title`=?, `isbn`=?, `quantity`=?, `auteur_id`=? WHERE `isbn`=? ";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, getTitle());
            preparedStatement.setString(2, getIsbn());
            preparedStatement.setInt(3, getQuantity());
            preparedStatement.setInt(4, getAuteurId());
            preparedStatement.setString(5, isbn);

            int count = preparedStatement.executeUpdate();
            if (count != 0) {
                System.out.println("Book Updated Successfully");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Delete Book

    public void deleteBook(String isbn){
        Connection con = DbConnection.createDbConection();
        String query = "Delete from books where isbn = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, isbn);

            int count = preparedStatement.executeUpdate();
            if (count != 0){
                System.out.println("Book deleted Successfully");
            }else {
                System.out.println("Something went wrong");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Test quantity

    public Boolean checkQuatity(String isbn) {
        Connection con = DbConnection.createDbConection();
        String query = "select * from books where isbn = ? and quantity > 0";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, isbn);
            ResultSet resultSet = stmt.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }

    //Get id of the the book title inserted
    public int getBookId(String isbn){
        Connection con = DbConnection.createDbConection();
        String query = "SELECT id FROM books WHERE isbn = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, isbn);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                return id;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    //Show available books
    public void availableBooks(){
        Connection con = DbConnection.createDbConection();
        String query = "SELECT * from books where quantity > 0";

        try {
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            System.out.println("The available books are: ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("title") + " which has the Isbn " +
                        resultSet.getString("isbn") + " and a quantity of " +
                        resultSet.getInt("quantity") + " books");
                System.out.println("==============================================================");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

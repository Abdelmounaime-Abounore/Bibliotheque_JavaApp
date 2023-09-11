import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private String status;
    private Reader reader;
    private Book book;

    private int userId;

    private  int bookId;

    public Reservation(String status, int userId, int bookId) {
        this.status = status;
        this.userId = userId;
        this.bookId = bookId;
    }
    public Reservation(){

    }



    public String getStatus() {
        return status;
    }

    public Reader getReader() {
        return reader;
    }
    public Book getBook() {
        return book;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    // Borrow a Book
    public void addReservation(){
        Connection con = DbConnection.createDbConection();
        String query = "INSERT into reservations (status, user_id, book_id) values (?,?,?)";
        String queryQuantity = "UPDATE books set quantity = quantity - 1 where id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            PreparedStatement preparedStatement2 = con.prepareStatement(queryQuantity);

            preparedStatement.setString(1, this.status);
            preparedStatement.setInt(2, this.userId);
            preparedStatement.setInt(3, this.bookId);

            preparedStatement2.setInt(1, this.bookId);

            int count = preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();

            if (count != 0){
                System.out.println("Book reserved Successfully");
            }else {
                System.out.println("Something went wrong");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Check if the book is already reserved by the same reader
    public Boolean checkUserReservation(){
        Connection con = DbConnection.createDbConection();
        String query = "SELECT * from reservations where status = 'Borrowed' and user_id = ? and book_id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, this.userId);
            stmt.setInt(2, this.bookId);

            ResultSet resultSet = stmt.executeQuery();
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    //Return Book

    public void returBook(String isbn){
        Connection con = DbConnection.createDbConection();
        String query = "UPDATE reservations SET status = 'returned' WHERE user_id = ? AND book_id = ?";
        String queryQuantity = "UPDATE books set quantity = quantity + 1 where id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, this.userId);
            preparedStatement.setInt(2, this.bookId);

            PreparedStatement preparedStatement2 = con.prepareStatement(queryQuantity);
            preparedStatement2.setInt(1, bookId);

            int count = preparedStatement.executeUpdate();
            preparedStatement2.executeUpdate();

            if (count != 0){
                System.out.println("Book returned Successfully");
            }else {
                System.out.println("Something went wrong");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

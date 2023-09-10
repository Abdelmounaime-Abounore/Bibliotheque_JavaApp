import java.sql.Connection;
import java.sql.PreparedStatement;
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
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, this.status);
            preparedStatement.setInt(2, this.userId);
            preparedStatement.setInt(3, this.bookId);

            int count = preparedStatement.executeUpdate();

            if (count != 0){
                System.out.println("Book reserved Successfully");
            }else {
                System.out.println("Something went wrong");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

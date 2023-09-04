import java.util.Date;

public class Reservation {
    private int id;
    private Date dateOfReservation;
    private String status;
    private Reader reader;
    private Book book;

    public Reservation(int id, Date dateOfReservation, String status, Reader reader, Book book) {
        this.id = id;
        this.dateOfReservation = dateOfReservation;
        this.status = status;
        this.reader = reader;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public Date getDateOfReservation() {
        return dateOfReservation;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfReservation(Date dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}

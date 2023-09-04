import java.util.ArrayList;
import java.util.List;

public class Reader extends User {
    private String userName;
    private int numMember;
    private List<Reservation> reservations;

    public Reader(int id, String email, String password, String userName, int numMember, Reservation res) {
        super(id, email, password);
        this.userName = userName;
        this.numMember = numMember;
        this.reservations = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumMember() {
        return numMember;
    }
    public void setNumMember(int numMember) {
        this.numMember = numMember;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}

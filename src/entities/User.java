import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
    private int id;
    private String email;
    private String password;

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Get the id of user name inserted
    public int getUserId(String name){
        Connection con = DbConnection.createDbConection();
        String query = "SELECT id FROM users WHERE userName = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
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
}

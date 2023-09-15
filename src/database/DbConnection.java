import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    static Connection con;
    public static Connection createDbConection(){
        try{
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/libraryjavaapp";
            String username = "root";
            String password = "";
            // get connection
            con = DriverManager.getConnection(url, username, password);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}

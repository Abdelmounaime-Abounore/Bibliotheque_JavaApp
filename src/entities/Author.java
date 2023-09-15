import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }
    public Author() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Author addAuthor(){

        Connection con = DbConnection.createDbConection();
        String query = "insert into auteurs (name) values(?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, this.name);
            int count = pstm.executeUpdate();
            if (count!=0){
                System.out.println("Author Inserted Successfully");
            }else {
                System.out.println("Failed to Insert Author");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return this;
    }


    // Get Author Id

    public int getAuthorId(String name){
        Connection con = DbConnection.createDbConection();
        String query = "SELECT id FROM auteurs WHERE name = ?";
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

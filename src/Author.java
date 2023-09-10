import java.sql.Connection;
import java.sql.PreparedStatement;

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
}

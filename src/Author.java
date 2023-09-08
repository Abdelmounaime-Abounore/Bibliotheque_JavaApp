import java.sql.Connection;
import java.sql.PreparedStatement;

public class Author {
    private int id;
    private String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Author() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author addAuthor(){

        Connection con = DbConnection.createDbConection();
        String query = "insert into auteurs values(?,?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, this.id);
            pstm.setString(2, this.name);
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

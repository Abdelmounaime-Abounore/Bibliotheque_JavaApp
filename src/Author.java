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

    public void addAuthor(Author author){
        Connection con = DbConnection.createDbConection();
        String query = "insert into auteurs values(?,?)";

        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, author.getId());
            pstm.setString(2, author.getName());
            int count = pstm.executeUpdate();
            if (count!=0)
                System.out.println("Author Inserted Successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

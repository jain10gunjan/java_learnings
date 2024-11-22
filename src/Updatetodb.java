import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Updatetodb {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "gunjan@123";
        String query = "update employees set job_title = 'Software Developer', salary = '70000.0' where id = 1";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            int res =  stmt.executeUpdate(query);
            System.out.println(res+ " Rows Affected");
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

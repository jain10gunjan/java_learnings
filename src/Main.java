import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Students";

        String username = "root";
        String password = "gunjan@123";

        try (Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected to the database");
            System.out.println(connection);
            //Performing other operations;

        }catch (SQLException e){
            System.out.println("Connection Failed: " + e.getMessage() );
        }
    }
}
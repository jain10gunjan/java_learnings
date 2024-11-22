import java.sql.*;

public class Insertdatatodb {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "gunjan@123";
        String query = "Insert into employees(id, name, job_title, salary) VALUES (4, 'Employee 2', 'Front-End Developer', '77000');";
        try{
            Class.forName("com.mysql.jdb.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate(query);// New Method.
            if(res > 0) {
                System.out.println(res + " Rows Affected");
            }else{
                System.out.println("No Rows Affected.");
            }
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

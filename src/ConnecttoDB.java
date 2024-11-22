import java.sql.*;

public class ConnecttoDB {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "gunjan@123";
        String sqlQuery = "Select * from employees";
        try{
            Class.forName("com.mysql.jdb.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection conn =  DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established");
            //Creating SQL Queries;
            Statement stmt = conn.createStatement();
            ResultSet resSet = stmt.executeQuery(sqlQuery);
            while(resSet.next()){
                int id = resSet.getInt("id");
                String name = resSet.getString("name");
                String jobTitle = resSet.getString("job_title");
                double salary = resSet.getDouble("salary");

                System.out.println();
                System.out.println("ID: "+ id);
                System.out.println("Name: "+ name);
                System.out.println("Job Title: "+ jobTitle);
                System.out.println("Salary: "+ salary);
            }

            resSet.close();
            stmt.close();
            conn.close();

            System.out.println("Connection De-Established.");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

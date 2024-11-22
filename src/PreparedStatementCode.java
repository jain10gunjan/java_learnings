import java.sql.*;
import java.util.Scanner;

public class PreparedStatementCode{
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "gunjan@123";
//        String sqlQuery = "select * from employees where name = ? AND job_title = ?";
        String sqlQuery = "insert into employees(id, name, job_title, salary) VALUES (?,?,?,?)";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully!..");

           PreparedStatement preparestatement = connection.prepareStatement(sqlQuery);

//           preparestatement.setString(1,"Hemant");
//           preparestatement.setString(2,"Devops Engineer");
//            ResultSet resultset = preparestatement.executeQuery();
//            while(resultset.next()){
//                int id = resultset.getInt("id");
//                String name = resultset.getString("name");
//                String jobTitle = resultset.getString("job_title");
//                double salary = resultset.getInt("salary");
//                System.out.println("ID: " + id);
//                System.out.println("Name: " + name);
//                System.out.println("Job Title: " + jobTitle);
//                System.out.println("Salary: " + salary);
//            }

//            preparestatement.setInt(1,3);
//            preparestatement.setString(2,"Gunjan");
//            preparestatement.setString(3,"Joh Bhi De Do");
//             preparestatement.setDouble(4,85000.0);

            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String jobtitle = sc.nextLine();
            Double salary = sc.nextDouble();

            preparestatement.setInt(1,id);
            preparestatement.setString(2,name);
            preparestatement.setString(3,jobtitle);
            preparestatement.setDouble(4,salary);
             int rowsAffected =  preparestatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Data updation or insertion successfully.");
            }else{
                System.out.println("Data Insertion Not Possible");
            }



//            resultset.close();
           connection.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

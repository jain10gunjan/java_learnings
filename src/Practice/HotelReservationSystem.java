package Practice;
import java.sql.*;
import java.util.Scanner;

public class HotelReservationSystem {

    private static String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static String username = "root";
    private static String password = "gunjan@123";

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            while(true){
                System.out.println();
                System.out.println("Hotel Management System");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservation");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("6. Exit");
                System.out.println("0. Exit");
                System.out.println("Choose an option: ");
                int choice = scanner.nextInt();

                switch(choice){
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        viewReservation(connection);
                        break;
                    case 3:
                        getRoomNumber(connection, scanner);
                        break;
//                    case 4:
//                        updateReservation(connection, scanner);
//                        break;
//                    case 5:
//                        deleteReservation(connection, scanner);
//                        break;
                    case 6:
//                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try Again");
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        //catch(InterruptedException e){
//            throw new RuntimeException(e);
//        }
    }

    private static void reserveRoom(Connection connection, Scanner scanner){
        try{
            System.out.println("Enter Guest Name ");
            String guestName = scanner.next();
            scanner.nextLine();
            System.out.println("Enter Room number: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Contact number: ");
            String contactNumber = scanner.nextLine();
            String sqlquery = "INSERT INTO reservations (guest_name, room_number, contact_number) " +
                    "VALUES ('" + guestName + "', " + roomNumber + ", '" + contactNumber + "')";


            try(Statement statement = connection.createStatement()){
                int affectedRows = statement.executeUpdate(sqlquery);
                if(affectedRows > 0){
                    System.out.println("Reservation Successful!.");
                }else{
                    System.out.println("Reservation Failed.");
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void viewReservation(Connection connection) throws SQLException{
        String sqlQuery = "Select reservation_id, guest_name, room_number, contact_number, reservation_date FROM reservations;";
        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);){
            System.out.println("Current Reservations");
            System.out.println("+---------------+");
            while(resultSet.next()){
                int reservationId = resultSet.getInt("reservation_id");
                String guestName = resultSet.getString("guest_name");
                int roomNumber = resultSet.getInt("room_number");
                String contactNumber = resultSet.getString("contact_number");
                String reservationDate = resultSet.getTimestamp("reservation_date").toString();
                System.out.println("ReservationID: " + reservationId);
                System.out.println("Guest Name: " + guestName);
                System.out.println("Room Number: " + roomNumber);
                System.out.println("Contact Number " + contactNumber);
                System.out.println("Reservation Date: " + reservationDate);
                System.out.println("+----------------+");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void getRoomNumber(Connection connection, Scanner scanner){
        System.out.println("Enter The Reservation Number:");
        int reservationId =  scanner.nextInt();
        System.out.println("Enter The Guest Name:");
        String guestName = scanner.next();
        scanner.nextLine();
        String sqlQuery = "SELECT room_number FROM reservations WHERE reservation_id = " + reservationId +
                " AND guest_name = '" + guestName + "'";
        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery)){
            if(resultSet.next()){
                int roomNumber = resultSet.getInt("room_number");
                System.out.println("Room Number For Reservation ID: " + reservationId + " and Guest Name: " + guestName);
                System.out.println("Room Number: " + roomNumber);
            }else{
                System.out.println("Reservation not found for the required details i.e. " + reservationId + " "  +guestName);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

private static void updateReservation(Connection connection, Scanner scanner){
    System.out.println("Enter reservation ID to update: ");
    int reservationId = scanner.nextInt();
    scanner.nextLine();

//    if(!reservationExists(connection, scanner)){
//        System.out.println("Reservation not found for the given ID: " + reservationId);
//        return;
//    }

    System.out.println("Enter new guest name: ");
    String newGuestName = scanner.next();
    scanner.nextLine();
    System.out.println("Enter new Room Number");
    int newRoomNumber = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter new contact number: ");
    String newContactNumber = scanner.nextLine();

    String sqlQuery = "Update reservations set guest_name= '" + newGuestName + "', " + "room_number=" + newRoomNumber + ", " + "contact_number = ' " + newContactNumber + ", " + "where reservation_id = " + reservationId;
    try(Statement statement = connection.createStatement();){
        int affectedRows = statement.executeUpdate(sqlQuery);
        if(affectedRows > 0){
            System.out.println("Reservation updated successfully");
        }else{
            System.out.println("Updation failed");
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
}
}

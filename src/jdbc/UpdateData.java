package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/hospital";
        System.out.print("Enter you user name : ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("Enter your password : ");
        String pass = sc.next();
        sc.nextLine();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }

        try {
            Connection con = DriverManager.getConnection(url, name, pass);
            Statement st = con.createStatement();
            int affectedRows = st.executeUpdate("UPDATE patients SET name = 'Tahsin',age = 6 WHERE id = 4;");
            if (affectedRows > 0) {
                System.out.println("Updated patient successfully");
            } else {
                System.out.println("Failed to update Patient");
            }

            st.close();
            con.close();
            System.out.println("Connection closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

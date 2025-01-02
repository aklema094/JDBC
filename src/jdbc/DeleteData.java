
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/hospital";
        System.out.print("Enter you user name : ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("Enter your password : ");
        String pass = sc.next();
        sc.nextLine();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            
        }
        
        try{
            Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            int affectedRows = st.executeUpdate("DELETE FROM patients WHERE id = 5;");
            if(affectedRows>0){
                System.out.println("Patient deleted successfully");
            }else{
                System.out.println("Failed to delete Patient");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

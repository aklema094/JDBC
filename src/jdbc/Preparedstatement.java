
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Preparedstatement {
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
            PreparedStatement st = con.prepareStatement("INSERT INTO patients(name, age, gender) VALUES (?,?,?);");
            st.setString(1,"Niha");
            st.setInt(2, 12);
            st.setString(3, "Female");
            int affectedRows = st.executeUpdate();
            if(affectedRows>0){
                System.out.println("Patient added successfully");
            }else{
                System.out.println("Failed to add Patient");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

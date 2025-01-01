
package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBC {
  
    public static void main(String[] args) {
        
         Scanner sc = new Scanner (System.in);
         String url = "jdbc:mysql://localhost:3306/hospital";
         System.out.print("Enter you user name : ");
         String userName = sc.next();
         sc.nextLine();
         System.out.print("Enter your password : ");
         String password = sc.next();
         sc.nextLine();
         
        //1st: loading driver class
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        //2: building Connection
        
        try{
            Connection con = DriverManager.getConnection(url,userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from patients");
            while(rs.next()){
                System.out.println("Patient Id : "+rs.getInt("id"));
                System.out.println("Name : "+rs.getString("name"));
                System.out.println("Age : "+rs.getInt("age"));
                System.out.println("Gender : "+rs.getString("gender"));
                System.out.println("================================================");                      
            }
            rs.close();
            st.close();
            con.close();
            System.out.println("Connection close successfully");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}

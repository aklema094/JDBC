
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class TransactionH {
    
     public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/my_db";
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
            con.setAutoCommit(false);
            PreparedStatement sw = con.prepareStatement("UPDATE account SET balance = balance - ? WHERE accNo = ?;");
            PreparedStatement sd = con.prepareStatement("UPDATE account SET balance = balance + ? WHERE accNo = ?;");
            sw.setDouble(1, 200);
            sw.setString(2, "acc234");
            sd.setDouble(1, 200);
            sd.setString(2, "acc123");
            int i1 = sw.executeUpdate();
            int i2 = sd.executeUpdate();
            if(i1>0 && i2>0){
                con.commit();
                System.out.println("Transection Successfull");
            }else{
                con.rollback();
                System.out.println("Transection Failed");
            }
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
     }
    
}

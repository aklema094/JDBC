
package jdbc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageInsert {
    
    public static void main(String[] args) throws SQLException,FileNotFoundException,IOException {
        
        String url ="jdbc:mysql://localhost:3306/my_db";
        String name = "root";
        String pass = "29344";
        
        String img = "src/jdbc/abc.jpg";
        String query = "INSERT INTO imageTable(image) VALUES(?);";
        FileInputStream fs = new FileInputStream(img);
        byte[] data = new byte[fs.available()];
        fs.read(data);
        
        Connection con = DriverManager.getConnection(url,name,pass);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setBytes(1, data);
        int r = ps.executeUpdate();
        if(r>0){
            System.out.println("Image uploaded Successfully");
        }else{
            System.out.println("Failed to upload image");
        }
        
        
        
    }
    
}

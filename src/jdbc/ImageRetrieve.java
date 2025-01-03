package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ImageRetrieve {

    public static void main(String[] args) throws SQLException,IOException {

        String url = "jdbc:mysql://localhost:3306/my_db";
        String name = "root";
        String pass = "29344";

        String img = "src/jdbc/";
        String query = "select * from imageTable WHere imgId = ?;";

        Connection con = DriverManager.getConnection(url, name, pass);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, 1);
        ResultSet r = ps.executeQuery();
        while (r.next()) {
            OutputStream us = new FileOutputStream(img + "imagee.jpg");
            byte[] data = r.getBytes("image");
            us.write(data);
            System.out.println("Successfull");
        }

    }

}

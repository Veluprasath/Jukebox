package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
    public static Connection getConnection()
    {
        Connection connection=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox","root" , "root");

        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println(e);

        }
        return connection;
    }
}

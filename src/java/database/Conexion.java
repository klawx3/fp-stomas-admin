package database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

// V2
public class Conexion {
    private Statement sen;
    private Connection con;
    private static String user;
    private static String password;
    private static String url;

   public Conexion(String bd) throws ClassNotFoundException, SQLException {
        try {
            user = "root";
            password  = "Olakease123!";
            url  = "jdbc:mysql://localhost/"+bd+"?useSSL=false";
            
//          Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,user,password);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   protected ResultSet ejecutar(String query) throws SQLException {
        System.out.println(query);
        sen = con.createStatement();

        if (
            query.toLowerCase().startsWith("insert") || 
            query.toLowerCase().startsWith("update") ||
            query.toLowerCase().startsWith("delete")
        ) {
            sen.executeUpdate(query);
            close();
            return null;
        }
            
        return sen.executeQuery(query);
    }

    protected void close() throws SQLException {
        sen.close();
    }
}

package database.model;

import database.Conexion;
import java.sql.SQLException;

public class DBUserLogin extends Conexion {

    private int id;
    private String userName;
    private String pass;

    public DBUserLogin() throws ClassNotFoundException, SQLException {
        super("fpdb");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "DBUserLogin{" + "id=" + id + ", userName=" + userName + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.impl;

import database.Conexion;
import database.dao.GenericCrud;
import database.model.DBUserLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 */
public class UserLoginDaoImpl extends Conexion implements GenericCrud<DBUserLogin> {

    public UserLoginDaoImpl() throws ClassNotFoundException, SQLException {
        super("fpdb");
    }

    @Override
    public void add(DBUserLogin t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DBUserLogin t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DBUserLogin t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DBUserLogin> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isValid(String name, String pass) throws SQLException {
        System.out.println("Nombre: " + name);
        System.out.println("Pass: " + pass);
        boolean isValid = false;
        ResultSet rs = ejecutar("SELECT COUNT(id) FROM adminLogin WHERE user_name = '" + name + "' AND password = SHA1('" + pass + "');");
        while (rs.next()) {
            int x = rs.getInt(1);
            if (x == 1) {
                isValid = true;
            }
        }
        return isValid;
    }

}

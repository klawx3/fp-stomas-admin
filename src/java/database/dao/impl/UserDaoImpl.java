/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.impl;

import database.Conexion;
import database.dao.UserDao;
import database.model.DBHistory;
import database.model.DBSede;
import database.model.DBUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 */
public class UserDaoImpl extends Conexion implements UserDao {

    public UserDaoImpl() throws ClassNotFoundException, SQLException {
        super("fpdb");
    }

    @Override
    public DBUser getAllUserBySede(DBSede sede) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DBUser> getUserById(int id) {
        List<DBUser> list = new ArrayList<>();
        try {

            ResultSet rs = ejecutar("SELECT id, fullname, rut FROM user WHERE id = " + id + ";");

            DBUser dbu;

            while (rs.next()) {
                dbu = new DBUser();
                dbu.setId(rs.getInt(1));
                dbu.setFullname(rs.getString(2));
                dbu.setRut(rs.getString(3));

                list.add(dbu);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<DBUser> getLatestEnrollments(int instituteId, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DBUser> getLatestVerified(int instituteId, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<DBUser>> exportDailyData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<DBUser> getUserByRut(String rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean userRutExists(String rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<List<DBUser>> exportDateData(String fecha1, String fecha2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(DBUser t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DBUser t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DBUser> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DBUser t) throws SQLException {

        ejecutar("UPDATE user SET fullname = '" + t.getFullname() + "', rut = '" + t.getRut() + "' WHERE id = " + t.getId() + ";");

    }

    @Override
    public void deleteById(int id) throws SQLException {

        ejecutar("DELETE FROM usuario WHERE id = " + id + ";");

    }
}

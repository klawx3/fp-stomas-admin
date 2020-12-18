/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao.impl;

import database.Conexion;
import database.dao.DaoHistorial;
import database.model.DBHistory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoryDaoImpl extends Conexion implements DaoHistorial {

    private ResultSet rs;

    public HistoryDaoImpl() throws ClassNotFoundException, SQLException {
        super("fpdb");
    }

    @Override
    public void add(DBHistory t) {
        String sql = "INSERT INTO history VALUES(NULL, " + t.getUserId() + ", NOW());";
    }

    @Override
    public void delete(DBHistory t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(DBHistory t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<DBHistory> getAll() throws SQLException {
        List<DBHistory> list = new ArrayList<>();
        rs = ejecutar("SELECT user.id, user.fullname, user.rut, history.register_date, user_type.name FROM history\n" +
                        "INNER JOIN user ON user.id = history.user_id_fk\n" +
                        "INNER JOIN user_type ON user.user_type_id_fk = user_type.id\n" +
                        "ORDER BY history.register_date;");

        DBHistory dbh;

        while (rs.next()) {
            dbh = new DBHistory();
            dbh.setUserId(rs.getInt(1));
            dbh.setUserName(rs.getString(2));
            dbh.setUserRut(rs.getString(3));
            dbh.setRegisterDate(rs.getString(4));
            dbh.setUserType(rs.getString(5));

            list.add(dbh);

        }

        return list;
    }

    @Override
    public List<DBHistory> getUserRecordByName(String name) throws SQLException {
        List<DBHistory> list = new ArrayList<>();
        try {

            rs = ejecutar("SELECT user.id, user.fullname, user.rut, history.register_date FROM history INNER JOIN user ON user.id = history.user_id_fk where user.fullname LIKE '%" + name + "%';");

            DBHistory dbh;

            while (rs.next()) {
                dbh = new DBHistory();
                dbh.setUserId(rs.getInt(1));
                dbh.setUserName(rs.getString(2));
                dbh.setUserRut(rs.getString(3));
                dbh.setRegisterDate(rs.getString(4));

                list.add(dbh);

            }

        } catch (SQLException ex) {
            Logger.getLogger(HistoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<DBHistory> getUserRecordByDate(String date) throws SQLException {
        List<DBHistory> list = new ArrayList<>();
        try {

            rs = ejecutar("SELECT user.fullname, user.rut, history.register_date FROM history INNER JOIN user ON user.id = history.user_id_fk where history.register_date = '" + date + "';");

            DBHistory dbh;

            while (rs.next()) {
                dbh = new DBHistory();

                dbh.setUserName(rs.getString(1));
                dbh.setUserRut(rs.getString(2));
                dbh.setRegisterDate(rs.getString(3));

                list.add(dbh);

            }

        } catch (SQLException ex) {
            Logger.getLogger(HistoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}

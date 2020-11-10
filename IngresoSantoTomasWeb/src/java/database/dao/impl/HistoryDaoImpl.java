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

/**
 *
 * @author klawx
 */
public class HistoryDaoImpl implements DaoHistorial {

    public static Logger log = Logger.getLogger(HistoryDaoImpl.class.getName());
    private Conexion con;

    public HistoryDaoImpl(Conexion con) {
        this.con = con;
    }

    @Override
    public void add(DBHistory t) {
        String sql = "INSERT INTO history VALUES(NULL, " + t.getUserId() + ", NOW());";
        try {
            log.fine(sql);
            con.ejecutar(sql);
        } catch (SQLException ex) {
            Logger.getLogger(HistoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(DBHistory t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DBHistory t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DBHistory> getAll() {
        String sql = "SELECT user.fullname, user.rut, history.register_date FROM history "
                + "INNER JOIN user ON user.id = history.user_id_fk";
        List<DBHistory> list = new ArrayList<>();
        try {
            ResultSet rs = con.ejecutar(sql);
            log.fine(sql);

            DBHistory dbh = new DBHistory();

            while (rs.next()) {
                dbh.setUserName(rs.getString(1));
                dbh.setUserRut(rs.getString(2));
                dbh.setRegisterDate(rs.getDate(3));
                list.add(dbh);
            }

            return null;
        } catch (SQLException ex) {
            Logger.getLogger(HistoryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}

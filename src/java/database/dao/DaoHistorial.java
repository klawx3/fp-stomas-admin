/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import database.model.DBHistory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author klawx
 */
public interface DaoHistorial extends GenericCrud<DBHistory> {

    List<DBHistory> getUserRecordByName(String name) throws SQLException;

    List<DBHistory> getUserRecordByDate(String date) throws SQLException;

}

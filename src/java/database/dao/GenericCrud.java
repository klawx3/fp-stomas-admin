/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kenshi
 * @param <T>
 */
public interface GenericCrud<T> {

    void add(T t) throws SQLException;

    void delete(T t) throws SQLException;

    void update(T t) throws SQLException;

    List<T> getAll() throws SQLException;
}

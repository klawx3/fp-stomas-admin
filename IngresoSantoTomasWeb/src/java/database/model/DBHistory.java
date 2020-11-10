/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.model;

import java.sql.Date;

/**
 *
 * @author klawx
 */
public class DBHistory {
    private int userId;
    private String userName;
    private String userRut;
    private Date registerDate;

    public DBHistory() {
    }
    
    public DBHistory(int userId, String userName, String userRut, Date registerDate) {
        this.userId = userId;
        this.userName = userName;
        this.userRut = userRut;
        this.registerDate = registerDate;
    }

    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRut() {
        return userRut;
    }

    public void setUserRut(String userRut) {
        this.userRut = userRut;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "DBHistory{" + "userId=" + userId + ", userName=" + userName + ", userRut=" + userRut + ", registerDate=" + registerDate + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}

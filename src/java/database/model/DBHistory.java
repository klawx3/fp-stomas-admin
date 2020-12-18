package database.model;
public class DBHistory {

    private int userId;
    private String userName;
    private String userRut;
    private String registerDate;
    private String userType;

    public DBHistory() {
    }

    public DBHistory(int userId, String userName, String userRut, String registerDate, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userRut = userRut;
        this.registerDate = registerDate;
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "DBHistory{" + "userId=" + userId + ", userName=" + userName + ", userRut=" + userRut + ", registerDate=" + registerDate + '}';
    }

}

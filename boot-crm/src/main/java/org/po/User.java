package org.po;

public class User {
    private Integer userId;

    private String userCode;

    private String userName;

    private String userPassword;

    private String userState;

    public User(Integer userId, String userCode, String userName, String userPassword, String userState) {
        this.userId = userId;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userState = userState;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }
}
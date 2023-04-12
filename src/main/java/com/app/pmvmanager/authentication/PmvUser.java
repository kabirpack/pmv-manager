package com.app.pmvmanager.authentication;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PmvUser {
    @Id
    private int userId;
    private String userName;
    private String password;
    private String userRole;

    public PmvUser() {
    }

    public PmvUser(int userId, String userName, String password, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}

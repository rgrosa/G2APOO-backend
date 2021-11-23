package br.com.src.dto;

import java.io.Serializable;

public class UpdateUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;
    private String userRealName;
    private String userPassword;
    private String currentUserPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCurrentUserPassword() {
        return currentUserPassword;
    }

    public void setCurrentUserPassword(String currentUserPassword) {
        this.currentUserPassword = currentUserPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", currentUserPassword='" + currentUserPassword + '\'' +
                '}';
    }
}

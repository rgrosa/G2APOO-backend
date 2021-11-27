package br.com.src.dto;

import java.io.Serializable;

public class UpdateUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;
    private String userRealName;
    private String userPassword;
    private String currentUserPassword;
    private String contactEmail;

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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", currentUserPassword='" + currentUserPassword + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                '}';
    }
}

package br.com.src.dto;


import java.io.Serializable;

public class LoggedUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String username;
    private String password;
    private String userRealName;
    private int userTypeId;
    private String jwtToken;

    public LoggedUserDTO(Long userId, String username, String password, String userRealName, String jwtToken, int userTypeId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userRealName = userRealName;
        this.jwtToken = jwtToken;
        this.userTypeId = userTypeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public String toString() {
        return "LoggedUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userTypeId=" + userTypeId +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}

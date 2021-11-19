package br.com.src.dto;

import java.io.Serializable;

public class UserLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;
    private String userSecret;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "userName='" + userName + '\'' +
                ", userSecret='" + userSecret + '\'' +
                '}';
    }
}

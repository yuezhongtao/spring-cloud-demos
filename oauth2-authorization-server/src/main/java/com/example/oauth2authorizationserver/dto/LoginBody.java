package com.example.oauth2authorizationserver.dto;

import java.io.Serializable;

public class LoginBody implements Serializable{
    private String username;
    private String password;

    public LoginBody() {
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
}

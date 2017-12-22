package com.example.oauth2authorizationserver.dto;

import java.io.Serializable;

public class LoginResponse implements Serializable{
    private String result;
    private String credential;

    public LoginResponse(String result) {
        this.result = result;
    }

    public LoginResponse(String result, String credential) {
        this.result = result;
        this.credential = credential;
    }

    public LoginResponse() {
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

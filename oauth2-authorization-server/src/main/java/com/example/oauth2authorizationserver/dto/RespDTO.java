package com.example.oauth2authorizationserver.dto;

import java.io.Serializable;

public class RespDTO implements Serializable {
    private String result;

    public RespDTO(String result) {
        this.result = result;
    }

    public RespDTO() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

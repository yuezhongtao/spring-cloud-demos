package com.example.oauth2authorizationserver.dto;

import java.io.Serializable;

public class RespDTO implements Serializable {
    private String result;
    private Serializable object;

    public RespDTO(String result) {
        this.result = result;
    }

    public RespDTO(String result, Serializable object) {
        this.result = result;
        this.object = object;
    }

    public RespDTO() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Serializable getObject() {
        return object;
    }

    public void setObject(Serializable object) {
        this.object = object;
    }
}

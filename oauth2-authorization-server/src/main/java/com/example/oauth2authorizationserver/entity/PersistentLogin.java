package com.example.oauth2authorizationserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "persistent_logins")
@Entity
public class PersistentLogin implements Serializable{
    @Id
    @Column(name = "series",length = 64)
    private String series;

    @Column(name = "username",length = 64,nullable = false)
    private String username;

    @Column(name = "token",length = 64,nullable = false)
    private String token;

    @Column(name = "last_userd",nullable = false)
    private Date lastUsed;

    public PersistentLogin() {
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
}

package com.example.oauth2authorizationserver.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "test")
@Entity
public class Test implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "enum_test")
    private TestEnum enumTest;

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestEnum getEnumTest() {
        return enumTest;
    }

    public void setEnumTest(TestEnum enumTest) {
        this.enumTest = enumTest;
    }
}

package com.example.oauth2authorizationserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Column(name = "enum_test2")
    @Convert(converter = TestEnum2Converter.class)
    private TestEnum2 enum2;

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

    public TestEnum2 getEnum2() {
        return enum2;
    }

    public void setEnum2(TestEnum2 enum2) {
        this.enum2 = enum2;
    }
}

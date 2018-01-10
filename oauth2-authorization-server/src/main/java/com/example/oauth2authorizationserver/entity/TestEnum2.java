package com.example.oauth2authorizationserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  TestEnum2 {
    TT("desc1",(short)3), TT2("desc2",(short) 4);

    private String desc;
    private short index;


    TestEnum2(String desc2, short i) {
        this.desc = desc2;
        this.index = i;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    public static TestEnum2 valueOf(Short dbData) {
        switch (dbData){
            case 3:
                return TT;
            case 4:
                return TT2;
            default:
                return TT;
        }
    }
}

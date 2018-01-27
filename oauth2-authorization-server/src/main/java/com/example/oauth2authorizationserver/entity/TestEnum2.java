package com.example.oauth2authorizationserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  TestEnum2 {
    TT("desc1",3), TT2("desc2",4);

    private String desc;
    private int index;


    TestEnum2(String desc2, int i) {
        this.desc = desc2;
        this.index = i;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static TestEnum2 valueOf(Integer dbData) {
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

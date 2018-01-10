package com.example.oauth2authorizationserver.entity;

import javax.persistence.AttributeConverter;

public class TestEnum2Converter implements AttributeConverter<TestEnum2, Short> {
    @Override
    public Short convertToDatabaseColumn(TestEnum2 attribute) {
        return attribute.getIndex();
    }

    @Override
    public TestEnum2 convertToEntityAttribute(Short dbData) {
        return TestEnum2.valueOf(dbData);
    }
}

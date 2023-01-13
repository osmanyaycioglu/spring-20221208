package com.training.spring.di.data.jpa;

import com.training.spring.di.encryption.JasyptSec;

import javax.persistence.AttributeConverter;

public class EncryptConverter implements AttributeConverter<String,String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        return JasyptSec.defaultEnc.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return JasyptSec.defaultEnc.decrypt(dbData);
    }
}

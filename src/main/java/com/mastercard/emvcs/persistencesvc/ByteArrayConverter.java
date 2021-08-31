package com.mastercard.emvcs.persistencesvc;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.nio.charset.StandardCharsets;

@Converter
public class ByteArrayConverter implements AttributeConverter<String, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(String string) {
        return PConfiguration.hexStringToByteArray(string);
    }

    @Override
    public String convertToEntityAttribute(byte[] byteArray) {
        return (new String(byteArray, StandardCharsets.UTF_8));
    }

}

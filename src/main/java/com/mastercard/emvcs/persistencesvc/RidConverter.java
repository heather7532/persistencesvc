package com.mastercard.emvcs.persistencesvc;

import javax.persistence.AttributeConverter;

public class RidConverter implements AttributeConverter<RID, ByteArray> {

    @Override
    public ByteArray convertToDatabaseColumn(RID rid) {
        return new ByteArray(rid.getRidAsBytes());
    }

    @Override
    public RID convertToEntityAttribute(ByteArray byteArray) {
        return null;
    }

}

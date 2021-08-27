package com.mastercard.emvcs.persistencesvc;

import org.hibernate.annotations.Type;

import javax.persistence.Lob;
import java.io.Serializable;

public class RID implements Serializable {

//    @Lob
//    @Type(type = "org.hibernate.type.BinaryType")
    private String rid;

    public String getRid() {
        return rid;
    }

    public byte[] getRidAsBytes() {
        return PConfiguration.hexStringToByteArray(rid);
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}

package com.mastercard.emvcs.persistencesvc;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static com.mastercard.emvcs.persistencesvc.PConfiguration.hexStringToByteArray;

@Entity
@Table(name="unallocated_sn")
public class UnallocatedSn {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column
    @Convert(converter = RidConverter.class)
    private RID rid;

//    @Column(name = "ca_pkidx")
//    @Lob
//    @Type(type = "org.hibernate.type.BinaryType")
    private String caPKIdx;

    @Column(name = "range_start")
    private long rangeStart;

    @Column(name = "range_end")
    private long rangeEnd;

    @Column(name = "alloc_size")
    private long allocSize;

    @Column(name = "realloc_level")
    private long reallocLevel;

    @Column(name = "created_timestamp")
    private Date createdTimestamp;

    @Column(name = "modified_timestamp")
    private Date modifiedTimestamp;

    public UnallocatedSn(RID rid, String caPKIdx, long rangeStart, long rangeEnd, long allocSize, long reallocLevel, Date createdTimestamp, Date modifiedTimestamp) {
    }

    public UnallocatedSn(UUID id, RID rid, String caPKIdx, long rangeStart, long rangeEnd, long allocSize, long reallocLevel, Date createdTimestamp, Date modifiedTimestamp) {
        this.id = id;
        this.rid = rid;
        this.caPKIdx = caPKIdx;
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.allocSize = allocSize;
        this.reallocLevel = reallocLevel;
        this.createdTimestamp = createdTimestamp;
        this.modifiedTimestamp = modifiedTimestamp;
    }

    public UnallocatedSn() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RID getRid() {
        return rid;
    }

    public void setRid(RID rid) {
        this.rid = rid;
    }

    public String getCaPKIdx() {
        return caPKIdx;
    }

    public void setCaPKIdx(String caPKIdx) {
        this.caPKIdx = caPKIdx;
    }

    public long getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(long rangeStart) {
        this.rangeStart = rangeStart;
    }

    public long getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(long rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public long getAllocSize() {
        return allocSize;
    }

    public void setAllocSize(long allocSize) {
        this.allocSize = allocSize;
    }

    public long getReallocLevel() {
        return reallocLevel;
    }

    public void setReallocLevel(long reallocLevel) {
        this.reallocLevel = reallocLevel;
    }

    public Date getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public void setModifiedTimestamp(Date modified_timestamp) {
        this.modifiedTimestamp = modified_timestamp;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date created_timestamp) {
        this.createdTimestamp = created_timestamp;
    }

    @PrePersist
    protected void onCreate() {
        setCreatedTimestamp(new Date());
        setId(UUID.randomUUID());
    }

    @PreUpdate
    protected void onUpdate() {
        setModifiedTimestamp(new Date());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnallocatedSn)) return false;
        UnallocatedSn that = (UnallocatedSn) o;
        return getId().equals(that.getId()) && rid.equals(that.rid) && getCaPKIdx().equals(that.getCaPKIdx());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), rid, getCaPKIdx());
    }

    @Override
    public String toString() {
        String r = new String(rid.getRidAsBytes(), StandardCharsets.UTF_8);
        return "UnallocatedSn{" +
                "id=" + id +
                ", rid='" + rid + '\'' +
                ", caPKIdx='" + caPKIdx + '\'' +
                ", rangeStart=" + rangeStart +
                ", rangeEnd=" + rangeEnd +
                ", allocSize=" + allocSize +
                ", reallocLevel=" + reallocLevel +
                ", createdTimestamp=" + createdTimestamp +
                ", modifiedTimestamp=" + modifiedTimestamp +
                '}';
    }
}
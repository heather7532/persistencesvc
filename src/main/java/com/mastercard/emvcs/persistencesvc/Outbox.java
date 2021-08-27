package com.mastercard.emvcs.persistencesvc;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="outbox")
public class Outbox {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "topic_name")
    private String topicName;

    @Column(name = "database")
    private String database;

    @Column(name = "schema")
    private String schema;

    @Column(name = "created_timestamp")
    private Date createdTimestamp;

    @Column(name = "content")
    private String content;

    public Outbox() {
    }

    public Outbox(String topicName, String database, String schema, Date createdTimestamp, String content) {
        this.topicName = topicName;
        this.database = database;
        this.schema = schema;
        this.createdTimestamp = createdTimestamp;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topic_name) {
        this.topicName = topic_name;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date created_timestamp) {
        this.createdTimestamp = created_timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Outbox{" +
                "id=" + id +
                ", topic_name='" + topicName + '\'' +
                ", database='" + database + '\'' +
                ", schema='" + schema + '\'' +
                ", created_timestamp=" + createdTimestamp +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Outbox)) return false;
        Outbox outbox = (Outbox) o;
        return getId().equals(outbox.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @PrePersist
    protected void onCreate() {
        createdTimestamp = new Date();
        setId(UUID.randomUUID());
    }

}
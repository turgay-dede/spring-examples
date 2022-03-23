package com.turgaydede.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    private String id;
    private String message;
    private boolean isSeen;
    private Date createdAt;

    public Notification() {
    }

    public Notification(String id, String message, boolean isSeen, Date createdAt) {
        this.id = id;
        this.message = message;
        this.isSeen = isSeen;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", isSeen=" + isSeen +
                ", createdAt=" + createdAt +
                '}';
    }
}

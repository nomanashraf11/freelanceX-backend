package com.freelancex.notificationservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String content;
    private LocalDateTime createdAt;

    public NotificationLog() {}

    public NotificationLog(String userId, String content, LocalDateTime createdAt) {
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "NotificationLog{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
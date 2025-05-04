package com.freelancex.notificationservice.dto;

import java.util.UUID;

public class NotificationRequestDTO {
    private UUID userId;
    private String type;
    private String content;

    public NotificationRequestDTO() {
        // default constructor
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

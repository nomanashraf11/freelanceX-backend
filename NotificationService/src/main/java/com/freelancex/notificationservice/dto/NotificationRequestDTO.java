package com.freelancex.notificationservice.dto;

public class NotificationRequestDTO {
    private String recipientId;
    private String type; // e.g., "JOB_POSTED", "BID_PLACED", etc.
    private String message;
    private String relatedEntityId;

    public NotificationRequestDTO() {}

    public NotificationRequestDTO(String recipientId, String type, String message, String relatedEntityId) {
        this.recipientId = recipientId;
        this.type = type;
        this.message = message;
        this.relatedEntityId = relatedEntityId;
    }

    public String getRecipientId() { return recipientId; }
    public void setRecipientId(String recipientId) { this.recipientId = recipientId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getRelatedEntityId() { return relatedEntityId; }
    public void setRelatedEntityId(String relatedEntityId) { this.relatedEntityId = relatedEntityId; }
}


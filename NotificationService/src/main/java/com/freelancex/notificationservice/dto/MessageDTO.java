package com.freelancex.notificationservice.dto;

public class MessageDTO {

    private String senderId;
    private String receiverId;
    private String message;
    private String sentAt;

    public MessageDTO() {}

    public MessageDTO(String senderId, String receiverId, String message, String sentAt) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.sentAt = sentAt;
    }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getReceiverId() { return receiverId; }
    public void setReceiverId(String receiverId) { this.receiverId = receiverId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getSentAt() { return sentAt; }
    public void setSentAt(String sentAt) { this.sentAt = sentAt; }
    
}

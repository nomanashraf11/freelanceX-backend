package com.freelancex.notificationservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderId;
    private String receiverId;
    private String message;
    private LocalDateTime sentAt;

    public Message() {}

    public Message(String senderId, String receiverId, String message, LocalDateTime sentAt) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.sentAt = sentAt;
    }

    // getters and setters 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSenderId() {
        return senderId;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    public String getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getSentAt() {
        return sentAt;
    }
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", message='" + message + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message1 = (Message) o;

        if (!getId().equals(message1.getId())) return false;
        if (!getSenderId().equals(message1.getSenderId())) return false;
        if (!getReceiverId().equals(message1.getReceiverId())) return false;
        if (!getMessage().equals(message1.getMessage())) return false;
        return getSentAt().equals(message1.getSentAt());
    }
}
package com.freelancex.notificationservice.service;

import com.freelancex.notificationservice.model.Message;
import com.freelancex.notificationservice.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public void sendMessage(String senderId, String receiverId, String message) {
        Message msg = new Message(senderId, receiverId, message, LocalDateTime.now());
        repository.save(msg);
    }

    public List<Message> getMessagesForUser(String userId) {
        return repository.findBySenderIdOrReceiverId(userId, userId);
    }
}
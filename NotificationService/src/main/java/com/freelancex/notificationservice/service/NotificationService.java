package com.freelancex.notificationservice.service;

import com.freelancex.notificationservice.model.NotificationLog;
import com.freelancex.notificationservice.repository.NotificationLogRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationLogRepository repository;

    public NotificationService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    public void sendNotification(String userId, String content) {
        NotificationLog notification = new NotificationLog(userId, content, LocalDateTime.now());
        repository.save(notification);
    }

    public List<NotificationLog> getNotificationsForUser(String userId) {
        return repository.findByUserId(userId);
    }
}

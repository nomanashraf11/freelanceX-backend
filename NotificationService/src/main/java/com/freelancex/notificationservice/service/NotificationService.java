package com.freelancex.notificationservice.service;

import com.freelancex.notificationservice.model.NotificationLog;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    List<NotificationLog> getUserNotifications(UUID userId);
    void processEventNotification(String eventType, UUID userId, String content);
}

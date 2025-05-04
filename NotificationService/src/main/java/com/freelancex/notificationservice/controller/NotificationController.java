package com.freelancex.notificationservice.controller;

import com.freelancex.notificationservice.model.NotificationLog;
import com.freelancex.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/user/{userId}")
    public List<NotificationLog> getUserNotifications(@PathVariable UUID userId) {
        return notificationService.getUserNotifications(userId);
    }
}

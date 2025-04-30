package com.freelancex.notificationservice.controller;

import com.freelancex.notificationservice.model.NotificationLog;
import com.freelancex.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<NotificationLog> getUserNotifications(@PathVariable String userId) {
        return service.getNotificationsForUser(userId);
    }
}
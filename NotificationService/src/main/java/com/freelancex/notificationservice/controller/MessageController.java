package com.freelancex.notificationservice.controller;

import com.freelancex.notificationservice.model.Message;
import com.freelancex.notificationservice.service.MessageService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping()
    public void sendMessage(@RequestParam String senderId,
                            @RequestParam String receiverId,
                            @RequestParam String message) {
        service.sendMessage(senderId, receiverId, message);
    }

    @GetMapping("/{userId}")
    public List<Message> getUserMessages(@PathVariable String userId) {
        return service.getMessagesForUser(userId);
    }
}

package com.freelancex.notificationservice.repository;

import com.freelancex.notificationservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderIdOrReceiverId(String senderId, String receiverId);
}

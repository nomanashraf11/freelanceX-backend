package com.freelancex.notificationservice.repository;

import com.freelancex.notificationservice.model.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    List<NotificationLog> findByUserId(String userId);
}

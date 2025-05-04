package com.freelancex.notificationservice.kafka.interfaces;

import com.freelancex.notificationservice.dto.event.payment.PaymentCompletedEvent;
import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumerService {

    @KafkaListener(
            topics = "${kafka.topics.payment-completed}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    void consumePaymentCompletedEvent(PaymentCompletedEvent event);
}

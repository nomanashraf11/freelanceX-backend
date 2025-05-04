package com.freelancex.notificationservice.kafka;

import com.freelancex.notificationservice.dto.event.payment.PaymentCompletedEvent;
import com.freelancex.notificationservice.kafka.interfaces.KafkaConsumerService;
import com.freelancex.notificationservice.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final NotificationService notificationService;

    public KafkaConsumerServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    @KafkaListener(
            topics = "${kafka.topics.payment-completed}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumePaymentCompletedEvent(PaymentCompletedEvent event) {
        String content = String.format(
            "Payment of $%.2f for contract #%s has been completed successfully.",
            event.getAmount(),
            event.getContractId()
        );
        notificationService.processEventNotification("payment_completed", event.getUserId(), content);
    }
}

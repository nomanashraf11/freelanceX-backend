package com.freelancex.biddingservice.kafka;

import com.freelancex.biddingservice.dtos.event.contract.CreateContractEvent;
import com.freelancex.biddingservice.kafka.interfaces.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topics.contract-created}")
    private String contractCreatedTopic;

    @Value("${kafka.topics.contract-updated}")
    private String contractUpdatedTopic;

    public KafkaProducerServiceImpl(
            @Qualifier("jsonKafkaTemplate") KafkaTemplate<String, Object> jsonKafkaTemplate) {
        this.kafkaTemplate = jsonKafkaTemplate;
    }

    @Override
    public void sendContractCreatedEvent(CreateContractEvent event) {
        sendEvent(contractCreatedTopic, event.contractId().toString(), event);
    }

    @Override
    public void sendContractUpdatedEvent(CreateContractEvent event) {
        sendEvent(contractUpdatedTopic, event.contractId().toString(), event);
    }

    private void sendEvent(String topic, String key, Object event) {
        kafkaTemplate.send(topic, key, event)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        logger.info("Sent {} event with key {}", topic, key);
                    } else {
                        logger.error("Failed to send {} event with key {}: {}", topic, key, ex.getMessage(),
                                ex);
                    }
                });
    }
}
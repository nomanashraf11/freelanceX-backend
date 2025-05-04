package com.freelancex.biddingservice.kafka.interfaces;

import com.freelancex.biddingservice.dtos.event.contract.CreateContractEvent;

public interface KafkaProducerService {
    void sendContractCreatedEvent(CreateContractEvent event);

    void sendContractUpdatedEvent(CreateContractEvent event);
}

package com.freelancex.biddingservice.dtos.event.contract;

import com.freelancex.biddingservice.enums.ContractStatus;

import java.util.UUID;

public record UpdateContractEvent(
        UUID contractId,
        ContractStatus status
) {
}

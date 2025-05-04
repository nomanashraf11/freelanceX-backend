package com.freelancex.biddingservice.dtos.api.bid;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Value
public class CreateBidRequest {

    @NotNull(message = "Job ID is required")
    UUID jobId;

    @NotNull(message = "Freelancer ID is required")
    UUID userId;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    Double amount;

    @NotBlank(message = "Proposal is required")
    @Size(max = 1000, message = "Proposal should not exceed 1000 characters")
    String proposal;
}

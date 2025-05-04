package com.freelancex.biddingservice.dtos.api.bid;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Value
public class UpdateBidRequest {
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    Double amount;

    @NotBlank(message = "Proposal is required")
    @Max(value = 500, message = "Proposal should not exceeds 500 characters")
    String proposal;
}

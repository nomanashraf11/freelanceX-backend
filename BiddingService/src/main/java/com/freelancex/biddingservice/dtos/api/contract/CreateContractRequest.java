package com.freelancex.biddingservice.dtos.api.contract;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Value
public class CreateContractRequest {

    @NotNull(message = "Bid ID is required")
    UUID bidId;

    @NotBlank(message = "Terms is required")
    @Size(max = 500, message = "Terms should not exceed 500 characters")
    String terms;
}

package com.freelancex.biddingservice.dtos.api.contract;

import com.freelancex.biddingservice.enums.ContractStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Value
public class UpdateContractRequest {
    @NotBlank(message = "Terms is required")
    @Size(max = 500, message = "Terms should not exceed 500 characters")
    String terms;

    @NotBlank(message = "Contract status is required")
    ContractStatus status;
}

package com.freelancex.biddingservice.dtos.event.job;

import com.freelancex.biddingservice.enums.JobStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateJobEvent(
        @NotNull UUID jobId, @NotNull UUID userId, @NotNull JobStatus status,
        @NotNull @Positive Double budget,
        @NotBlank @Size(max = 255) String title) {
}

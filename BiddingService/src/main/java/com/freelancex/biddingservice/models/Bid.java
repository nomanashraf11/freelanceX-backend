package com.freelancex.biddingservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "bids", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "job_id"}),
        indexes = {
                @Index(name = "idx_user_id", columnList = "user_id"),
                @Index(name = "idx_job_id", columnList = "job_id")
        })
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bid_id", updatable = false, nullable = false)
    private UUID bidId;

    @Setter
    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Setter
    @Column(name = "job_id", nullable = false)
    private UUID jobId;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)
    private Job job;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToOne(mappedBy = "bid", orphanRemoval = true, cascade = CascadeType.ALL)
    private Contract contract;

    @Setter
    @Column(nullable = false)
    private Double amount;

    @Setter
    @Column(nullable = false, length = 1000)
    private String proposal;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime updatedAt;
}
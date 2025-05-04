package com.freelancex.biddingservice.models;

import com.freelancex.biddingservice.enums.ContractStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "contracts")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "contract_id", updatable = false, nullable = false)
    private UUID contractId;

    @Setter
    @Column(name = "bid_id", nullable = false)
    private UUID bidId;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid_id", referencedColumnName = "bid_id", unique = true, insertable = false, updatable = false)
    private Bid bid;

    @Setter
    @Column(nullable = false, length = 500)
    private String terms;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractStatus status = ContractStatus.ACTIVE;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime updatedAt;
}
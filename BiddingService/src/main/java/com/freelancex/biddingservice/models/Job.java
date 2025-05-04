package com.freelancex.biddingservice.models;

import com.freelancex.biddingservice.enums.JobStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class Job {

    @Id
    @Column(name = "job_id", nullable = false, updatable = false)
    private UUID jobId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private JobStatus status;

    @Column(nullable = false)
    private Double budget;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Bid> bid;
}
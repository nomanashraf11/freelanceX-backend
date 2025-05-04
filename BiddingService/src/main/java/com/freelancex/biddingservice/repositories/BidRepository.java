package com.freelancex.biddingservice.repositories;

import com.freelancex.biddingservice.models.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BidRepository extends JpaRepository<Bid, UUID> {
    List<Bid> findBidsByJobIdAndJobUserId(UUID jobId, UUID jobUserId);

    List<Bid> findBidsByUserId(UUID userId);

    Optional<Bid> findBidByBidIdAndUserId(UUID bidId, UUID userId);
}

package com.freelancex.biddingservice.controllers;

import com.freelancex.biddingservice.dtos.api.bid.*;
import com.freelancex.biddingservice.services.interfaces.BidService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/bid")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping("/job/{jobId}/user/{userId}")
    public ResponseEntity<GetBidsResponse> getBidByJobId(@PathVariable UUID jobId,
                                                         @PathVariable UUID userId) {
        GetBidsResponse response = this.bidService.getBidsByJobId(jobId, userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<GetBidsResponse> getBidsByUserId(@PathVariable UUID userId) {
        GetBidsResponse response = this.bidService.getBidsByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{bidId}/user/{userId}")
    public ResponseEntity<GetBidResponse> getBidByUserId(@PathVariable UUID bidId,
                                                         @PathVariable UUID userId) {
        GetBidResponse response = this.bidService.getBidByUserId(bidId, userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<CreateBidResponse> createBid(@RequestBody @Valid CreateBidRequest request) {
        CreateBidResponse response = this.bidService.createBid(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{bidId}/user/{userId}")
    public ResponseEntity<UpdateBidResponse> updateBidByUserId(@PathVariable UUID bidId,
                                                               @PathVariable UUID userId,
                                                               @RequestBody @Valid UpdateBidRequest request) {
        UpdateBidResponse response = this.bidService.updateBidByUserId(bidId, userId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{bidId}/user/{userId}")
    public ResponseEntity<DeleteBidResponse> deleteBidByUserId(@PathVariable UUID bidId,
                                                               @PathVariable UUID userId) {
        DeleteBidResponse response = this.bidService.deleteBidByUserId(bidId, userId);
        return ResponseEntity.ok(response);
    }
}

package com.freelancex.biddingservice.services;

import com.freelancex.biddingservice.dtos.api.bid.*;
import com.freelancex.biddingservice.exceptions.ApiException;
import com.freelancex.biddingservice.models.Bid;
import com.freelancex.biddingservice.repositories.BidRepository;
import com.freelancex.biddingservice.services.interfaces.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BidServiceImpl implements BidService {
    private final BidRepository bidRepository;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }


    @Override
    public GetBidsResponse getBidsByJobId(UUID jobId, UUID userId) throws ApiException {
        List<Bid> bids = this.bidRepository.findBidsByJobIdAndJobUserId(jobId, userId);

        GetBidsResponse response = new GetBidsResponse(bids);
        response.setMessage("success");
        response.setStatusCode(HttpStatus.OK.value());
        return response;
    }

    @Override
    public CreateBidResponse createBid(CreateBidRequest request) {
        Bid bid = new Bid();
        bid.setUserId(request.getUserId());
        bid.setJobId(request.getJobId());
        bid.setAmount(request.getAmount());
        bid.setProposal(request.getProposal());
        bidRepository.save(bid);

        CreateBidResponse response = new CreateBidResponse();
        response.setMessage("success");
        response.setStatusCode(HttpStatus.CREATED.value());
        return response;
    }

    @Override
    public GetBidResponse getBidByUserId(UUID bidId, UUID userId) throws ApiException {
        Optional<Bid> bid = bidRepository.findBidByBidIdAndUserId(bidId, userId);

        if (bid.isEmpty()) {
            throw new ApiException("Bid not found", HttpStatus.NOT_FOUND);
        }

        GetBidResponse response = new GetBidResponse(bid.get());
        response.setMessage("success");
        response.setStatusCode(HttpStatus.OK.value());
        return response;
    }

    @Override
    public GetBidsResponse getBidsByUserId(UUID userId) {
        List<Bid> bids = this.bidRepository.findBidsByUserId(userId);

        GetBidsResponse response = new GetBidsResponse(bids);
        response.setMessage("success");
        response.setStatusCode(HttpStatus.OK.value());
        return response;
    }

    @Override
    public UpdateBidResponse updateBidByUserId(UUID bidId, UUID userId,
                                               UpdateBidRequest request) throws ApiException {
        Optional<Bid> bid = bidRepository.findBidByBidIdAndUserId(bidId, userId);

        if (bid.isEmpty()) {
            throw new ApiException("Bid not found", HttpStatus.NOT_FOUND);
        }

        Bid bidToUpdate = bid.get();
        bidToUpdate.setAmount(request.getAmount());
        bidToUpdate.setProposal(request.getProposal());
        bidRepository.save(bidToUpdate);

        UpdateBidResponse response = new UpdateBidResponse();
        response.setMessage("success");
        response.setStatusCode(HttpStatus.OK.value());
        return response;
    }

    @Override
    public DeleteBidResponse deleteBidByUserId(UUID bidId, UUID userId) throws ApiException {
        Optional<Bid> bid = bidRepository.findBidByBidIdAndUserId(bidId, userId);

        if (bid.isEmpty()) {
            throw new ApiException("Bid not found", HttpStatus.NOT_FOUND);
        }

        bidRepository.delete(bid.get());
        DeleteBidResponse response = new DeleteBidResponse();
        response.setMessage("success");
        response.setStatusCode(HttpStatus.OK.value());
        return response;
    }
}

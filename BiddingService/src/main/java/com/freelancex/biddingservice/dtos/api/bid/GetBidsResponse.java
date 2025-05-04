package com.freelancex.biddingservice.dtos.api.bid;

import com.freelancex.biddingservice.dtos.common.Response;
import com.freelancex.biddingservice.models.Bid;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetBidsResponse extends Response {
    private List<Bid> bids;
}

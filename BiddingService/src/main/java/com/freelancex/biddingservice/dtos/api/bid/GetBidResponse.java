package com.freelancex.biddingservice.dtos.api.bid;

import com.freelancex.biddingservice.dtos.common.Response;
import com.freelancex.biddingservice.models.Bid;
import lombok.*;

@AllArgsConstructor
public class GetBidResponse extends Response {
    private Bid data;
}

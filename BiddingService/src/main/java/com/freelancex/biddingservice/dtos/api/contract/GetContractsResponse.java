package com.freelancex.biddingservice.dtos.api.contract;

import com.freelancex.biddingservice.dtos.common.Response;
import com.freelancex.biddingservice.models.Contract;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetContractsResponse extends Response {
    private List<Contract> bids;
}

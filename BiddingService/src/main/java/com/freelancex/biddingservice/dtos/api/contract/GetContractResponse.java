package com.freelancex.biddingservice.dtos.api.contract;

import com.freelancex.biddingservice.dtos.common.Response;
import com.freelancex.biddingservice.models.Contract;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetContractResponse extends Response {
    private Contract data;
}

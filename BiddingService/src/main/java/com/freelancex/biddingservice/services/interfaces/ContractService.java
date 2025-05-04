package com.freelancex.biddingservice.services.interfaces;

import com.freelancex.biddingservice.dtos.api.contract.*;
import com.freelancex.biddingservice.exceptions.ApiException;

import java.util.UUID;

public interface ContractService {
    GetContractsResponse getAllContracts() throws ApiException;

    GetContractResponse getContractById(UUID id) throws ApiException;

    CreateContractResponse createContract(CreateContractRequest request);

    UpdateContractResponse updateContract(UUID id, UpdateContractRequest request) throws ApiException;
}

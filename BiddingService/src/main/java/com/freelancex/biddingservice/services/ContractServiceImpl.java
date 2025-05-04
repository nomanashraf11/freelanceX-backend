package com.freelancex.biddingservice.services;

import com.freelancex.biddingservice.dtos.api.contract.*;
import com.freelancex.biddingservice.exceptions.ApiException;
import com.freelancex.biddingservice.models.Bid;
import com.freelancex.biddingservice.models.Contract;
import com.freelancex.biddingservice.repositories.ContractRepository;
import com.freelancex.biddingservice.services.interfaces.ContractService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final EntityManager entityManager;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, EntityManager entityManager) {
        this.contractRepository = contractRepository;
        this.entityManager = entityManager;
    }


    @Override
    public GetContractsResponse getAllContracts() throws ApiException {
        List<Contract> contracts = contractRepository.findAll();

        GetContractsResponse response = new GetContractsResponse(contracts);
        response.setMessage("success");
        response.setStatusCode(200);

        return response;
    }

    @Override
    public GetContractResponse getContractById(UUID id) throws ApiException {
        Optional<Contract> contract = contractRepository.findById(id);

        if (contract.isEmpty()) {
            throw new ApiException(String.format("Contract:%s not found", id), HttpStatus.NOT_FOUND);
        }

        GetContractResponse response = new GetContractResponse(contract.get());
        response.setMessage("success");
        response.setStatusCode(200);

        return response;
    }

    @Override
    public CreateContractResponse createContract(CreateContractRequest request) {
        Contract contract = new Contract();

        contract.setTerms(request.getTerms());
        contract.setBid(entityManager.getReference(Bid.class, request.getBidId()));

        contractRepository.save(contract);

        CreateContractResponse response = new CreateContractResponse();
        response.setMessage("success");
        response.setStatusCode(201);

        return response;
    }

    @Override
    public UpdateContractResponse updateContract(UUID id, UpdateContractRequest request) throws ApiException {
        Optional<Contract> contract = contractRepository.findById(id);

        if (contract.isEmpty()) {
            throw new ApiException(String.format("Contract:%s not found", id), HttpStatus.NOT_FOUND);
        }

        Contract contractToUpdate = contract.get();
        contractToUpdate.setTerms(request.getTerms());
        contractToUpdate.setStatus(request.getStatus());

        contractRepository.save(contractToUpdate);

        UpdateContractResponse response = new UpdateContractResponse();
        response.setMessage("success");
        response.setStatusCode(200);

        return response;
    }
}

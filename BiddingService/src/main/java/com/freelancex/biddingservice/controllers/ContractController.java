package com.freelancex.biddingservice.controllers;

import com.freelancex.biddingservice.dtos.api.contract.*;
import com.freelancex.biddingservice.services.interfaces.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/api/contract")
public class ContractController {
    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping()
    public ResponseEntity<GetContractsResponse> getContract() {
        GetContractsResponse response = this.contractService.getAllContracts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetContractResponse> getContractById(@PathVariable UUID id) {
        GetContractResponse response = this.contractService.getContractById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<CreateContractResponse> createContract(@RequestBody @Valid CreateContractRequest request) {
        CreateContractResponse response = this.contractService.createContract(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateContractResponse> updateContract(@PathVariable UUID id, @RequestBody @Valid UpdateContractRequest request) {
        UpdateContractResponse response = this.contractService.updateContract(id, request);
        return ResponseEntity.ok(response);
    }
}

package com.freelancex.biddingservice.repositories;

import com.freelancex.biddingservice.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {
}
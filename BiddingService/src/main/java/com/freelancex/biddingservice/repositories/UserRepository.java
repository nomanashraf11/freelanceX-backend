package com.freelancex.biddingservice.repositories;

import com.freelancex.biddingservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

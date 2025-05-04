package com.freelancex.userservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.freelancex.userservice.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Getter
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;

    @Setter
    @Column(nullable = false, unique = true)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role = UserRole.FREELANCER;

    @Setter
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Setter
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Setter
    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;
}

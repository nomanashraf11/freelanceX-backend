package com.freelancex.userservice.dtos.common;

import com.freelancex.userservice.enums.UserRole;

public record JwtBody(String email, String role) {
}

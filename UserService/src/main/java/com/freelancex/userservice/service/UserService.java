package com.freelancex.userservice.service;

import com.freelancex.userservice.dtos.api.CreateUserRequest;
import com.freelancex.userservice.dtos.api.LoginRequest;
import com.freelancex.userservice.enums.UserRole;
import com.freelancex.userservice.jwt.interfaces.JwtService;
import com.freelancex.userservice.model.Profile;
import com.freelancex.userservice.model.User;
import com.freelancex.userservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest request) {
        User user = getUserByEmail(request.getEmail());

        boolean doesPasswordMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!doesPasswordMatch) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }

        return jwtService.generateToken(user.getEmail(), user.getRole().name());
    }

    public User createUser(CreateUserRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.email());

        if (optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setEmail(request.email());
        user.setRole(UserRole.valueOf(request.role()));

        Profile profile = new Profile();
        profile.setUser(user);
        profile.setFirstName(request.firstName());
        profile.setLastName(request.lastName());
        profile.setBio(request.bio());
        user.setProfile(profile);

        return userRepository.save(user);
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByRole(UserRole role) {
        return userRepository.findByRole(role);
    }
}

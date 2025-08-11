package com.example.secureapi.auth;

import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that exposes authentication endpoints.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * Simple login endpoint that issues an access token if the provided
     * credentials match the expected values. This method does not perform
     * any real password hashing or database lookups—it is purely for
     * demonstration. Replace this logic with your own user service.
     *
     * @param loginRequest the submitted username and password
     * @return a map containing the issued access token and expiry
     */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> login(@RequestBody LoginRequest loginRequest) {
        // In a real application verify the username/password against your user repository
        String username = loginRequest.username();
        String password = loginRequest.password();
        // Very basic check: accept any non-empty username/password for demo
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        // Determine roles: hard-code admin vs user for demonstration
        List<String> roles = username.equals("admin")
                ? List.of("ROLE_ADMIN", "ROLE_USER")
                : List.of("ROLE_USER");
        long ttlSeconds = 900; // 15 minutes
        String token = jwtUtil.generateAccessToken(username, roles, ttlSeconds);
        return Map.of(
                "access_token", token,
                "token_type", "Bearer",
                "expires_in", String.valueOf(ttlSeconds)
        );
    }
}
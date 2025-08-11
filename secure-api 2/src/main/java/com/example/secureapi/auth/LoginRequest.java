package com.example.secureapi.auth;

/**
 * Simple DTO to capture login requests. In a real application you
 * would likely validate these fields and perhaps use a more
 * sophisticated mechanism for credential storage and verification.
 *
 * @param username the username of the user
 * @param password the plain text password (for demo purposes only)
 */
public record LoginRequest(String username, String password) {
}
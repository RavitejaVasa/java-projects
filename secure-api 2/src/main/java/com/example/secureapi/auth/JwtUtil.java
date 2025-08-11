package com.example.secureapi.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Utility class for generating and validating JSON Web Tokens (JWTs).
 *
 * In this simple example we generate a new RSA key pair on startup.
 * In a production environment you would load keys from a keystore or
 * environment variables and rotate them periodically.
 */
@Component
public class JwtUtil {

    private final KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

    private static final String ISSUER = "secure-api";
    private static final String AUDIENCE = "secure-api-clients";

    /**
     * Generate a signed access token for the given user and roles.
     *
     * @param subject the unique identifier of the user (e.g. username)
     * @param roles the roles associated with the user
     * @param ttlSeconds time-to-live of the token in seconds
     * @return a compact JWT string
     */
    public String generateAccessToken(String subject, List<String> roles, long ttlSeconds) {
        Instant now = Instant.now();
        PrivateKey privateKey = keyPair.getPrivate();
        return Jwts.builder()
                .setSubject(subject)
                .setIssuer(ISSUER)
                .setAudience(AUDIENCE)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(ttlSeconds)))
                .claim("roles", roles)
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    /**
     * Parse and validate the given token. If valid, returns the parsed JWT.
     *
     * @param token the JWT as received from the client
     * @return the parsed claims
     */
    public Jws<Claims> parseAndValidate(String token) {
        PublicKey publicKey = keyPair.getPublic();
        return Jwts.parserBuilder()
                .requireIssuer(ISSUER)
                .requireAudience(AUDIENCE)
                .setAllowedClockSkewSeconds(30)
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token);
    }
}
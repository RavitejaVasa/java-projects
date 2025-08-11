package com.example.secureapi.api;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example controller that exposes endpoints requiring authentication and
 * authorization. You can adapt this to your domain model and business logic.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    /**
     * List all products. Accessible to users with either ROLE_USER or ROLE_ADMIN.
     *
     * @return a static list of product names
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<String> list() {
        return List.of("Product A", "Product B", "Product C");
    }

    /**
     * Create a new product. Only users with ROLE_ADMIN may access this endpoint.
     *
     * @param body the name of the new product
     * @return a simple message
     */
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String create(@RequestBody String body) {
        return "Created product: " + body;
    }
}
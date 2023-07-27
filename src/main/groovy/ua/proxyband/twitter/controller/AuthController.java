package ua.proxyband.twitter.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping("/secure")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String secureEndpoint() {
        return "Hello, authenticated user!";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Hello, public user!";
    }
}


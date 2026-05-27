package com.company.employeemgmt.controller;

import com.company.employeemgmt.dto.LoginRequest;
import com.company.employeemgmt.dto.LoginResponse;
import com.company.employeemgmt.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        if ("employee1".equals(request.username()) && "password123".equals(request.password())) {
            String token = jwtService.generateToken(request.username());
            long expiresIn = jwtService.getExpirationTimeMs();
            return ResponseEntity.ok(new LoginResponse(token, "Bearer", expiresIn));
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
}

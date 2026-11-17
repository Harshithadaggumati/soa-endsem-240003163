package com.klef.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.banking.dto.JwtRequest;
import com.klef.banking.dto.JwtResponse;
import com.klef.banking.service.AuthService;

@RestController
@RequestMapping("/api/jwt")
public class JwtController
{
    @Autowired
    private AuthService service;

    @PostMapping("/generate")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest request)
    {
        String token = service.generateToken(
                request.getUsername(),
                request.getPassword()
        );

        if(token.equals("Invalid username or password"))
        {
            return ResponseEntity.status(401).body(token);
        }

        return ResponseEntity.ok(new JwtResponse(token));
    }
}

package com.klef.banking.service;

public interface AuthService
{
    String generateToken(String username, String password);
}

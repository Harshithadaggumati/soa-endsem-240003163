
package com.klef.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.banking.security.JwtUtil;
import com.klef.banking.entity.User;
import com.klef.banking.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService
{
    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String generateToken(String username, String password)
    {
        User user = repo.findByUsername(username).orElse(null);

        if(user != null && user.getPassword().equals(password))
        {
            return jwtUtil.generateToken(username);
        }
        else
        {
            return "Invalid username or password";
        }
    }
}

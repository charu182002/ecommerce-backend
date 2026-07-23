package com.ecommerce.ecart.controller;

import com.ecommerce.ecart.entity.AuthEntity;
import com.ecommerce.ecart.repository.AuthRepository;
import com.ecommerce.ecart.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    // Register
    @PostMapping("/register")
    public String register(@RequestBody AuthEntity user) {
        user.setPassword(
            passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");
        }
        authRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthEntity user) {

        var dbUser = authRepository.findByUsername(user.getUsername())
                .orElse(null);

        if (dbUser == null) {
            return "User not found!";
        }

        if (passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            return jwtUtil.generateToken(
                    dbUser.getUsername(),
                    dbUser.getRole()
            );
        } else {
            return "Invalid password!";
        }
    }
}

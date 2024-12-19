package com.example.QuizApp.controller;


import com.example.QuizApp.entity.User;
import com.example.QuizApp.repo.UserRepository;
import com.example.QuizApp.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }

        // Encrypt the password (using BCrypt for security)
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginRequest , HttpSession session) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        boolean isPresent = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (user.isPresent()){
            session.setAttribute("loggedIn", true);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Destroy session
        return ResponseEntity.ok("Logged out successfully");
    }

    @GetMapping("/check-login")
    public ResponseEntity<Boolean> checkLogin(HttpSession session) {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        return ResponseEntity.ok(isLoggedIn != null && isLoggedIn);
    }
}

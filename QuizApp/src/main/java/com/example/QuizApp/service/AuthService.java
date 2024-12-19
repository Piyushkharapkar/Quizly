package com.example.QuizApp.service;

import com.example.QuizApp.entity.User;
import com.example.QuizApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository; // Ensure you have a UserRepository

    public boolean authenticate(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        // Check if user exists, then validate the password
        if (user.isPresent()) {
            return user.get().getPassword().equals(password); // Hashing recommended
        }
        return false; // User does not exist
    }
}

package com.example.QuizApp.controller;

import com.example.QuizApp.entity.QuizQuestions;
import com.example.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http:/localhost:8080")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    QuestionService questionService;

    private String USERNAME;
    private String PASSWORD;

    @GetMapping("/questions")
    public List<QuizQuestions> getQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public QuizQuestions saveQuestion(@RequestBody QuizQuestions question) {
        return questionService.saveQuestion(question);
    }


    @PutMapping("/questions/{id}")
    public QuizQuestions updateQuestion(@PathVariable Long id, @RequestBody QuizQuestions updatedQuestion) {
        QuizQuestions question = questionService.updateQuestion(id, updatedQuestion);
        if (question != null) {
            return question;  // Return the updated question
        } else {
            throw new RuntimeException("Question not found with id " + id);  // Handle not found case
        }
    }

}

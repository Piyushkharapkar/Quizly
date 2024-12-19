package com.example.QuizApp.service;

import com.example.QuizApp.entity.QuizQuestions;
import com.example.QuizApp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public List<QuizQuestions> getAllQuestions() {
        return questionRepo.findAll();
    }

    public QuizQuestions saveQuestion(QuizQuestions question) {
        return questionRepo.save(question);
    }

    // Method to update a question
    public QuizQuestions updateQuestion(Long id, QuizQuestions updatedQuestion) {
        Optional<QuizQuestions> existingQuestionOpt = questionRepo.findById(id);

        if (existingQuestionOpt.isPresent()) {
            QuizQuestions existingQuestion = existingQuestionOpt.get();
            // Update the fields as needed
            existingQuestion.setQuestionText(updatedQuestion.getQuestionText());
            existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
            existingQuestion.setOptions(updatedQuestion.getOptions());
            return questionRepo.save(existingQuestion);  // Save the updated question
        } else {
            return null;  // If the question with the given ID doesn't exist
        }
    }
}

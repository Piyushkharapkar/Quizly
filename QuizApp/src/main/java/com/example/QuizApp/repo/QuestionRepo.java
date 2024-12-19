package com.example.QuizApp.repo;

import com.example.QuizApp.entity.QuizQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuizQuestions , Long> {

}

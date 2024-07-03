package com.fix.quiz_service.Model;

import lombok.Data;

@Data
public class QuizDetails {
    private String category;
    private int numQuestions;
    private String title;
}

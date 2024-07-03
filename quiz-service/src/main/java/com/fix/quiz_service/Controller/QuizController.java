package com.fix.quiz_service.Controller;


import com.fix.quiz_service.Model.QuestionWrapper;
import com.fix.quiz_service.Model.QuizDetails;
import com.fix.quiz_service.Model.Response;
import com.fix.quiz_service.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDetails quizDetails){
        return quizService.createQuiz(quizDetails.getCategory(), quizDetails.getNumQuestions(), quizDetails.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> responses){
        return quizService.calcucateResult(responses);
    }

}

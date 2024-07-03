package com.fix.question_service.Controller;


import com.fix.question_service.Model.Question;
import com.fix.question_service.Model.QuestionWrapper;
import com.fix.question_service.Model.Response;
import com.fix.question_service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id){
        return questionService.getQuestionById(id);
    }

    @PostMapping("addquestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions){
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> id){
        return questionService.getQuestionsFromId(id);
    }

    @PostMapping("getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}

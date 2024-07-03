package com.fix.quiz_service.Feign;

import com.fix.quiz_service.Model.QuestionWrapper;
import com.fix.quiz_service.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions);

    @PostMapping("question/getquestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> id);

    @PostMapping("question/getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}

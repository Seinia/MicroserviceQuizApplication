package com.fix.quiz_service.Service;


import com.fix.quiz_service.Dao.QuizDao;
import com.fix.quiz_service.Feign.QuizInterface;
import com.fix.quiz_service.Model.QuestionWrapper;
import com.fix.quiz_service.Model.Quiz;
import com.fix.quiz_service.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizInterface quizInterface;



    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questionsForUser = quizInterface.getQuestionsFromId(questionIds);

        return questionsForUser;
    }

    public ResponseEntity<Integer> calcucateResult(List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);

        return score;
    }
}

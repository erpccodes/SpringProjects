package springboot.questionService.controller;

import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.questionService.dto.AnswerRequestDTO;
import springboot.questionService.dto.NextQuestionResponseDTO;
import springboot.questionService.dto.QuestionDTO;
import springboot.questionService.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/play")
    public ResponseEntity<QuestionDTO> play() {
        // Generate a random question ID
        Long questionId = getRandomQuestionId();
        QuestionDTO questionDTO = questionService.getQuestionById(questionId);
        if (questionDTO != null) {
            return ResponseEntity.ok(questionDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    private Long getRandomQuestionId() {
        List<QuestionDTO> allQuestions = questionService.getAllQuestions(); // Assuming you have a method to retrieve all questions
        int totalQuestions = allQuestions.size();

        if (totalQuestions > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(totalQuestions);
            QuestionDTO randomQuestion = allQuestions.get(randomIndex);
            return randomQuestion.getQuestionId();
        }

        return null; // Handle the case when no questions are available
    }

    @PostMapping("/next")
    public ResponseEntity<NextQuestionResponseDTO> next(@RequestBody AnswerRequestDTO answerRequest) {
        NextQuestionResponseDTO responseDTO = questionService.checkAnswerAndGetNextQuestion(answerRequest.getQuestionId(), answerRequest.getAnswer());
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

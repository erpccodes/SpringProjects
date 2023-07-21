package springboot.questionService.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import springboot.questionService.dto.NextQuestionResponseDTO;
import springboot.questionService.dto.QuestionDTO;
import springboot.questionService.entity.Question;
import springboot.questionService.repository.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final RestTemplate restTemplate;

    public QuestionService(QuestionRepository questionRepository, RestTemplate restTemplate) {
        this.questionRepository = questionRepository;
        this.restTemplate = restTemplate;
    }

    public List<Question> fetchRandomQuestions(int count) {
        String url = "https://jservice.io/api/random?count=" + count;
        ResponseEntity<QuestionDTO[]> response = restTemplate.getForEntity(url, QuestionDTO[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            QuestionDTO[] questionDTOs = response.getBody();
            List<Question> questions = Arrays.stream(questionDTOs)
                    .map(questionDTO -> new Question(questionDTO.getQuestionId(), questionDTO.getQuestion(), ""))
                    .collect(Collectors.toList());
            return questionRepository.saveAll(questions);
        }
        return Collections.emptyList();
    }
    
    public void fetchAndSaveQuestions(int count) {
        String url = "https://jservice.io/api/random?count=" + count;
        ResponseEntity<QuestionDTO[]> response = restTemplate.getForEntity(url, QuestionDTO[].class);
        if (response.getStatusCode() == HttpStatus.OK) {
            QuestionDTO[] questionDTOs = response.getBody();
            List<Question> questions = Arrays.stream(questionDTOs)
                    .map(questionDTO -> new Question(questionDTO.getQuestionId(), questionDTO.getQuestion(), ""))
                    .collect(Collectors.toList());
            questionRepository.saveAll(questions);
        }
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
                .map(question -> new QuestionDTO(question.getId(), question.getQuestion()))
                .collect(Collectors.toList());
    }
    
    public QuestionDTO getQuestionById(Long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            return new QuestionDTO(question.getId(), question.getQuestion());
        }
        return null;
    }

    public NextQuestionResponseDTO checkAnswerAndGetNextQuestion(Long id, String answer) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            String correctAnswer = question.getAnswer();
            Question nextQuestion = questionRepository.findFirstQuestionByIdAsc();
            return new NextQuestionResponseDTO(correctAnswer, new QuestionDTO(nextQuestion.getId(), nextQuestion.getQuestion()));
        }
        return null;
    }
}

package springboot.questionService;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import springboot.questionService.service.QuestionService;

@SpringBootApplication()
@EnableJpaRepositories("springboot.questionService.repository")
public class QuestionsApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuestionsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    
    @Bean
    public ApplicationRunner initializeData(QuestionService questionService) {
        return args -> {
            int count = 10; // Set the desired number of questions
            questionService.fetchAndSaveQuestions(count);
        };
    }
}

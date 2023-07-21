package springboot.questionService.dto;

public class QuestionDTO {
    private Long questionId;
    private String question;
    
    public Long getQuestionId() {
        return questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public QuestionDTO(Long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }
}

package springboot.questionService.dto;

public class AnswerRequestDTO {
    private Long questionId;
    private String answer;
    
    public Long getQuestionId() {
        return questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    public String getAnswer() {
        return answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public AnswerRequestDTO(Long questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }
}

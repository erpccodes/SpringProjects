package springboot.questionService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springboot.questionService.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	 @Query(value = "SELECT * FROM Question ORDER BY id ASC LIMIT 1", nativeQuery = true)
	    Question findFirstQuestionByIdAsc();
}
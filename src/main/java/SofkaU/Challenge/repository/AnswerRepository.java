package SofkaU.Challenge.repository;

import SofkaU.Challenge.entity.Answer;
import SofkaU.Challenge.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    public List<Answer> findByQuestion(Question question);
}

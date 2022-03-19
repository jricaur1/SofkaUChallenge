package SofkaU.Challenge.repository;

import SofkaU.Challenge.entity.Category;
import SofkaU.Challenge.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    public List<Question> findByCategory(Category category);
}

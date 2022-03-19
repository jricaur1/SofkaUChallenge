package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Category;
import SofkaU.Challenge.entity.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> listAllQuestion();
    public Question getQuestion(Long id);

    public Question createQuestion(Question question);
    public Question updateQuestion(Question question);
    public void deleteQuestion(Long id);

    public List<Question> findByCategory(Category category);
}

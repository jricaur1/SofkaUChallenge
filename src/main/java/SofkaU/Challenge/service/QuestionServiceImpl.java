package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Category;
import SofkaU.Challenge.entity.Question;
import SofkaU.Challenge.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements  QuestionService{

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> listAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Question questionDB = questionRepository.findById(question.getQuestion_id()).orElse(null);
        if (questionDB==null){
            return null;
        }
        questionDB.setContent(question.getContent());
        return questionRepository.save(questionDB);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question questionDB = questionRepository.findById(id).orElse(null);
        if (questionDB != null){
            questionRepository.delete(questionDB);
        }
    }

    @Override
    public List<Question> findByCategory(Category category) {
        return questionRepository.findByCategory(category);
    }
}

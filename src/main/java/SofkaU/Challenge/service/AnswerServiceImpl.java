package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Answer;
import SofkaU.Challenge.entity.Question;
import SofkaU.Challenge.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements  AnswerService{

    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> findByQuestion(Question question) {
        return answerRepository.findByQuestion(question);
    }

    @Override
    public Answer getAnswer(Long id) {
        return answerRepository.getById(id);
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        Answer answerDB = answerRepository.findById(answer.getAnswer_id()).orElse(null);
        if (answerDB ==null){
            return null;
        }
        answerDB.setContent(answer.getContent());
        answerDB.setQuestion(answer.getQuestion());
        answerDB.setRight(answer.isRight());
        return answerRepository.save(answerDB);
    }
}

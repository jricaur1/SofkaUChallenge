package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Answer;
import SofkaU.Challenge.entity.Question;

import java.util.List;

public interface AnswerService {
    public Answer getAnswer(Long id);

    public Answer createAnswer(Answer answer);
    public Answer updateAnswer(Answer answer);
    public List<Answer> findByQuestion(Question question);
}

package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.Answer;
import SofkaU.Challenge.entity.Category;
import SofkaU.Challenge.entity.Question;
import SofkaU.Challenge.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private  final AnswerController answerController;
    public boolean createQuestions(int nQuestions, Category category){
        try {
            Scanner scan = new Scanner(System.in);
            for (int i = 0; i < nQuestions; i++) {
                System.out.println("Ingrese la pregunta para la categoría " + category.getMultiplier());
                String quesContent = "";
                quesContent = scan.nextLine();
                if(quesContent.equals("")){
                    throw new Exception("No ha ingresado una pregunta");
                }
                Question question = Question.builder()
                        .content(quesContent)
                        .category(category)
                        .build();
                questionService.createQuestion(question);
                if(!answerController.createAnswers(question)){
                    questionService.deleteQuestion(question.getQuestion_id());
                    throw new Exception("Error al crear las respuestas");
                }

            }
            return true;
        } catch(Exception ex){
            System.err.println(ex);
            return  false;
        }
    }

    public List<Question> getQuestions(Category category){
        return  questionService.findByCategory(category);
    }

    public boolean answerQuestion(Question question){
        Scanner scan = new Scanner(System.in);
        System.out.println("Pregunta de categoría "+ question.getCategory().getMultiplier()+": "+question.getContent());

        List<Answer> answers = answerController.showAnswersByQuestion(question);
        for (Answer answer : answers) {
            System.out.println(answer.getContent());
        }
        System.out.println("Escriba el número de la respuesta.");
        String playerAnswer = scan.nextLine();
        for (Answer answer : answers) {
            if (playerAnswer.charAt(0) == answer.getContent().charAt(0)) {
                if(answer.isRight()){
                    return true;
                }
            }
        }
        return false;
    }
}

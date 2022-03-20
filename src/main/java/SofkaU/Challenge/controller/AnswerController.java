package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.Answer;
import SofkaU.Challenge.entity.Question;
import SofkaU.Challenge.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    public boolean  createAnswers(Question question){
        try {
            List<Answer> answers = new ArrayList<>();
            Scanner scan = new Scanner(System.in);
            int isCorrect = 0;
            for (int j = 0; j < 4; j++) {
                System.out.println("Ingrese una opción de respuesta "+ (j+1) +" de 4");
                String ansContent = (j+1) + " " +scan.nextLine();
                System.out.println("¿Es la respuesta correcta? [1] Si, [2] No");
                String bool =  scan.nextLine();

                if (bool.equals("1")) {
                    Answer answer = Answer.builder()
                            .isRight(true)
                            .content(ansContent)
                            .question(question)
                            .build();
                    isCorrect++;
                    answers.add(answer);
                } else if (bool.equals("2")) {
                    Answer answer = Answer.builder()
                            .isRight(false)
                            .content(ansContent)
                            .question(question)
                            .build();
                    answers.add(answer);
                } else {
                    throw new Exception("Número ingresado no está en las opciones.");
                }
            }
            if (isCorrect == 0) {
                throw new Exception("No ha ingresado respuesta correcta.");
            }else if (isCorrect > 1) {
                throw new Exception("No puede tener más de una respuesta correcta.");
            }else{
                for(Answer answer: answers){
                    answerService.createAnswer(answer);
                }
                return true;
            }
        }catch(Exception ex){
            System.err.println(ex);
            return false;
        }
    }

    public List<Answer> showAnswersByQuestion(Question question) {
        try {
            List<Answer> answers = answerService.findByQuestion(question);
            if (answers.isEmpty()){
                throw new Exception("No se encuentran respuestas para la pregunta.");
            }
            return answers;
        }catch (Exception ex){
            System.err.println(ex);
            return null;
        }
    }
}

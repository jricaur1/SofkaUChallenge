package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.*;
import SofkaU.Challenge.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final GameService gameService;
    private final CategoryService categoryService;
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping
    public void createplayer(){
        System.out.println("Bienvenido!");
        Scanner scan = new Scanner(System.in);
        boolean cond = true;
        while (cond) {
            options();
            String option = "";
            option = scan.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Ingrese su nombre:");
                    String name = "";
                    name = scan.nextLine();
                    startGame(name);
                    break;
                case "2":
                    startQuestions();
                    break;
                default:
                    cond = false;
            }
        }
        System.out.println("Hasta la próxima!");
        System.exit(0);

        }

        public void options(){
            System.out.println("Seleccione una opción:");
            System.out.println("[1] Iniciar juego.");
            System.out.println("[2] Configurar preguntas.");
            System.out.println("Cualquier otra tecla para salir.");
        }

        public void startGame(String name){
            Player playerDB = Player.builder()
                    .username(name)
                    .build();
            playerService.createPlayer(playerDB);
            Game gameDB = Game.builder()
                    .player(playerDB)
                    .build();
            gameService.createGame(gameDB);
            System.out.println("Juego creado para " + playerDB.getUsername());
            if (playerDB.getUsername().equals("Vicente")){
                gameService.updatePoints(gameDB,100);
            }
        }

        public void startQuestions(){
            Scanner scan = new Scanner(System.in);
            List<Category> categories = createCategories();
            System.out.println("¿Cuántas preguntas tendrá cada categoría? Use números enteros, mínimo 5:");

            int nQuestions = scan.nextInt();
            for (Category category: categories){
                createQuestions(nQuestions, category);

            }
        }

        public void createQuestions(int nQuestions, Category category){
            Scanner scan = new Scanner(System.in);
            for (int i = 0; i < nQuestions; i++){
                System.out.println("Ingrese la pregunta");
                String quesContent = "";
                quesContent = scan.nextLine();
                Question question = questionService.createQuestion(Question.builder()
                        .content(quesContent)
                        .category(category)
                        .build());
                createAnswers(question, scan);
            }
        }

        public void  createAnswers(Question question, Scanner scan){
            boolean isCorrect=false;
            for (int j = 0; j < 4; j++){
                System.out.println("Ingrese una opción de respuesta");
                String ansContent = scan.nextLine();
                System.out.println("¿Es la respuesta correcta? [1] Si, [2] No");
                String bool = scan.nextLine();

                if (bool.equals("1") && !isCorrect){
                    Answer answer = answerService.createAnswer(Answer.builder()
                            .isRight(true)
                            .content(ansContent)
                            .question(question)
                            .build());
                    isCorrect=true;
                } else if(bool.equals("2")){
                    Answer answer = answerService.createAnswer(Answer.builder()
                            .isRight(false)
                            .content(ansContent)
                            .question(question)
                            .build());
                }

            }
        }

        public List<Category> createCategories(){
            List<Category> categories = new ArrayList<>();
            for (int i = 1; i <= 5; i++){
                categories.add(Category.builder()
                                .multiplier(i)
                                .build());
            }
            for (Category category: categories){
                categoryService.createCategory(category);
            }
            return categories;
        }


}

package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.Category;
import SofkaU.Challenge.entity.Game;
import SofkaU.Challenge.entity.Player;
import SofkaU.Challenge.entity.Question;
import SofkaU.Challenge.service.GameService;
import SofkaU.Challenge.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/game")
@RequiredArgsConstructor
public class GameController {
    private final PlayerService playerService;
    private final GameService gameService;
    private final CategoryController categoryController;
    private final QuestionController questionController;

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
        try {
            if (name.equals("")){
                throw new Exception("Ingrese su nombre.");
            }
            Player playerDB = Player.builder()
                    .username(name)
                    .build();
            playerService.createPlayer(playerDB);
            Game gameDB = Game.builder()
                    .player(playerDB)
                    .build();
            gameService.createGame(gameDB);
            System.out.println("Juego creado para " + playerDB.getUsername());
            List<Category> categories = categoryController.getCategories();
            for (Category category : categories) {
                List<Question> questions = questionController.getQuestions(category);
                for (Question question : questions) {
                    if (questionController.answerQuestion(question)) {
                        gameService.updatePoints(gameDB,category.getMultiplier());
                        System.out.println("Respuesta correcta! Tu puntaje ahora es de " + gameDB.getPoints());
                    } else {
                        throw new Exception("Respuesta Incorrecta! Tu puntaje fue de " + gameDB.getPoints());
                    }
                }
            }
            System.out.println("Ganaste! GOLAZOOOOO.");
        }catch (Exception ex){
            System.err.println(ex);
        }
    }

    public void startQuestions(){
        Scanner scan = new Scanner(System.in);

        System.out.println("¿Cuántas preguntas tendrá cada categoría? Use números enteros, mínimo 5:");
        try{
            int nQuestions = scan.nextInt();
            //i2f (nQuestions < 5){
              //  throw new Exception("Debe haber un mínimo de 5 preguntas.");
            //}
            List<Category> categories = categoryController.createCategories();
            for (Category category: categories){
                if(!questionController.createQuestions(nQuestions, category)){
                    break;
                }
            }
        } catch (Exception ex){
            System.err.println(ex);
            try {
                wait(100);
            }catch(Exception e){

            }

        }

    }
}

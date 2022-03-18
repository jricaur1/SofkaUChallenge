package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.Game;
import SofkaU.Challenge.entity.Player;
import SofkaU.Challenge.service.GameService;
import SofkaU.Challenge.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final GameService gameService;

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
                default:
                    cond = false;
            }
        }
        System.out.println("Hasta la próxima!");
        System.exit(0);

        }

        public void options(){
            System.out.println("Seleccione una opción:");
            System.out.println("[1] Iniciar Juego.");
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
        }

}

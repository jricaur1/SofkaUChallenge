package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.Game;
import SofkaU.Challenge.entity.Player;
import SofkaU.Challenge.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> listGame(){
        Player player = Player.builder()
                .player_id(1L)
                .username("Li")
                .build();
        Game game = Game.builder()
                .game_id(1L)
                .player(player)
                .build();
        gameService.createGame(game);

        List<Game> games = gameService.listAllGame();
        if (games.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(games);
    }
}

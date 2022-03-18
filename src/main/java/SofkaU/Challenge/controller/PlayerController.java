package SofkaU.Challenge.controller;

import SofkaU.Challenge.entity.Player;
import SofkaU.Challenge.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> listPlayer(){
        Player player = Player.builder()
                .player_id(1L)
                .username("Li")
                .build();
        playerService.createPlayer(player);
        List<Player> players = playerService.listAllPlayer();
        if(players.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(players);
    }

}

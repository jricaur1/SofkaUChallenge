package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Game;
import SofkaU.Challenge.entity.Player;

import java.util.List;

public interface GameService {
    public List<Game> listAllGame();
    public Game getGame(Long id);

    public Game createGame(Game game);
    public List<Game> findByPlayer(Player player);
}

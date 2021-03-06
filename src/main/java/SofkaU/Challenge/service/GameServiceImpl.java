package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Category;
import SofkaU.Challenge.entity.Game;
import SofkaU.Challenge.entity.Player;
import SofkaU.Challenge.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{

    private final GameRepository gameRepository;

    @Override
    public List<Game> listAllGame() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGame(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game createGame(Game game) {
        game.setWhencreated(new Date());
        game.setPoints(0);
        return gameRepository.save(game);
    }

    @Override
    public Game updateCategory(Game game, Category category) {
        Game gameDB = gameRepository.findById(game.getGame_id()).orElse(null);
        if (gameDB == null){
            return null;
        }
        gameDB.setCategory(category);
        return gameRepository.save(gameDB);
    }

    @Override
    public Game updatePoints(Game game, int multiplier){
        Game gameDB = gameRepository.findById(game.getGame_id()).orElse(null);
        if (gameDB == null){
            return null;
        }
        gameDB.setPoints(gameDB.getPoints()+ (100*multiplier));
        return gameRepository.save(gameDB);
    }

    @Override
    public List<Game> findByPlayer(Player player) {
        return gameRepository.findByPlayer(player);
    }
}

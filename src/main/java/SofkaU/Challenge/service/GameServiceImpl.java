package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Game;
import SofkaU.Challenge.entity.Player;
import SofkaU.Challenge.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findByPlayer(Player player) {
        return gameRepository.findByPlayer(player);
    }
}

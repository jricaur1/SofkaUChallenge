package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Player;
import SofkaU.Challenge.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    @Override
    public List<Player> listAllPlayer() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepository.getById(id);
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
}

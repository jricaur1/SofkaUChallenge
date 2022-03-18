package SofkaU.Challenge.repository;

import SofkaU.Challenge.entity.Game;
import SofkaU.Challenge.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    public List<Game> findByPlayer(Player player);
}

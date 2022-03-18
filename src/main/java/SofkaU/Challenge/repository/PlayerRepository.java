package SofkaU.Challenge.repository;

import SofkaU.Challenge.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}

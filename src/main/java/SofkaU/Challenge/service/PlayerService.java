package SofkaU.Challenge.service;

import SofkaU.Challenge.entity.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> listAllPlayer();
    public Player getPlayer(Long id);

    public Player createPlayer(Player player);
}

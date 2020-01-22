package marek.poznan.service;

import java.util.List;

import marek.poznan.entity.Player;

public interface PlayerService {

	List<Player> getPlayers();

	Player getPlayer(int playerId);

	void savePlayer(Player player);

	void deletePlayer(int playerId);

}

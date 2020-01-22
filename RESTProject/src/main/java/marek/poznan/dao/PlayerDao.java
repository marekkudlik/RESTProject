package marek.poznan.dao;

import java.util.List;

import marek.poznan.entity.Player;

public interface PlayerDao  {

	List<Player> getPlayers();

	Player getPlayer(int playerId);

	void savePlayer(Player player);

	void deletePlayer(int playerId);

}
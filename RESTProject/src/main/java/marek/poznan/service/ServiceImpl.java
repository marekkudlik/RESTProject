package marek.poznan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import marek.poznan.dao.PlayerDao;
import marek.poznan.entity.Player;



@Service
public class ServiceImpl implements PlayerService {
	
	@Autowired
	PlayerDao playerDao;
	
	@Transactional
	@Override
	public List<Player> getPlayers() {

		return playerDao.getPlayers();
	}

	@Transactional
	@Override
	public Player getPlayer(int playerId) {
		Player player = playerDao.getPlayer(playerId);
		return player;
	}
	@Transactional
	@Override
	public void savePlayer(Player player) {
		playerDao.savePlayer(player);
	}

	@Transactional
	@Override
	public void deletePlayer(int playerId) {
		playerDao.deletePlayer(playerId);
	}
	
	

}

package marek.poznan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import marek.poznan.entity.Player;


@Repository
public class PlayerDaoImpl implements PlayerDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Player> getPlayers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Player> theQuery = session.createQuery("from Player", Player.class);
		List<Player> players = theQuery.getResultList();
		
		return players;
	}

	@Override
	public Player getPlayer(int playerId) {
		Session session = sessionFactory.getCurrentSession();
		Player player = session.get(Player.class, playerId);
		return player;
	}

	@Override
	public void savePlayer(Player player) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(player);
	}

	@Override
	public void deletePlayer(int playerId) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Player where id=:playerId");
		theQuery.setParameter("playerId", playerId);
		theQuery.executeUpdate();
	}
	
}

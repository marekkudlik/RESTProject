package marek.poznan.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marek.poznan.entity.Player;
import marek.poznan.service.PlayerService;


@RestController
@RequestMapping("/show")
public class PlayerController {

	
	@Autowired
	PlayerService serv;
	
	@GetMapping("/players")
	public List<Player> showPlayers() {
		List<Player> players = serv.getPlayers();
		return players;
	}
	@GetMapping("/players/{playerId}")
	public Player showPlayer(@PathVariable int playerId) {
		
		Player player = serv.getPlayer(playerId);
		if(player==null) {
			throw new RuntimeException("Player id not Found: " + playerId);
		}
		return player;
	}
	@PostMapping("/players")
	public Player addPlayer(@RequestBody Player player) {
		player.setId(0);
		serv.savePlayer(player);
		return player;
	}
	@DeleteMapping("/players/{playerId}")
	public String deletePlayer(@PathVariable int playerId) {
		Player player = serv.getPlayer(playerId);
		if(player==null) {
			throw new RuntimeException("Player id not Found: " + playerId);
		}
		serv.deletePlayer(playerId);
		return "Delete Player: " + playerId;
	}
	@PutMapping("/players/{playerId}")
	public Player updatePlayer(@RequestBody Player player) {
		serv.savePlayer(player);
		
		return player;
		
	}
	
}

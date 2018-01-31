package org.game.fantasy.dao;

import java.io.IOException;

import org.game.fantasy.model.Player;

public class PlayerDAO {

	ObjectIOOperations objectIO = new ObjectIOOperations();

	@SuppressWarnings("unchecked")
	public Player getDetails( String playerName) throws ClassNotFoundException, IOException {

		Player player = new Player();
		player = (Player) objectIO.deserialize( playerName +  ".ser");

		return player;
	}

	public void save(Player player) throws IOException {
		objectIO.serialize(player,  player.getName() + ".ser");
	}

}

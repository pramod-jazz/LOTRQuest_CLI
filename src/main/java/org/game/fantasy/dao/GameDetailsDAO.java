package org.game.fantasy.dao;

import java.io.IOException;

import org.game.fantasy.model.GameDetails;

public class GameDetailsDAO {

	ObjectIOOperations objectIO = new ObjectIOOperations();

	@SuppressWarnings("unchecked")
	public GameDetails getDetails() throws ClassNotFoundException, IOException {

		GameDetails details = new GameDetails();
		details = (GameDetails) objectIO.deserialize("gamedetails.ser");

		return details;
	}

	public void save(GameDetails details) throws IOException {
		objectIO.serialize(details, "gamedetails.ser");
	}

}

package org.game.fantasy.dao;

import java.io.IOException;
import java.util.Optional;

import org.game.fantasy.model.GameDetails;

public class GameDetailsDAO {

	ObjectIOOperations objectIO = new ObjectIOOperations();

	@SuppressWarnings("unchecked")
	public Optional<GameDetails> getDetails() throws ClassNotFoundException, IOException {

		Optional<GameDetails> detailsOptional = Optional.empty();
		detailsOptional = Optional.ofNullable((GameDetails) objectIO.deserialize("gamedetails.ser"));

		return detailsOptional;
	}

	public void save(GameDetails details) throws IOException {
		objectIO.serialize(details, "gamedetails.ser");
	}

}

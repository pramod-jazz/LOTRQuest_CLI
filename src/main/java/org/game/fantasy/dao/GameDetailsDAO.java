package org.game.fantasy.dao;

import java.io.IOException;
import java.util.Optional;

import org.game.fantasy.model.GameDetails;


/**
 * The Class GameDetailsDAO.
 */
public class GameDetailsDAO {

	/** The object IO. */
	ObjectIOOperations objectIO = new ObjectIOOperations();

	/**
	 * Gets the details.
	 *
	 * @return the details
	 * @throws ClassNotFoundException the class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public Optional<GameDetails> getDetails() throws ClassNotFoundException, IOException {

		Optional<GameDetails> detailsOptional = Optional.empty();
		detailsOptional = Optional.ofNullable((GameDetails) objectIO.deserialize("gamedetails.ser"));

		return detailsOptional;
	}

	/**
	 * Save.
	 *
	 * @param details the details
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void save(GameDetails details) throws IOException {
		objectIO.serialize(details, "gamedetails.ser");
	}

}

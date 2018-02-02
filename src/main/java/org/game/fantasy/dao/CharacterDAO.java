package org.game.fantasy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.game.fantasy.model.GameCharacter;

/**
 * The Class CharacterDAO.
 */
public class CharacterDAO {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(CharacterDAO.class);

	/** The object IO. */
	private ObjectIOOperations objectIO = new ObjectIOOperations();

	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public List<GameCharacter> findAll() throws ClassNotFoundException, IOException {

		List<GameCharacter> gameCharacters = new ArrayList<>();
		gameCharacters.addAll((List<GameCharacter>) objectIO.deserialize("gameCharacters.ser"));

		return gameCharacters;
	}

	/**
	 * Save all.
	 *
	 * @param gameCharacters
	 *            the game characters
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void saveAll(List<GameCharacter> gameCharacters) throws IOException {

		objectIO.serialize(gameCharacters, "gameCharacters.ser");
	}

	public void setObjectIO(ObjectIOOperations objectIO) {
		this.objectIO = objectIO;
	}
	
	
	
	

}

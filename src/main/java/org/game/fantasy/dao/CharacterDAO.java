package org.game.fantasy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.game.fantasy.model.GameCharacter;

public class CharacterDAO {

	final static Logger logger = Logger.getLogger(CharacterDAO.class);

	ObjectIOOperations objectIO = new ObjectIOOperations();

	@SuppressWarnings("unchecked")
	public List<GameCharacter> findAll() throws ClassNotFoundException, IOException {

		List<GameCharacter> gameCharacters = new ArrayList<>();
		gameCharacters.addAll((List<GameCharacter>) objectIO.deserialize("gameCharacters.ser"));

		return gameCharacters;
	}

	public void save(GameCharacter gameCharacter) throws IOException, ClassNotFoundException {

		List<GameCharacter> gameCharacters = findAll();
		gameCharacters.add(gameCharacter);

		saveAll(gameCharacters);
	}

	public void saveAll(List<GameCharacter> gameCharacters) throws IOException {

		objectIO.serialize(gameCharacters, "gameCharacters.ser");
	}

}

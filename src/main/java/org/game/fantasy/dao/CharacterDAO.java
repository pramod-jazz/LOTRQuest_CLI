package org.game.fantasy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class CharacterDAO {

	final static Logger logger = Logger.getLogger(CharacterDAO.class);

	ObjectIOOperations objectIO = new ObjectIOOperations();

	@SuppressWarnings("unchecked")
	public List<Character> findAll() throws ClassNotFoundException, IOException {

		List<Character> Characters = new ArrayList<>();
		Characters.addAll((List<Character>) objectIO.deserialize("characters.ser"));

		return Characters;
	}

	public void save(Character Character) throws IOException, ClassNotFoundException {

		List<Character> Characters = findAll();
		Characters.add(Character);

		saveAll(Characters);
	}

	public void saveAll(List<Character> Characters) throws IOException {

		objectIO.serialize(Characters, "characters.ser");
	}

}

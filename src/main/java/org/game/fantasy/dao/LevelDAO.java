package org.game.fantasy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.model.Level;

public class LevelDAO {

	ObjectIOOperations objectIO = new ObjectIOOperations();

	@SuppressWarnings("unchecked")
	public List<Level> findAll() throws ClassNotFoundException, IOException {

		List<Level> levels = new ArrayList<Level>();
		levels.addAll((List<Level>) objectIO.deserialize("characters.ser"));

		return levels;
	}

	public void save(Level level) throws IOException, ClassNotFoundException {
		
		List<Level> levels = findAll();
		levels.add(level);

		saveAll(levels);
	}

	public void saveAll(List<Level> levels) throws IOException {

		objectIO.serialize(levels, "levels.ser");
	}

}

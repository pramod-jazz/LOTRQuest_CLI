package org.game.fantasy.dao;

import java.io.IOException;
import java.util.List;

import org.game.fantasy.model.Level;


/**
 * The Class LevelDAO.
 * 
 * @author Pramod Nikam
 */
public class LevelDAO {

	/** The object IO. */
	ObjectIOOperations objectIO = new ObjectIOOperations();

	/**
	 * Save all.
	 *
	 * @param levels the levels
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void saveAll(List<Level> levels) throws IOException {

		objectIO.serialize(levels, "levels.ser");
	}

	/**
	 * Sets the object IO.
	 *
	 * @param objectIO the new object IO
	 */
	public void setObjectIO(ObjectIOOperations objectIO) {
		this.objectIO = objectIO;
	}

}

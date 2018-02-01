package org.game.fantasy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.controls.GameController;
import org.game.fantasy.dao.CharacterDAO;
import org.game.fantasy.dao.LevelDAO;
import org.game.fantasy.exceptions.GameException;
import org.game.fantasy.model.GameCharacter;
import org.game.fantasy.model.Level;
import org.game.fantasy.ui.DisplayUnit;
import org.game.fantasy.ui.Header;
import org.game.fantasy.ui.MiddleTile;

/**
 * This class tries to generated initial game setup related metadata.
 * 
 * @author Pramod Nikam
 */
public class GameMetadata {

	/** The total characters. */
	private static Integer totalCharacters;

	/** The total levels. */
	private static Integer totalLevels;

	/** The current logged in user name. */
	private static String currentLoggedInUserName;

	/** The characters. */
	private static List<GameCharacter> characters = new ArrayList<>();

	/** The levels. */
	private static List<Level> levels = new ArrayList<>();

	/** The character DAO. */
	static CharacterDAO characterDAO = new CharacterDAO();

	/** The level DAO. */
	static LevelDAO levelDAO = new LevelDAO();

	/** The game controller. */
	private GameController gameController = new GameController();

	/**
	 * Setup characters.
	 */

	public static void setupCharacters() {
		/*
		 * These characters will be predefined characters. You can easily extend these
		 * characters for another idea of game.
		 */
		characters.add(new GameCharacter(1, "frodo", "Frodo"));
		characters.add(new GameCharacter(2, "sam", "Sam"));
		characters.add(new GameCharacter(3, "mary", "Mary"));
		characters.add(new GameCharacter(4, "pippin", "Pippin"));

		try {
			characterDAO.saveAll(characters);
		} catch (IOException e) {
			throw new GameException("IO Exception occured!", e);
		}

		totalCharacters = characters.size();
	}

	/**
	 * Gets the current logged in user name.
	 *
	 * @return the current logged in user name
	 */
	public static String getCurrentLoggedInUserName() {
		return currentLoggedInUserName;
	}

	/**
	 * Sets the current logged in user name.
	 *
	 * @param currentLoggedInUserName
	 *            the new current logged in user name
	 */
	public static void setCurrentLoggedInUserName(String currentLoggedInUserName) {
		GameMetadata.currentLoggedInUserName = currentLoggedInUserName;
	}

	/**
	 * Setup levels.
	 */

	public static void setupLevels() {

		/*
		 * These levels will be predefined levels. You can easily extend these levels
		 * for another idea of game.
		 */
		levels.add(new Level(1, "Shire"));
		levels.add(new Level(2, "Rivendel"));
		levels.add(new Level(3, "Rohan"));
		levels.add(new Level(4, "Gondor"));
		levels.add(new Level(5, "Mordor"));

		try {
			levelDAO.saveAll(levels);
		} catch (IOException e) {
			throw new GameException("IO Exception occured!", e);
		}

		totalLevels = levels.size();

	}

	/**
	 * Adds the custom character.
	 *
	 * @param characterName
	 *            the character name
	 */
	public static void addCustomCharacter(String characterName) {
		String capitalizedCharacterName = characterName.substring(0, 1).toUpperCase() + characterName.substring(1);
		characters.add(new GameCharacter(0, characterName, capitalizedCharacterName));

	}

	/**
	 * Gets the total characters.
	 *
	 * @return the total characters
	 */
	public static Integer getTotalCharacters() {
		return totalCharacters;
	}

	/**
	 * Gets the total levels.
	 *
	 * @return the total levels
	 */
	public static Integer getTotalLevels() {
		return totalLevels;
	}

	/**
	 * Show greetings.
	 */
	public void showGreetings() {
		DisplayUnit header = new Header();
		header.renderUI(false);

		gameController.addDelayAndGap(2);

		DisplayUnit gandalfImage = new MiddleTile("gandalf.txt");
		gandalfImage.renderUI(false);
	}

}

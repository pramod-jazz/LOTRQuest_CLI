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

public class GameMetadata {

	private static Boolean preDefinedCharacterStatus = false;
	private static Boolean customCharacterStatus = false;
	private static Integer totalCharacters;
	private static Integer totalLevels;
	private static String currentLoggedInUserName;

	private static List<GameCharacter> characters = new ArrayList<>();
	private static List<Level> levels = new ArrayList<>();
	
	static CharacterDAO characterDAO = new CharacterDAO();
	static LevelDAO levelDAO = new LevelDAO();
	
	private GameController gameController = new GameController();

	// These characters will be predefined characters. You can easily extend these
	// characters for another idea of game.
	public static void setupCharacters() {
		characters.add(new GameCharacter(1, "frodo", "Frodo"));
		characters.add(new GameCharacter(2, "sam", "Sam"));
		characters.add(new GameCharacter(3, "mary", "Mary"));
		characters.add(new GameCharacter(4, "pippin", "Pippin"));

		try {
			characterDAO.saveAll(characters);
		} catch (IOException e) {
			new GameException("IO Exception occured!", e);
		}
		preDefinedCharacterStatus = true;
		totalCharacters = characters.size();
	}
	
	
	
	public static String getCurrentLoggedInUserName() {
		return currentLoggedInUserName;
	}



	public static void setCurrentLoggedInUserName(String currentLoggedInUserName) {
		GameMetadata.currentLoggedInUserName = currentLoggedInUserName;
	}



	// These characters will be predefined characters. You can easily extend these
	// characters for another idea of game.
	public static void setupLevels() {
		levels.add(new Level(1,"Shire") );
		levels.add(new Level(2,"Rivendel") );
		levels.add(new Level(3,"Rohan") );
		levels.add(new Level(4,"Gondor") );
		levels.add(new Level(5,"Mordor") );
        
		try {
			levelDAO.saveAll(levels);
		} catch (IOException e) {
			throw new GameException("IO Exception occured!", e);
		}
		
		totalLevels = levels.size();
         
		
	}
	
	

	public static void addCustomCharacter(String characterName) {
		String capitalizedCharacterName = characterName.substring(0, 1).toUpperCase() + characterName.substring(1);
		characters.add(new GameCharacter(0, characterName, capitalizedCharacterName));

		customCharacterStatus = true;

	}

	public static Integer getTotalCharacters() {
		return totalCharacters;
	}

	public static Integer getTotalLevels() {
		return totalLevels;
	}

	public  void showGreetings() {
		DisplayUnit header = new Header();
		header.renderUI(false);

		gameController.addDelayAndGap(2);

		DisplayUnit gandalfImage = new MiddleTile("gandalf.txt");
		gandalfImage.renderUI(false);
	}
	
	

}

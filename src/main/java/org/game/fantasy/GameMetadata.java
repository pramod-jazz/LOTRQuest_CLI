package org.game.fantasy;

import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.model.Character;

public class GameMetadata {

	private static Boolean preDefinedCharacterStatus = false;
	private static Boolean customCharacterStatus = false;

	private static List<Character> characters = new ArrayList<>();

	// These characters will be predefined characters. You can easily extend these
	// characters for another idea of game.
	public static void setupCharacters() {
		characters.add(new Character(1, "frodo", "Frodo"));
		characters.add(new Character(2, "sam", "Sam"));
		characters.add(new Character(3, "mary", "Mary"));
		characters.add(new Character(4, "pippin", "Pippin"));

		preDefinedCharacterStatus = true;
	}

	public static void addCustomCharacter(String characterName) {
		String capitalizedCharacterName = characterName.substring(0, 1).toUpperCase() + characterName.substring(1);
		characters.add(new Character(0, characterName, capitalizedCharacterName));

		customCharacterStatus = true;

	}

}

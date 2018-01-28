package org.game.fantasy;

import org.game.fantasy.model.CharacterAvatar;
import org.game.fantasy.ui.DisplayUnit;
import org.game.fantasy.ui.Header;
import org.game.fantasy.ui.MiddleTile;
import org.game.fantasy.utils.Delay;

import java.io.File;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class Game {
	public static void main(String[] args) {
		System.out.println("Hello World 3 !");
		DisplayUnit header = new Header();
		header.renderUI();

		new Delay(2).delayExecution();

		DisplayUnit gandalfImage = new MiddleTile("gandalf.txt");
		gandalfImage.renderUI();

		// Arrays.asList(CharacterAvatar.class).forEach(System.out::println);

		// Stream.of(CharacterAvatar.values())
		// CharacterAvatar.values()

		new Delay(2).delayExecution();

		// Stream.of(CharacterAvatar.values()).map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);
		// Going to change this to java 8
        int counter =1;
		for (CharacterAvatar avatar : CharacterAvatar.values()) {
			System.out.println("  ");
			if (!avatar.toString().equals("CUSTOM")) {
				// System.out.println(avatar.toString().toLowerCase());
				new MiddleTile(avatar.toString().toLowerCase() + ".txt").renderUI();
			}
			System.out.println("  ");
			counter++;
		}
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character choice : ");
        int choiceNumber = scanner.nextInt();
        
        System.out.println("You have selected choice number " + choiceNumber +  " who is :" );
        
        new MiddleTile(CharacterAvatar.values()[choiceNumber].toString().toLowerCase() + ".txt").renderUI();
        
		

	}

}

package org.game.fantasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.game.fantasy.model.CharacterAvatar;
import org.game.fantasy.ui.DisplayUnit;
import org.game.fantasy.ui.Header;
import org.game.fantasy.ui.MiddleTile;
import org.game.fantasy.utils.Delay;

/**
 * Hello world!
 *
 */
public class Game {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		System.out.println("Hello World 3 !");
		showGreetings();
		
		GameMetadata.setupCharacters();
		

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
				new MiddleTile(avatar.toString().toLowerCase() + ".txt").renderUI(false);
			}
			System.out.println("  ");
			counter++;
		}
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character choice : ");
        int choiceNumber = scanner.nextInt();
        
        
        
        System.out.println("You have selected choice number " + choiceNumber +  " who is :" );
        
        new MiddleTile(CharacterAvatar.values()[choiceNumber].toString().toLowerCase() + ".txt").renderUI(false);
		
		 
		    new MiddleTile("frodo_strict.txt").renderUI(true);
		    boolean isInturrupted = false;
		    
		    InputStreamReader inStream = new InputStreamReader(System.in);
		    BufferedReader bufferedReader = new BufferedReader(inStream);
		    for (int i = 0; i < 38; i++) {

		        System.out.print("=>");
		        TimeUnit.MILLISECONDS.sleep(20);

		        // Something that allows user input/interaction capable to stop the progressbar
		        try {
		            if (bufferedReader.ready()) {
		            	isInturrupted = true;
		                break;
		            }
		        } catch (IOException e) {

		            e.printStackTrace();
		        }
		    }
		    
		    System.out.println(" ");
		    
		    if(isInturrupted) {
		    	System.out.println("You got 10 Points !!");	
		    }else {
		    	System.out.println("ohh you died!!!");
		    }
		    
		
		
		
		
        
		

	}
	
	

	private static void showGreetings() {
		DisplayUnit header = new Header();
		header.renderUI(false);

		new Delay(2).delayExecution();

		DisplayUnit gandalfImage = new MiddleTile("gandalf.txt");
		gandalfImage.renderUI(false);
	}

}

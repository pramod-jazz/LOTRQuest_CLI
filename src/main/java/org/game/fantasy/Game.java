package org.game.fantasy;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.game.fantasy.controls.GameController;

/**
 * Hello world!
 *
 */
public class Game {
	
	final static Logger logger = Logger.getLogger(Game.class);
	

	public static void main(String[] args) throws IOException, InterruptedException {
			
		logger.info("Starting Game.");
		

		
		
		GameController gameController = new GameController();
		gameController.showGreetings();
		
		gameController.initialisePlayer();
		
		
		//gameController.showCharacters();
		gameController.setCharacterChoice();
		//gameController.showChoicedCharacter();
		
		gameController.addDelayAndGap(5);		
		
		gameController.introduceLevel(1);
		
		gameController.readCommand();
		
		
		
		
		
		
	/*	try {
			gameController.help();
			gameController.continueGame1();
			gameController.resume();
			gameController.quit();
			gameController.map();
		} catch (Exception e) {
			new GameException("Fatal Exception Occured", e);
		}*/
		
		/*System.out.println("Hello World 3 !");
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

		        // Something that allows user input/interaction capable to stop the progress bar
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
		    }*/
		    
		
		
		
		
        
		

	}
	
	

	

}

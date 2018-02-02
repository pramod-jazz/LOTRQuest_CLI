/*
 * @Author - Pramod Nikam
 */
package org.game.fantasy;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.game.fantasy.controls.GameController;

public class Game {
	
	  final static Logger logger = Logger.getLogger(Game.class);
	  
	  /**
		 * The main method.
		 *
		 * @param args
		 *            the arguments
		 * @throws IOException
		 *             Signals that an I/O exception has occurred.
		 * @throws InterruptedException
		 *             the interrupted exception
		 * 
		 * 
		 */
	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * Game Controller is a one entry point or Facade for all external interactions.
		 * 
		 */
		logger.info("initializing game");

		GameController gameController = new GameController();

		gameController.showGreetings();
		gameController.initialisePlayer();
		gameController.setCharacterChoice();
		gameController.addDelayAndGap(2);

		gameController.readCommand();

	}

}

package org.game.fantasy.controls;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.game.fantasy.GameMetadata;
import org.game.fantasy.command.Command;
import org.game.fantasy.command.params.ContinueCommandParams;
import org.game.fantasy.command.params.HelpCommandParams;
import org.game.fantasy.command.params.MapCommandParams;
import org.game.fantasy.command.params.ProfileCommandParams;
import org.game.fantasy.command.params.QuitCommandParams;
import org.game.fantasy.command.params.ResumeCommandParams;
import org.game.fantasy.dao.CharacterDAO;
import org.game.fantasy.dao.GameDetailsDAO;
import org.game.fantasy.dao.LevelDAO;
import org.game.fantasy.dao.PlayerDAO;
import org.game.fantasy.exceptions.GameException;
import org.game.fantasy.model.GameCharacter;
import org.game.fantasy.model.GameDetails;
import org.game.fantasy.model.Player;
import org.game.fantasy.ui.DisplayUnit;
import org.game.fantasy.ui.Header;
import org.game.fantasy.ui.MiddleTile;

/**
 * Finally, the top of the stack. This is the class that is invoking the
 * command. Looks simple from up here, doesn't it?
 */
public class GameController extends GameControlBase {

	final static Logger logger = Logger.getLogger(GameController.class);

	LevelDAO levelDAO = new LevelDAO();

	PlayerDAO playerDAO = new PlayerDAO();

	CharacterDAO characterDAO = new CharacterDAO();

	GameDetailsDAO gameDetailsDAO = new GameDetailsDAO();

	ConsoleController consoleController = new ConsoleController();

	private Integer currentLevelSuccess = 0;

	private static boolean isGameCompplete = false;

	private static boolean isGameAborted = false;

	public static boolean isGameCompplete() {
		return isGameCompplete;
	}

	public static void setGameCompplete(boolean isGameCompplete) {
		GameController.isGameCompplete = isGameCompplete;
	}

	public static boolean isGameAborted() {
		return isGameAborted;
	}

	public static void setGameAborted(boolean isGameAborted) {
		GameController.isGameAborted = isGameAborted;
	}

	public void showGreetings() {
		DisplayUnit header = new Header();
		header.renderUI(false);

		addDelayAndGap(2);

		DisplayUnit gandalfImage = new MiddleTile("gandalf.txt");
		gandalfImage.renderUI(false);
	}

	public void help() throws Exception {
		logger.info("Watch me invoke the map command");
		String message = executeCommand(Command.HELP, new HelpCommandParams("Helping World"));
		logger.info("Message: " + message);
	}

	public void map(Player player) throws Exception {
		logger.info("Watch me invoke the map command");
		String message = executeCommand(Command.MAP, new MapCommandParams(player.getCurrentLevel()));
		logger.info("Message: " + message);
	}

	public void quit() throws Exception {
		logger.info("Watch me invoke the quit command");
		String message = executeCommand(Command.QUIT, new QuitCommandParams("Quitting game"));
		logger.info("Message: " + message);
	}

	public void profile(Player player) throws Exception {
		logger.info("Watch me invoke the profile command");
		String message = executeCommand(Command.PROFILE,
				new ProfileCommandParams(player.getName(), player.getPoints(), player.getCurrentLevel().toString()));
		logger.info("Message: " + message);
	}

	public void continueGame1() throws Exception {
		logger.info("Watch me invoke the contine command");
		String message = executeCommand(Command.CONTINUE, new ContinueCommandParams("Continuing game!"));
		logger.info("Message: " + message);
	}

	public void resume() throws Exception {
		logger.info("Watch me invoke the resume command");
		String message = executeCommand(Command.RESUME, new ResumeCommandParams("Resuming Game"));
		logger.info("Message: " + message);
	}

	public void showCharacters() {

		List<GameCharacter> gameCharacters;
		try {
			gameCharacters = characterDAO.findAll();

			int counter = 1;
			for (GameCharacter character : gameCharacters) {
				new MiddleTile(character.getCharacterAvatar().toLowerCase() + ".txt").renderUI(false);
				counter++;
			}

		} catch (ClassNotFoundException e) {
			new GameException("Class not found exception Occured.", e);
		} catch (IOException e) {
			new GameException("Serialization file IO exception Occured. Check the proper file location.", e);
		}

		// Stream.of(CharacterAvatar.values()).map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);
		// Going to change this to java 8

	}

	public Player acceptCreds(Player player) {

		String playerName = ConsoleController.readString("Please enter your name : ", "Please enter valid name!");
		String passphrase = ConsoleController.readString("Please enter pass phrase : ",
				"Please enter valid passphrase!");
		String reenterpassphrase = ConsoleController.readString("Please reenter pass phrase : ",
				"Please enter valid passphrase!");

		if (!passphrase.equals(reenterpassphrase)) {
			acceptCreds(player);
		}

		player.setName(playerName);
		player.setPassphrase(passphrase);

		return player;

	}

	public boolean validatePlayer(String name, String passphrase) {
		Optional<Player> existingPlayer = Optional.empty();
		try {
			existingPlayer = Optional.ofNullable(playerDAO.getDetails(name));
		} catch (ClassNotFoundException | IOException e) {
			new GameException("Fatal Exception", e);
		}
		if (existingPlayer.isPresent()) {
			if (existingPlayer.get().getPassphrase().equals(passphrase)) {
				GameDetails gameDetails = new GameDetails(existingPlayer.get().getId(), existingPlayer.get().getName(),
						existingPlayer.get().getCurrentLevel());
				try {
					clearState(existingPlayer.get(), gameDetails);

					gameDetailsDAO.save(gameDetails);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			} else {
				ConsoleController.printMessageToConsole("Passphrase does not match!");
				return false;
			}

		} else {
			ConsoleController.printMessageToConsole("Mentioned user is not present");
			return false;
		}

	}

	public void initialisePlayer() {
		Boolean verification = ConsoleController.readBoolean("Are you a new player? (yes | no ) ?  ");
		Player player = new Player();

		if (verification) {

			player = acceptCreds(player);
			GameDetails gameDetails = new GameDetails(player.getId(), player.getName(), player.getCurrentLevel());
			try {

				playerDAO.save(player);
				gameDetailsDAO.save(gameDetails);
				GameMetadata.setCurrentLoggedInUserName(player.getName());
				try {
					profile(player);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {

			}
			;

		} else {

			String playerName = ConsoleController.readString("Please enter your name : ", "Please enter valid name!");
			String passphrase = ConsoleController.readString("Please enter pass phrase : ",
					"Please enter valid passphrase!");

			boolean status = validatePlayer(playerName, passphrase);

		}

	}

	private void clearState(Player player, GameDetails gameDetails) {
		Boolean clearStatus = ConsoleController
				.readBoolean("Do you want to start from where you left last time? (yes | no ) ?  ");
		if (clearStatus) {
			player.setCurrentLevel(1);
			player.setCharacter(null);
			player.setPoints(0);

			gameDetails.setCurrentLevel(0);
		}
		ConsoleController.printGap();
		try {
			profile(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConsoleController.printGap();
	}

	public void setCharacterChoice() {
		GameDetails gameDetails;
		Player player = new Player();
		try {
			gameDetails = gameDetailsDAO.getDetails().get();
			player = playerDAO.getDetails(gameDetails.getLoggedInUserName());
		} catch (ClassNotFoundException | IOException e1) {
			new GameException("FatalException", e1);
		}

		// Optional<Integer> option = consoleController.getIntegerUserInput("Please
		// enter which character do you want to possess? :");
		Optional<Integer> option = Optional
				.ofNullable(consoleController.readInteger("Please enter which character do you want to possess? :",
						"Wrong input !! Please make valid input between 1 to " + GameMetadata.getTotalCharacters()));
		if (option.isPresent()) {
			Integer choice = option.get();
			if (choice <= GameMetadata.getTotalCharacters() && choice != 0) {
				player.setCharacter(choice);

				player.setCurrentLevel(1);
				player.setPoints(0);
				try {
					playerDAO.save(player);

				} catch (IOException e) {
					new GameException("IO Exception", e);
				}

			} else {
				new GameException("Wrong input !! Please make input between 1 to " + GameMetadata.getTotalCharacters());
				setCharacterChoice();
			}
			player.setCharacter(choice);
		}

	}

	public void showChoicedCharacter() {
		Player player;
		GameCharacter character;

		GameDetails gameDetails;

		try {
			gameDetails = gameDetailsDAO.getDetails().get();
			player = playerDAO.getDetails(gameDetails.getLoggedInUserName());

			character = characterDAO.findAll().get(player.getCharacter() - 1);
			consoleController.printGap();
			consoleController
					.printMessageToConsole("You have selected choice number " + character.getId() + " who is :");

			new MiddleTile(character.getCharacterName() + ".txt").renderUI(false);

		} catch (ClassNotFoundException | IOException e) {
			new GameException("Fatal Exception Occured!", e);
		}

	}

	public void addDelayAndGap(Integer seconds) {
		consoleController.printGap();
		try {

			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void introduceLevel(Integer levelNumber) {

		System.out.flush();
		consoleController
				.printMessageToConsole(" Lets start first level my dear hobbit! Here is map of all the levels.");
		addDelayAndGap(2);
		new MiddleTile("level" + levelNumber + ".txt").renderUI(false);
		consoleController.printGap();
		consoleController
				.printMessageToConsole(" Read all commands carefully. Type play command to play game at first level.");

	}

	public void resolveAndExecuteCommand(String command) {
		GameDetails gameDetails;

		Player player = null;
		try {

			gameDetails = gameDetailsDAO.getDetails().get();

			player = playerDAO.getDetails(gameDetails.getLoggedInUserName());
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		switch (command) {
		case "play":
			try {
				continueGame1();
			} catch (Exception e) {
				new GameException("Error while playing game ", e);
			}

			break;
		case "help":
			try {
				help();
			} catch (Exception e) {
				new GameException("Error while playing game ", e);
			}
			break;

		case "quit":

			try {
				quit();
			} catch (Exception e) {
				new GameException("Error while playing game ", e);
			}

			break;
		case "profile":

			try {
				profile(player);
			} catch (Exception e) {
				new GameException("Error while playing game ", e);
			}

			break;
		case "map":

			try {
				map(player);
			} catch (Exception e) {
				new GameException("Error while playing game ", e);
			}

			break;

		default:
			new GameException("I dont understand your command hobbit. Please retry: ");
			break;
		}

	}

	public void readCommand() {
		String command = ConsoleController.readString("Enter your command hobbit :");
		resolveAndExecuteCommand(command);

		while (!isGameCompplete || !isGameAborted) {
			addDelayAndGap(2);
			readCommand();
		}

	}

}
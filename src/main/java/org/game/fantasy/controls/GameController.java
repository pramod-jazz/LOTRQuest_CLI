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

public class GameController extends GameControlBase {

	final static Logger logger = Logger.getLogger(GameController.class);

	LevelDAO levelDAO = new LevelDAO();

	PlayerDAO playerDAO = new PlayerDAO();

	CharacterDAO characterDAO = new CharacterDAO();

	GameDetailsDAO gameDetailsDAO = new GameDetailsDAO();

	ConsoleController consoleController = new ConsoleController();

	private static boolean isGameCompplete = false;

	private static boolean isGameAborted = false;

	public static boolean isGameCompplete() {
		return GameController.isGameCompplete;
	}

	public static void setGameCompplete(final boolean isGameCompplete) {
		GameController.isGameCompplete = isGameCompplete;
	}

	public static boolean isGameAborted() {
		return GameController.isGameAborted;
	}

	public static void setGameAborted(final boolean isGameAborted) {
		GameController.isGameAborted = isGameAborted;
	}

	public void showGreetings() {
		final DisplayUnit header = new Header();
		header.renderUI(false);

		addDelayAndGap(2);

	}

	public void showGandalf() {
		final DisplayUnit gandalfImage = new MiddleTile("gandalf.txt");
		gandalfImage.renderUI(false);
	}

	public void help() throws Exception {
		GameController.logger.info("Invoking map command");
		executeCommand(Command.HELP, new HelpCommandParams("Helping World"));

	}

	public void map(final Player player) throws Exception {
		GameController.logger.info("Invoking map command");
		executeCommand(Command.MAP, new MapCommandParams(player.getCurrentLevel()));

	}

	public void quit() throws Exception {
		GameController.logger.info("Invoking quit command");
		executeCommand(Command.QUIT, new QuitCommandParams("Quitting game"));

	}

	public void profile(final Player player) throws Exception {
		GameController.logger.info("Invoking profile command");
		executeCommand(Command.PROFILE,
				new ProfileCommandParams(player.getName(), player.getPoints(), player.getCurrentLevel().toString()));

	}

	public void continueGame1() throws Exception {
		GameController.logger.info("Invoking contine command");
		executeCommand(Command.CONTINUE, new ContinueCommandParams("Continuing game!"));

	}

	public void resume() throws Exception {
		GameController.logger.info("Invoking resume command");
		executeCommand(Command.RESUME, new ResumeCommandParams("Resuming Game"));

	}

	public void showCharacters() {

		List<GameCharacter> gameCharacters;
		try {
			gameCharacters = characterDAO.findAll();

			int counter = 1;
			for (final GameCharacter character : gameCharacters) {
				new MiddleTile(character.getCharacterAvatar().toLowerCase() + ".txt").renderUI(false);
				counter++;
			}

		} catch (final ClassNotFoundException e) {
			throw new GameException("Class not found exception Occured.", e);
		} catch (final IOException e) {
			throw new GameException("Serialization file IO exception Occured. Check the proper file location.", e);
		}

		// Stream.of(CharacterAvatar.values()).map(String::toLowerCase).collect(Collectors.toList()).forEach(System.out::println);
		// Going to change this to java 8

	}

	public Player acceptCreds(final Player player) {

		final String playerName = ConsoleController.readString("Please enter your name : ", "Please enter valid name!");

		if (playerName.trim().equalsIgnoreCase("")) {
			acceptCreds(player);
		}

		fillNewPlayer(player, playerName);

		return player;

	}

	private void fillNewPlayer(final Player player, final String playerName) {
		player.setName(playerName);
		player.setCharacter(0);
		player.setCurrentLevel(1);
		player.setPoints(0);
	}

	public boolean validatePlayer(final String name) {
		Optional<Player> existingPlayer = Optional.empty();
		try {
			existingPlayer = Optional.ofNullable(playerDAO.getDetails(name));
		} catch (ClassNotFoundException | IOException e) {
			throw new GameException("Fatal Exception", e);
		}
		if (existingPlayer.isPresent()) {

			final GameDetails gameDetails = new GameDetails(existingPlayer.get().getId(),
					existingPlayer.get().getName(), existingPlayer.get().getCurrentLevel());
			try {
				clearState(existingPlayer.get(), gameDetails);

				gameDetailsDAO.save(gameDetails);
			} catch (final IOException e) {
				throw new GameException("Fatal error occured!", e);
			}
			return true;

		} else {
			ConsoleController.printMessageToConsole("Mentioned user is not present");
			return false;
		}

	}

	public void initialisePlayer() {
		final Boolean verification = ConsoleController.readBoolean("Are you a new player? (yes | no ) ?  ");

		Player player = new Player();

		if (verification) {

			player = acceptCreds(player);
			final GameDetails gameDetails = new GameDetails(player.getId(), player.getName(), player.getCurrentLevel());
			try {

				playerDAO.save(player);
				gameDetailsDAO.save(gameDetails);
				GameMetadata.setCurrentLoggedInUserName(player.getName());
				try {
					profile(player);
				} catch (final Exception e) {
					throw new GameException("Fatal error occured!", e);
				}
			} catch (final IOException e) {

			}
			;

		} else {

			/*
			 * Player old = new Player();
			 * 
			 * newPlayer = acceptCreds(newPlayer);
			 */
			/*
			 * String passphrase =
			 * ConsoleController.readString("Please enter pass phrase : ",
			 * "Please enter valid passphrase!");
			 */

			// status = validatePlayer(playerName);
			final String playerName = getPlayerName();

			validatePlayer(playerName);

		}

	}

	private String getPlayerName() {
		final String playerName = ConsoleController.readString("Please enter your name ", "Please enter valid name!!");
		if (playerName.trim().equalsIgnoreCase("")) {
			getPlayerName();
		}

		return playerName;
	}

	private void clearState(final Player player, final GameDetails gameDetails) {
		final Boolean clearStatus = ConsoleController
				.readBoolean("Do you want to start from where you left last time? (yes | no ) ?  ");
		if (clearStatus) {
			player.setCurrentLevel(1);
			player.setCharacter(null);
			player.setIsNew(false);
			player.setIsChoiceSet(false);
			player.setPoints(0);

			gameDetails.setCurrentLevel(0);
		}
		ConsoleController.printGap();
		try {
			profile(player);
		} catch (final Exception e) {
			throw new GameException("Fatal error occured!", e);
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
			throw new GameException("Fatal error occured!", e1);
		}

		if (!player.getIsChoiceSet()) {
			showGandalf();
			showCharacters();

			// Optional<Integer> option = consoleController.getIntegerUserInput("Please
			// enter which character do you want to possess? :");
			final Optional<Integer> option = Optional.ofNullable(ConsoleController.readInteger(
					"Please enter which character do you want to possess? :",
					"Wrong input !! Please make valid input between 1 to " + GameMetadata.getTotalCharacters()));
			if (option.isPresent()) {
				final Integer choice = option.get();
				if (choice <= GameMetadata.getTotalCharacters() && choice != 0) {
					player.setCharacter(choice);
					player.setIsChoiceSet(true);

					player.setCurrentLevel(1);
					player.setPoints(0);
					try {
						playerDAO.save(player);

					} catch (final IOException e) {
						new GameException("IO Exception", e);
					}

				} else {
					new GameException(
							"Wrong input !! Please make input between 1 to " + GameMetadata.getTotalCharacters());
					setCharacterChoice();
				}
				player.setCharacter(choice);
			}

			showChoicedCharacter();

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
			ConsoleController.printGap();
			ConsoleController
					.printMessageToConsole("You have selected choice number " + character.getId() + " who is :");

			new MiddleTile(character.getCharacterName() + ".txt").renderUI(false);

		} catch (ClassNotFoundException | IOException e) {
			new GameException("Fatal Exception Occured!", e);
		}

	}

	public void addDelayAndGap(final Integer seconds) {
		ConsoleController.printGap();
		try {

			Thread.sleep(seconds * 1000);

		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void introduceLevel(final Integer levelNumber) {

		System.out.flush();
		ConsoleController
				.printMessageToConsole(" Lets start first level my dear hobbit! Here is map of all the levels.");
		addDelayAndGap(2);
		new MiddleTile("level" + levelNumber + ".txt").renderUI(false);
		ConsoleController.printGap();
		ConsoleController
				.printMessageToConsole(" Read all commands carefully. Type play command to play game at first level.");

	}

	public void resolveAndExecuteCommand(final String command) {
		GameDetails gameDetails;

		Player player = null;
		try {

			gameDetails = gameDetailsDAO.getDetails().get();

			player = playerDAO.getDetails(gameDetails.getLoggedInUserName());
		} catch (ClassNotFoundException | IOException e1) {
			throw new GameException("Error while playing game ", e1);
		}

		switch (command) {
		case "play":
			try {
				continueGame1();
			} catch (final Exception e) {
				throw new GameException("Error while playing game ", e);
			}

			break;
		case "help":
			try {
				help();
			} catch (final Exception e) {
				throw new GameException("Error while playing game ", e);
			}
			break;

		case "quit":

			try {
				quit();
			} catch (final Exception e) {
				throw new GameException("Error while playing game ", e);
			}

			break;
		case "profile":

			try {
				profile(player);
			} catch (final Exception e) {
				throw new GameException("Error while playing game ", e);
			}

			break;
		case "map":

			try {
				map(player);
			} catch (final Exception e) {
				throw new GameException("Error while playing game ", e);
			}

			break;

		default:
			new GameException("I dont understand your command hobbit. Please retry: ");
			break;
		}

	}

	public void readCommand() {
		final String command = ConsoleController.readString("Enter your command hobbit :");
		resolveAndExecuteCommand(command);

		while (!GameController.isGameCompplete || !GameController.isGameAborted) {
			addDelayAndGap(2);
			readCommand();
		}

	}

}
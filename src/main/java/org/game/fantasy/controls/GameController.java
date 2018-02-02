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
 * Main Controller Facade class for Game. One Class Entry to external world.
 * 
 * @author Pramod Nikam
 * 
 * The Class GameController.
 */
public class GameController extends GameControlBase {

	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(GameController.class);

	/** The level DAO. */
	LevelDAO levelDAO = new LevelDAO();

	/** The player DAO. */
	PlayerDAO playerDAO = new PlayerDAO();

	/** The character DAO. */
	CharacterDAO characterDAO = new CharacterDAO();

	/** The game details DAO. */
	GameDetailsDAO gameDetailsDAO = new GameDetailsDAO();

	/** The console controller. */
	ConsoleController consoleController = new ConsoleController();

	/** The is game compplete. */
	private static boolean isGameCompplete = false;

	/** The is game aborted. */
	private static boolean isGameAborted = false;

	/**
	 * Checks if is game compplete.
	 *
	 * @return true, if is game compplete
	 */
	public static boolean isGameCompplete() {
		return GameController.isGameCompplete;
	}

	/**
	 * Sets the game compplete.
	 *
	 * @param isGameCompplete the new game compplete
	 */
	public static void setGameCompplete(final boolean isGameCompplete) {
		GameController.isGameCompplete = isGameCompplete;
	}

	/**
	 * Checks if is game aborted.
	 *
	 * @return true, if is game aborted
	 */
	public static boolean isGameAborted() {
		return GameController.isGameAborted;
	}

	/**
	 * Sets the game aborted.
	 *
	 * @param isGameAborted the new game aborted
	 */
	public static void setGameAborted(final boolean isGameAborted) {
		GameController.isGameAborted = isGameAborted;
	}

	/**
	 * Show greetings.
	 */
	public void showGreetings() {
		final DisplayUnit header = new Header();
		header.renderUI(false);

		addDelayAndGap(2);

	}

	/**
	 * Show gandalf.
	 */
	public void showGandalf() {
		final DisplayUnit gandalfImage = new MiddleTile("gandalf.txt");
		gandalfImage.renderUI(false);
	}

	/**
	 * Help.
	 *
	 * @throws Exception the exception
	 */
	public void help() throws Exception {
		GameController.logger.info("Invoking map command");
		executeCommand(Command.HELP, new HelpCommandParams("Help"));

	}

	/**
	 * Map.
	 *
	 * @param player the player
	 * @throws Exception the exception
	 */
	public void map(final Player player) throws Exception {
		GameController.logger.info("Invoking map command");
		executeCommand(Command.MAP, new MapCommandParams(player.getCurrentLevel()));

	}

	/**
	 * Quit.
	 *
	 * @throws Exception the exception
	 */
	public void quit() throws Exception {
		GameController.logger.info("Invoking quit command");
		executeCommand(Command.QUIT, new QuitCommandParams("Quit"));

	}

	/**
	 * Profile.
	 *
	 * @param player the player
	 * @throws Exception the exception
	 */
	public void profile(final Player player) throws Exception {
		GameController.logger.info("Invoking profile command");
		executeCommand(Command.PROFILE,
				new ProfileCommandParams(player.getName(), player.getPoints(), player.getCurrentLevel().toString()));

	}

	/**
	 * Continue game 1.
	 *
	 * @throws Exception the exception
	 */
	public void continueGame1() throws Exception {
		GameController.logger.info("Invoking contine command");
		executeCommand(Command.CONTINUE, new ContinueCommandParams("Continue"));

	}

	/**
	 * Show characters.
	 */
	public void showCharacters() {

		List<GameCharacter> gameCharacters;
		try {
			gameCharacters = characterDAO.findAll();

			for (final GameCharacter character : gameCharacters) {
				new MiddleTile(character.getCharacterAvatar().toLowerCase() + ".txt").renderUI(false);
				ConsoleController.printGap();

			}

		} catch (final ClassNotFoundException e) {
			throw new GameException("Class not found exception Occured.", e);
		} catch (final IOException e) {
			throw new GameException("Serialization file IO exception Occured. Check the proper file location.", e);
		}

	}

	/**
	 * Accept creds.
	 *
	 * @param player the player
	 * @return the player
	 */
	public Player acceptCreds(final Player player) {

		final String playerName = ConsoleController.readString("Please enter your name : ", "Please enter valid name!");

		if (playerName.trim().equalsIgnoreCase("")) {
			acceptCreds(player);
		}

		fillNewPlayer(player, playerName);

		return player;

	}

	/**
	 * Fill new player.
	 *
	 * @param player the player
	 * @param playerName the player name
	 */
	private void fillNewPlayer(final Player player, final String playerName) {
		player.setName(playerName);
		player.setCharacter(0);
		player.setCurrentLevel(1);
		player.setPoints(0);
	}

	/**
	 * Validate player.
	 *
	 * @param name the name
	 * @return true, if successful
	 */
	public boolean validatePlayer(final String name) {
		Optional<Player> existingPlayerOptional = Optional.empty();
		try {
			existingPlayerOptional = Optional.ofNullable(playerDAO.getDetails(name));
		} catch (ClassNotFoundException | IOException e) {
			throw new GameException("Fatal Exception", e);
		} catch (Exception e) {
			ConsoleController.printMessageToConsole("Mentioned user is not present");
			return false;
		}
		if (existingPlayerOptional.isPresent()) {
			Player existingPlayer = existingPlayerOptional.get();

			final GameDetails gameDetails = new GameDetails(existingPlayer.getId(),
					existingPlayer.getName(), existingPlayer.getCurrentLevel());
			try {
				// clearState(existingPlayer.get(), gameDetails);

				final Boolean clearStatus = ConsoleController
						.readBoolean("Do you want to start from where you left last time? (yes | no ) ?  ");
				if (!clearStatus) {
					existingPlayer.setCurrentLevel(1);
					existingPlayer.setCharacter(null);
					existingPlayer.setIsNew(false);
					existingPlayer.setIsChoiceSet(false);
					existingPlayer.setPoints(0);

					gameDetails.setCurrentLevel(0);
					gameDetails.setLoggedInUserName(existingPlayer.getName());
					gameDetails.setPlayerId(existingPlayer.getId());
				}
				ConsoleController.printGap();

				gameDetailsDAO.save(gameDetails);
				playerDAO.save(existingPlayer);
			} catch (final IOException e) {
				throw new GameException("Fatal error occured!", e);
			}
			return true;

		} else {
			ConsoleController.printMessageToConsole("Mentioned user is not present");
			return false;
		}

	}

	/**
	 * Initialise player.
	 */
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

			final String playerName = getPlayerName();

			boolean validationStatus = validatePlayer(playerName);
			if (!validationStatus) {
				initialisePlayer();
			}

		}

	}

	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
	private String getPlayerName() {
		final String playerName = ConsoleController.readString("Please enter your name ", "Please enter valid name!!");
		if (playerName.trim().equalsIgnoreCase("")) {
			getPlayerName();
		}

		return playerName;
	}

	/**
	 * Sets the character choice.
	 */
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

			
			final Optional<Integer> option = Optional.ofNullable(ConsoleController.readInteger(
					"Please enter serial number of which character do you want to possess? :",
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

			introduceLevel(1);

		}
	}

	/**
	 * Show choiced character.
	 */
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

			new MiddleTile(character.getCharacterName().toLowerCase() + ".txt").renderUI(false);

		} catch (ClassNotFoundException | IOException e) {
			new GameException("Fatal Exception Occured!", e);
		}

	}

	/**
	 * Adds the delay and gap.
	 *
	 * @param seconds the seconds
	 */
	public void addDelayAndGap(final Integer seconds) {
		ConsoleController.printGap();
		try {

			Thread.sleep(seconds * 1000);

		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Introduce level.
	 *
	 * @param levelNumber the level number
	 */
	public void introduceLevel(final Integer levelNumber) {

		System.out.flush();
		ConsoleController
				.printMessageToConsole(" Lets start first level my dear hobbit! Here is map of all the levels.");
		addDelayAndGap(2);
		new MiddleTile("level" + levelNumber + ".txt").renderUI(false);
		ConsoleController.printGap();
		ConsoleController
				.printMessageToConsole("Read all commands carefully.You can type help command for understanding commands.");
		ConsoleController.printMessageToConsole("Currently you can type play command to play game at first level.");

	}

	/**
	 * Resolve and execute command.
	 *
	 * @param command the command
	 */
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

	/**
	 * Read command.
	 */
	public void readCommand() {
		final String command = ConsoleController.readString("Enter your command hobbit :");
		resolveAndExecuteCommand(command.toLowerCase());

		while (!GameController.isGameCompplete || !GameController.isGameAborted) {
			addDelayAndGap(2);
			readCommand();
		}

	}

}
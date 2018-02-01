package org.game.fantasy.command.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.ContinueCommandParams;
import org.game.fantasy.controls.ConsoleController;
import org.game.fantasy.dao.GameDetailsDAO;
import org.game.fantasy.dao.PlayerDAO;
import org.game.fantasy.model.GameDetails;
import org.game.fantasy.model.Player;
import org.game.fantasy.ui.MiddleTile;


/**
 * The Class ContinueCommandHandler.
 */
public class ContinueCommandHandler implements CommandHandler<ContinueCommandParams, String> {
	
	/** The player DAO. */
	private final PlayerDAO playerDAO = new PlayerDAO();
	
	/** The Game details DAO. */
	private final GameDetailsDAO GameDetailsDAO = new GameDetailsDAO();

	/** The max steps. */
	int maxSteps = 38;
	
	/** The initial speed. */
	int initialSpeed = 30;

	/* (non-Javadoc)
	 * @see org.game.fantasy.command.CommandHandler#execute(java.lang.Object)
	 */
	@Override
	public String execute(final ContinueCommandParams params) throws Exception {
		new MiddleTile("frodo_strict.txt").renderUI(true);
		boolean isInturrupted = false;

		try (final InputStreamReader inStream = new InputStreamReader(System.in);
				final BufferedReader bufferedReader = new BufferedReader(inStream)) {
			for (int i = 0; i < maxSteps; i++) {
				System.out.print("=>");
				TimeUnit.MILLISECONDS.sleep(initialSpeed);

				// Something that allows user input/interaction capable to stop the arrows of
				// orcs.
				try {
					if (bufferedReader.ready()) {
						isInturrupted = true;
						break;
					}
				} catch (final IOException e) {

					e.printStackTrace();
				}
			}
		}

		System.out.println(" ");

		if (isInturrupted) {
			final Integer levelThreshould = 4;
			final Optional<GameDetails> gameDetailsOptional = GameDetailsDAO.getDetails();

			if (gameDetailsOptional.isPresent()) {
				final Player player = playerDAO.getDetails(gameDetailsOptional.get().getLoggedInUserName());

				player.setPoints(player.getPoints() + 10);
				player.setCurrentLevelSuccess(player.getCurrentLevelSuccess() + 1);

				if (player.getCurrentLevelSuccess() > levelThreshould) {
					if (player.getCurrentLevel() == 5) {
						ConsoleController.printMessageToConsole(
								"Best You have saved middle earth by dropping ring in mordor's volcano!! Thanks for playing!!!");
					} else {
						player.setCurrentLevel(player.getCurrentLevel() + 1);
						player.setCurrentLevelSuccess(0);
						ConsoleController.printMessageToConsole(
								"Best You have entered now at next level. Which is " + player.getCurrentLevel() + " !");
					}
				}

				playerDAO.save(player);
				System.out.println("Best you just saved yourself! You got 10 Points !! your total points are "
						+ player.getPoints());
			}
		} else {
			System.out.println("ohh you died!!!");
		}

		return "call map";
	}
}
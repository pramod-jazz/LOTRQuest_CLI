package org.game.fantasy.command.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.game.fantasy.GameMetadata;
import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.params.ContinueCommandParams;
import org.game.fantasy.controls.ConsoleController;
import org.game.fantasy.dao.GameDetailsDAO;
import org.game.fantasy.dao.PlayerDAO;
import org.game.fantasy.model.GameDetails;
import org.game.fantasy.model.Player;
import org.game.fantasy.ui.MiddleTile;

public class ContinueCommandHandler implements CommandHandler<ContinueCommandParams, String> {

	private PlayerDAO playerDAO = new PlayerDAO();
	private GameDetailsDAO GameDetailsDAO = new GameDetailsDAO();

	@Override
	public String execute(ContinueCommandParams params) throws Exception {

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
		

		if (isInturrupted) {
			Integer levelThreshould = 4;
			Optional<GameDetails> gameDetailsOptional = GameDetailsDAO.getDetails();
			if (gameDetailsOptional.isPresent()) {
				Player player = playerDAO.getDetails(gameDetailsOptional.get().getLoggedInUserName());

				player.setPoints(player.getPoints() + 10);
				player.setCurrentLevelSuccess(player.getCurrentLevelSuccess() + 1);
				if(player.getCurrentLevelSuccess() > 4) {
					if(player.getCurrentLevel() == 5) {
						ConsoleController.printMessageToConsole("Best You have saved middle earth by dropping ring in mordor's volcano!! Thanks for playing!!!");
					}else {
						player.setCurrentLevel(player.getCurrentLevel() + 1);
						player.setCurrentLevelSuccess(0);
						ConsoleController.printMessageToConsole("Best You have entered now at next level. Which is " + player.getCurrentLevel()  +" !");
						
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
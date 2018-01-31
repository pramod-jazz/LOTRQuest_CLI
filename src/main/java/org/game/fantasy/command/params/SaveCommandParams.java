package org.game.fantasy.command.params;

import org.game.fantasy.model.GameDetails;
import org.game.fantasy.model.Player;

public class SaveCommandParams {
	private GameDetails gameDetails;

	private Player player;

	public SaveCommandParams(GameDetails gameDetails, Player player) {
		super();
		this.gameDetails = gameDetails;
		this.player = player;
	}

	public GameDetails getGameDetails() {
		return gameDetails;
	}

	public void setGameDetails(GameDetails gameDetails) {
		this.gameDetails = gameDetails;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}

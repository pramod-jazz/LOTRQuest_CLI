package org.game.fantasy.command.params;

import org.game.fantasy.model.GameDetails;
import org.game.fantasy.model.Player;


/**
 * The Class SaveCommandParams.
 */
public class SaveCommandParams {
	
	/** The game details. */
	private GameDetails gameDetails;

	/** The player. */
	private Player player;

	/**
	 * Instantiates a new save command params.
	 *
	 * @param gameDetails the game details
	 * @param player the player
	 */
	public SaveCommandParams(GameDetails gameDetails, Player player) {
		super();
		this.gameDetails = gameDetails;
		this.player = player;
	}

	/**
	 * Gets the game details.
	 *
	 * @return the game details
	 */
	public GameDetails getGameDetails() {
		return gameDetails;
	}

	/**
	 * Sets the game details.
	 *
	 * @param gameDetails the new game details
	 */
	public void setGameDetails(GameDetails gameDetails) {
		this.gameDetails = gameDetails;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Sets the player.
	 *
	 * @param player the new player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}

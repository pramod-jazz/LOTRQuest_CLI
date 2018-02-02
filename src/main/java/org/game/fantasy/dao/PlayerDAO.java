package org.game.fantasy.dao;

import java.io.IOException;

import org.game.fantasy.model.Player;

/**
 * The Class PlayerDAO.
 */
public class PlayerDAO {

	/** The object IO. */
	ObjectIOOperations objectIO = new ObjectIOOperations();

	/**
	 * Gets the details.
	 *
	 * @param playerName
	 *            the player name
	 * @return the details
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public Player getDetails(String playerName) throws ClassNotFoundException, IOException {

		Player player = new Player();
		player = (Player) objectIO.deserialize(playerName + ".ser");

		return player;
	}

	/**
	 * Save.
	 *
	 * @param player
	 *            the player
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void save(Player player) throws IOException {
		objectIO.serialize(player, player.getName() + ".ser");
	}

}

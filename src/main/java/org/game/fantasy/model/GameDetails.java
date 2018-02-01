package org.game.fantasy.model;

import java.io.Serializable;


/**
 * The Class GameDetails.
 */
public class GameDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5177633036159010101L;

	/** The player id. */
	private Integer playerId;

	/** The logged in user name. */
	private String loggedInUserName;

	/**
	 * Gets the logged in user name.
	 *
	 * @return the logged in user name
	 */
	public String getLoggedInUserName() {
		return loggedInUserName;
	}

	/**
	 * Sets the logged in user name.
	 *
	 * @param loggedInUserName the new logged in user name
	 */
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}

	/** The current level. */
	private Integer currentLevel;

	/**
	 * Gets the player id.
	 *
	 * @return the player id
	 */
	public Integer getPlayerId() {
		return playerId;
	}

	/**
	 * Sets the player id.
	 *
	 * @param playerId the new player id
	 */
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	/**
	 * Gets the current level.
	 *
	 * @return the current level
	 */
	public Integer getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Sets the current level.
	 *
	 * @param currentLevel the new current level
	 */
	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Instantiates a new game details.
	 *
	 * @param playerId the player id
	 * @param loggedInUserName the logged in user name
	 * @param currentLevel the current level
	 */
	public GameDetails(Integer playerId, String loggedInUserName, Integer currentLevel) {
		super();
		this.playerId = playerId;
		this.loggedInUserName = loggedInUserName;
		this.currentLevel = currentLevel;
	}

}

package org.game.fantasy.command.params;

/**
 * The Class ProfileCommandParams.
 * 
 * @author Pramod Nikam
 */
public class ProfileCommandParams {

	private String playerName;

	private Integer currentPoint;

	private String currentLevel;

	/**
	 * Instantiates a new profile command params.
	 *
	 * @param playerName
	 *            the player name
	 * @param currentPoint
	 *            the current point
	 * @param currentLevel
	 *            the current level
	 */
	public ProfileCommandParams(String playerName, Integer currentPoint, String currentLevel) {
		super();
		this.playerName = playerName;
		this.currentPoint = currentPoint;
		this.currentLevel = currentLevel;
	}

	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Sets the player name.
	 *
	 * @param playerName
	 *            the new player name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Gets the current point.
	 *
	 * @return the current point
	 */
	public Integer getCurrentPoint() {
		return currentPoint;
	}

	/**
	 * Sets the current point.
	 *
	 * @param currentPoint
	 *            the new current point
	 */
	public void setCurrentPoint(Integer currentPoint) {
		this.currentPoint = currentPoint;
	}

	/**
	 * Gets the current level.
	 *
	 * @return the current level
	 */
	public String getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * Sets the current level.
	 *
	 * @param currentLevel
	 *            the new current level
	 */
	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}

}

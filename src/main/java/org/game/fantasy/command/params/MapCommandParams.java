package org.game.fantasy.command.params;


/**
 * The Class MapCommandParams.
 */
public class MapCommandParams {

	/** The current level. */
	private Integer currentLevel;

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
	 * @param currentLevel
	 *            the new current level
	 */
	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * Instantiates a new map command params.
	 *
	 * @param currentLevel
	 *            the current level
	 */
	public MapCommandParams(Integer currentLevel) {
		super();
		this.currentLevel = currentLevel;
	}

}

package org.game.fantasy.model;

import java.io.Serializable;


/**
 * The Class Player.
 */
public class Player implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4406687381110224319L;

	/** The id. */
	private Integer id;

	/** The is new. */
	private Boolean isNew = true;

	/** The is choice set. */
	private Boolean isChoiceSet = false;

	/** The name. */
	private String name;

	/** The character name. */
	private String characterName;

	/** The current level success. */
	private Integer currentLevelSuccess = 0;

	/**
	 * Gets the character name.
	 *
	 * @return the character name
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * Sets the character name.
	 *
	 * @param characterName the new character name
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/** The passphrase. */
	private String passphrase;

	/**
	 * Gets the passphrase.
	 *
	 * @return the passphrase
	 */
	public String getPassphrase() {
		return passphrase;
	}

	/**
	 * Sets the passphrase.
	 *
	 * @param passphrase the new passphrase
	 */
	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** The points. */
	private Integer points;

	/** The current level. */
	private Integer currentLevel;

	/** The character. */
	private Integer character;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}

	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(Integer points) {
		this.points = points;
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
	 * Gets the character.
	 *
	 * @return the character
	 */
	public Integer getCharacter() {
		return character;
	}

	/**
	 * Sets the character.
	 *
	 * @param character the new character
	 */
	public void setCharacter(Integer character) {
		this.character = character;
	}

	/**
	 * Gets the current level success.
	 *
	 * @return the current level success
	 */
	public Integer getCurrentLevelSuccess() {
		return currentLevelSuccess;
	}

	/**
	 * Sets the current level success.
	 *
	 * @param currentLevelSuccess the new current level success
	 */
	public void setCurrentLevelSuccess(Integer currentLevelSuccess) {
		this.currentLevelSuccess = currentLevelSuccess;
	}

	/**
	 * Gets the checks if is new.
	 *
	 * @return the checks if is new
	 */
	public Boolean getIsNew() {
		return isNew;
	}

	/**
	 * Sets the checks if is new.
	 *
	 * @param isNew the new checks if is new
	 */
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	/**
	 * Gets the checks if is choice set.
	 *
	 * @return the checks if is choice set
	 */
	public Boolean getIsChoiceSet() {
		return isChoiceSet;
	}

	/**
	 * Sets the checks if is choice set.
	 *
	 * @param isChoiceSet the new checks if is choice set
	 */
	public void setIsChoiceSet(Boolean isChoiceSet) {
		this.isChoiceSet = isChoiceSet;
	}

}

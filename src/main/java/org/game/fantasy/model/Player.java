package org.game.fantasy.model;

import java.io.Serializable;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4406687381110224319L;

	private Integer id;
	
	private Boolean isNew = true;
	
	private Boolean isChoiceSet = false;
	
	private String name;
	
	private String characterName;
	
	private Integer currentLevelSuccess = 0;
	
	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	private String passphrase;
	
	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Integer points;
	
	private Integer currentLevel;
	
	private Integer character;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	public Integer getCharacter() {
		return character;
	}

	public void setCharacter(Integer character) {
		this.character = character;
	}

	public Integer getCurrentLevelSuccess() {
		return currentLevelSuccess;
	}

	public void setCurrentLevelSuccess(Integer currentLevelSuccess) {
		this.currentLevelSuccess = currentLevelSuccess;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public Boolean getIsChoiceSet() {
		return isChoiceSet;
	}

	public void setIsChoiceSet(Boolean isChoiceSet) {
		this.isChoiceSet = isChoiceSet;
	}
	
	
	
	
	
	
	
	
	

}

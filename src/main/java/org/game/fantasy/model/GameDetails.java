package org.game.fantasy.model;

import java.io.Serializable;

public class GameDetails implements Serializable    {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5177633036159010101L;

	private Integer playerId;
	
	private String loggedInUserName;

	public String getLoggedInUserName() {
		return loggedInUserName;
	}

	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}

	private Integer currentLevel;

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	public GameDetails(Integer playerId, String loggedInUserName, Integer currentLevel) {
		super();
		this.playerId = playerId;
		this.loggedInUserName = loggedInUserName;
		this.currentLevel = currentLevel;
	}

}

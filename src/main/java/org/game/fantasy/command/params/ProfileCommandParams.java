package org.game.fantasy.command.params;

public class ProfileCommandParams {
	
	private String playerName;
	
	private Integer currentPoint;
	
	private String currentLevel;
	
	

	public ProfileCommandParams(String playerName, Integer currentPoint, String currentLevel) {
		super();
		this.playerName = playerName;
		this.currentPoint = currentPoint;
		this.currentLevel = currentLevel;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Integer getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Integer currentPoint) {
		this.currentPoint = currentPoint;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	

}

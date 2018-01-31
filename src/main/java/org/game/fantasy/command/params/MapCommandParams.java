package org.game.fantasy.command.params;

public class MapCommandParams {
	
	private Integer currentLevel;

	public Integer getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	public MapCommandParams(Integer currentLevel) {
		super();
		this.currentLevel = currentLevel;
	}

	
}

package org.game.fantasy.model;

import java.io.Serializable;

public class Level implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8267317090994661416L;

	private Integer id;
	
	private String levelName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLavelName() {
		return levelName;
	}

	public void setLavelName(String lavelName) {
		this.levelName = lavelName;
	}

	public Level(Integer id, String levelName) {
		super();
		this.id = id;
		this.levelName = levelName;
	}
	
	

}

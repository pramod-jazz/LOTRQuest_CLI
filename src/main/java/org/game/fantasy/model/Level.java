package org.game.fantasy.model;

import java.io.Serializable;


/**
 * The Class Level.
 */
public class Level implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8267317090994661416L;

	/** The id. */
	private Integer id;

	/** The level name. */
	private String levelName;

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
	 * Gets the lavel name.
	 *
	 * @return the lavel name
	 */
	public String getLavelName() {
		return levelName;
	}

	/**
	 * Sets the lavel name.
	 *
	 * @param lavelName the new lavel name
	 */
	public void setLavelName(String lavelName) {
		this.levelName = lavelName;
	}

	/**
	 * Instantiates a new level.
	 *
	 * @param id the id
	 * @param levelName the level name
	 */
	public Level(Integer id, String levelName) {
		super();
		this.id = id;
		this.levelName = levelName;
	}

}

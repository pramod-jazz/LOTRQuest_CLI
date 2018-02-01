package org.game.fantasy.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The Class GameCharacter.
 */
public class GameCharacter implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8262717372960454445L;

	/**
	 * Instantiates a new game character.
	 *
	 * @param id the id
	 * @param characterAvatar the character avatar
	 * @param characterName the character name
	 */
	public GameCharacter(Integer id, String characterAvatar, String characterName) {
		super();
		this.id = id;
		this.characterAvatar = characterAvatar;
		this.characterName = characterName;

	}

	/** The id. */
	private Integer id;

	/** The character avatar. */
	private String characterAvatar;

	/** The character name. */
	private String characterName;

	/** The created at. */
	private Date createdAt;

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
	 * Gets the character avatar.
	 *
	 * @return the character avatar
	 */
	public String getCharacterAvatar() {
		return characterAvatar;
	}

	/**
	 * Sets the character avatar.
	 *
	 * @param characterAvatar the new character avatar
	 */
	public void setCharacterAvatar(String characterAvatar) {
		this.characterAvatar = characterAvatar;
	}

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

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 */
	public void setCreatedAt() {
		createdAt = new Date();
	}

}

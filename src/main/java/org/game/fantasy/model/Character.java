package org.game.fantasy.model;

import java.util.Date;

public class Character {

	public Character(Integer id, String characterAvatar, String characterName) {
		super();
		this.id = id;
		this.characterAvatar = characterAvatar;
		this.characterName = characterName;
		
	}

	private Integer id;

	private String characterAvatar;

	private String characterName;

	private Date createdAt;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCharacterAvatar() {
		return characterAvatar;
	}

	public void setCharacterAvatar(String characterAvatar) {
		this.characterAvatar = characterAvatar;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
	   createdAt =	new Date();
	}

}

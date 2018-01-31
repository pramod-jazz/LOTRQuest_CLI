package org.game.fantasy.command.params;

public class QuitCommandParams {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public QuitCommandParams(String message) {
		super();
		this.message = message;
	}

}

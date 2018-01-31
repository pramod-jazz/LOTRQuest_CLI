package org.game.fantasy.command.params;

public class HelpCommandParams {

	private String helpMessage;

	public HelpCommandParams(String helpMessage) {
		super();
		this.helpMessage = helpMessage;
	}

	public String getHelpMessage() {
		return helpMessage;
	}

	public void setHelpMessage(String helpMessage) {
		this.helpMessage = helpMessage;
	}
}

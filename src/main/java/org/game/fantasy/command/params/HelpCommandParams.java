package org.game.fantasy.command.params;


/**
 * The Class HelpCommandParams.
 */
public class HelpCommandParams {

	/** The help message. */
	private String helpMessage;

	/**
	 * Instantiates a new help command params.
	 *
	 * @param helpMessage the help message
	 */
	public HelpCommandParams(String helpMessage) {
		super();
		this.helpMessage = helpMessage;
	}

	/**
	 * Gets the help message.
	 *
	 * @return the help message
	 */
	public String getHelpMessage() {
		return helpMessage;
	}

	/**
	 * Sets the help message.
	 *
	 * @param helpMessage the new help message
	 */
	public void setHelpMessage(String helpMessage) {
		this.helpMessage = helpMessage;
	}
}

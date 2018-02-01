package org.game.fantasy.command.params;

/**
 * The Class ContinueCommandParams.
 */
public class ContinueCommandParams {


	private String message;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Instantiates a new continue command params.
	 *
	 * @param message
	 *            the message
	 */
	public ContinueCommandParams(String message) {
		super();
		this.message = message;
	}

}

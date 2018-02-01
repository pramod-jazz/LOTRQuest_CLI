package org.game.fantasy.command.params;


/**
 * The Class ResumeCommandParams.
 */
public class ResumeCommandParams {

	/** The message. */
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
	 * Instantiates a new resume command params.
	 *
	 * @param message
	 *            the message
	 */
	public ResumeCommandParams(String message) {
		super();
		this.message = message;
	}

}

package org.game.fantasy.exceptions;

import org.apache.log4j.Logger;

public class GameException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -625466456421541522L;
	final static Logger logger = Logger.getLogger(GameException.class);

	public GameException(String message) {
		super(message);
		System.err.println(message);
		logger.error(message);

	}

	public GameException(String message, Throwable throwable) {
		super(message, throwable);
		logger.error(throwable.getMessage());

	}

}

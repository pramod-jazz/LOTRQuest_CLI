package org.game.fantasy.controls;

import org.game.fantasy.GameContext;
import org.game.fantasy.command.Command;


/**
 * The Class GameControlBase.
 */
public abstract class GameControlBase {
	
	/** The game context. */
	private GameContext gameContext = new GameContext();

	/**
	 * Execute command.
	 *
	 * @param <ParamType> the generic type
	 * @param <ReturnType> the generic type
	 * @param command the command
	 * @param parameters the parameters
	 * @return the return type
	 * @throws Exception the exception
	 */
	public <ParamType, ReturnType> ReturnType executeCommand(Command<ParamType, ReturnType> command,
			ParamType parameters) throws Exception {
		return getApplicationContext().executeCommand(command, parameters);
	}

	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	private GameContext getApplicationContext() {
		return gameContext;
	}
}
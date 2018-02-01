package org.game.fantasy.command;

/**
 * The Class CommandHandlerBinding.
 * 
 * @author Pramod
 *
 * @param <ParamType>
 *            the generic type
 * @param <ReturnType>
 *            the generic type
 */
public class CommandHandlerBinding<ParamType, ReturnType> {

	private Command<ParamType, ReturnType> command;

	private CommandHandler<ParamType, ReturnType> handler;

	/**
	 * Instantiates a new command handler binding.
	 *
	 * @param command
	 *            the command
	 * @param handler
	 *            the handler
	 */
	public CommandHandlerBinding(Command<ParamType, ReturnType> command, CommandHandler<ParamType, ReturnType> handler) {
		this.command = command;
		this.handler = handler;
	}

	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	public Command<ParamType, ReturnType> getCommand() {
		return command;
	}

	/**
	 * Gets the handler.
	 *
	 * @return the handler
	 */
	public CommandHandler<ParamType, ReturnType> getHandler() {
		return handler;
	}
}
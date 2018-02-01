/*
 * 
 */
package org.game.fantasy;

import java.util.ArrayList;
import java.util.List;

import org.game.fantasy.command.Command;
import org.game.fantasy.command.CommandHandler;
import org.game.fantasy.command.CommandHandlerBinding;
import org.game.fantasy.command.handlers.ContinueCommandHandler;
import org.game.fantasy.command.handlers.HelpCommandHandler;
import org.game.fantasy.command.handlers.MapCommandHandler;
import org.game.fantasy.command.handlers.ProfileCommandHandler;
import org.game.fantasy.command.handlers.QuitCommandHandler;
import org.game.fantasy.command.handlers.ResumeCommandHandler;

/**
 * GameContext. Applied for game bootstrapping.
 * 
 * @author Pramod Nikam
 * 
 * 
 * 
 */
public class GameContext {

	/** The command handler bindings. */
	private List<CommandHandlerBinding> commandHandlerBindings = new ArrayList<>();

	/**
	 * Initialize application.
	 */
	public void initializeApplication() {

		GameMetadata.setupCharacters();
		GameMetadata.setupLevels();

		registerCommandHandler(Command.HELP, new HelpCommandHandler());
		registerCommandHandler(Command.QUIT, new QuitCommandHandler());
		registerCommandHandler(Command.RESUME, new ResumeCommandHandler());
		registerCommandHandler(Command.PROFILE, new ProfileCommandHandler());
		registerCommandHandler(Command.MAP, new MapCommandHandler());
		registerCommandHandler(Command.CONTINUE, new ContinueCommandHandler());
	}

	/**
	 * Instantiates a new game context.
	 */
	public GameContext() {

		initializeApplication();

	}

	/**
	 * Register command handler.
	 *
	 * @param <ParamType>
	 *            the generic type
	 * @param <ReturnType>
	 *            the generic type
	 * @param command
	 *            the command
	 * @param handler
	 *            the handler
	 */
	public <ParamType, ReturnType> void registerCommandHandler(Command<ParamType, ReturnType> command,
			CommandHandler<ParamType, ReturnType> handler) {
		CommandHandler<ParamType, ReturnType> existingHandler = getCommandHandler(command);
		if (existingHandler != null) {
			System.out.println(
					"Command [" + command.getName() + "] already has a handler [" + existingHandler.getClass().getName()
							+ "] but is being set to [" + handler.getClass().getName() + "]");
		}
		commandHandlerBindings.add(new CommandHandlerBinding<ParamType, ReturnType>(command, handler));
	}

	/**
	 * Gets the command handler.
	 *
	 * @param <ParamType>
	 *            the generic type
	 * @param <ReturnType>
	 *            the generic type
	 * @param command
	 *            the command
	 * @return the command handler
	 */
	private <ParamType, ReturnType> CommandHandler<ParamType, ReturnType> getCommandHandler(
			Command<ParamType, ReturnType> command) {

		if (commandHandlerBindings != null) {
			for (CommandHandlerBinding<ParamType, ReturnType> binding : commandHandlerBindings) {
				if (binding.getCommand().getName().equals(command.getName())) {
					return binding.getHandler();
				}
			}
		}
		return null;
	}

	/**
	 * Execute command.
	 *
	 * @param <ParamType>
	 *            the generic type
	 * @param <ReturnType>
	 *            the generic type
	 * @param command
	 *            the command
	 * @param parameters
	 *            the parameters
	 * @return the return type
	 * @throws Exception
	 *             the exception
	 */
	public <ParamType, ReturnType> ReturnType executeCommand(Command<ParamType, ReturnType> command,
			ParamType parameters) throws Exception {
		CommandHandler<ParamType, ReturnType> handler = getCommandHandler(command);
		if (handler == null) {
			throw new NullPointerException("No CommandHandler registered for Command [" + command.getName() + "]");
		}
		return handler.execute(parameters);
	}
}
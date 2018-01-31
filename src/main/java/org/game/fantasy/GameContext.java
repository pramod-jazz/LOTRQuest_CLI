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
 * Handles registering command handlers (binding them to commands) and
 * executing. I called this ApplicationContext but it can be any class that's
 * initialized on application startup and accessible to any code that needs to
 * execute commands. Most application frameworks have something like this.
 */
public class GameContext {
	private List<CommandHandlerBinding> commandHandlerBindings = new ArrayList<>();

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

	public GameContext() {
		// super();
		initializeApplication();

	}

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

	private <ParamType, ReturnType> CommandHandler<ParamType, ReturnType> getCommandHandler(
			Command<ParamType, ReturnType> command) {
		// initializeApplication();
		if (commandHandlerBindings != null) {
			for (CommandHandlerBinding<ParamType, ReturnType> binding : commandHandlerBindings) {
				if (binding.getCommand().getName().equals(command.getName())) {
					return binding.getHandler();
				}
			}
		}
		return null;
	}

	public <ParamType, ReturnType> ReturnType executeCommand(Command<ParamType, ReturnType> command,
			ParamType parameters) throws Exception {
		CommandHandler<ParamType, ReturnType> handler = getCommandHandler(command);
		if (handler == null) {
			throw new NullPointerException("No CommandHandler registered for Command [" + command.getName() + "]");
		}
		return handler.execute(parameters);
	}
}
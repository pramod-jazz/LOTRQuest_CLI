package org.game.fantasy.command;

import org.game.fantasy.command.params.ContinueCommandParams;
import org.game.fantasy.command.params.HelpCommandParams;
import org.game.fantasy.command.params.MapCommandParams;
import org.game.fantasy.command.params.ProfileCommandParams;
import org.game.fantasy.command.params.QuitCommandParams;

/**
 * The Class Command.
 * 
 * @author Pramod Nikam
 *
 * @param <ParamType>
 *            the generic type
 * @param <ReturnType>
 *            the generic type
 */
public class Command<ParamType, ReturnType> {

	public static final Command<HelpCommandParams, String> HELP = new Command<HelpCommandParams, String>(
			"HELP");

	public static final Command<MapCommandParams, String> MAP = new Command<MapCommandParams, String>(
			"MAP");

	public static final Command<ProfileCommandParams, String> PROFILE = new Command<ProfileCommandParams, String>(
			"PROFILE");

	public static final Command<QuitCommandParams, String> QUIT = new Command<QuitCommandParams, String>(
			"QUIT");

	public static final Command<ContinueCommandParams, String> CONTINUE = new Command<ContinueCommandParams, String>(
			"CONTINUE");

	private String name;

	/**
	 * Instantiates a new command.
	 *
	 * @param name
	 *            the name
	 */
	private Command(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
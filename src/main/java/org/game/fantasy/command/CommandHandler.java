package org.game.fantasy.command;

/**
 * This is the interface for handling the commands that are executed. Implement
 * this using the correct parameter type and return type to have code that
 * handles the command.
 * 
 * @author Pramod Nikam
 */
public interface CommandHandler<ParamType, ReturnType> {
	public ReturnType execute(ParamType params) throws Exception;
}
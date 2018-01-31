package org.game.fantasy.command;

@FunctionalInterface
public interface ConsoleCommand<T> {
	
	/**
     * The Command Invoker calls this.
     */
    void execute(T order);

}
